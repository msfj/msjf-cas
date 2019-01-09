package com.msjf.finance.cas.modules.organ.entity;

/**
 * 企业基本信息表
 * Created by lzp on 2018/12/26.
 */
public class OrganInfoEntity extends OrganInfoKey{
    //版本号（由小到大）
    private Integer version;
    //企业名称
    private String membername;
    //企业类型 字典104 0-有限公司 1-合伙企业
    private String organtype;
    //企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业
    private String organclass;
    //企业状态 字典 106 0-企业设立中 1-企业已注册 2-企业已注销
    private String organstatus;
    //预核名发起人
    private String startcustomerno;
    //服务人员
    private String servicecustomerno;
    //办理流程 字典120 0-现场 1-半电子 2-全电子
    private String dealflow;
    //经营期限
    private String managelimit;
    //缴付期限
    private String paydatelimit;
    //注册地址(省) dict101021
    private String registerprovince;
    //注册地址(市) dict101022
    private String registercity;
    //注册地址(区/县) dict101023
    private String registercounty;
    //注册地址(街道)
    private String registertreet;
    //实际地址(省) dict101021
    private String realprovince;
    //实际地址(市) dict101022
    private String realcity;
    //实际地址(区/县) dict101023
    private String realcounty;
    //实际地址(街道)
    private String realtreet;
    //经营范围/主营业务
    private String businessscope;
    //执行事务合伙人类型 字典 107 0-个人 1-公司 -合伙企业属性
    private String partnertype;
    //执行事务合伙人名称
    private String partnername;
    //注册资本（金）认缴出资额(万元)
    private String regicapital;
    //注册资本金币种
    private String regicapitalbz;
    //是否存在董事会 0-否 1-是 -有限公司属性
    private String isboard;
    //是否存在监事会 0-否 1-是 -有限公司属性
    private String issupervision;
    //备用联系人
    private String sparecontactname;
    //备用联系人手机号码
    private String sparecontactmobile;
    //成立时间 年月日
    private String establishdate;
    //公司简介
    private String companyintro;
    //挂牌情况 字典 112
    private String hanginfo;
    //企业成份 字典 113
    private String companymodel;
    //投资来源 字典 114
    private String investsource;
    //营业执照附件
    private String businessfile;
    //企业设立附件
    private String establishfile;
    //企业变更附件
    private String modifyfile;
    //插入日期
    private String insertdate;
    //插入时间
    private String inserttime;
    //更新日期
    private String updatedate;
    //更新时间
    private String updatetime;
    //来源：1-企业注册服务平台；2-企业三方会签
    private String source;
    public void init() {
    }
    public Integer getVersion() {
        return this.version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public String getMembername() {
        return this.membername;
    }
    public void setMembername(String membername) {
        this.membername = membername;
    }
    public String getOrgantype() {
        return this.organtype;
    }
    public void setOrgantype(String organtype) {
        this.organtype = organtype;
    }
    public String getOrganclass() {
        return this.organclass;
    }
    public void setOrganclass(String organclass) {
        this.organclass = organclass;
    }
    public String getOrganstatus() {
        return this.organstatus;
    }
    public void setOrganstatus(String organstatus) {
        this.organstatus = organstatus;
    }
    public String getStartcustomerno() {
        return this.startcustomerno;
    }
    public void setStartcustomerno(String startcustomerno) {
        this.startcustomerno = startcustomerno;
    }
    public String getServicecustomerno() {
        return this.servicecustomerno;
    }
    public void setServicecustomerno(String servicecustomerno) {
        this.servicecustomerno = servicecustomerno;
    }
    public String getDealflow() {
        return this.dealflow;
    }
    public void setDealflow(String dealflow) {
        this.dealflow = dealflow;
    }
    public String getManagelimit() {
        return this.managelimit;
    }
    public void setManagelimit(String managelimit) {
        this.managelimit = managelimit;
    }
    public String getPaydatelimit() {
        return this.paydatelimit;
    }
    public void setPaydatelimit(String paydatelimit) {
        this.paydatelimit = paydatelimit;
    }
    public String getRegisterprovince() {
        return this.registerprovince;
    }
    public void setRegisterprovince(String registerprovince) {
        this.registerprovince = registerprovince;
    }
    public String getRegistercity() {
        return this.registercity;
    }
    public void setRegistercity(String registercity) {
        this.registercity = registercity;
    }
    public String getRegistercounty() {
        return this.registercounty;
    }
    public void setRegistercounty(String registercounty) {
        this.registercounty = registercounty;
    }
    public String getRegistertreet() {
        return this.registertreet;
    }
    public void setRegistertreet(String registertreet) {
        this.registertreet = registertreet;
    }
    public String getRealprovince() {
        return this.realprovince;
    }
    public void setRealprovince(String realprovince) {
        this.realprovince = realprovince;
    }
    public String getRealcity() {
        return this.realcity;
    }
    public void setRealcity(String realcity) {
        this.realcity = realcity;
    }
    public String getRealcounty() {
        return this.realcounty;
    }
    public void setRealcounty(String realcounty) {
        this.realcounty = realcounty;
    }
    public String getRealtreet() {
        return this.realtreet;
    }
    public void setRealtreet(String realtreet) {
        this.realtreet = realtreet;
    }
    public String getBusinessscope() {
        return this.businessscope;
    }
    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope;
    }
    public String getPartnertype() {
        return this.partnertype;
    }
    public void setPartnertype(String partnertype) {
        this.partnertype = partnertype;
    }
    public String getPartnername() {
        return this.partnername;
    }
    public void setPartnername(String partnername) {
        this.partnername = partnername;
    }
    public String getRegicapital() {
        return this.regicapital;
    }
    public void setRegicapital(String regicapital) {
        this.regicapital = regicapital;
    }
    public String getRegicapitalbz() {
        return this.regicapitalbz;
    }
    public void setRegicapitalbz(String regicapitalbz) {
        this.regicapitalbz = regicapitalbz;
    }
    public String getIsboard() {
        return this.isboard;
    }
    public void setIsboard(String isboard) {
        this.isboard = isboard;
    }
    public String getIssupervision() {
        return this.issupervision;
    }
    public void setIssupervision(String issupervision) {
        this.issupervision = issupervision;
    }
    public String getSparecontactname() {
        return this.sparecontactname;
    }
    public void setSparecontactname(String sparecontactname) {
        this.sparecontactname = sparecontactname;
    }
    public String getSparecontactmobile() {
        return this.sparecontactmobile;
    }
    public void setSparecontactmobile(String sparecontactmobile) {
        this.sparecontactmobile = sparecontactmobile;
    }
    public String getEstablishdate() {
        return this.establishdate;
    }
    public void setEstablishdate(String establishdate) {
        this.establishdate = establishdate;
    }
    public String getCompanyintro() {
        return this.companyintro;
    }
    public void setCompanyintro(String companyintro) {
        this.companyintro = companyintro;
    }
    public String getHanginfo() {
        return this.hanginfo;
    }
    public void setHanginfo(String hanginfo) {
        this.hanginfo = hanginfo;
    }
    public String getCompanymodel() {
        return this.companymodel;
    }
    public void setCompanymodel(String companymodel) {
        this.companymodel = companymodel;
    }
    public String getInvestsource() {
        return this.investsource;
    }
    public void setInvestsource(String investsource) {
        this.investsource = investsource;
    }
    public String getBusinessfile() {
        return this.businessfile;
    }
    public void setBusinessfile(String businessfile) {
        this.businessfile = businessfile;
    }
    public String getEstablishfile() {
        return this.establishfile;
    }
    public void setEstablishfile(String establishfile) {
        this.establishfile = establishfile;
    }
    public String getModifyfile() {
        return this.modifyfile;
    }
    public void setModifyfile(String modifyfile) {
        this.modifyfile = modifyfile;
    }
    public String getInsertdate() {
        return this.insertdate;
    }
    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }
    public String getInserttime() {
        return this.inserttime;
    }
    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }
    public String getUpdatedate() {
        return this.updatedate;
    }
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }
    public String getUpdatetime() {
        return this.updatetime;
    }
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
