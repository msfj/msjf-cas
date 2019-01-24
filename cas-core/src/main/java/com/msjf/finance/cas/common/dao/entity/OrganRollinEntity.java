package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganRollinKey;
/***
  *OrganRollinEntity
  *企业迁入基本信息表
  */
public class OrganRollinEntity extends OrganRollinKey {
	/**申请人客户代码	**/
	private String customerno;
	/**企业名称	**/
	private String companyname;
	/**营业执照	**/
	private String businessno;
	/**企业负责人	**/
	private String leader;
	/**注册资本（万元）	**/
	private String regicapital;
	/**注册资本金币种	**/
	private String regicapitalbz;
	/**联系人	**/
	private String linkmanname;
	/**手机号码	**/
	private String mobile;
	/**服务人员代码	**/
	private String servicecustomerno;
	/**主要经营范围	**/
	private String businessscope;
	/**公司简介	**/
	private String companyintro;
	/**办公地址	**/
	private String workaddress;
	/**注册地址	**/
	private String registeraddress;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	/**更新日期	**/
	private String updatedate;
	/**更新时间	**/
	private String updatetime;
	public void init() {
	}
	/**申请编号	**/
	public String getSerialno() {
		return this.serialno;
	}
	/**申请编号	**/
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	/**申请人客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**申请人客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**企业名称	**/
	public String getCompanyname() {
		return this.companyname;
	}
	/**企业名称	**/
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	/**营业执照	**/
	public String getBusinessno() {
		return this.businessno;
	}
	/**营业执照	**/
	public void setBusinessno(String businessno) {
		this.businessno = businessno;
	}
	/**企业负责人	**/
	public String getLeader() {
		return this.leader;
	}
	/**企业负责人	**/
	public void setLeader(String leader) {
		this.leader = leader;
	}
	/**注册资本（万元）	**/
	public String getRegicapital() {
		return this.regicapital;
	}
	/**注册资本（万元）	**/
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
	/**联系人	**/
	public String getLinkmanname() {
		return this.linkmanname;
	}
	/**联系人	**/
	public void setLinkmanname(String linkmanname) {
		this.linkmanname = linkmanname;
	}
	/**手机号码	**/
	public String getMobile() {
		return this.mobile;
	}
	/**手机号码	**/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**服务人员代码	**/
	public String getServicecustomerno() {
		return this.servicecustomerno;
	}
	/**服务人员代码	**/
	public void setServicecustomerno(String servicecustomerno) {
		this.servicecustomerno = servicecustomerno;
	}
	/**主要经营范围	**/
	public String getBusinessscope() {
		return this.businessscope;
	}
	/**主要经营范围	**/
	public void setBusinessscope(String businessscope) {
		this.businessscope = businessscope;
	}
	/**公司简介	**/
	public String getCompanyintro() {
		return this.companyintro;
	}
	/**公司简介	**/
	public void setCompanyintro(String companyintro) {
		this.companyintro = companyintro;
	}
	/**办公地址	**/
	public String getWorkaddress() {
		return this.workaddress;
	}
	/**办公地址	**/
	public void setWorkaddress(String workaddress) {
		this.workaddress = workaddress;
	}
	/**注册地址	**/
	public String getRegisteraddress() {
		return this.registeraddress;
	}
	/**注册地址	**/
	public void setRegisteraddress(String registeraddress) {
		this.registeraddress = registeraddress;
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
	/**更新日期	**/
	public String getUpdatedate() {
		return this.updatedate;
	}
	/**更新日期	**/
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**更新时间	**/
	public String getUpdatetime() {
		return this.updatetime;
	}
	/**更新时间	**/
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}