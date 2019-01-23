package com.msjf.finance.cas.modules.register.service.impl;

import com.msjf.finance.cas.facade.register.domain.RegisterDomain;
import com.msjf.finance.cas.modules.ausAuthone.dao.AusAuthoneDao;
import com.msjf.finance.cas.modules.organ.dao.OrganInfoChangeDao;
import com.msjf.finance.cas.modules.organ.dao.OrganInfoDao;
import com.msjf.finance.cas.modules.organ.dao.OrganRollinDao;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoEntity;
import com.msjf.finance.cas.modules.organ.entity.OrganRollinEntity;
import com.msjf.finance.cas.modules.person.dao.PersonInfoDao;
import com.msjf.finance.cas.modules.register.dao.CasRegisterDao;
import com.msjf.finance.cas.modules.register.dao.CustDao;
import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.cas.modules.register.service.RegisterService;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.cas.modules.util.DateUtil;
import com.msjf.finance.cas.modules.util.StringUtil;
import com.msjf.finance.mcs.facade.sms.SendVerificationCodeFacade;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.msjf.finance.cas.modules.Account.Account.*;
import static com.msjf.finance.cas.modules.util.CommonUtil.DATE_FMT_DATE;
import static com.msjf.finance.cas.modules.util.CommonUtil.DATE_FMT_TIME;

@Service("registerServicel")
@Transactional(rollbackFor = RuntimeException.class)
public class RegisterServiceImpl implements RegisterService {


    @Resource
    CustDao custDao;

    @Resource
    OrganInfoDao organInfoDao;

    @Resource
    OrganInfoChangeDao organInfoChangeDao;

    @Resource
    OrganRollinDao organRollinDao;

    @Resource
    PersonInfoDao personInfoDao;

    @Resource
    AusAuthoneDao ausAuthoneDao;


    @Resource
    CasRegisterDao casRegisterDao;


    @Resource
    SendVerificationCodeFacade sendVerificationCodeFacade;



    /**
     * 用户类型
     */
    private String membertype;

    /**
     * 注册来源 0-web 1-app
     */
    private String registersource;



    /**
     * 用户名称
     */
    private String membername;

    /**
     * 证件类型 0-身份证 1-护照 A-营业执照
     */
    private String certificatetype;

    /**
     * 证件号码
     */
    private String certificateno;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 银行卡号
     */
    private String cardno;

    /**
     * 银行
     */
    private String bank;

    /**
     * 验证码
     */
    private String msgcode;

    /**
     * 密码
     */
    private String password;


    /**
     * 就职单位
     */
    private String companyname;

    /**
     * 法人名称
     */
    private String corname;


    /**
     * 法人证件类型
     */
    private String corcardtype;


    /**
     * 法人证件号码
     */
    private String corcardno;


    /**
     * 法注册步骤
     */
    private String step;


