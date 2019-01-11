package com.msjf.finance.cas.modules.login.service.impl;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.modules.Account;
import com.msjf.finance.cas.modules.ausAuthone.dao.AusAuthoneDao;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneEntity;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneKey;
import com.msjf.finance.cas.modules.login.dao.OrganAppendMapper;
import com.msjf.finance.cas.modules.login.entity.OrganAppendEntityWithBLOBs;
import com.msjf.finance.cas.modules.login.service.LoginService;
import com.msjf.finance.cas.modules.organ.dao.OrganInfoDao;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoEntity;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoKey;
import com.msjf.finance.cas.modules.person.dao.PersonInfoDao;
import com.msjf.finance.cas.modules.person.entity.PersonInfoEntity;
import com.msjf.finance.cas.modules.person.entity.PersonInfoKey;
import com.msjf.finance.cas.modules.register.dao.CustDao;
import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.cas.modules.util.*;
import com.msjf.finance.mcs.facade.sms.SendVerificationCodeFacade;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("loginService")
@Scope("prototype")
public class LoginServiceImpl extends Account implements LoginService {

    /** 登录账号*/
    private String loginname;

    /** 密码*/
    private String password;

    /** 登录来源  0-web 1-app*/
    private String loginsource;

    /** 客户代码*/
    private String customerno;

    /** 用户类型*/
    private String membertype;

    /** 图形验证码对应的解析码*/
    private String uniqueID;

    /** 图形验证码*/
    private String inputValidecode;

    /** 企业类型*/
    private String organtype;

    /** 企业分类*/
    private String organclass;

    /** 用户名*/
    private String membername;

    /** 手机号码 */
    private String mobile;

    private String msgCode;

    /**
     *
     * 登陆方式
     * 1-账号密码 2-手机号码
     * */
    private String loginType;

    @Resource
    CustDao custDao;
    @Resource
    AusAuthoneDao ausAuthoneDao;
    @Resource
    PersonInfoDao personInfoDao;
    @Resource
    CommonUtil commonUtil;
    @Resource
    OrganInfoDao organInfoDao;
    @Resource
    OrganAppendMapper organAppendMapper;
    @Resource
    SendVerificationCodeFacade sendVerificationCodeFacade;
    /**
     * 登录入口 包含以下两种情况
     * 1.企业和个人账户登陆
     * 2.个人手机号码登陆
     * @param mapParam
     * @param
     */
    @Override
    public Response<Map> memberLogin(HashMap<String, Object> mapParam) {
        Response rs=new Response();
        rs.fail("登录失败");
        //1.获取参数值
        getParam(mapParam);
        //2.检查数据不能为空
        if(!preCheck(rs)){
            return rs;
        }
        //3.查询数据库账户，校验是否合法
        CustEntity entity = new CustEntity();
        if("1".equals(loginType)){
            entity.setLoginname(loginname);
        }else if("2".equals(loginType)){
            entity.setMobile(mobile);
        }
        List<CustEntity> entitys = custDao.queryCustEntityList(entity);
        if (CheckUtil.isNull(entitys)) {
            rs.fail("用户不存在");
            return rs;
        }
        customerno = entitys.get(0).getCustomerno();
        membertype = entitys.get(0).getMembertype();
        if (MacroDefine.CUST_STATUS.LOCK.getValue().equals(entitys.get(0).getStatus())) {
            rs.fail("账户已锁定");
            return rs;
        }
        if (MacroDefine.CUST_STATUS.FROZEN.getValue().equals(entitys.get(0).getStatus())) {
            rs.fail("账户已冻结");
            return rs;
        }
        if (MacroDefine.CUST_STATUS.CANCEL.getValue().equals(entitys.get(0).getStatus())) {
            rs.fail("账户已销户");
            return rs;
        }
        AusAuthoneKey ausAuthoneKey = new AusAuthoneKey();
        ausAuthoneKey.setCustomerno(customerno);
        AusAuthoneEntity ausAuthoneEntity = ausAuthoneDao.getAusAuthoneByKeyLock(ausAuthoneKey);
        if (CheckUtil.isNull(ausAuthoneEntity)) {
            rs.fail("用户信息不存在");
            return rs;
        }
//        String enPassword = KDEncodeUtil.getKingdomPasswrod(password, customerno);
        //4.根据不同登陆类型 校验不同参数
        if("1".equals(loginType)){
             if (WEB.equals(loginsource)) {
                if (!CommonUtil.checkImageValidecode(uniqueID, inputValidecode, rs)) {
                    return rs;
                }
            }
            String enPassword = CommonUtil.encryptPassword(password);
            if (CheckUtil.isNull(enPassword)) {
                rs.fail("密码加密对比失败");
                return rs;
            }
            if (!enPassword.equals(ausAuthoneEntity.getPassword())) {
                //检查错误次数 错误达到上限锁定 并返回前端信息
                checkFailcount(ausAuthoneEntity.getFailcount(), rs);
                //rs.failed("用户名或密码错误");
                return rs;
            }
        }else if("2".equals(loginType)){
            Boolean flag=CommonUtil.checkVerificationCode(SMS_SERVICE_LOGIN_TYPE,mobile,msgCode);
            if(!flag){
                rs.fail("校验失败");
                return rs;
            }
        }
        //5.校验通过更新登陆表状态并返回信息
        updAuthone(rs);
        //基本信息是否完成填写 未完成时跳转到基本信息修改页面
        boolean isfinish = checkIsFinish(rs);
        HashMap<String, Object> rsmap = new HashMap<String, Object>();
        rsmap.put("customerno", customerno);
        rsmap.put("isfinish", isfinish ? CommonUtil.YES : CommonUtil.NO);
//        rsmap.put("kosgParams", CommonUtil.getKosgParams(customerno));
        rsmap.put("membertype", membertype);
        rsmap.put("membername", membername);
        rsmap.put("name", loginname);
        if (CommonUtil.YES.equals(membertype)) {
            rsmap.put("organtype", organtype);
            rsmap.put("organclass", organclass);
        }
        rs.success("登陆成功",rsmap);
        return rs;
    }

