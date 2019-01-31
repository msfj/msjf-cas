//package com.msjf.finance.cas.modules.organ.service.impl;
//
//import com.msjf.finance.cas.common.dao.entity.CustEntity;
//import com.msjf.finance.cas.common.dao.entity.PersonInfoEntity;
//import com.msjf.finance.cas.common.dao.key.CustKey;
//import com.msjf.finance.cas.common.dao.key.PersonInfoKey;
//import com.msjf.finance.cas.common.dao.persistence.CustDao;
//import com.msjf.finance.cas.common.dao.persistence.PersonInfoDao;
//import com.msjf.finance.cas.common.utils.DateUtils;
//import com.msjf.finance.cas.common.utils.StringUtil;
//import com.msjf.finance.cas.modules.Account.Account;
//import com.msjf.finance.msjf.core.response.Response;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 个人信息管理
// * Created by csw on 2019/1/29.
// */
//@Service("personMangerService")
//@Scope("prototype")
//public class PersonMangerServiceImpl extends Account {
//    /** 客户代码 */
//    private String customerno;
//
//    /** 企业客户代码 */
//    private String orgcustomerno;
//
//    /** 用户名称 */
//    private String membername;
//
//    /** 证件类型 */
//    private String certificatetype;
//
//    /** 证件号 */
//    private String certificateno;
//
//
//    /** 邮箱 */
//    private String email;
//
//    /** 联系人 */
//    private String mobile;
//
//    /** 手机号码 */
//    private String linkmanname;
//
//    /** 招商对接人 */
//    private String dockingpeople;
//
//    /** 学历 */
//    private String education;
//
//    /** 工作经验 */
//    private String workexp;
//
//    /** 投资经历 */
//    private String investexp;
//
//    /** 身份证正反面 */
//    private String idcard;
//
//    /** 是否拥有基金从业资格证 */
//    private String isamac;
//
//    /** 基金从业资格证号 */
//    private String amacno;
//
//    /** 公司名称或者股东名称 */
//    private String companyname;
//
//    @Resource
//    CustDao custDao;
//    @Resource
//    PersonInfoDao personInfoDao;
//
//    private void getParam(HashMap<String, Object> mapParam) {
//        customerno = StringUtil.valueOf(mapParam.get("customerno"));
//        orgcustomerno = StringUtil.valueOf(mapParam.get("orgcustomerno"));
//        membername = StringUtil.valueOf(mapParam.get("membername"));
//        certificatetype = StringUtil.valueOf(mapParam.get("certificatetype"));
//        certificateno = StringUtil.valueOf(mapParam.get("certificateno"));
//        email = StringUtil.valueOf(mapParam.get("email"));
//        mobile = StringUtil.valueOf(mapParam.get("mobile"));
//        linkmanname = StringUtil.valueOf(mapParam.get("linkmanname"));
//        dockingpeople = StringUtil.valueOf(mapParam.get("dockingpeople"));
//        education = StringUtil.valueOf(mapParam.get("education"));
//        workexp = StringUtil.valueOf(mapParam.get("workexp"));
//        investexp = StringUtil.valueOf(mapParam.get("investexp"));
//        idcard = StringUtil.valueOf(mapParam.get("idcard"));
//        isamac = StringUtil.valueOf(mapParam.get("isamac"));
//        amacno = StringUtil.valueOf(mapParam.get("amacno"));
//        companyname= StringUtil.valueOf(mapParam.get("companyname"));
//    }
//    /**
//     * 个人信息入口
//     *
//     * @param mapParam
//     * @param rs
//     * @throws Exception
//     */
//    public Response<Map> personInfo(HashMap<String, Object> mapParam) {
//        Response rs=new Response();
//        rs.fail(serviceName,"查询失败");
//        getParam(mapParam);
//        Map<String, String> paramMap = new HashMap<String, String>();
//        if (StringUtils.isEmpty(customerno)) {
//            return rs.fail(serviceName,"客户代码不能为空");
//        }
//        paramMap.put("customerno", customerno);
//        try {
//            Map<String, String> infoMap = cifOrganInfoPersistence.queryObject("get_personInfo_by_customerno", paramMap);
//            String appdockingpeople = infoMap.get("appdockingpeople");
//            if (!StringUtils.isEmpty(appdockingpeople)) {
//                if (!appdockingpeople.equals("无")) {
//                    infoMap.put("dockingpeople", appdockingpeople);
//                }
//            }
//            rs.success(infoMap);
//        } catch (Exception e) {
//            logger.error(e);
//            throw new RuntimeException("查询报告失败");
//        }
//    }
//
//    /**
//     * 个人信息修改入口
//     *
//     * @param mapParam
//     * @param rs
//     * @throws Exception
//     */
//    public Response updatePersonInfo(HashMap<String, Object> mapParam) {
//        Response rs=new Response();
//        rs.fail(serviceName,"修改失败");
//        getParam(mapParam);
//        if (StringUtils.isEmpty(customerno)) {
//            return rs.fail(serviceName,"客户代码不能为空");
//        }
//        if (!StringUtils.isEmpty(companyname)) {
//            if(companyname.length()>32){
//                return rs.fail(serviceName,"就职单位名称过长");
//            }
//        }
//
//        if (StringUtils.isEmpty(membername)) {
//            return rs.fail(serviceName,"客户名称不能为空");;
//        }
//        if(membername.length()>32){
//            rs.failed("客户名称过长");
//            return;
//        }
//        if (StringUtils.isEmpty(certificatetype, "证件类型", rs)) {
//            return;
//        }
//        if (StringUtils.isEmpty(certificateno, "证件号码", rs)) {
//            return;
//        }
//        if(certificateno.length()>32){
//            rs.failed("证件号码过长");
//            return;
//        }
//        if (StringUtils.isEmpty(email, "邮箱", rs)) {
//            return;
//        }
//        if(email.length()>32){
//            rs.failed("邮箱过长");
//            return;
//        }
//        if (StringUtils.isEmpty(mobile, "手机号码", rs)) {
//            return;
//        }
//        if(mobile.length()>32){
//            rs.failed("邮箱过长");
//            return;
//        }
//        if (StringUtils.isEmpty(dockingpeople, "招商对接人", rs)) {
//            return;
//        }
//        if (StringUtils.isEmpty(education, "学历", rs)) {
//            return;
//        }
//        if (StringUtils.isEmpty(workexp, "工作经历", rs)) {
//            return;
//        }
//        if (StringUtils.isEmpty(investexp, "投资经历", rs)) {
//            return;
//        }
//		/*if (CheckUtil.checkNull(idcard, "身份证正反面", rs)) {
//			return;
//		}*/
//        if (StringUtils.isEmpty(isamac, "是否拥有基金从业资格证", rs)) {
//            return;
//        }
//        if (isamac.equals(YES)) {
//            if (StringUtils.isEmpty(amacno, "基金从业资格证号码", rs)) {
//                return;
//            }
//        } else if (isamac.equals(NO)) {
//            amacno = " ";
//        }
//        CustKey custKey = new CustKey();
//        custKey.setKey(customerno);
//        CustEntity custEntity = custDao.getEntityKey(custKey);
//        if (StringUtils.isEmpty(custEntity)) {
//            return rs.fail(serviceName,"用户公共信息不存在");
//        }
//        custEntity.setEmail(email);
//        custEntity.setCertificateno(certificateno);
//        custEntity.setCertificatetype(certificatetype);
//        custEntity.setCompanyname(companyname);
////		custEntity.setMobile(mobile);
//        custEntity.setIssave("1");//有保存说明信息是完整的
//        custEntity.setUpdatedate(DateUtils.getUserDate("yyyyMMdd"));
//        custEntity.setUpdatetime(DateUtils.getUserDate("HHmmss"));
//        try {
//            custDao.updEntity(custEntity);
//        } catch (Exception e) {
//            logger.error(e);
//            throw new RuntimeException("修改cif_cust表失败");
//        }
//        PersonInfoKey personInfoKey = new PersonInfoKey();
//        personInfoKey.setKey(customerno);
//        PersonInfoEntity personInfoEntity = personInfoDao.getEntityKey(personInfoKey);
//        if (StringUtils.isEmpty(personInfoEntity)) {
//            return rs.fail(serviceName,"用户个人信息不存在");
//        }
//        personInfoEntity.setEducation(education);
//        personInfoEntity.setAmacno(amacno);
//        personInfoEntity.setIdcard(idcard);
//        personInfoEntity.setInvestexp(investexp);
//        personInfoEntity.setIsamac(isamac);
//        personInfoEntity.setWorkexp(workexp);
//        personInfoEntity.setMembername(membername);
//        personInfoEntity.setUpdatedate(DateUtils.getUserDate("yyyyMMdd"));
//        personInfoEntity.setUpdatetime(DateUtils.getUserDate("HHmmss"));
//        try {
//            personInfoDao.updEntity(personInfoEntity);
//        } catch (Exception e) {
//            logger.error(e);
//            throw new RuntimeException("修改cif_cust表失败");
//        }
//        rs.success("修改成功");
//    }
//}
