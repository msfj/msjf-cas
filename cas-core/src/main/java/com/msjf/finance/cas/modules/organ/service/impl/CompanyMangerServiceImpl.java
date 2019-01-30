package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.entity.OrganAppendEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.key.CustKey;
import com.msjf.finance.cas.common.dao.key.OrganAppendKey;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
import com.msjf.finance.cas.common.dao.persistence.CustDao;
import com.msjf.finance.cas.common.dao.persistence.OrganAppendDao;
import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.joindao.persistence.AccountJoinDao;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.DateUtils;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.Account.Account;
import com.msjf.finance.cas.modules.organ.emun.OrganInfoEmun;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 企业个人信息管理
 * Created by csw on 2019/1/29.
 */
@Service("companyMangerService")
@Scope("prototype")
public class CompanyMangerServiceImpl extends Account {
    /** 客户代码 */
    private String customerno;

    /** 企业客户代码 */
    private String orgcustomerno;

    /** 注册省 */
    private String registerprovince;

    /** 注册市 */
    private String registercity;

    /** 注册县区 */
    private String registercounty;

    /** 注册街道 */
    private String registertreet;

    /** 实际省 */
    private String realprovince;

    /** 实际市 */
    private String realcity;

    /** 实际区县 */
    private String realcounty;

    /** 实际街道 */
    private String realtreet;

    /** 企业分类 */
    private String organclass;

    /** 企业类别 */
    private String organtype;

    /** 所属招商部门 */
    private String dockingbranch;

    /** 公司名称或者股东名称 */
    private String companyname;

    /** 用户名称 */
    private String membername;

    /** 证件类型 */
    private String certificatetype;

    /** 证件号 */
    private String certificateno;

    /** 投资来源 企业类型 内资 外资 */
    private String investsource;

    /** 企业主营范围 */
    private String businessscope;
    /** 企业介绍 */
    private String companyintro;
    /** 成立时间 */
    private String establishdate;
    /** 备用联系人 */
    private String sparecontactname;
    /** 备用联系人电话 */
    private String sparecontactmobile;
    /** 注册资本 */
    private String regicapital;
    /** 注册资本币种 */
    private String regicapitalbz;
    /** 营业执照附件 */
    private String businessfile;

    /** 挂牌情况 */
    private String hanginfo;

    /** 公司成分 */
    private String companymodel;


    /** 邮箱 */
    private String email;

    /** 联系人 */
    private String mobile;

    /** 手机号码 */
    private String linkmanname;

    /** 招商对接人 */
    private String dockingpeople;

    /** 学历 */
    private String education;

    /** 工作经验 */
    private String workexp;

    /** 投资经历 */
    private String investexp;

    /** 身份证正反面 */
    private String idcard;

    /** 是否拥有基金从业资格证 */
    private String isamac;

    /** 基金从业资格证号 */
    private String amacno;

    // 企业扩展信息 基金公共
    /** 是否备案 */
    private String isfiling;

    /** 备案编号 */
    private String registerno;

    // 企业扩展信息 基金管理人企业
    /** 从业人员数量 */
    private String employeenum;

    /** 投资关注市场类型 */
    private String caremarkettype;

    /** 投资关注项目阶段 */
    private String projectphase;

    /** 投资获得收益来源 */
    private String profittype;

    // 基金项目产品企业
    /** 产品是否备案 0-否 1-是 */
    private String isfundfiling;

    /** 产品备案编码 */
    private String fundfilingno;

    /** 基金项目企业-所属基金管理人 */
    private String fundmanagername;

    /** 基金项目企业-所属基金管理人编码（登记编码） */
    private String fundmanagerno;

    // 个人自有资金投资平台类企业
    /** 个人自有资金-所投公司所属行业/二级市场 dict20025 */
    private String companytrade;

    /** 个人自有资金-所投公司具体名称 */
    private String companyName;

    /** 个人自有资金-所投公司具体信息 */
    private String companyinfo;

    /** 个人自有资金-投资人数 */
    private String investnum;

    // 企业自有资金投资平台类企业
    /** 企业自有资金-所投项目所属行业 dict20025 */
    private String projecttrade;

    /** 企业自有资金-所投项目情况简介 */
    private String projectintro;