    /**
     * 企业法人登陆
     * 1.校验码验证码通过返回企业列表
     * 2.第二次传企业名称和第一次校验通过的验证码登陆
     * @param mapParam
     * @return
     */
    @Override
    public Response<Map> corporationLogin(HashMap<String, Object> mapParam) {
        Response rs=new Response();
        rs.fail("登录失败");
        //1.获取参数值
        getParam(mapParam);
        if(!CheckUtil.isNull(loginname)){
            if (CheckUtil.checkNull(loginsource, "登录来源", rs)) {
                return rs;
            }
        }
        if (CheckUtil.checkNull(mobile, "手机号码", rs)) {
            return rs;
        }
        if (CheckUtil.checkNull(msgCode, "验证码", rs)) {
            return rs;
        }
        if(CheckUtil.isNull(loginname)){
            Boolean flag=CommonUtil.checkVerificationCode(SMS_SERVICE_LOGIN_TYPE,mobile,msgCode);
            if(!flag){
                rs.fail("校验失败");
                return rs;
            }
            CustEntity entity = new CustEntity();
            entity.setMobile(mobile);
            entity.setMembertype(company);
            List<CustEntity> custEntityList = custDao.queryCustEntityList(entity);
            List<HashMap> mapList=new ArrayList<>();
            for(CustEntity custEntity:custEntityList){
                HashMap custmap=new HashMap();
                custmap.put("loginname",custEntity.getLoginname());
                mapList.add(custmap);
            }
            if(CheckUtil.isNull(custEntityList)){
                rs.fail("查无该法人信息");
            }
            rs.success("登陆成功",mapList);
        }else{
            CustEntity entity = new CustEntity();
            entity.setLoginname(loginname);
            entity.setMembertype(company);
            List<CustEntity> custEntityList = custDao.queryCustEntityList(entity);
            if(CheckUtil.isNull(custEntityList)){
                rs.fail("账户信息不存在");
                return rs;
            }
            CustEntity custEntity=custEntityList.get(0);
            customerno=custEntity.getCustomerno();
            membertype = custEntity.getMembertype();
            updAuthone(rs);
            //基本信息是否完成填写 未完成时跳转到基本信息修改页面
            boolean isfinish = checkIsFinish(rs);
            HashMap<String, Object> rsmap = new HashMap<String, Object>();
            rsmap.put("customerno", customerno);
            rsmap.put("isfinish", isfinish ? CommonUtil.YES : CommonUtil.NO);
//        rsmap.put("kosgParams", CommonUtil.getKosgParams(customerno));
            rsmap.put("membertype", membertype);
            rsmap.put("membername", membername);
            rsmap.put("name", loginname);
            if (CommonUtil.YES.equals(membertype)) {
                rsmap.put("organtype", organtype);
                rsmap.put("organclass", organclass);
            }
            rs.success("登陆成功",rsmap);
        }
        return rs;
    }

