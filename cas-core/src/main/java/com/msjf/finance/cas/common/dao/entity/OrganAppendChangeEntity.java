package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganAppendChangeKey;
/***
  *OrganAppendChangeEntity
  *企业附属信息变更记录表
  */
public class OrganAppendChangeEntity extends OrganAppendChangeKey {
	/**基金管理人企业-是否备案 0-否 1-是	**/
	private String isfiling;
	/**基金管理人企业-登记编码	**/
	private String registerno;
	/**基金管理人企业-从业人员数量	**/
	private String employeenum;
	/**基金管理人企业-投资所关注行业市场类型（多选） 字典 dict20025	**/
	private String caremarkettype;
	/**基金管理人企业-关注的项目阶段（多选）dict20026	**/
	private String projectphase;
	/**基金管理人企业-投资获得收益方式	**/
	private String profittype;
	/**基金项目企业-产品是否备案 0-否 1-是	**/
	private String isfundfiling;
	/**基金项目企业-产品备案编码	**/
	private String fundfilingno;
	/**基金项目企业-所属基金管理人	**/
	private String fundmanagername;
	/**基金项目企业-所属基金管理人编码（登记编码）	**/
	private String fundmanagerno;
	/**基金项目企业-所属基金管理人基本情况介绍	**/
	private String fundmanagerintro;
	/**基金项目企业-所投项目所属行业（多选） dict20025	**/
	private String fundprojecttrade;
	/**基金项目企业-关注的项目阶段（多选）dict20026	**/
	private String fundprojectphase;
	/**基金项目企业-该产品所属投资	**/
	private String belonginvest;
	/**基金项目企业-预计平均年化收益率	**/
	private String annualrate;
	/**基金项目企业-资金募集方式	**/
	private String raisetype;
	/**基金项目企业-投资者人数	**/
	private String invertcount;
	/**基金项目企业-所投项目情况简介（可不透露具体名称）	**/
	private String fundprojectintro;
	/**个人自有资金-所投公司所属行业/二级市场(多选) dict20025	**/
	private String companytrade;
	/**个人自有资金-所投公司具体名称	**/
	private String companyname;
	/**个人自有资金-所投公司基本信息	**/
	private String companyinfo;
	/**个人自有资金-所投项目所属行业 dict20025	**/
	private String protrade;
	/**个人自有资金-所投项目情况简介	**/
	private String prointro;
	/**个人自有资金-投资者人数	**/
	private String investnum;
	/**企业自有资金-所投项目所属行业 dict20025	**/
	private String projecttrade;
	/**企业自有资金-所投项目情况简介	**/
	private String projectintro;
	/**企业自有资金-所属集团企业	**/
	private String blocname;
	/**融资租赁企业-分类 字典115 0-产商系融资租赁 1-中间系融资租赁	**/
	private String classify;
	/**融资租赁企业-经营业务类型	**/
	private String businesstype;
	/**融资租赁企业-擅长租赁标的类型	**/
	private String objecttype;
	/**其他企业-具体业务类型	**/
	private String specificbusinesstype;
	/**其他企业-盈利模式	**/
	private String profitmodel;
	/**其他企业-资金来源	**/
	private String capitalsource;
	/**公共-主要负责人从业经历介绍	**/
	private String mainworkexp;
	/**公共-其他主要负责人介绍	**/
	private String othersintro;
	/**公共-股东背景介绍	**/
	private String partnerintro;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	/**从业人数数量	**/
	private String mployedPeopleNumbere;
	/**投资所关注行业市场类型	**/
	private String industryMarketType;
	/**关注的项目阶段	**/
	private String focusProjectPhase;
	/**投资获得收益方式	**/
	private String returnInvestment;
	/**附件	**/
	private String adjunct;
	/**备注	**/
	private String remarks;
	public void init() {
	}
	/**企业客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**企业客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**版本号	**/
	public Integer getVersion() {
		return this.version;
	}
	/**版本号	**/
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**基金管理人企业-是否备案 0-否 1-是	**/
	public String getIsfiling() {
		return this.isfiling;
	}
	/**基金管理人企业-是否备案 0-否 1-是	**/
	public void setIsfiling(String isfiling) {
		this.isfiling = isfiling;
	}
	/**基金管理人企业-登记编码	**/
	public String getRegisterno() {
		return this.registerno;
	}
	/**基金管理人企业-登记编码	**/
	public void setRegisterno(String registerno) {
		this.registerno = registerno;
	}
	/**基金管理人企业-从业人员数量	**/
	public String getEmployeenum() {
		return this.employeenum;
	}
	/**基金管理人企业-从业人员数量	**/
	public void setEmployeenum(String employeenum) {
		this.employeenum = employeenum;
	}
	/**基金管理人企业-投资所关注行业市场类型（多选） 字典 dict20025	**/
	public String getCaremarkettype() {
		return this.caremarkettype;
	}
	/**基金管理人企业-投资所关注行业市场类型（多选） 字典 dict20025	**/
	public void setCaremarkettype(String caremarkettype) {
		this.caremarkettype = caremarkettype;
	}
	/**基金管理人企业-关注的项目阶段（多选）dict20026	**/
	public String getProjectphase() {
		return this.projectphase;
	}
	/**基金管理人企业-关注的项目阶段（多选）dict20026	**/
	public void setProjectphase(String projectphase) {
		this.projectphase = projectphase;
	}
	/**基金管理人企业-投资获得收益方式	**/
	public String getProfittype() {
		return this.profittype;
	}
	/**基金管理人企业-投资获得收益方式	**/
	public void setProfittype(String profittype) {
		this.profittype = profittype;
	}
	/**基金项目企业-产品是否备案 0-否 1-是	**/
	public String getIsfundfiling() {
		return this.isfundfiling;
	}
	/**基金项目企业-产品是否备案 0-否 1-是	**/
	public void setIsfundfiling(String isfundfiling) {
		this.isfundfiling = isfundfiling;
	}
	/**基金项目企业-产品备案编码	**/
	public String getFundfilingno() {
		return this.fundfilingno;
	}
	/**基金项目企业-产品备案编码	**/
	public void setFundfilingno(String fundfilingno) {
		this.fundfilingno = fundfilingno;
	}
	/**基金项目企业-所属基金管理人	**/
	public String getFundmanagername() {
		return this.fundmanagername;
	}
	/**基金项目企业-所属基金管理人	**/
	public void setFundmanagername(String fundmanagername) {
		this.fundmanagername = fundmanagername;
	}
	/**基金项目企业-所属基金管理人编码（登记编码）	**/
	public String getFundmanagerno() {
		return this.fundmanagerno;
	}
	/**基金项目企业-所属基金管理人编码（登记编码）	**/
	public void setFundmanagerno(String fundmanagerno) {
		this.fundmanagerno = fundmanagerno;
	}
	/**基金项目企业-所属基金管理人基本情况介绍	**/
	public String getFundmanagerintro() {
		return this.fundmanagerintro;
	}
	/**基金项目企业-所属基金管理人基本情况介绍	**/
	public void setFundmanagerintro(String fundmanagerintro) {
		this.fundmanagerintro = fundmanagerintro;
	}
	/**基金项目企业-所投项目所属行业（多选） dict20025	**/
	public String getFundprojecttrade() {
		return this.fundprojecttrade;
	}
	/**基金项目企业-所投项目所属行业（多选） dict20025	**/
	public void setFundprojecttrade(String fundprojecttrade) {
		this.fundprojecttrade = fundprojecttrade;
	}
	/**基金项目企业-关注的项目阶段（多选）dict20026	**/
	public String getFundprojectphase() {
		return this.fundprojectphase;
	}
	/**基金项目企业-关注的项目阶段（多选）dict20026	**/
	public void setFundprojectphase(String fundprojectphase) {
		this.fundprojectphase = fundprojectphase;
	}
	/**基金项目企业-该产品所属投资	**/
	public String getBelonginvest() {
		return this.belonginvest;
	}
	/**基金项目企业-该产品所属投资	**/
	public void setBelonginvest(String belonginvest) {
		this.belonginvest = belonginvest;
	}
	/**基金项目企业-预计平均年化收益率	**/
	public String getAnnualrate() {
		return this.annualrate;
	}
	/**基金项目企业-预计平均年化收益率	**/
	public void setAnnualrate(String annualrate) {
		this.annualrate = annualrate;
	}
	/**基金项目企业-资金募集方式	**/
	public String getRaisetype() {
		return this.raisetype;
	}
	/**基金项目企业-资金募集方式	**/
	public void setRaisetype(String raisetype) {
		this.raisetype = raisetype;
	}
	/**基金项目企业-投资者人数	**/
	public String getInvertcount() {
		return this.invertcount;
	}
	/**基金项目企业-投资者人数	**/
	public void setInvertcount(String invertcount) {
		this.invertcount = invertcount;
	}
	/**基金项目企业-所投项目情况简介（可不透露具体名称）	**/
	public String getFundprojectintro() {
		return this.fundprojectintro;
	}
	/**基金项目企业-所投项目情况简介（可不透露具体名称）	**/
	public void setFundprojectintro(String fundprojectintro) {
		this.fundprojectintro = fundprojectintro;
	}
	/**个人自有资金-所投公司所属行业/二级市场(多选) dict20025	**/
	public String getCompanytrade() {
		return this.companytrade;
	}
	/**个人自有资金-所投公司所属行业/二级市场(多选) dict20025	**/
	public void setCompanytrade(String companytrade) {
		this.companytrade = companytrade;
	}
	/**个人自有资金-所投公司具体名称	**/
	public String getCompanyname() {
		return this.companyname;
	}
	/**个人自有资金-所投公司具体名称	**/
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	/**个人自有资金-所投公司基本信息	**/
	public String getCompanyinfo() {
		return this.companyinfo;
	}
	/**个人自有资金-所投公司基本信息	**/
	public void setCompanyinfo(String companyinfo) {
		this.companyinfo = companyinfo;
	}
	/**个人自有资金-所投项目所属行业 dict20025	**/
	public String getProtrade() {
		return this.protrade;
	}
	/**个人自有资金-所投项目所属行业 dict20025	**/
	public void setProtrade(String protrade) {
		this.protrade = protrade;
	}
	/**个人自有资金-所投项目情况简介	**/
	public String getProintro() {
		return this.prointro;
	}
	/**个人自有资金-所投项目情况简介	**/
	public void setProintro(String prointro) {
		this.prointro = prointro;
	}
	/**个人自有资金-投资者人数	**/
	public String getInvestnum() {
		return this.investnum;
	}
	/**个人自有资金-投资者人数	**/
	public void setInvestnum(String investnum) {
		this.investnum = investnum;
	}
	/**企业自有资金-所投项目所属行业 dict20025	**/
	public String getProjecttrade() {
		return this.projecttrade;
	}
	/**企业自有资金-所投项目所属行业 dict20025	**/
	public void setProjecttrade(String projecttrade) {
		this.projecttrade = projecttrade;
	}
	/**企业自有资金-所投项目情况简介	**/
	public String getProjectintro() {
		return this.projectintro;
	}
	/**企业自有资金-所投项目情况简介	**/
	public void setProjectintro(String projectintro) {
		this.projectintro = projectintro;
	}
	/**企业自有资金-所属集团企业	**/
	public String getBlocname() {
		return this.blocname;
	}
	/**企业自有资金-所属集团企业	**/
	public void setBlocname(String blocname) {
		this.blocname = blocname;
	}
	/**融资租赁企业-分类 字典115 0-产商系融资租赁 1-中间系融资租赁	**/
	public String getClassify() {
		return this.classify;
	}
	/**融资租赁企业-分类 字典115 0-产商系融资租赁 1-中间系融资租赁	**/
	public void setClassify(String classify) {
		this.classify = classify;
	}
	/**融资租赁企业-经营业务类型	**/
	public String getBusinesstype() {
		return this.businesstype;
	}
	/**融资租赁企业-经营业务类型	**/
	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}
	/**融资租赁企业-擅长租赁标的类型	**/
	public String getObjecttype() {
		return this.objecttype;
	}
	/**融资租赁企业-擅长租赁标的类型	**/
	public void setObjecttype(String objecttype) {
		this.objecttype = objecttype;
	}
	/**其他企业-具体业务类型	**/
	public String getSpecificbusinesstype() {
		return this.specificbusinesstype;
	}
	/**其他企业-具体业务类型	**/
	public void setSpecificbusinesstype(String specificbusinesstype) {
		this.specificbusinesstype = specificbusinesstype;
	}
	/**其他企业-盈利模式	**/
	public String getProfitmodel() {
		return this.profitmodel;
	}
	/**其他企业-盈利模式	**/
	public void setProfitmodel(String profitmodel) {
		this.profitmodel = profitmodel;
	}
	/**其他企业-资金来源	**/
	public String getCapitalsource() {
		return this.capitalsource;
	}
	/**其他企业-资金来源	**/
	public void setCapitalsource(String capitalsource) {
		this.capitalsource = capitalsource;
	}
	/**公共-主要负责人从业经历介绍	**/
	public String getMainworkexp() {
		return this.mainworkexp;
	}
	/**公共-主要负责人从业经历介绍	**/
	public void setMainworkexp(String mainworkexp) {
		this.mainworkexp = mainworkexp;
	}
	/**公共-其他主要负责人介绍	**/
	public String getOthersintro() {
		return this.othersintro;
	}
	/**公共-其他主要负责人介绍	**/
	public void setOthersintro(String othersintro) {
		this.othersintro = othersintro;
	}
	/**公共-股东背景介绍	**/
	public String getPartnerintro() {
		return this.partnerintro;
	}
	/**公共-股东背景介绍	**/
	public void setPartnerintro(String partnerintro) {
		this.partnerintro = partnerintro;
	}
	/**插入日期	**/
	public String getInsertdate() {
		return this.insertdate;
	}
	/**插入日期	**/
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	/**插入时间	**/
	public String getInserttime() {
		return this.inserttime;
	}
	/**插入时间	**/
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	/**从业人数数量	**/
	public String getMployedPeopleNumbere() {
		return this.mployedPeopleNumbere;
	}
	/**从业人数数量	**/
	public void setMployedPeopleNumbere(String mployedPeopleNumbere) {
		this.mployedPeopleNumbere = mployedPeopleNumbere;
	}
	/**投资所关注行业市场类型	**/
	public String getIndustryMarketType() {
		return this.industryMarketType;
	}
	/**投资所关注行业市场类型	**/
	public void setIndustryMarketType(String industryMarketType) {
		this.industryMarketType = industryMarketType;
	}
	/**关注的项目阶段	**/
	public String getFocusProjectPhase() {
		return this.focusProjectPhase;
	}
	/**关注的项目阶段	**/
	public void setFocusProjectPhase(String focusProjectPhase) {
		this.focusProjectPhase = focusProjectPhase;
	}
	/**投资获得收益方式	**/
	public String getReturnInvestment() {
		return this.returnInvestment;
	}
	/**投资获得收益方式	**/
	public void setReturnInvestment(String returnInvestment) {
		this.returnInvestment = returnInvestment;
	}
	/**附件	**/
	public String getAdjunct() {
		return this.adjunct;
	}
	/**附件	**/
	public void setAdjunct(String adjunct) {
		this.adjunct = adjunct;
	}
	/**备注	**/
	public String getRemarks() {
		return this.remarks;
	}
	/**备注	**/
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}