package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 企业基本信息变更记录表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:09
 */
public class OrganInfoChangeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 企业客户代码
     */
    private String customerno;
    /**
     * 版本号（由小到大）
     */
    private Integer version;
    /**
     * 企业名称
     */
    private String membername;
    /**
     * 企业类型 字典104 0-有限公司 1-合伙企业
     */
    private String organtype;
    /**
     * 企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业
     */
    private String organclass;
    /**
     * 变更发起人
     */
    private String startcustomerno;
    /**
     * 服务人员
     */
    private String servicecustomerno;
    /**
     * 办理流程 字典120 0-现场 1-半电子 2-全电子
     */
    private String dealflow;
    /**
     * 经营期限
     */
    private String managelimit;
    /**
     * 缴付期限
     */
    private String paydatelimit;
    /**
     * 注册地址(省) dict101021
     */
    private String registerprovince;
    /**
     * 注册地址(市) dict101022
     */
    private String registercity;
    /**
     * 注册地址(区/县) dict101023
     */
    private String registercounty;
    /**
     * 注册地址(街道)
     */
    private String registertreet;
    /**
     * 实际地址(省) dict101021
     */
    private String realprovince;
    /**
     * 实际地址(市) dict101022
     */
    private String realcity;
    /**
     * 实际地址(区/县) dict101023
     */
    private String realcounty;
    /**
     * 实际地址(街道)
     */
    private String realtreet;
    /**
     * 经营范围/主营业务
     */
    private String businessscope;
    /**
     * 执行事务合伙人类型 字典 107  0-个人 1-公司
     */
    private String partnertype;
    /**
     * 执行事务合伙人名称
     */
    private String partnername;
    /**
     * 注册资本（金）认缴出资额(万元)
     */
    private String regicapital;
    /**
     * 注册资本金币种
     */
    private String regicapitalbz;
    /**
     * 是否存在董事会 0-否 1-是
     */
    private String isboard;
    /**
     * 是否存在监事会 0-否 1-是
     */
    private String issupervision;
    /**
     * 备用联系人
     */
    private String sparecontactname;
    /**
     * 备用联系人手机号码
     */
    private String sparecontactmobile;
    /**
     * 成立时间 年月日
     */
    private String establishdate;
    /**
     * 公司简介
     */
    private String companyintro;
    /**
     * 挂牌情况 字典 112
     */
    private String hanginfo;
    /**
     * 企业成份 字典 113
     */
    private String companymodel;
    /**
     * 投资来源 字典 114
     */
    private String investsource;
    /**
     * 营业执照附件
     */
    private String businessfile;
    /**
     * 企业设立附件
     */
    private String establishfile;
    /**
     * 企业变更附件
     */
    private String modifyfile;
    /**
     * 插入日期
     */
    private String insertdate;
    /**
     * 插入时间
     */
    private String inserttime;

    /**
     * 设置：企业客户代码
     */
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    /**
     * 获取：企业客户代码
     */
    public String getCustomerno() {
        return customerno;
    }

    /**
     * 设置：版本号（由小到大）
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取：版本号（由小到大）
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置：企业名称
     */
    public void setMembername(String membername) {
        this.membername = membername;
    }

    /**
     * 获取：企业名称
     */
    public String getMembername() {
        return membername;
    }

    /**
     * 设置：企业类型 字典104 0-有限公司 1-合伙企业
     */
    public void setOrgantype(String organtype) {
        this.organtype = organtype;
    }

    /**
     * 获取：企业类型 字典104 0-有限公司 1-合伙企业
     */
    public String getOrgantype() {
        return organtype;
    }

    /**
     * 设置：企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业
     */
    public void setOrganclass(String organclass) {
        this.organclass = organclass;
    }

    /**
     * 获取：企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业
     */
    public String getOrganclass() {
        return organclass;
    }

    /**
     * 设置：变更发起人
     */
    public void setStartcustomerno(String startcustomerno) {
        this.startcustomerno = startcustomerno;
    }

    /**
     * 获取：变更发起人
     */
    public String getStartcustomerno() {
        return startcustomerno;
    }

    /**
     * 设置：服务人员
     */
    public void setServicecustomerno(String servicecustomerno) {
        this.servicecustomerno = servicecustomerno;
    }

    /**
     * 获取：服务人员
     */
    public String getServicecustomerno() {
        return servicecustomerno;
    }

    /**
     * 设置：办理流程 字典120 0-现场 1-半电子 2-全电子
     */
    public void setDealflow(String dealflow) {
        this.dealflow = dealflow;
    }

    /**
     * 获取：办理流程 字典120 0-现场 1-半电子 2-全电子
     */
    public String getDealflow() {
        return dealflow;
    }

    /**
     * 设置：经营期限
     */
    public void setManagelimit(String managelimit) {
        this.managelimit = managelimit;
    }

    /**
     * 获取：经营期限
     */
    public String getManagelimit() {
        return managelimit;
    }

    /**
     * 设置：缴付期限
     */
    public void setPaydatelimit(String paydatelimit) {
        this.paydatelimit = paydatelimit;
    }

    /**
     * 获取：缴付期限
     */
    public String getPaydatelimit() {
        return paydatelimit;
    }

    /**
     * 设置：注册地址(省) dict101021
     */
    public void setRegisterprovince(String registerprovince) {
        this.registerprovince = registerprovince;
    }

    /**
     * 获取：注册地址(省) dict101021
     */
    public String getRegisterprovince() {
        return registerprovince;
    }

    /**
     * 设置：注册地址(市) dict101022
     */
    public void setRegistercity(String registercity) {
        this.registercity = registercity;
    }

    /**
     * 获取：注册地址(市) dict101022
     */
    public String getRegistercity() {
        return registercity;
    }

    /**
     * 设置：注册地址(区/县) dict101023
     */
    public void setRegistercounty(String registercounty) {
        this.registercounty = registercounty;
    }

    /**
     * 获取：注册地址(区/县) dict101023
     */
    public String getRegistercounty() {
        return registercounty;
    }

    /**
     * 设置：注册地址(街道)
     */
    public void setRegistertreet(String registertreet) {
        this.registertreet = registertreet;
    }

    /**
     * 获取：注册地址(街道)
     */
    public String getRegistertreet() {
        return registertreet;
    }

    /**
     * 设置：实际地址(省) dict101021
     */
    public void setRealprovince(String realprovince) {
        this.realprovince = realprovince;
    }

    /**
     * 获取：实际地址(省) dict101021
     */
    public String getRealprovince() {
        return realprovince;
    }

    /**
     * 设置：实际地址(市) dict101022
     */
    public void setRealcity(String realcity) {
        this.realcity = realcity;
    }

    /**
     * 获取：实际地址(市) dict101022
     */
    public String getRealcity() {
        return realcity;
    }

    /**
     * 设置：实际地址(区/县) dict101023
     */
    public void setRealcounty(String realcounty) {
        this.realcounty = realcounty;
    }

    /**
     * 获取：实际地址(区/县) dict101023
     */
    public String getRealcounty() {
        return realcounty;
    }

    /**
     * 设置：实际地址(街道)
     */
    public void setRealtreet(String realtreet) {
        this.realtreet = realtreet;
    }

    /**
     * 获取：实际地址(街道)
     */
    public String getRealtreet() {
        return realtreet;
    }

    /**
     * 设置：经营范围/主营业务
     */
    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope;
    }

    /**
     * 获取：经营范围/主营业务
     */
    public String getBusinessscope() {
        return businessscope;
    }

    /**
     * 设置：执行事务合伙人类型 字典 107  0-个人 1-公司
     */
    public void setPartnertype(String partnertype) {
        this.partnertype = partnertype;
    }

    /**
     * 获取：执行事务合伙人类型 字典 107  0-个人 1-公司
     */
    public String getPartnertype() {
        return partnertype;
    }

    /**
     * 设置：执行事务合伙人名称
     */
    public void setPartnername(String partnername) {
        this.partnername = partnername;
    }

    /**
     * 获取：执行事务合伙人名称
     */
    public String getPartnername() {
        return partnername;
    }

    /**
     * 设置：注册资本（金）认缴出资额(万元)
     */
    public void setRegicapital(String regicapital) {
        this.regicapital = regicapital;
    }

    /**
     * 获取：注册资本（金）认缴出资额(万元)
     */
    public String getRegicapital() {
        return regicapital;
    }

    /**
     * 设置：注册资本金币种
     */
    public void setRegicapitalbz(String regicapitalbz) {
        this.regicapitalbz = regicapitalbz;
    }

    /**
     * 获取：注册资本金币种
     */
    public String getRegicapitalbz() {
        return regicapitalbz;
    }

    /**
     * 设置：是否存在董事会 0-否 1-是
     */
    public void setIsboard(String isboard) {
        this.isboard = isboard;
    }

    /**
     * 获取：是否存在董事会 0-否 1-是
     */
    public String getIsboard() {
        return isboard;
    }

    /**
     * 设置：是否存在监事会 0-否 1-是
     */
    public void setIssupervision(String issupervision) {
        this.issupervision = issupervision;
    }

    /**
     * 获取：是否存在监事会 0-否 1-是
     */
    public String getIssupervision() {
        return issupervision;
    }

    /**
     * 设置：备用联系人
     */
    public void setSparecontactname(String sparecontactname) {
        this.sparecontactname = sparecontactname;
    }

    /**
     * 获取：备用联系人
     */
    public String getSparecontactname() {
        return sparecontactname;
    }

    /**
     * 设置：备用联系人手机号码
     */
    public void setSparecontactmobile(String sparecontactmobile) {
        this.sparecontactmobile = sparecontactmobile;
    }

    /**
     * 获取：备用联系人手机号码
     */
    public String getSparecontactmobile() {
        return sparecontactmobile;
    }

    /**
     * 设置：成立时间 年月日
     */
    public void setEstablishdate(String establishdate) {
        this.establishdate = establishdate;
    }

    /**
     * 获取：成立时间 年月日
     */
    public String getEstablishdate() {
        return establishdate;
    }

    /**
     * 设置：公司简介
     */
    public void setCompanyintro(String companyintro) {
        this.companyintro = companyintro;
    }

    /**
     * 获取：公司简介
     */
    public String getCompanyintro() {
        return companyintro;
    }

    /**
     * 设置：挂牌情况 字典 112
     */
    public void setHanginfo(String hanginfo) {
        this.hanginfo = hanginfo;
    }

    /**
     * 获取：挂牌情况 字典 112
     */
    public String getHanginfo() {
        return hanginfo;
    }

    /**
     * 设置：企业成份 字典 113
     */
    public void setCompanymodel(String companymodel) {
        this.companymodel = companymodel;
    }

    /**
     * 获取：企业成份 字典 113
     */
    public String getCompanymodel() {
        return companymodel;
    }

    /**
     * 设置：投资来源 字典 114
     */
    public void setInvestsource(String investsource) {
        this.investsource = investsource;
    }

    /**
     * 获取：投资来源 字典 114
     */
    public String getInvestsource() {
        return investsource;
    }

    /**
     * 设置：营业执照附件
     */
    public void setBusinessfile(String businessfile) {
        this.businessfile = businessfile;
    }

    /**
     * 获取：营业执照附件
     */
    public String getBusinessfile() {
        return businessfile;
    }

    /**
     * 设置：企业设立附件
     */
    public void setEstablishfile(String establishfile) {
        this.establishfile = establishfile;
    }

    /**
     * 获取：企业设立附件
     */
    public String getEstablishfile() {
        return establishfile;
    }

    /**
     * 设置：企业变更附件
     */
    public void setModifyfile(String modifyfile) {
        this.modifyfile = modifyfile;
    }

    /**
     * 获取：企业变更附件
     */
    public String getModifyfile() {
        return modifyfile;
    }

    /**
     * 设置：插入日期
     */
    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }

    /**
     * 获取：插入日期
     */
    public String getInsertdate() {
        return insertdate;
    }

    /**
     * 设置：插入时间
     */
    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * 获取：插入时间
     */
    public String getInserttime() {
        return inserttime;
    }
}