    /** 企业自有资金-所属集团企业 */
    private String blocname;
    // 融资租赁企业
    /** 融资租赁企业-分类 字典115 0-产商系融资租赁 1-中间系融资租赁 */
    private String classify;
    /** 融资租赁企业-经营业务类型 */
    private String businesstype;
    /** 融资租赁企业-擅长租赁标的类型 */
    private String objecttype;
    // 其他企业
    /** 其他企业-具体业务类型 */
    private String specificbusinesstype;
    /** 其他企业-盈利模式 */
    private String profitmodel;
    /** 其他企业-资金来源 */
    private String capitalsource;
    /** 办公地址-宁波市   筛选出宁波市外 */
    private String org_office_address_city;
    /** 注册地址-宁波市   筛选出宁波市外 */
    private String org_register_address_city;
    /** 基金项目企业-所投项目所属行业（多选）  dict20025 */
    private String fundprojecttrade;
    /** 基金项目企业-关注的项目阶段（多选）dict20026 */
    private String fundprojectphase;
    /** 注册资金范围 */
    private String beginregicapital;
    /** 注册资金范围 */
    private String endregicapital;

    @Resource
    OrganInfoDao organInfoDao;
    @Resource
    AccountJoinDao accountJoinDao;
    @Resource
    CustDao custDao;
    @Resource
    OrganAppendDao organAppendDao;

    private void getParam(HashMap<String, Object> mapParam) {
        customerno = StringUtil.valueOf(mapParam.get("customerno"));
        orgcustomerno = StringUtil.valueOf(mapParam.get("orgcustomerno"));
        registercity = StringUtil.valueOf(mapParam.get("registercity"));
        registercounty = StringUtil.valueOf(mapParam.get("registercounty"));
        realcity = StringUtil.valueOf(mapParam.get("realcity"));
        realcounty = StringUtil.valueOf(mapParam.get("realcounty"));
        organclass = StringUtil.valueOf(mapParam.get("organclass"));
        organtype = StringUtil.valueOf(mapParam.get("organtype"));
        dockingbranch = StringUtil.valueOf(mapParam.get("dockingbranch"));
        companyname = StringUtil.valueOf(mapParam.get("companyname"));
        membername = StringUtil.valueOf(mapParam.get("membername"));
        certificatetype = StringUtil.valueOf(mapParam.get("certificatetype"));
        certificateno = StringUtil.valueOf(mapParam.get("certificateno"));
        email = StringUtil.valueOf(mapParam.get("email"));
        mobile = StringUtil.valueOf(mapParam.get("mobile"));
        linkmanname = StringUtil.valueOf(mapParam.get("linkmanname"));
        dockingpeople = StringUtil.valueOf(mapParam.get("dockingpeople"));
        education = StringUtil.valueOf(mapParam.get("education"));
        workexp = StringUtil.valueOf(mapParam.get("workexp"));
        investexp = StringUtil.valueOf(mapParam.get("investexp"));
        idcard = StringUtil.valueOf(mapParam.get("idcard"));
        isamac = StringUtil.valueOf(mapParam.get("isamac"));
        amacno = StringUtil.valueOf(mapParam.get("amacno"));
        registerprovince = StringUtil.valueOf(mapParam.get("registerprovince"));
        registertreet = StringUtil.valueOf(mapParam.get("registertreet"));
        realprovince = StringUtil.valueOf(mapParam.get("realprovince"));
        realtreet = StringUtil.valueOf(mapParam.get("realtreet"));
        businessfile = StringUtil.valueOf(mapParam.get("businessfile"));
        hanginfo = StringUtil.valueOf(mapParam.get("hanginfo"));
        companymodel = StringUtil.valueOf(mapParam.get("companymodel"));
        investsource = StringUtil.valueOf(mapParam.get("investsource"));
        isfiling = StringUtil.valueOf(mapParam.get("isfiling"));
        registerno = StringUtil.valueOf(mapParam.get("registerno"));
        employeenum = StringUtil.valueOf(mapParam.get("employeenum"));
        caremarkettype = StringUtil.valueOf(mapParam.get("caremarkettype"));
        projectphase = StringUtil.valueOf(mapParam.get("projectphase"));
        profittype = StringUtil.valueOf(mapParam.get("profittype"));
        isfundfiling = StringUtil.valueOf(mapParam.get("isfundfiling"));
        fundfilingno = StringUtil.valueOf(mapParam.get("fundfilingno"));
        fundmanagername = StringUtil.valueOf(mapParam.get("fundmanagername"));
        fundmanagerno = StringUtil.valueOf(mapParam.get("fundmanagerno"));
        fundprojectphase = StringUtil.valueOf(mapParam.get("fundprojectphase"));
        fundprojecttrade=StringUtil.valueOf(mapParam.get("fundprojecttrade"));
        companytrade = StringUtil.valueOf(mapParam.get("companytrade"));
        companyName = StringUtil.valueOf(mapParam.get("companyname"));
        companyinfo = StringUtil.valueOf(mapParam.get("companyinfo"));
        investnum = StringUtil.valueOf(mapParam.get("investnum"));
        projecttrade = StringUtil.valueOf(mapParam.get("projecttrade"));
        projectintro = StringUtil.valueOf(mapParam.get("projectintro"));
        blocname = StringUtil.valueOf(mapParam.get("blocname"));
        classify = StringUtil.valueOf(mapParam.get("classify"));
        businesstype = StringUtil.valueOf(mapParam.get("businesstype"));
        objecttype = StringUtil.valueOf(mapParam.get("objecttype"));
        specificbusinesstype = StringUtil.valueOf(mapParam.get("specificbusinesstype"));
        profitmodel = StringUtil.valueOf(mapParam.get("profitmodel"));
        capitalsource = StringUtil.valueOf(mapParam.get("capitalsource"));
        businessscope = StringUtil.valueOf(mapParam.get("businessscope"));
        companyintro = StringUtil.valueOf(mapParam.get("companyintro"));
        establishdate = StringUtil.valueOf(mapParam.get("establishdate"));
        sparecontactname = StringUtil.valueOf(mapParam.get("sparecontactname"));
        sparecontactmobile = StringUtil.valueOf(mapParam.get("sparecontactmobile"));
        regicapital = StringUtil.valueOf(mapParam.get("regicapital"));
        regicapitalbz = StringUtil.valueOf(mapParam.get("regicapitalbz"));
        beginregicapital = StringUtil.valueOf(mapParam.get("beginregicapital"));
        endregicapital = StringUtil.valueOf(mapParam.get("endregicapital"));
        org_office_address_city = StringUtil.valueOf(mapParam.get("org_office_address_city"));
        org_register_address_city = StringUtil.valueOf(mapParam.get("org_register_address_city"));
    }

