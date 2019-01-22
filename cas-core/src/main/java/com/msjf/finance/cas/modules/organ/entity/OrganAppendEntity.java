package com.msjf.finance.cas.modules.organ.entity;

/***
 *OrganAppendEntity
 *企业附属信息表
 */
public class OrganAppendEntity extends OrganAppendKey {
    //版本号
    private Integer version;
    //基金管理人企业-是否备案 0-否 1-是
    private String isfiling;
    //基金管理人企业-登记编码
    private String registerno;
    //基金管理人企业-从业人员数量
    private String employeenum;
    //基金管理人企业-投资所关注行业市场类型（多选） 字典 dict20025
    private String caremarkettype;
    //基金管理人企业-关注的项目阶段（多选）dict20026
    private String projectphase;
    //基金管理人企业-投资获得收益方式
    private String profittype;
    //基金项目企业-产品是否备案 0-否 1-是
    private String isfundfiling;
    //基金项目企业-产品备案编码
    private String fundfilingno;
    //基金项目企业-所属基金管理人
    private String fundmanagername;
    //基金项目企业-所属基金管理人编码（登记编码）
    private String fundmanagerno;
    //基金项目企业-所属基金管理人基本情况介绍
    private String fundmanagerintro;
    //基金项目企业-所投项目所属行业（多选） dict20025
    private String fundprojecttrade;
    //基金项目企业-关注的项目阶段（下拉）dict20026
    private String fundprojectphase;
    //基金项目企业-该产品所属投资
    private String belonginvest;
    //基金项目企业-预计平均年化收益率
    private String annualrate;
    //基金项目企业-资金募集方式
    private String raisetype;
    //基金项目企业-投资者人数
    private String invertcount;
    //基金项目企业-所投项目情况简介（可不透露具体名称）
    private String fundprojectintro;
    //个人自有资金-所投公司所属行业/二级市场 dict20025
    private String companytrade;
    //个人自有资金-所投公司具体名称
    private String companyname;
    //个人自有资金-所投公司基本信息
    private String companyinfo;
    //个人自有资金-所投项目所属行业 dict20025
    private String protrade;
    //个人自有资金-所投项目情况简介
    private String prointro;
    //个人自有资金-投资者人数
    private String investnum;
    //企业自有资金-所投项目所属行业 dict20025
    private String projecttrade;
    //企业自有资金-所投项目情况简介
    private String projectintro;
    //企业自有资金-所属集团企业
    private String blocname;
    //融资租赁企业-分类 字典115 0-产商系融资租赁 1-中间系融资租赁
    private String classify;
    //融资租赁企业-经营业务类型
    private String businesstype;
    //融资租赁企业-擅长租赁标的类型
    private String objecttype;
    //其他企业-具体业务类型
    private String specificbusinesstype;
    //其他企业-盈利模式
    private String profitmodel;
    //其他企业-资金来源
    private String capitalsource;
    //公共-主要负责人从业经历介绍
    private String mainworkexp;
    //公共-其他主要负责人介绍
    private String othersintro;
    //公共-股东背景介绍
    private String partnerintro;
    //插入日期
    private String insertdate;
    //插入时间
    private String inserttime;
    //更新日期
    private String updatedate;
    //更新时间
    private String updatetime;

    public void init() {
    }