    @Override
    public Response<Map> changePwd(HashMap<String, Object> mapParam) {
        Response<Map> rs=new Response();
        HashMap resMap=new HashMap();
        rs.fail();
        String certificateno=StringUtil.valueOf(mapParam.get("certificateno"));
        String msgCode=StringUtil.valueOf(mapParam.get("msgCode"));
        String step=StringUtil.valueOf(mapParam.get("step"));
        String password=StringUtil.valueOf(mapParam.get("password"));
        if(CheckUtil.checkNull(step,"步骤",rs)){
            return rs;
        }
        if(CheckUtil.checkNull(certificateno,"证件号码",rs)){
            return rs;
        }
        CustEntity custEntity=new CustEntity();
        custEntity.setCertificateno(certificateno);
        List<CustEntity> custEntityList= custDao.queryCustEntityList(custEntity);
        if(CheckUtil.isNull(custEntityList)){
            rs.fail("账户信息不存在");
        }
        mobile=custEntityList.get(0).getMobile();
        if(step.equals(step_1)){
            Boolean flag=CommonUtil.sendVerificationCode(SMS_CHANGE_PWD_TYPE,mobile);
            if(flag){
                resMap.put("mobile",mobile.replaceAll("(\\d{3})\\d{6}(\\d{2})", "$1****$2"));
                rs.success("发送成功",resMap);
            }else {
                rs.fail("发送失败");
            }
        }
        else if(step.equals(step_2)){
            if(CheckUtil.checkNull(msgCode,"验证码",rs)){
                return rs;
            }
            if(CheckUtil.checkNull(password,"密码",rs)){
                return rs;
            }
            Boolean flag=CommonUtil.isExistVerificationCode(SMS_CHANGE_PWD_TYPE,mobile,msgCode);
            if(flag){
                AusAuthoneEntity ausAuthoneEntity=new AusAuthoneEntity();
                ausAuthoneEntity.setCustomerno(custEntityList.get(0).getCustomerno());
                ausAuthoneEntity.setPassword(CommonUtil.encryptPassword(password));
                ausAuthoneDao.update(ausAuthoneEntity);
                rs.success("修改成功");
            }else{
                rs.fail("修改失败");
            }
        }
        return rs;
    }

