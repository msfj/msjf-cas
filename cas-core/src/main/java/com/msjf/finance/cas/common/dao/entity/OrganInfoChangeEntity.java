package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganInfoChangeKey;
/***
  *OrganInfoChangeEntity
  *企业基本信息变更记录表
  */
public class OrganInfoChangeEntity extends OrganInfoChangeKey {
	/**企业名称	**/
	private String membername;
	/**企业类型 字典104 0-有限公司 1-合伙企业	**/
	private String organtype;
	/**企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业	**/
	private String organclass;
	/**变更发起人	**/
	private String startcustomerno;
	/**服务人员	**/
	private String servicecustomerno;
	/**办理流程 字典120 0-现场 1-半电子 2-全电子	**/
	private String dealflow;
	/**经营期限	**/
	private String managelimit;
	/**缴付期限	**/
	private String paydatelimit;
	/**注册地址(省) dict101021	**/
	private String registerprovince;
	/**注册地址(市) dict101022	**/
	private String registercity;
	/**注册地址(区/县) dict101023	**/
	private String registercounty;
	/**注册地址(街道)	**/
	private String registertreet;
	/**实际地址(省) dict101021	**/
	private String realprovince;
	/**实际地址(市) dict101022	**/
	private String realcity;
	/**实际地址(区/县) dict101023	**/
	private String realcounty;
	/**实际地址(街道)	**/
	private String realtreet;
	/**经营范围/主营业务	**/
	private String businessscope;
	/**执行事务合伙人类型 字典 107 0-个人 1-公司	**/
	private String partnertype;
	/**执行事务合伙人名称	**/
	private String partnername;
	/**注册资本（金）认缴出资额(万元)	**/
	private String regicapital;
	/**注册资本金币种	**/
	private String regicapitalbz;
	/**是否存在董事会 0-否 1-是	**/
	private String isboard;
	/**是否存在监事会 0-否 1-是	**/
	private String issupervision;
	/**备用联系人	**/
	private String sparecontactname;
	/**备用联系人手机号码	**/
	private String sparecontactmobile;
	/**成立时间 年月日	**/
	private String establishdate;
	/**公司简介	**/
	private String companyintro;
	/**挂牌情况 字典 112	**/
	private String hanginfo;
	/**企业成份 字典 113	**/
	private String companymodel;
	/**投资来源 字典 114	**/
	private String investsource;
	/**营业执照附件	**/
	private String businessfile;
	/**企业设立附件	**/
	private String establishfile;
	/**企业变更附件	**/
	private String modifyfile;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
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
	/**版本号（由小到大）	**/
	public Integer getVersion() {
		return this.version;
	}
	/**版本号（由小到大）	**/
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**企业名称	**/
	public String getMembername() {
		return this.membername;
	}
	/**企业名称	**/
	public void setMembername(String membername) {
		this.membername = membername;
	}
	/**企业类型 字典104 0-有限公司 1-合伙企业	**/
	public String getOrgantype() {
		return this.organtype;
	}
	/**企业类型 字典104 0-有限公司 1-合伙企业	**/
	public void setOrgantype(String organtype) {
		this.organtype = organtype;
	}
	/**企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业	**/
	public String getOrganclass() {
		return this.organclass;
	}
	/**企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业	**/
	public void setOrganclass(String organclass) {
		this.organclass = organclass;
	}
	/**变更发起人	**/
	public String getStartcustomerno() {
		return this.startcustomerno;
	}
	/**变更发起人	**/
	public void setStartcustomerno(String startcustomerno) {
		this.startcustomerno = startcustomerno;
	}
	/**服务人员	**/
	public String getServicecustomerno() {
		return this.servicecustomerno;
	}
	/**服务人员	**/
	public void setServicecustomerno(String servicecustomerno) {
		this.servicecustomerno = servicecustomerno;
	}
	/**办理流程 字典120 0-现场 1-半电子 2-全电子	**/
	public String getDealflow() {
		return this.dealflow;
	}
	/**办理流程 字典120 0-现场 1-半电子 2-全电子	**/
	public void setDealflow(String dealflow) {
		this.dealflow = dealflow;
	}
	/**经营期限	**/
	public String getManagelimit() {
		return this.managelimit;
	}
	/**经营期限	**/
	public void setManagelimit(String managelimit) {
		this.managelimit = managelimit;
	}
	/**缴付期限	**/
	public String getPaydatelimit() {
		return this.paydatelimit;
	}
	/**缴付期限	**/
	public void setPaydatelimit(String paydatelimit) {
		this.paydatelimit = paydatelimit;
	}
	/**注册地址(省) dict101021	**/
	public String getRegisterprovince() {
		return this.registerprovince;
	}
	/**注册地址(省) dict101021	**/
	public void setRegisterprovince(String registerprovince) {
		this.registerprovince = registerprovince;
	}
	/**注册地址(市) dict101022	**/
	public String getRegistercity() {
		return this.registercity;
	}
	/**注册地址(市) dict101022	**/
	public void setRegistercity(String registercity) {
		this.registercity = registercity;
	}
	/**注册地址(区/县) dict101023	**/
	public String getRegistercounty() {
		return this.registercounty;
	}
	/**注册地址(区/县) dict101023	**/
	public void setRegistercounty(String registercounty) {
		this.registercounty = registercounty;
	}
	/**注册地址(街道)	**/
	public String getRegistertreet() {
		return this.registertreet;
	}
	/**注册地址(街道)	**/
	public void setRegistertreet(String registertreet) {
		this.registertreet = registertreet;
	}
	/**实际地址(省) dict101021	**/
	public String getRealprovince() {
		return this.realprovince;
	}
	/**实际地址(省) dict101021	**/
	public void setRealprovince(String realprovince) {
		this.realprovince = realprovince;
	}
	/**实际地址(市) dict101022	**/
	public String getRealcity() {
		return this.realcity;
	}
	/**实际地址(市) dict101022	**/
	public void setRealcity(String realcity) {
		this.realcity = realcity;
	}
	/**实际地址(区/县) dict101023	**/
	public String getRealcounty() {
		return this.realcounty;
	}
	/**实际地址(区/县) dict101023	**/
	public void setRealcounty(String realcounty) {
		this.realcounty = realcounty;
	}
	/**实际地址(街道)	**/
	public String getRealtreet() {
		return this.realtreet;
	}
	/**实际地址(街道)	**/
	public void setRealtreet(String realtreet) {
		this.realtreet = realtreet;
	}
	/**经营范围/主营业务	**/
	public String getBusinessscope() {
		return this.businessscope;
	}
	/**经营范围/主营业务	**/
	public void setBusinessscope(String businessscope) {
		this.businessscope = businessscope;
	}
	/**执行事务合伙人类型 字典 107 0-个人 1-公司	**/
	public String getPartnertype() {
		return this.partnertype;
	}
	/**执行事务合伙人类型 字典 107 0-个人 1-公司	**/
	public void setPartnertype(String partnertype) {
		this.partnertype = partnertype;
	}
	/**执行事务合伙人名称	**/
	public String getPartnername() {
		return this.partnername;
	}
	/**执行事务合伙人名称	**/
	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}
	/**注册资本（金）认缴出资额(万元)	**/
	public String getRegicapital() {
		return this.regicapital;
	}
	/**注册资本（金）认缴出资额(万元)	**/
	public void setRegicapital(String regicapital) {
		this.regicapital = regicapital;
	}
	/**注册资本金币种	**/
	public String getRegicapitalbz() {
		return this.regicapitalbz;
	}
	/**注册资本金币种	**/
	public void setRegicapitalbz(String regicapitalbz) {
		this.regicapitalbz = regicapitalbz;
	}
	/**是否存在董事会 0-否 1-是	**/
	public String getIsboard() {
		return this.isboard;
	}
	/**是否存在董事会 0-否 1-是	**/
	public void setIsboard(String isboard) {
		this.isboard = isboard;
	}
	/**是否存在监事会 0-否 1-是	**/
	public String getIssupervision() {
		return this.issupervision;
	}
	/**是否存在监事会 0-否 1-是	**/
	public void setIssupervision(String issupervision) {
		this.issupervision = issupervision;
	}
	/**备用联系人	**/
	public String getSparecontactname() {
		return this.sparecontactname;
	}
	/**备用联系人	**/
	public void setSparecontactname(String sparecontactname) {
		this.sparecontactname = sparecontactname;
	}
	/**备用联系人手机号码	**/
	public String getSparecontactmobile() {
		return this.sparecontactmobile;
	}
	/**备用联系人手机号码	**/
	public void setSparecontactmobile(String sparecontactmobile) {
		this.sparecontactmobile = sparecontactmobile;
	}
	/**成立时间 年月日	**/
	public String getEstablishdate() {
		return this.establishdate;
	}
	/**成立时间 年月日	**/
	public void setEstablishdate(String establishdate) {
		this.establishdate = establishdate;
	}
	/**公司简介	**/
	public String getCompanyintro() {
		return this.companyintro;
	}
	/**公司简介	**/
	public void setCompanyintro(String companyintro) {
		this.companyintro = companyintro;
	}
	/**挂牌情况 字典 112	**/
	public String getHanginfo() {
		return this.hanginfo;
	}
	/**挂牌情况 字典 112	**/
	public void setHanginfo(String hanginfo) {
		this.hanginfo = hanginfo;
	}
	/**企业成份 字典 113	**/
	public String getCompanymodel() {
		return this.companymodel;
	}
	/**企业成份 字典 113	**/
	public void setCompanymodel(String companymodel) {
		this.companymodel = companymodel;
	}
	/**投资来源 字典 114	**/
	public String getInvestsource() {
		return this.investsource;
	}
	/**投资来源 字典 114	**/
	public void setInvestsource(String investsource) {
		this.investsource = investsource;
	}
	/**营业执照附件	**/
	public String getBusinessfile() {
		return this.businessfile;
	}
	/**营业执照附件	**/
	public void setBusinessfile(String businessfile) {
		this.businessfile = businessfile;
	}
	/**企业设立附件	**/
	public String getEstablishfile() {
		return this.establishfile;
	}
	/**企业设立附件	**/
	public void setEstablishfile(String establishfile) {
		this.establishfile = establishfile;
	}
	/**企业变更附件	**/
	public String getModifyfile() {
		return this.modifyfile;
	}
	/**企业变更附件	**/
	public void setModifyfile(String modifyfile) {
		this.modifyfile = modifyfile;
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
}