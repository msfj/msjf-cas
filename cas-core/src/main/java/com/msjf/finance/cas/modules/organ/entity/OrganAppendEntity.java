package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 企业附属信息表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:07
 */
public class OrganAppendEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 企业客户代码
     */

    private String customerno;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 基金管理人企业-是否备案 0-否 1-是
     */
    private String isfiling;
    /**
     * 基金管理人企业-登记编码
     */
    private String registerno;
    /**
     * 基金管理人企业-从业人员数量
     */
    private String employeenum;
    /**
     * 基金管理人企业-投资所关注行业市场类型（多选） 字典 dict20025
     */
    private String caremarkettype;
    /**
     * 基金管理人企业-关注的项目阶段（多选）dict20026
     */
    private String projectphase;
    /**
     * 基金管理人企业-投资获得收益方式
     */
    private String profittype;
    /**
     * 基金项目企业-产品是否备案 0-否 1-是
     */
    private String isfundfiling;
    /**
     * 基金项目企业-产品备案编码
     */
    private String fundfilingno;
    /**
     * 基金项目企业-所属基金管理人
     */
    private String fundmanagername;
    /**
     * 基金项目企业-所属基金管理人编码（登记编码）
     */
    private String fundmanagerno;
    /**
     * 基金项目企业-所属基金管理人基本情况介绍
     */
    private String fundmanagerintro;
    /**
     * 基金项目企业-所投项目所属行业（多选）  dict20025
     */
    private String fundprojecttrade;
    /**
     * 基金项目企业-关注的项目阶段（下拉）dict20026
     */
    private String fundprojectphase;
    /**
     * 基金项目企业-该产品所属投资
     */
    private String belonginvest;
    /**
     * 基金项目企业-预计平均年化收益率
     */
    private String annualrate;
    /**
     * 基金项目企业-资金募集方式
     */
    private String raisetype;
    /**
     * 基金项目企业-投资者人数
     */
    private String invertcount;
    /**
     * 基金项目企业-所投项目情况简介（可不透露具体名称）
     */
    private String fundprojectintro;
    /**
     * 个人自有资金-所投公司所属行业/二级市场  dict20025
     */
    private String companytrade;
    /**
     * 个人自有资金-所投公司具体名称
     */
    private String companyname;
    /**
     * 个人自有资金-所投公司基本信息
     */
    private String companyinfo;
    /**
     * 个人自有资金-所投项目所属行业  dict20025
     */
    private String protrade;
    /**
     * 个人自有资金-所投项目情况简介
     */
    private String prointro;
    /**
     * 个人自有资金-投资者人数
     */
    private String investnum;
    /**
     * 企业自有资金-所投项目所属行业  dict20025
     */
    private String projecttrade;
    /**
     * 企业自有资金-所投项目情况简介
     */
    private String projectintro;
    /**
     * 企业自有资金-所属集团企业
     */
    private String blocname;
    /**
     * 融资租赁企业-分类 字典115 0-产商系融资租赁 1-中间系融资租赁
     */
    private String classify;
    /**
     * 融资租赁企业-经营业务类型
     */
    private String businesstype;
    /**
     * 融资租赁企业-擅长租赁标的类型
     */
    private String objecttype;
    /**
     * 其他企业-具体业务类型
     */
    private String specificbusinesstype;
    /**
     * 其他企业-盈利模式
     */
    private String profitmodel;
    /**
     * 其他企业-资金来源
     */
    private String capitalsource;
    /**
     * 公共-主要负责人从业经历介绍
     */
    private String mainworkexp;
    /**
     * 公共-其他主要负责人介绍
     */
    private String othersintro;
    /**
     * 公共-股东背景介绍
     */
    private String partnerintro;
    /**
     * 插入日期
     */
    private String insertdate;
    /**
     * 插入时间
     */
    private String inserttime;
    /**
     * 更新日期
     */
    private String updatedate;
    /**
     * 更新时间
     */
    private String updatetime;

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
     * 设置：版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取：版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置：基金管理人企业-是否备案 0-否 1-是
     */
    public void setIsfiling(String isfiling) {
        this.isfiling = isfiling;
    }

    /**
     * 获取：基金管理人企业-是否备案 0-否 1-是
     */
    public String getIsfiling() {
        return isfiling;
    }

    /**
     * 设置：基金管理人企业-登记编码
     */
    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    /**
     * 获取：基金管理人企业-登记编码
     */
    public String getRegisterno() {
        return registerno;
    }

    /**
     * 设置：基金管理人企业-从业人员数量
     */
    public void setEmployeenum(String employeenum) {
        this.employeenum = employeenum;
    }

    /**
     * 获取：基金管理人企业-从业人员数量
     */
    public String getEmployeenum() {
        return employeenum;
    }

    /**
     * 设置：基金管理人企业-投资所关注行业市场类型（多选） 字典 dict20025
     */
    public void setCaremarkettype(String caremarkettype) {
        this.caremarkettype = caremarkettype;
    }

    /**
     * 获取：基金管理人企业-投资所关注行业市场类型（多选） 字典 dict20025
     */
    public String getCaremarkettype() {
        return caremarkettype;
    }

    /**
     * 设置：基金管理人企业-关注的项目阶段（多选）dict20026
     */
    public void setProjectphase(String projectphase) {
        this.projectphase = projectphase;
    }

    /**
     * 获取：基金管理人企业-关注的项目阶段（多选）dict20026
     */
    public String getProjectphase() {
        return projectphase;
    }

    /**
     * 设置：基金管理人企业-投资获得收益方式
     */
    public void setProfittype(String profittype) {
        this.profittype = profittype;
    }

    /**
     * 获取：基金管理人企业-投资获得收益方式
     */
    public String getProfittype() {
        return profittype;
    }

    /**
     * 设置：基金项目企业-产品是否备案 0-否 1-是
     */
    public void setIsfundfiling(String isfundfiling) {
        this.isfundfiling = isfundfiling;
    }

    /**
     * 获取：基金项目企业-产品是否备案 0-否 1-是
     */
    public String getIsfundfiling() {
        return isfundfiling;
    }

    /**
     * 设置：基金项目企业-产品备案编码
     */
    public void setFundfilingno(String fundfilingno) {
        this.fundfilingno = fundfilingno;
    }

    /**
     * 获取：基金项目企业-产品备案编码
     */
    public String getFundfilingno() {
        return fundfilingno;
    }

    /**
     * 设置：基金项目企业-所属基金管理人
     */
    public void setFundmanagername(String fundmanagername) {
        this.fundmanagername = fundmanagername;
    }

    /**
     * 获取：基金项目企业-所属基金管理人
     */
    public String getFundmanagername() {
        return fundmanagername;
    }

    /**
     * 设置：基金项目企业-所属基金管理人编码（登记编码）
     */
    public void setFundmanagerno(String fundmanagerno) {
        this.fundmanagerno = fundmanagerno;
    }

    /**
     * 获取：基金项目企业-所属基金管理人编码（登记编码）
     */
    public String getFundmanagerno() {
        return fundmanagerno;
    }

    /**
     * 设置：基金项目企业-所属基金管理人基本情况介绍
     */
    public void setFundmanagerintro(String fundmanagerintro) {
        this.fundmanagerintro = fundmanagerintro;
    }

    /**
     * 获取：基金项目企业-所属基金管理人基本情况介绍
     */
    public String getFundmanagerintro() {
        return fundmanagerintro;
    }

    /**
     * 设置：基金项目企业-所投项目所属行业（多选）  dict20025
     */
    public void setFundprojecttrade(String fundprojecttrade) {
        this.fundprojecttrade = fundprojecttrade;
    }

    /**
     * 获取：基金项目企业-所投项目所属行业（多选）  dict20025
     */
    public String getFundprojecttrade() {
        return fundprojecttrade;
    }

    /**
     * 设置：基金项目企业-关注的项目阶段（下拉）dict20026
     */
    public void setFundprojectphase(String fundprojectphase) {
        this.fundprojectphase = fundprojectphase;
    }

    /**
     * 获取：基金项目企业-关注的项目阶段（下拉）dict20026
     */
    public String getFundprojectphase() {
        return fundprojectphase;
    }

    /**
     * 设置：基金项目企业-该产品所属投资
     */
    public void setBelonginvest(String belonginvest) {
        this.belonginvest = belonginvest;
    }

    /**
     * 获取：基金项目企业-该产品所属投资
     */
    public String getBelonginvest() {
        return belonginvest;
    }

    /**
     * 设置：基金项目企业-预计平均年化收益率
     */
    public void setAnnualrate(String annualrate) {
        this.annualrate = annualrate;
    }

    /**
     * 获取：基金项目企业-预计平均年化收益率
     */
    public String getAnnualrate() {
        return annualrate;
    }

    /**
     * 设置：基金项目企业-资金募集方式
     */
    public void setRaisetype(String raisetype) {
        this.raisetype = raisetype;
    }

    /**
     * 获取：基金项目企业-资金募集方式
     */
    public String getRaisetype() {
        return raisetype;
    }

    /**
     * 设置：基金项目企业-投资者人数
     */
    public void setInvertcount(String invertcount) {
        this.invertcount = invertcount;
    }

    /**
     * 获取：基金项目企业-投资者人数
     */
    public String getInvertcount() {
        return invertcount;
    }

    /**
     * 设置：基金项目企业-所投项目情况简介（可不透露具体名称）
     */
    public void setFundprojectintro(String fundprojectintro) {
        this.fundprojectintro = fundprojectintro;
    }

    /**
     * 获取：基金项目企业-所投项目情况简介（可不透露具体名称）
     */
    public String getFundprojectintro() {
        return fundprojectintro;
    }

    /**
     * 设置：个人自有资金-所投公司所属行业/二级市场  dict20025
     */
    public void setCompanytrade(String companytrade) {
        this.companytrade = companytrade;
    }

    /**
     * 获取：个人自有资金-所投公司所属行业/二级市场  dict20025
     */
    public String getCompanytrade() {
        return companytrade;
    }

    /**
     * 设置：个人自有资金-所投公司具体名称
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    /**
     * 获取：个人自有资金-所投公司具体名称
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * 设置：个人自有资金-所投公司基本信息
     */
    public void setCompanyinfo(String companyinfo) {
        this.companyinfo = companyinfo;
    }

    /**
     * 获取：个人自有资金-所投公司基本信息
     */
    public String getCompanyinfo() {
        return companyinfo;
    }

    /**
     * 设置：个人自有资金-所投项目所属行业  dict20025
     */
    public void setProtrade(String protrade) {
        this.protrade = protrade;
    }

    /**
     * 获取：个人自有资金-所投项目所属行业  dict20025
     */
    public String getProtrade() {
        return protrade;
    }

    /**
     * 设置：个人自有资金-所投项目情况简介
     */
    public void setProintro(String prointro) {
        this.prointro = prointro;
    }

    /**
     * 获取：个人自有资金-所投项目情况简介
     */
    public String getProintro() {
        return prointro;
    }

    /**
     * 设置：个人自有资金-投资者人数
     */
    public void setInvestnum(String investnum) {
        this.investnum = investnum;
    }

    /**
     * 获取：个人自有资金-投资者人数
     */
    public String getInvestnum() {
        return investnum;
    }

    /**
     * 设置：企业自有资金-所投项目所属行业  dict20025
     */
    public void setProjecttrade(String projecttrade) {
        this.projecttrade = projecttrade;
    }

    /**
     * 获取：企业自有资金-所投项目所属行业  dict20025
     */
    public String getProjecttrade() {
        return projecttrade;
    }

    /**
     * 设置：企业自有资金-所投项目情况简介
     */
    public void setProjectintro(String projectintro) {
        this.projectintro = projectintro;
    }

    /**
     * 获取：企业自有资金-所投项目情况简介
     */
    public String getProjectintro() {
        return projectintro;
    }

    /**
     * 设置：企业自有资金-所属集团企业
     */
    public void setBlocname(String blocname) {
        this.blocname = blocname;
    }

    /**
     * 获取：企业自有资金-所属集团企业
     */
    public String getBlocname() {
        return blocname;
    }

    /**
     * 设置：融资租赁企业-分类 字典115 0-产商系融资租赁 1-中间系融资租赁
     */
    public void setClassify(String classify) {
        this.classify = classify;
    }

    /**
     * 获取：融资租赁企业-分类 字典115 0-产商系融资租赁 1-中间系融资租赁
     */
    public String getClassify() {
        return classify;
    }

    /**
     * 设置：融资租赁企业-经营业务类型
     */
    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    /**
     * 获取：融资租赁企业-经营业务类型
     */
    public String getBusinesstype() {
        return businesstype;
    }

    /**
     * 设置：融资租赁企业-擅长租赁标的类型
     */
    public void setObjecttype(String objecttype) {
        this.objecttype = objecttype;
    }

    /**
     * 获取：融资租赁企业-擅长租赁标的类型
     */
    public String getObjecttype() {
        return objecttype;
    }

    /**
     * 设置：其他企业-具体业务类型
     */
    public void setSpecificbusinesstype(String specificbusinesstype) {
        this.specificbusinesstype = specificbusinesstype;
    }

    /**
     * 获取：其他企业-具体业务类型
     */
    public String getSpecificbusinesstype() {
        return specificbusinesstype;
    }

    /**
     * 设置：其他企业-盈利模式
     */
    public void setProfitmodel(String profitmodel) {
        this.profitmodel = profitmodel;
    }

    /**
     * 获取：其他企业-盈利模式
     */
    public String getProfitmodel() {
        return profitmodel;
    }

    /**
     * 设置：其他企业-资金来源
     */
    public void setCapitalsource(String capitalsource) {
        this.capitalsource = capitalsource;
    }

    /**
     * 获取：其他企业-资金来源
     */
    public String getCapitalsource() {
        return capitalsource;
    }

    /**
     * 设置：公共-主要负责人从业经历介绍
     */
    public void setMainworkexp(String mainworkexp) {
        this.mainworkexp = mainworkexp;
    }

    /**
     * 获取：公共-主要负责人从业经历介绍
     */
    public String getMainworkexp() {
        return mainworkexp;
    }

    /**
     * 设置：公共-其他主要负责人介绍
     */
    public void setOthersintro(String othersintro) {
        this.othersintro = othersintro;
    }

    /**
     * 获取：公共-其他主要负责人介绍
     */
    public String getOthersintro() {
        return othersintro;
    }

    /**
     * 设置：公共-股东背景介绍
     */
    public void setPartnerintro(String partnerintro) {
        this.partnerintro = partnerintro;
    }

    /**
     * 获取：公共-股东背景介绍
     */
    public String getPartnerintro() {
        return partnerintro;
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

    /**
     * 设置：更新日期
     */
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取：更新日期
     */
    public String getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取：更新时间
     */
    public String getUpdatetime() {
        return updatetime;
    }
}