    private void getParam(HashMap<String, Object> mapParam) {
        loginname = StringUtil.valueOf(mapParam.get("loginname"));
        password = StringUtil.valueOf(mapParam.get("password"));
        loginsource = StringUtil.valueOf(mapParam.get("loginsource"));
        uniqueID = StringUtil.valueOf(mapParam.get("uniqueID"));
        inputValidecode = StringUtil.valueOf(mapParam.get("inputValidecode"));
        loginType=StringUtil.valueOf(mapParam.get("loginType"));
        msgCode=StringUtil.valueOf(mapParam.get("msgCode"));
        mobile=StringUtil.valueOf(mapParam.get("mobile"));
    }
    public Boolean preCheck(Response rs) {
        if(CheckUtil.checkNull(loginType,"登陆方式",rs)){
            return false;
        }
        if("1".equals(loginType)){
            if (CheckUtil.checkNull(loginname, "登录账号", rs)) {
                return false;
            }
            if (CheckUtil.checkNull(password, "密码", rs)) {
                return false;
            }
            if ("0".equals(loginsource)) {
                if (CheckUtil.checkNull(uniqueID, "uniqueID", rs)) {
                    return false;
                }
                if (CheckUtil.checkNull(inputValidecode, "图形验证码", rs)) {
                    return false;
                }
            }
        }
        if("2".equals(loginType)){
            if (CheckUtil.checkNull(mobile, "手机号码", rs)) {
                return false;
            }
            if (CheckUtil.checkNull(msgCode, "验证码", rs)) {
                return false;
            }
        }
        if (CheckUtil.checkNull(loginsource, "登录来源", rs)) {
            return false;
        }
        return true;
    }

//    public boolean check(IResult rs) {
//        if ("0".equals(loginsource)) {
//            if (!CommonUtil.checkImageValidecode(uniqueID, inputValidecode, rs)) {
//                return false;
//            }
//        }
//        if (!CommonUtil.isLegalOfDictValue("100", "登录来源", loginsource, rs)) {
//            return false;
//        }
//        return true;
//    }


//    @Override
//    public boolean clear(IResult rs) {
//        updAuthone(rs);
//        //基本信息是否完成填写 未完成时跳转到基本信息修改页面
//        boolean isfinish = checkIsFinish(rs);
//        HashMap<String, Object> rsmap = new HashMap<String, Object>();
//        rsmap.put("customerno", customerno);
//        rsmap.put("isfinish", isfinish ? YES : NO);
//        rsmap.put("kosgParams", CommonUtil.getKosgParams(customerno));
//        rsmap.put("membertype", membertype);
//        rsmap.put("membername", membername);
//        rsmap.put("name", loginname);
//        if (YES.equals(membertype)) {
//            rsmap.put("organtype", organtype);
//            rsmap.put("organclass", organclass);
//        }
//        ResultUtil.makerSusResults("登录成功", rsmap, rs);
//        return true;
//    }

    /**
     * 登录成功更新登录认证信息
     *
     * @param rs
     */
    private void updAuthone(Response rs) {
        try {
            AusAuthoneEntity ausAuthoneEntity = new AusAuthoneEntity();
            ausAuthoneEntity.setCustomerno(customerno);
            ausAuthoneEntity.setFailcount(0);
            ausAuthoneEntity.setLoginsource(loginsource);
            ausAuthoneEntity.setOnlinestatus("Y");//N-不在线 Y-在线
            ausAuthoneEntity.setUpdatedate(DateUtil.getUserDate(CommonUtil.DATE_FMT_DATE));
            ausAuthoneEntity.setUpdatetime(DateUtil.getUserDate(CommonUtil.DATE_FMT_TIME));
            ausAuthoneDao.update(ausAuthoneEntity);
        } catch (Exception e) {
//            LogUtil.error(e);
            throw new RuntimeException("aus_authone表更新失败");
        }
    }

    /**
     * 登录失败更新错误次数 错误次数达到上限状态锁定
     *
     * @param failCount 当前认证失败次数
     * @param rs
     */
    private void checkFailcount(int failCount, Response rs) {
        //获取系统参数 错误次数上限
        int sysFailCount = Integer
                .valueOf(commonUtil.getSysConfigValue("login_allow_error_num", "login_allow_error_num"));
        //更新错误次数 和 账户状态
        AusAuthoneEntity ausAuthoneEntity = new AusAuthoneEntity();
        ausAuthoneEntity.setCustomerno(customerno);
        ausAuthoneEntity.setUpdatedate(DateUtil.getUserDate(CommonUtil.DATE_FMT_DATE));
        ausAuthoneEntity.setUpdatetime(DateUtil.getUserDate(CommonUtil.DATE_FMT_TIME));
        try {
            if (failCount + 1 >= sysFailCount) {
                //错误次数加1 状态更新为锁定
                ausAuthoneEntity.setFailcount(sysFailCount);
                CustEntity c = new CustEntity();
                c.setCustomerno(customerno);
                c.setStatus(MacroDefine.CUST_STATUS.LOCK.getValue());
                c.setUpdatedate(DateUtil.getUserDate(CommonUtil.DATE_FMT_DATE));
                c.setUpdatetime(DateUtil.getUserDate(CommonUtil.DATE_FMT_TIME));
                custDao.update(c);
            } else {
                ausAuthoneEntity.setFailcount(failCount + 1);
            }
            ausAuthoneDao.update(ausAuthoneEntity);
        } catch (Exception e) {
//            LogUtil.error(e);
            throw new RuntimeException("登录错误次数更新失败");
        }
        int failedExistCount=sysFailCount-ausAuthoneEntity.getFailcount();//剩余次数
        if(failedExistCount>0){
            rs.fail("用户名或密码错误,剩余"+StringUtil.valueOf(failedExistCount)+"次机会");
        }else{
            rs.fail("用户名或密码错误,账户已锁定");
        }
    }