    public Response<Map> companyPersonInfo(HashMap<String, Object> mapParam) {
        customerno= StringUtil.valueOf(mapParam.get("customerno"));
        Map<String, String> paramMap = new HashMap<String, String>();
        if (StringUtils.isEmpty(customerno)){
            return new Response().fail(OrganInfoEmun.MSG_PARAM_NULL);
        }
        OrganInfoKey organInfoKey = new OrganInfoKey();
        organInfoKey.setCustomerno(customerno);
        OrganInfoEntity organInfoEntity = organInfoDao.getEntityKey(organInfoKey);
        if (ObjectUtils.isEmpty(organInfoEntity)) {
            return new Response().fail(OrganInfoEmun.QUERY_INFO_NULL);
        }
        paramMap.put("organclass", organInfoEntity.getOrganclass());
        paramMap.put("organtype", organInfoEntity.getOrgantype());
        paramMap.put("customerno", customerno);
        HashMap reqMap=new HashMap();
        reqMap.put("customerno",customerno);
        Map<String, String> infoMap;
        try {
            infoMap = accountJoinDao.selectCompanyPersonInfo(reqMap);
            if(!StringUtils.isEmpty(infoMap.get("caremarkettype"))){
                infoMap.put("caremarkettypename", CommonUtil.getDictValueBatch("dict20025",infoMap.get("caremarkettype")));
            }
//			if(!CheckUtil.isNull(infoMap.get("fundprojecttrade"))){
//			    infoMap.put("fundprojecttradename",CommonUtil.getDictValueBatch("dict20025",infoMap.get
// ("fundprojecttrade")));
//			}
            if(!StringUtils.isEmpty(infoMap.get("companytrade"))){
                infoMap.put("companytradename",CommonUtil.getDictValueBatch("dict20025",infoMap.get("companytrade")));
            }
            if(!StringUtils.isEmpty(infoMap.get("projecttrade"))){
                infoMap.put("projecttradename",CommonUtil.getDictValueBatch("dict20025",infoMap.get("projecttrade")));
            }
//			if(!CheckUtil.isNull(infoMap.get("fundprojectphase"))){
//				infoMap.put("fundprojectphasename",CommonUtil.getDictValueBatch("dict20026",infoMap.get
// ("fundprojectphase")));
//			}
            if(!StringUtils.isEmpty(infoMap.get("projectphase"))) {
                infoMap.put("projectphasename", CommonUtil.getDictValueBatch("dict20026", infoMap.get("projectphase")));
            }
            //ResultUtil.makerSusResults("查询成功", infoMap, rs);
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException("查询失败");
        }
        return new Response<>().success(OrganInfoEmun.QUERY_INFO_SUCCESS,infoMap);
    }
    /**
     * 企业个人信息修改入口
     *
     * @param mapParam
     * @throws Exception
     */
    public Response companyPersonInfoUpdate(HashMap<String, Object> mapParam) {
        Response rs=new Response();
        rs.fail(serviceName,"修改失败");
        getParam(mapParam);
        if (StringUtils.isEmpty(customerno)) {
            return rs.fail(serviceName,"客户代码不能为空");
        }
        if (StringUtils.isEmpty(membername)) {
            return rs.fail(serviceName,"企业名称不能为空");
        }
        if (StringUtils.isEmpty(organtype)) {
            return rs.fail(serviceName,"企业类别不能为空");
        }
        if (StringUtils.isEmpty(certificatetype)) {
            return rs.fail(serviceName,"证件类型不能为空");
        }
        if (StringUtils.isEmpty(certificateno)) {
            return rs.fail(serviceName,"证件号不能为空");
        }
        if (StringUtils.isEmpty(businessscope)) {
            return rs.fail(serviceName,"主营范围不能为空");
        }
        if (StringUtils.isEmpty(companyintro)) {
            return rs.fail(serviceName,"公司介绍不能为空");
        }
        if (StringUtils.isEmpty(regicapital)) {
            return rs.fail(serviceName,"注册资本不能为空");
        }
        if (StringUtils.isEmpty(regicapitalbz)) {
            return rs.fail(serviceName,"注册资本金币种不能为空");
        }
        if (StringUtils.isEmpty(establishdate)) {
            return rs.fail(serviceName,"成立时间不能为空");
        }
        if (StringUtils.isEmpty(registerprovince)) {
            return rs.fail(serviceName,"注册省不能为空");
        }
        if (StringUtils.isEmpty(registercity)) {
            return rs.fail(serviceName,"注册市不能为空");
        }
        if (StringUtils.isEmpty(registercounty)) {
            return rs.fail(serviceName,"注册县区不能为空");
        }
        if (StringUtils.isEmpty(registertreet)) {
            return rs.fail(serviceName,"注册街道不能为空");
        }
        if (StringUtils.isEmpty(realprovince)) {
            return rs.fail(serviceName,"实际省不能为空");
        }
        if (StringUtils.isEmpty(realcity)) {
            return rs.fail(serviceName,"实际市不能为空");
        }
        if (StringUtils.isEmpty(realcounty)) {
            return rs.fail(serviceName,"实际县区不能为空");
        }
        if (StringUtils.isEmpty(realtreet)) {
            return rs.fail(serviceName,"实际街道不能为空");
        }
        if (StringUtils.isEmpty(linkmanname)) {
            return rs.fail(serviceName,"主要联系人不能为空");
        }
        if (StringUtils.isEmpty(mobile)) {
            return rs.fail(serviceName,"电话号码不能为空");
        }
        if (StringUtils.isEmpty(hanginfo)) {
            return rs.fail(serviceName,"挂牌情况不能为空");
        }
        if (StringUtils.isEmpty(companymodel)) {
            return rs.fail(serviceName,"企业成分不能为空");
        }
        if (StringUtils.isEmpty(investsource)) {
            return rs.fail(serviceName,"投资来源不能为空");
        }
		/*if (CheckUtil.checkNull(businessfile, "营业执照附件", rs)) {
			return;
		}*/
        CustKey custKey = new CustKey();
        custKey.setKey(customerno);
        CustEntity custEntity = custDao.getEntityKey(custKey);
        OrganInfoKey organInfoKey = new OrganInfoKey();
        organInfoKey.setKey(customerno);
        OrganInfoEntity organInfoEntity = organInfoDao.getEntityKey(organInfoKey);
        if(CheckUtil.isNull(organInfoEntity)||CheckUtil.isNull(organInfoEntity)){
            return rs.fail(serviceName,"企业信息不存在");
        }
        custEntity.setCertificatetype(certificatetype);
        custEntity.setCertificateno(certificateno);
        custEntity.setLinkmanname(linkmanname);
//		custEntity.setMobile(mobile);
        custEntity.setIssave("1");//保存过一次就说明这个企业信息完整
        custEntity.setUpdatedate(DateUtils.getUserDate("yyyyMMdd"));
        custEntity.setUpdatetime(DateUtils.getUserDate("HHmmss"));
        try {
            custDao.updEntity(custEntity);
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException("修改cust表失败");
        }

        organInfoEntity.setMembername(membername);
        organInfoEntity.setBusinessscope(businessscope);
        organInfoEntity.setCompanyintro(companyintro);
        organInfoEntity.setRegicapital(regicapital);
        organInfoEntity.setRegicapitalbz(regicapitalbz);

        organInfoEntity.setEstablishdate(establishdate);
        organInfoEntity.setRegisterprovince(registerprovince);
        organInfoEntity.setRegistercity(registercity);
        organInfoEntity.setRegistercounty(registercounty);
        organInfoEntity.setRegistertreet(registertreet);
        organInfoEntity.setRealprovince(realprovince);
        organInfoEntity.setRealcity(realcity);
        organInfoEntity.setRealcounty(realcounty);
        organInfoEntity.setRealtreet(realtreet);
        organInfoEntity.setSparecontactname(sparecontactname);
        organInfoEntity.setSparecontactmobile(sparecontactmobile);
        organInfoEntity.setHanginfo(hanginfo);
        organInfoEntity.setCompanymodel(companymodel);
        organInfoEntity.setInvestsource(investsource);
        organInfoEntity.setBusinessfile(businessfile);
        organInfoEntity.setUpdatedate(DateUtils.getUserDate("yyyyMMdd"));
        organInfoEntity.setUpdatetime(DateUtils.getUserDate("HHmmss"));
        try {
            organInfoDao.updEntity(organInfoEntity);
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException("修改organInfo表失败");
        }
        OrganAppendKey appendKey = new OrganAppendKey();
        appendKey.setKey(customerno);
        OrganAppendEntity appendEntity = organAppendDao.getEntityKey(appendKey);
        String upFlag = YES;
        if(ObjectUtils.isEmpty(appendEntity)){
            appendEntity = new OrganAppendEntity();
            appendEntity.setCustomerno(customerno);
            upFlag = NO;
        }
        if(organInfoEntity.getOrganclass().equals(ORGCLASS_TYPE_0)){
            if (StringUtils.isEmpty(isfiling)) {
                return rs.fail(serviceName,"是否备案不能为空");
            }
            if(isfiling.equals(YES)){
                if (StringUtils.isEmpty(registerno)) {
                    return rs.fail(serviceName,"备案编号不能为空");
                }
                appendEntity.setRegisterno(registerno);
            }else if(isfiling.equals(NO)){
                appendEntity.setRegisterno(" ");
            }
            if (StringUtils.isEmpty(employeenum)) {
                return rs.fail(serviceName,"从业人员数量不能为空");
            }
            if (StringUtils.isEmpty(caremarkettype)) {
                return rs.fail(serviceName,"投资关注市场类型不能为空");
            }
            if (StringUtils.isEmpty(projectphase)) {
                return rs.fail(serviceName,"投资关注项目阶段不能为空");
            }
            if (StringUtils.isEmpty(profittype)) {
                return rs.fail(serviceName,"投资获得收益来源不能为空");
            }
            appendEntity.setIsfiling(isfiling);
            appendEntity.setEmployeenum(employeenum);
            appendEntity.setCaremarkettype(caremarkettype);
            appendEntity.setProjectphase(projectphase);
            appendEntity.setProfittype(profittype);
        }else if(organInfoEntity.getOrganclass().equals(ORGCLASS_TYPE_1)){
            if (StringUtils.isEmpty(isfundfiling)) {
                return rs.fail(serviceName,"是否备案不能为空");
            }
            if(isfundfiling.equals(YES)){
                if (StringUtils.isEmpty(fundfilingno)) {
                    return rs.fail(serviceName,"备案编号不能为空");
                }
                appendEntity.setFundfilingno(fundfilingno);
            }else if(isfundfiling.equals(NO)){
                appendEntity.setFundfilingno(" ");
            }

            if (StringUtils.isEmpty(fundmanagername)) {
                return rs.fail(serviceName,"所属基金管理人不能为空");
            }
            if (StringUtils.isEmpty(fundmanagerno)) {
                return rs.fail(serviceName,"所属基金管理人编码（登记编码）不能为空");
            }
            appendEntity.setIsfundfiling(isfundfiling);
            appendEntity.setFundmanagername(fundmanagername);
            appendEntity.setFundmanagerno(fundmanagerno);
//			if (CheckUtil.checkNull(fundprojectphase, "关注的项目阶段", rs)) {
//				return;
//			}
//			if (CheckUtil.checkNull(fundprojecttrade, "所投项目所属行业", rs)) {
//				return;
//			}
//			appendEntity.setFundprojectphase(fundprojectphase);
//			appendEntity.setFundprojecttrade(fundprojecttrade);
        }else if(organInfoEntity.getOrganclass().equals(ORGCLASS_TYPE_2)||organInfoEntity.getOrganclass().equals(ORGCLASS_TYPE_6)){
            if (StringUtils.isEmpty(companytrade)) {
                return rs.fail(serviceName,"所投公司所属行业/二级市场不能为空");
            }
            if (StringUtils.isEmpty(companyName)) {
                return rs.fail(serviceName,"所投公司具体名称不能为空");
            }
            if (StringUtils.isEmpty(companyinfo)) {
                return rs.fail(serviceName,"所投公司具体信息不能为空");
            }
            if (StringUtils.isEmpty(investnum)) {
                return rs.fail(serviceName,"投资人数不能为空");
            }
            appendEntity.setCompanytrade(companytrade);
            appendEntity.setCompanyname(companyName);
            appendEntity.setCompanyinfo(companyinfo);
            appendEntity.setInvestnum(investnum);
        }else if(organInfoEntity.getOrganclass().equals(ORGCLASS_TYPE_3)){
            if (StringUtils.isEmpty(projecttrade)) {
                return rs.fail(serviceName,"所投项目所属行业不能为空");
            }
            if (StringUtils.isEmpty(projectintro)) {
                return rs.fail(serviceName,"所投项目情况简介不能为空");
            }
            if (StringUtils.isEmpty(blocname)) {
                return rs.fail(serviceName,"所属集团企业不能为空");
            }
            appendEntity.setProjectintro(projectintro);
            appendEntity.setProjecttrade(projecttrade);
            appendEntity.setBlocname(blocname);
        }else if(organInfoEntity.getOrganclass().equals(ORGCLASS_TYPE_4)){
            if (StringUtils.isEmpty(classify)) {
                return rs.fail(serviceName,"融资租赁企业-分类不能为空");
            }
            if (StringUtils.isEmpty(businesstype)) {
                return rs.fail(serviceName,"经营业务类型不能为空");
            }
            if (StringUtils.isEmpty(objecttype)) {
                return rs.fail(serviceName,"擅长租赁标的类型不能为空");
            }
            appendEntity.setClassify(classify);
            appendEntity.setBusinesstype(businesstype);
            appendEntity.setObjecttype(objecttype);
        }else if(organInfoEntity.getOrganclass().equals(ORGCLASS_TYPE_5)){
            if (StringUtils.isEmpty(specificbusinesstype)) {
                return rs.fail(serviceName,"其他企业-具体业务类型不能为空");
            }
            if (StringUtils.isEmpty(profitmodel)) {
                return rs.fail(serviceName,"其他企业-盈利模式不能为空");
            }
            if (StringUtils.isEmpty(capitalsource)) {
                return rs.fail(serviceName,"其他企业-资金来源不能为空");
            }
            appendEntity.setSpecificbusinesstype(specificbusinesstype);
            appendEntity.setCapitalsource(capitalsource);
            appendEntity.setProfitmodel(profitmodel);
        }
        appendEntity.setUpdatedate(DateUtils.getUserDate("yyyyMMdd"));
        appendEntity.setUpdatetime(DateUtils.getUserDate("HHmmss"));
        if(upFlag.equals(YES)){
            try {
                organAppendDao.updEntity(appendEntity);
            } catch (Exception e) {
                logger.error(e);
                throw new RuntimeException("修改append表失败");
            }
        }else{
            appendEntity.setInsertdate(DateUtils.getUserDate("yyyyMMdd"));
            appendEntity.setUpdatetime(DateUtils.getUserDate("HHmmss"));
            try {
                organAppendDao.insEntity(appendEntity);
            } catch (Exception e) {
                logger.error(e);
                throw new RuntimeException("新增append表失败");
            }
        }
        return  rs.success("修改成功");
    }
}