    public String getCustomerno() {
        return this.customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getIsfiling() {
        return this.isfiling;
    }

    public void setIsfiling(String isfiling) {
        this.isfiling = isfiling;
    }

    public String getRegisterno() {
        return this.registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    public String getEmployeenum() {
        return this.employeenum;
    }

    public void setEmployeenum(String employeenum) {
        this.employeenum = employeenum;
    }

    public String getCaremarkettype() {
        return this.caremarkettype;
    }

    public void setCaremarkettype(String caremarkettype) {
        this.caremarkettype = caremarkettype;
    }

    public String getProjectphase() {
        return this.projectphase;
    }

    public void setProjectphase(String projectphase) {
        this.projectphase = projectphase;
    }

    public String getProfittype() {
        return this.profittype;
    }

    public void setProfittype(String profittype) {
        this.profittype = profittype;
    }

    public String getIsfundfiling() {
        return this.isfundfiling;
    }

    public void setIsfundfiling(String isfundfiling) {
        this.isfundfiling = isfundfiling;
    }

    public String getFundfilingno() {
        return this.fundfilingno;
    }

    public void setFundfilingno(String fundfilingno) {
        this.fundfilingno = fundfilingno;
    }

    public String getFundmanagername() {
        return this.fundmanagername;
    }

    public void setFundmanagername(String fundmanagername) {
        this.fundmanagername = fundmanagername;
    }

    public String getFundmanagerno() {
        return this.fundmanagerno;
    }

    public void setFundmanagerno(String fundmanagerno) {
        this.fundmanagerno = fundmanagerno;
    }

    public String getFundmanagerintro() {
        return this.fundmanagerintro;
    }

    public void setFundmanagerintro(String fundmanagerintro) {
        this.fundmanagerintro = fundmanagerintro;
    }

    public String getFundprojecttrade() {
        return this.fundprojecttrade;
    }

    public void setFundprojecttrade(String fundprojecttrade) {
        this.fundprojecttrade = fundprojecttrade;
    }

    public String getFundprojectphase() {
        return this.fundprojectphase;
    }

    public void setFundprojectphase(String fundprojectphase) {
        this.fundprojectphase = fundprojectphase;
    }

    public String getBelonginvest() {
        return this.belonginvest;
    }

    public void setBelonginvest(String belonginvest) {
        this.belonginvest = belonginvest;
    }

    public String getAnnualrate() {
        return this.annualrate;
    }

    public void setAnnualrate(String annualrate) {
        this.annualrate = annualrate;
    }

    public String getRaisetype() {
        return this.raisetype;
    }

    public void setRaisetype(String raisetype) {
        this.raisetype = raisetype;
    }

    public String getInvertcount() {
        return this.invertcount;
    }

    public void setInvertcount(String invertcount) {
        this.invertcount = invertcount;
    }

    public String getFundprojectintro() {
        return this.fundprojectintro;
    }

    public void setFundprojectintro(String fundprojectintro) {
        this.fundprojectintro = fundprojectintro;
    }

    public String getCompanytrade() {
        return this.companytrade;
    }

    public void setCompanytrade(String companytrade) {
        this.companytrade = companytrade;
    }

    public String getCompanyname() {
        return this.companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyinfo() {
        return this.companyinfo;
    }

    public void setCompanyinfo(String companyinfo) {
        this.companyinfo = companyinfo;
    }

    public String getProtrade() {
        return this.protrade;
    }

    public void setProtrade(String protrade) {
        this.protrade = protrade;
    }

    public String getProintro() {
        return this.prointro;
    }

    public void setProintro(String prointro) {
        this.prointro = prointro;
    }

    public String getInvestnum() {
        return this.investnum;
    }

    public void setInvestnum(String investnum) {
        this.investnum = investnum;
    }

    public String getProjecttrade() {
        return this.projecttrade;
    }

    public void setProjecttrade(String projecttrade) {
        this.projecttrade = projecttrade;
    }

    public String getProjectintro() {
        return this.projectintro;
    }

    public void setProjectintro(String projectintro) {
        this.projectintro = projectintro;
    }

    public String getBlocname() {
        return this.blocname;
    }

    public void setBlocname(String blocname) {
        this.blocname = blocname;
    }

    public String getClassify() {
        return this.classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getBusinesstype() {
        return this.businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public String getObjecttype() {
        return this.objecttype;
    }

    public void setObjecttype(String objecttype) {
        this.objecttype = objecttype;
    }

    public String getSpecificbusinesstype() {
        return this.specificbusinesstype;
    }

    public void setSpecificbusinesstype(String specificbusinesstype) {
        this.specificbusinesstype = specificbusinesstype;
    }

    public String getProfitmodel() {
        return this.profitmodel;
    }

    public void setProfitmodel(String profitmodel) {
        this.profitmodel = profitmodel;
    }

    public String getCapitalsource() {
        return this.capitalsource;
    }

    public void setCapitalsource(String capitalsource) {
        this.capitalsource = capitalsource;
    }

    public String getMainworkexp() {
        return this.mainworkexp;
    }

    public void setMainworkexp(String mainworkexp) {
        this.mainworkexp = mainworkexp;
    }

    public String getOthersintro() {
        return this.othersintro;
    }

    public void setOthersintro(String othersintro) {
        this.othersintro = othersintro;
    }

    public String getPartnerintro() {
        return this.partnerintro;
    }

    public void setPartnerintro(String partnerintro) {
        this.partnerintro = partnerintro;
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
}