    /**
     * 检查基本信息是否填写完整
     *
     * @param rs
     * @return
     */
    private boolean checkIsFinish(Response rs) {
        if (CommonUtil.NO.equals(membertype)) {
            PersonInfoKey personInfoKey=new PersonInfoKey();
            personInfoKey.setCustomerno(customerno);
            PersonInfoEntity e = personInfoDao.selectByKey(personInfoKey);
            if (CheckUtil.isNull(e)) {
                rs.fail("未获取到基本信息");
                throw new RuntimeException(rs.getMsg());
            }
            membername = e.getMembername();
            if (CheckUtil.isNull(e.getMembername())) {
                return false;
            }
            if (CheckUtil.isNull(e.getEducation())) {
                return false;
            }
            if (CheckUtil.isNull(e.getWorkexp())) {
                return false;
            }
            if (CheckUtil.isNull(e.getInvestexp())) {
                return false;
            }
            if (CheckUtil.isNull(e.getIdcard())) {
                return false;
            }
            if (CheckUtil.isNull(e.getIsamac())) {
                return false;
            }
            if (CheckUtil.isNull(e.getAmacno())) {
                return false;
            }
        } else {
            OrganInfoKey organInfoKey=new OrganInfoKey();
            organInfoKey.setCustomerno(customerno);
            OrganInfoEntity c = organInfoDao.getOrganInfoByKey(organInfoKey);
            if (CheckUtil.isNull(c)) {
                rs.fail("企业基本信息获取失败");
                throw new RuntimeException(rs.getMsg());
            }
            organtype = c.getOrgantype();
            organclass = c.getOrganclass();
            membername = c.getMembername();
            //6类企业的基本信息差异字段 保存在 企业附属信息表
            OrganAppendEntityWithBLOBs entity = organAppendMapper.selectByPrimaryKey(customerno);
            if (CheckUtil.isNull(entity)) {
                return false;
            }
            //6类企业基本信息检查
            if (!checkOrganInfoCommon(c)) {
                return false;
            }
            //差异性检查
            if ("0".equals(c.getOrganclass())) {
                return checkOrganInfo0(entity);
            } else if ("1".equals(c.getOrganclass())) {
                return checkOrganInfo1(entity);
            } else if ("2".equals(c.getOrganclass())) {
                return checkOrganInfo2(entity);
            } else if ("3".equals(c.getOrganclass())) {
                return checkOrganInfo3(entity);
            } else if ("4".equals(c.getOrganclass())) {
                return checkOrganInfo4(entity);
            } else if ("5".equals(c.getOrganclass())) {
                return checkOrganInfo5(entity);
            } else {
                rs.fail("企业分类字典值[" + c.getOrganclass() + "]有误");
                throw new RuntimeException(rs.getMsg());
            }
        }
        return true;
    }