    @Override
    public Response Register(RegisterDomain registerDomain) {
        Response rs=new Response();
        getParam(registerDomain);//获取入参
        if(!preCheck(rs)){
            //入参校验
            return rs;
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap = getCasRegister();
        if(step.equals(step_1)){
            if (membertype.equals(company)) {
                /**
                 * 1、企业名称以及企业营业执照校验
                 * 2、校验成功后生成custno并记录相关数据
                 */
                //企业名称唯一检查
                if(!checkOrganName(rs)){
                    return  rs;
                }
                if(!checkCustCertificateno(rs)){
                    //证件号在cust表校验唯一性
                    return  rs;
                }
            }else if(membertype.equals(person)){
                /**
                 * 1、先做手机验证码校验；
                 *2、校验成功生成custno并记录手机号码
                 */
                Boolean flag=CommonUtil.checkVerificationCode(SMS_REGISTER_TYPE,mobile,msgcode);
                if(!flag){
                    return new Response().fail("0","短信验证码验证不通过！");
                }
               if(!checkCustMembertypeAndMobile(rs)){//用户类型+手机号码在cust表校验唯一性
                   return rs;
               }
            }
            if(ObjectUtils.isEmpty(resultMap)){
                String  id =  StringUtil.getUUID();//生成
                addCasRegisterInfo(id);//写用户注册基本信息表
            }
        }else if(step.equals(step_2)){
            if (membertype.equals(company)) {
                /**
                 * 需校验验证码
                 */
                Boolean flag=CommonUtil.checkVerificationCode(SMS_REGISTER_TYPE,mobile,msgcode);
                if(!flag){
                    return new Response().fail("0","短信验证码验证不通过！");
                }
            }
            Map<String,Object> entity = new HashMap<>();
            entity = getCasRegister();
            if(ObjectUtils.isEmpty(entity)){
                return new Response().fail("0","当前信息不存在");
            }
            Map<String,Object> mapParam =new HashMap<>();
            mapParam.put("corname",corname);
            mapParam.put("corcardtype",corcardtype);
            mapParam.put("corcardno",corcardno);
            mapParam.put("mobile",mobile);
            mapParam.put("cardno",cardno);
            mapParam.put("membername",membername);
            mapParam.put("certificatetype",certificatetype);
            mapParam.put("certificateno",certificateno);
            mapParam.put("bank",bank);
            mapParam.put("id",entity.get("id"));
            updCasRegisterInfo(mapParam);
        }else if(step.equals(step_3)){
            Map<String,Object> entity = new HashMap<>();
            entity = getCasRegister();
            if(ObjectUtils.isEmpty(entity)){
                return new Response().fail("0","当前信息不存在");
            }
            if (membertype.equals(company)) {
                addOrganInfo(entity);
                entity.put("cormob",entity.get("mobile"));
                entity.put("mobile","");
            }else{
                addPersonInfo(entity);
            }
            addCust(entity);
            addAuthone(entity);
        }
        return new Response().success("1","操作成功",resultMap);
    }

    /**
     * 获取入参
     * @param res
     */
    private void getParam(RegisterDomain res) {
        membertype = StringUtil.valueOf(res.getMembertype());
        registersource = StringUtil.valueOf(res.getRegistersource());
        membername = StringUtil.valueOf(res.getMembername());
        certificatetype = StringUtil.valueOf(res.getCertificatetype());
        certificateno = StringUtil.valueOf(res.getCertificateno());
        mobile = StringUtil.valueOf(res.getMobile());
        cardno = StringUtil.valueOf(res.getCardno());
        bank = StringUtil.valueOf(res.getBank());
        msgcode = StringUtil.valueOf(res.getMsgcode());
        password = StringUtil.valueOf(res.getPassword());
        companyname = StringUtil.valueOf(res.getCompanyname());
        corname = StringUtil.valueOf(res.getCorname());
        corcardtype = StringUtil.valueOf(res.getCorcardtype());
        corcardno = StringUtil.valueOf(res.getCorcardno());
        step = StringUtil.valueOf(res.getStep());
    }

    /**
     * 入参校验
     * @return
     */
    private boolean preCheck(Response rs){
        if(ObjectUtils.isEmpty(membertype)){
            rs.fail("0","用户类型不能为空！");
            return false;
        }
        if(ObjectUtils.isEmpty(step)){
            rs.fail("0","注册步骤不能为空！");
            return false;
        }

        if(ObjectUtils.isEmpty(registersource)){
            rs.fail("0","注册来源不能为空！");
            return false;
        }

        if(membertype.equals(company)){
            /**
             * 企业
             */
            certificatetype = "A";
            if(step.equals(step_1)){
                if(ObjectUtils.isEmpty(membername)){
                    rs.fail("0","用户名称不能为空！");
                    return false;
                }

                if(ObjectUtils.isEmpty(certificateno)){
                    rs.fail("0","证件号码不能为空！");
                    return false;
                }
            }else if(step.equals(step_2)){

                if(ObjectUtils.isEmpty(corname)){
                    rs.fail("0","法人名称不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(corcardtype)){
                    rs.fail("0","法人证件类型不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(corcardno)){
                    rs.fail("0","法人证件号码不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(mobile)){
                    rs.fail("0","手机号码不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(msgcode)){
                    rs.fail("0","验证码不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(cardno)){
                    rs.fail("0","银行卡号不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(bank)){
                    rs.fail("0","银行名称不能为空！");
                    return false;
                }
            }else if(step.equals(step_3)){
                if(ObjectUtils.isEmpty(password)){
                    rs.fail("0","密码不能为空！");
                    return false;
                }
            }else{
                rs.fail("0","注册步骤不正确！");
                return false;
            }
        }else if(membertype.equals(person)){
            /**
             * 个人
             */
            if(step.equals(step_1)){
                if(ObjectUtils.isEmpty(mobile)){
                    rs.fail("0","手机号码不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(msgcode)){
                    rs.fail("0","验证码不能为空！");
                    return false;
                }
            }else if(step.equals(step_2)){
                if(ObjectUtils.isEmpty(membername)){
                    rs.fail("0","用户名称不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(certificatetype)){
                    rs.fail("0","证件类型不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(certificateno)){
                    rs.fail("0","证件号码不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(cardno)){
                    rs.fail("0","银行卡号不能为空！");
                    return false;
                }
                if(ObjectUtils.isEmpty(bank)){
                    rs.fail("0","银行名称不能为空！");
                    return false;
                }
            }else if(step.equals(step_3)){
                /**
                 * 验证密码
                 */
                if(ObjectUtils.isEmpty(password)){
                    rs.fail("0","密码不能为空！");
                    return false;
                }
            }else{
                rs.fail("0","注册步骤不正确！");
                return false;
            }
        }else{
            rs.fail("0","用户类型不正确！");
            return false;
        }

        return true;
    }

    /**
     * 用户信息：证件号唯一性检查
     * 忽略大小写
     * @return
     */
    private Boolean checkCustCertificateno( Response rs){
        try {
            CustEntity c = new CustEntity();
            c.setCertificateno(certificateno);
            List<CustEntity> clist = custDao.checkCustCertificatenoIsExist(c);
            if(!ObjectUtils.isEmpty(clist)){
                rs.fail("0","证件号码已经使用");//证件号码已经使用
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 用户信息：证件号唯一性检查
     * 忽略大小写
     * @return
     */
    private Map getCasRegister(){
        Map<String,Object> entity = new HashMap<>();
        entity.put("membertype",membertype);
        if(membertype.equals(company)){
            entity.put("membername",membername);
            entity.put("certificateno",certificateno);
        }else {
            entity.put("mobile",mobile);
        }
        List<Map> list = casRegisterDao.queryCasRegisterList(entity);
        if(ObjectUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    /**
     * 登录账号唯一性检查
     * @return
     */
    private Response checkCustLoginName(){
        try{
            CustEntity d = new CustEntity();
            d.setLoginname(certificateno);
            List<CustEntity> dlist =  custDao.queryCustEntityList(d);
            if(!ObjectUtils.isEmpty(dlist)){
                return new Response<>().fail("0","证件号码已经使用");//证件号码已经使用
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Response<>().success();
    }

    /**
     * 用户类型+手机号码在cust表校验唯一性
     */
    private Boolean checkCustMembertypeAndMobile(Response rs){
        try{
            CustEntity f = new CustEntity();
            f.setMembertype(membertype);
            f.setMobile(mobile);
            List<CustEntity> flist = custDao.queryCustEntityList(f);
            if(!ObjectUtils.isEmpty(flist)){
                if (person.equals(membertype) && flist.size() >= init_phone_count_person) {
                    rs.fail("0","手机号已使用");//手机号已使用
                    return false;
                }
                if (company.equals(membertype) && flist.size() >= init_phone_count_organ) {
                    rs.fail("0","手机号已使用");//手机号已使用
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     *企业名称唯一性检查
     */
    private Boolean checkOrganName(Response rs){
        //企业基本信息表检查
        OrganInfoEntity c = new OrganInfoEntity();
        c.setMembername(membername);
        c.setOrganstatus("");
        List<OrganInfoEntity> clist = organInfoDao.getOrganInfo(c);
        if(!ObjectUtils.isEmpty(clist)){
            rs.fail("0","企业名称已存在");//企业名称已存在
            return false;
        }
        //企业变更记录表最新插入的一条变更记录 检查
        HashMap<String, Object> amap = new HashMap<String, Object>();
        amap.put("membername", membername);
        List<HashMap<String, Object>> ls;
        try {
            ls = organInfoChangeDao.checkExistCompanynameInChange(amap);
        }catch (Exception e){
            rs.fail("0","查询失败");//查询失败
            return false;
        }
        if(!ObjectUtils.isEmpty(ls)){
            rs.fail("0","企业名称已存在");
            return false;
        }
        //企业迁入表检查
        OrganRollinEntity cor = new OrganRollinEntity();
        cor.setCompanyname(companyname);
        List<OrganRollinEntity> dlist =  organRollinDao.getOrganRollin(cor);
        if(!ObjectUtils.isEmpty(dlist)){
            rs.fail("0","企业名称已存在");
            return false;
        }
        return true;
    }

    /**
     *写客户信息表
     */
    private void addCust(Map<String, Object> mapParam){
        try {
            mapParam.put("customerno",mapParam.get("id"));
            mapParam.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("inserttime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("updatetime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("status","0");
            custDao.insCust(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("注册失败");
        }
    }

    /**
     * 写个人基本信息表
     */
    private void addPersonInfo(Map<String, Object> mapParam){
        try {

            mapParam.put("customerno",mapParam.get("id"));
            mapParam.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("inserttime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("updatetime",DateUtil.getUserDate(DATE_FMT_TIME));
            personInfoDao.insPersonInfo(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("注册失败");
        }
    }

    /**
     * 查询s个人注册基本信息表
     */
    private List<Map> queryCasRegisterInfo(){
        Map<String,Object> entity = new HashMap<>();
        entity.put("membertype",membertype);
        if(membertype.equals(company)){
            entity.put("membername",membername);
            entity.put("certificateno",certificateno);
        }else {
            entity.put("mobile",mobile);
        }
        List<Map> list = casRegisterDao.queryCasRegisterList(entity);
        return list;
    }


    /**
     * 写个人注册基本信息表
     */
    private Response addCasRegisterInfo( String id){
        Map<String,Object> entity = new HashMap<>();
        try {
            entity.put("id",id);
            entity.put("registersource",registersource);
            entity.put("membertype",membertype);
            if(membertype.equals(company)){
                entity.put("membername",membername);
                entity.put("certificatetype",certificatetype);
                entity.put("certificateno",certificateno);
            }else {
                entity.put("mobile",mobile);
            }
            entity.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATETIME));
            casRegisterDao.insCasRegister(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("注册失败");
        }
        return new Response<>().success();
    }


    /**
     * 修改个人注册基本信息表
     */
    private void updCasRegisterInfo(Map<String, Object> mapParam){
        try {
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATETIME));
            casRegisterDao.updCasRegister(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("注册失败");
        }
    }

    /**
     * 写企业基本信息表
     */
    private void addOrganInfo(Map<String, Object> mapParam){
        try {
            mapParam.put("customerno",mapParam.get("id"));
            mapParam.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("inserttime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("updatetime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("organstatus","1");
            mapParam.put("version",1);
            organInfoDao.insOrganInfo(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("注册失败");
        }
    }

    /**
     * 写登陆认证表
     */
    private  void addAuthone(Map<String, Object> mapParam){
        try {
            mapParam.put("customerno",mapParam.get("id"));
            mapParam.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("inserttime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("updatetime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("password",CommonUtil.HmacSHA1Encrypt(password,(String)mapParam.get("id")));
            mapParam.put("failcount",0);
            mapParam.put("registersource",registersource);
            ausAuthoneDao.inrAusAuthone(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("注册失败");
        }
    }
}
