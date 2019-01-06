//package com.msjf.finance.cas.modules.login.service.impl;
//
//import com.msjf.finance.cas.common.response.Response;
//import com.msjf.finance.cas.modules.login.service.LoginService;
//import com.msjf.finance.cas.modules.util.CheckUtil;
//import com.msjf.finance.cas.modules.util.StringUtil;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//@Service("loginService")
//@Scope("prototype")
//public class LoginServiceImpl implements LoginService {
//
//    /** 登录账号*/
//    private String loginname;
//
//    /** 密码*/
//    private String password;
//
//    /** 登录来源  0-web 1-app*/
//    private String loginsource;
//
//    /** 客户代码*/
//    private String customerno;
//
//    /** 用户类型*/
//    private String membertype;
//
//    /** 图形验证码对应的解析码*/
//    private String uniqueID;
//
//    /** 图形验证码*/
//    private String inputValidecode;
//
//    /** 企业类型*/
//    private String organtype;
//
//    /** 企业分类*/
//    private String organclass;
//
//    /** 用户名*/
//    private String membername;
//
//    /** 手机号码 */
//    private String mobile;
//
//    private String msgCode;
//
//    /**
//     *
//     * 登陆方式
//     * 1-账号密码 2-手机号码
//     * */
//    private String loginType;
//    /**
//     * 登录入口
//     * @param mapParam
//     * @param
//     */
//    @Override
//    public Response<List<Map>> memberLogin(HashMap<String, Object> mapParam) {
//        Response rs=new Response();
//        rs.fail("登录失败");
//        getParam(mapParam);
//        preCheck(rs);
//        doSingleService(mapParam, rs);
//    }
//
//    private void getParam(HashMap<String, Object> mapParam) {
//        loginname = StringUtil.valueOf(mapParam.get("loginname"));
//        password = StringUtil.valueOf(mapParam.get("password"));
//        loginsource = StringUtil.valueOf(mapParam.get("loginsource"));
//        uniqueID = StringUtil.valueOf(mapParam.get("uniqueID"));
//        inputValidecode = StringUtil.valueOf(mapParam.get("inputValidecode"));
//        loginType=StringUtil.valueOf(mapParam.get("loginType"));
//        msgCode=StringUtil.valueOf(mapParam.get("msgCode"));
//        mobile=StringUtil.valueOf(mapParam.get("mobile"));
//    }
//    public Response preCheck(Response rs) {
//        if(CheckUtil.checkNull(loginType,"登陆方式",rs)){
//            return rs;
//        }
//        if("1".equals(loginType)){
//            if (CheckUtil.checkNull(loginname, "登录账号", rs)) {
//                return rs;
//            }
//            if (CheckUtil.checkNull(password, "密码", rs)) {
//                return rs;
//            }
//        }
//        if("2".equals(loginType)){
//            if (CheckUtil.checkNull(loginname, "手机号码", rs)) {
//                return rs;
//            }
//            if (CheckUtil.checkNull(password, "验证码", rs)) {
//                return rs;
//            }
//        }
//        if (CheckUtil.checkNull(loginsource, "登录来源", rs)) {
//            return rs;
//        }
//        if ("0".equals(loginsource)) {
//            if (CheckUtil.checkNull(uniqueID, "uniqueID", rs)) {
//                return rs;
//            }
//            if (CheckUtil.checkNull(inputValidecode, "图形验证码", rs)) {
//                return rs;
//            }
//        }
//        return rs;
//    }
//
//    @Override
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
//
//    @Override
//    public boolean before(IResult rs) {
//        CifCustEntity entity = new CifCustEntity();
//        entity.setLoginname(loginname);
//        List<CifCustEntity> entitys = cifCustPersistence.queryEntityList(entity);
//        if (CheckUtil.isNull(entitys)) {
//            rs.failed("用户名或密码错误");
//            return false;
//        }
//        customerno = entitys.get(0).getCustomerno();
//        membertype = entitys.get(0).getMembertype();
//        if (MacroDefine.CUST_STATUS.LOCK.getValue().equals(entitys.get(0).getStatus())) {
//            rs.failed("账户已锁定");
//            return false;
//        }
//        if (MacroDefine.CUST_STATUS.FROZEN.getValue().equals(entitys.get(0).getStatus())) {
//            rs.failed("账户已冻结");
//            return false;
//        }
//        if (MacroDefine.CUST_STATUS.CANCEL.getValue().equals(entitys.get(0).getStatus())) {
//            rs.failed("账户已销户");
//            return false;
//        }
//        AusAuthoneKey ausAuthoneKey = new AusAuthoneKey();
//        ausAuthoneKey.setKey(customerno);
//        AusAuthoneEntity ausAuthoneEntity = ausAuthonePersistence.queryEntityLock(ausAuthoneKey);
//        if (CheckUtil.isNull(ausAuthoneEntity)) {
//            rs.failed("用户信息不存在");
//            return false;
//        }
//        String enPassword = KDEncodeUtil.getKingdomPasswrod(password, customerno);
//        if (CheckUtil.isNull(enPassword)) {
//            rs.failed("密码加密对比失败");
//            return false;
//        }
//        if (!enPassword.equals(ausAuthoneEntity.getPassword())) {
//            //检查错误次数 错误达到上限锁定 并返回前端信息
//            checkFailcount(ausAuthoneEntity.getFailcount(), rs);
//            //rs.failed("用户名或密码错误");
//            return false;
//        }
//        return true;
//    }
//
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
//
//    /**
//     * 登录成功更新登录认证信息
//     *
//     * @param rs
//     */
//    private void updAuthone(IResult rs) {
//        try {
//            AusAuthoneEntity ausAuthoneEntity = new AusAuthoneEntity();
//            ausAuthoneEntity.setCustomerno(customerno);
//            ausAuthoneEntity.setFailcount(0);
//            ausAuthoneEntity.setLoginsource(loginsource);
//            ausAuthoneEntity.setOnlinestatus("Y");//N-不在线 Y-在线
//            ausAuthoneEntity.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
//            ausAuthoneEntity.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
//            ausAuthonePersistence.update(ausAuthoneEntity);
//        } catch (Exception e) {
//            LogUtil.error(e);
//            throw new WsRuntimeException("aus_authone表更新失败");
//        }
//    }
//
//    /**
//     * 登录失败更新错误次数 错误次数达到上限状态锁定
//     *
//     * @param failCount 当前认证失败次数
//     * @param rs
//     */
//    private void checkFailcount(int failCount, IResult rs) {
//        //获取系统参数 错误次数上限
//        int sysFailCount = Integer
//                .valueOf(CommonUtil.getSysConfigValue(SYS_PARAM_ID_LOGIN_ERROR, SYS_PARAM_TYPE_LOGIN_ERROR));
//        //更新错误次数 和 账户状态
//        AusAuthoneEntity ausAuthoneEntity = new AusAuthoneEntity();
//        ausAuthoneEntity.setCustomerno(customerno);
//        ausAuthoneEntity.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
//        ausAuthoneEntity.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
//        try {
//            if (failCount + 1 >= sysFailCount) {
//                //错误次数加1 状态更新为锁定
//                ausAuthoneEntity.setFailcount(sysFailCount);
//                CifCustEntity c = new CifCustEntity();
//                c.setCustomerno(customerno);
//                c.setStatus(MacroDefine.CUST_STATUS.LOCK.getValue());
//                c.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
//                c.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
//                cifCustPersistence.update(c);
//            } else {
//                ausAuthoneEntity.setFailcount(failCount + 1);
//            }
//            ausAuthonePersistence.update(ausAuthoneEntity);
//        } catch (Exception e) {
//            LogUtil.error(e);
//            throw new WsRuntimeException("登录错误次数更新失败");
//        }
//        int failedExistCount=sysFailCount-ausAuthoneEntity.getFailcount();//剩余次数
//        if(failedExistCount>0){
//            rs.failed("用户名或密码错误,剩余"+StringUtil.valueOf(failedExistCount)+"次机会");
//        }else{
//            rs.failed("用户名或密码错误,账户已锁定");
//        }
//    }
//
//    /**
//     * 检查基本信息是否填写完整
//     *
//     * @param rs
//     * @return
//     */
//    private boolean checkIsFinish(IResult rs) {
//        if (NO.equals(membertype)) {
//            CifPersonInfoEntity e = cifPersonInfoPersistence.queryEntity(customerno);
//            if (CheckUtil.isNull(e)) {
//                rs.failed("未获取到基本信息");
//                throw new WsRuntimeException(rs.getErrorMessage());
//            }
//            membername = e.getMembername();
//            if (CheckUtil.isNull(e.getMembername())) {
//                return false;
//            }
//            if (CheckUtil.isNull(e.getEducation())) {
//                return false;
//            }
//            if (CheckUtil.isNull(e.getWorkexp())) {
//                return false;
//            }
//            if (CheckUtil.isNull(e.getInvestexp())) {
//                return false;
//            }
//            if (CheckUtil.isNull(e.getIdcard())) {
//                return false;
//            }
//            if (CheckUtil.isNull(e.getIsamac())) {
//                return false;
//            }
//            if (CheckUtil.isNull(e.getAmacno())) {
//                return false;
//            }
//        } else {
//            CifOrganInfoEntity c = cifOrganInfoPersistence.queryEntity(customerno);
//            if (CheckUtil.isNull(c)) {
//                rs.failed("企业基本信息获取失败");
//                throw new WsRuntimeException(rs.getErrorMessage());
//            }
//            organtype = c.getOrgantype();
//            organclass = c.getOrganclass();
//            membername = c.getMembername();
//            //6类企业的基本信息差异字段 保存在 企业附属信息表
//            CifOrganAppendEntity entity = PersistenceUtil.getPersistence(CifOrganAppendPersistence.class)
//                    .queryEntity(customerno);
//            if (CheckUtil.isNull(entity)) {
//                return false;
//            }
//            //6类企业基本信息检查
//            if (!checkOrganInfoCommon(c)) {
//                return false;
//            }
//            //差异性检查
//            if ("0".equals(c.getOrganclass())) {
//                return checkOrganInfo0(entity);
//            } else if ("1".equals(c.getOrganclass())) {
//                return checkOrganInfo1(entity);
//            } else if ("2".equals(c.getOrganclass())) {
//                return checkOrganInfo2(entity);
//            } else if ("3".equals(c.getOrganclass())) {
//                return checkOrganInfo3(entity);
//            } else if ("4".equals(c.getOrganclass())) {
//                return checkOrganInfo4(entity);
//            } else if ("5".equals(c.getOrganclass())) {
//                return checkOrganInfo5(entity);
//            } else {
//                rs.failed("企业分类字典值[" + c.getOrganclass() + "]有误");
//                throw new WsRuntimeException(rs.getErrorMessage());
//            }
//        }
//        return true;
//    }
//
//    /**
//     * 基本信息页面 6类企业公共字段检查
//     *
//     * @param rs
//     * @return
//     */
//    private boolean checkOrganInfoCommon(CifOrganInfoEntity c) {
//        if (CheckUtil.isNull(c.getSparecontactname())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getSparecontactmobile())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRegicapital())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getEstablishdate())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRealprovince())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRealcity())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRealcounty())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRealtreet())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRegisterprovince())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRegistercity())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRegistercounty())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRegistertreet())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getBusinessscope())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getCompanyintro())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getHanginfo())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getCompanymodel())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getInvestsource())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getBusinessfile())) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 基金管理人企业
//     *
//     * @param c
//     * @return
//     */
//    private boolean checkOrganInfo0(CifOrganAppendEntity c) {
//        if (CheckUtil.isNull(c.getIsfiling())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getRegisterno())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getEmployeenum())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getCaremarkettype())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getProjectphase())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getProfittype())) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 基金项目产业企业
//     *
//     * @param c
//     * @return
//     */
//    private boolean checkOrganInfo1(CifOrganAppendEntity c) {
//        if (CheckUtil.isNull(c.getIsfundfiling())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getFundfilingno())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getFundmanagername())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getFundmanagerno())) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 个人自有资金投资平台类企业
//     *
//     * @param c
//     * @return
//     */
//    private boolean checkOrganInfo2(CifOrganAppendEntity c) {
//        if (CheckUtil.isNull(c.getCompanytrade())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getCompanyname())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getCompanyinfo())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getInvestnum())) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 企业自有资金投资平台类企业
//     *
//     * @param c
//     * @return
//     */
//    private boolean checkOrganInfo3(CifOrganAppendEntity c) {
//        if (CheckUtil.isNull(c.getProjecttrade())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getProjectintro())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getBlocname())) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 融资租赁企业
//     *
//     * @param c
//     * @return
//     */
//    private boolean checkOrganInfo4(CifOrganAppendEntity c) {
//        if (CheckUtil.isNull(c.getClassify())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getBusinesstype())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getObjecttype())) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 其他企业
//     *
//     * @param c
//     * @return
//     */
//    private boolean checkOrganInfo5(CifOrganAppendEntity c) {
//        if (CheckUtil.isNull(c.getSpecificbusinesstype())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getProfitmodel())) {
//            return false;
//        }
//        if (CheckUtil.isNull(c.getCapitalsource())) {
//            return false;
//        }
//        return true;
//    }
//}