    /**
     * 基本信息页面 6类企业公共字段检查
     *
     * @param
     * @return
     */
    private boolean checkOrganInfoCommon(OrganInfoEntity c) {
        if (CheckUtil.isNull(c.getSparecontactname())) {
            return false;
        }
        if (CheckUtil.isNull(c.getSparecontactmobile())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRegicapital())) {
            return false;
        }
        if (CheckUtil.isNull(c.getEstablishdate())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRealprovince())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRealcity())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRealcounty())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRealtreet())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRegisterprovince())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRegistercity())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRegistercounty())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRegistertreet())) {
            return false;
        }
        if (CheckUtil.isNull(c.getBusinessscope())) {
            return false;
        }
        if (CheckUtil.isNull(c.getCompanyintro())) {
            return false;
        }
        if (CheckUtil.isNull(c.getHanginfo())) {
            return false;
        }
        if (CheckUtil.isNull(c.getCompanymodel())) {
            return false;
        }
        if (CheckUtil.isNull(c.getInvestsource())) {
            return false;
        }
        if (CheckUtil.isNull(c.getBusinessfile())) {
            return false;
        }
        return true;
    }

    /**
     * 基金管理人企业
     *
     * @param c
     * @return
     */
    private boolean checkOrganInfo0(OrganAppendEntityWithBLOBs c) {
        if (CheckUtil.isNull(c.getIsfiling())) {
            return false;
        }
        if (CheckUtil.isNull(c.getRegisterno())) {
            return false;
        }
        if (CheckUtil.isNull(c.getEmployeenum())) {
            return false;
        }
        if (CheckUtil.isNull(c.getCaremarkettype())) {
            return false;
        }
        if (CheckUtil.isNull(c.getProjectphase())) {
            return false;
        }
        if (CheckUtil.isNull(c.getProfittype())) {
            return false;
        }
        return true;
    }

    /**
     * 基金项目产业企业
     *
     * @param c
     * @return
     */
    private boolean checkOrganInfo1(OrganAppendEntityWithBLOBs c) {
        if (CheckUtil.isNull(c.getIsfundfiling())) {
            return false;
        }
        if (CheckUtil.isNull(c.getFundfilingno())) {
            return false;
        }
        if (CheckUtil.isNull(c.getFundmanagername())) {
            return false;
        }
        if (CheckUtil.isNull(c.getFundmanagerno())) {
            return false;
        }
        return true;
    }

    /**
     * 个人自有资金投资平台类企业
     *
     * @param c
     * @return
     */
    private boolean checkOrganInfo2(OrganAppendEntityWithBLOBs c) {
        if (CheckUtil.isNull(c.getCompanytrade())) {
            return false;
        }
        if (CheckUtil.isNull(c.getCompanyname())) {
            return false;
        }
        if (CheckUtil.isNull(c.getCompanyinfo())) {
            return false;
        }
        if (CheckUtil.isNull(c.getInvestnum())) {
            return false;
        }
        return true;
    }

    /**
     * 企业自有资金投资平台类企业
     *
     * @param c
     * @return
     */
    private boolean checkOrganInfo3(OrganAppendEntityWithBLOBs c) {
        if (CheckUtil.isNull(c.getProjecttrade())) {
            return false;
        }
        if (CheckUtil.isNull(c.getProjectintro())) {
            return false;
        }
        if (CheckUtil.isNull(c.getBlocname())) {
            return false;
        }
        return true;
    }

    /**
     * 融资租赁企业
     *
     * @param c
     * @return
     */
    private boolean checkOrganInfo4(OrganAppendEntityWithBLOBs c) {
        if (CheckUtil.isNull(c.getClassify())) {
            return false;
        }
        if (CheckUtil.isNull(c.getBusinesstype())) {
            return false;
        }
        if (CheckUtil.isNull(c.getObjecttype())) {
            return false;
        }
        return true;
    }

    /**
     * 其他企业
     *
     * @param c
     * @return
     */
    private boolean checkOrganInfo5(OrganAppendEntityWithBLOBs c) {
        if (CheckUtil.isNull(c.getSpecificbusinesstype())) {
            return false;
        }
        if (CheckUtil.isNull(c.getProfitmodel())) {
            return false;
        }
        if (CheckUtil.isNull(c.getCapitalsource())) {
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        String phone = "17721029999";
        System.out.println(phone.replaceAll("(\\d{3})\\d{6}(\\d{2})", "$1****$2"));
    }
}
