package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.CustKey;
/***
  *CustEntity
  *用户基本信息表
  */
public class CustEntity extends CustKey {
	/**登录名	**/
	private String loginname;
	/**注册来源 0-web 1-app	**/
	private String registersource;
	/**用户类型 字典102 0-个人 1-企业	**/
	private String membertype;
	/**证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照	**/
	private String certificatetype;
	/**证件号码	**/
	private String certificateno;
	/**主要联系人	**/
	private String linkmanname;
	/**联系人证件号码	**/
	private String linkmanCertificateno;
	/**手机号码	**/
	private String mobile;
	/**银行卡号	**/
	private String cardno;
	/**银行	**/
	private String bank;
	/**就职单位	**/
	private String companyname;
	/**联系邮箱	**/
	private String email;
	/**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
	private String status;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	/**更新日期	**/
	private String updatedate;
	/**更新时间	**/
	private String updatetime;
	/**基本信息是否保存(0：否，1：是)	**/
	private String issave;
	/**来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签	**/
	private String source;
	/**法人名称	**/
	private String corname;
	/**法人证件类型	**/
	private String corcardtype;
	/**法人证件号	**/
	private String corcardno;
	/**法人电话号码	**/
	private String cormob;
	/**所属招商对接人	**/
	private String dockingPeople;
	/**拟变更招商对接人	**/
	private String appDockingPeople;
	public void init() {
	}
	/**客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**登录名	**/
	public String getLoginname() {
		return this.loginname;
	}
	/**登录名	**/
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**注册来源 0-web 1-app	**/
	public String getRegistersource() {
		return this.registersource;
	}
	/**注册来源 0-web 1-app	**/
	public void setRegistersource(String registersource) {
		this.registersource = registersource;
	}
	/**用户类型 字典102 0-个人 1-企业	**/
	public String getMembertype() {
		return this.membertype;
	}
	/**用户类型 字典102 0-个人 1-企业	**/
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	/**证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照	**/
	public String getCertificatetype() {
		return this.certificatetype;
	}
	/**证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照	**/
	public void setCertificatetype(String certificatetype) {
		this.certificatetype = certificatetype;
	}
	/**证件号码	**/
	public String getCertificateno() {
		return this.certificateno;
	}
	/**证件号码	**/
	public void setCertificateno(String certificateno) {
		this.certificateno = certificateno;
	}
	/**主要联系人	**/
	public String getLinkmanname() {
		return this.linkmanname;
	}
	/**主要联系人	**/
	public void setLinkmanname(String linkmanname) {
		this.linkmanname = linkmanname;
	}
	/**联系人证件号码	**/
	public String getLinkmanCertificateno() {
		return this.linkmanCertificateno;
	}
	/**联系人证件号码	**/
	public void setLinkmanCertificateno(String linkmanCertificateno) {
		this.linkmanCertificateno = linkmanCertificateno;
	}
	/**手机号码	**/
	public String getMobile() {
		return this.mobile;
	}
	/**手机号码	**/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**银行卡号	**/
	public String getCardno() {
		return this.cardno;
	}
	/**银行卡号	**/
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	/**银行	**/
	public String getBank() {
		return this.bank;
	}
	/**银行	**/
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**就职单位	**/
	public String getCompanyname() {
		return this.companyname;
	}
	/**就职单位	**/
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	/**联系邮箱	**/
	public String getEmail() {
		return this.email;
	}
	/**联系邮箱	**/
	public void setEmail(String email) {
		this.email = email;
	}
	/**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
	public String getStatus() {
		return this.status;
	}
	/**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
	public void setStatus(String status) {
		this.status = status;
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
	/**基本信息是否保存(0：否，1：是)	**/
	public String getIssave() {
		return this.issave;
	}
	/**基本信息是否保存(0：否，1：是)	**/
	public void setIssave(String issave) {
		this.issave = issave;
	}
	/**来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签	**/
	public String getSource() {
		return this.source;
	}
	/**来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签	**/
	public void setSource(String source) {
		this.source = source;
	}
	/**法人名称	**/
	public String getCorname() {
		return this.corname;
	}
	/**法人名称	**/
	public void setCorname(String corname) {
		this.corname = corname;
	}
	/**法人证件类型	**/
	public String getCorcardtype() {
		return this.corcardtype;
	}
	/**法人证件类型	**/
	public void setCorcardtype(String corcardtype) {
		this.corcardtype = corcardtype;
	}
	/**法人证件号	**/
	public String getCorcardno() {
		return this.corcardno;
	}
	/**法人证件号	**/
	public void setCorcardno(String corcardno) {
		this.corcardno = corcardno;
	}
	/**法人电话号码	**/
	public String getCormob() {
		return this.cormob;
	}
	/**法人电话号码	**/
	public void setCormob(String cormob) {
		this.cormob = cormob;
	}
	/**所属招商对接人	**/
	public String getDockingPeople() {
		return this.dockingPeople;
	}
	/**所属招商对接人	**/
	public void setDockingPeople(String dockingPeople) {
		this.dockingPeople = dockingPeople;
	}
	/**拟变更招商对接人	**/
	public String getAppDockingPeople() {
		return this.appDockingPeople;
	}
	/**拟变更招商对接人	**/
	public void setAppDockingPeople(String appDockingPeople) {
		this.appDockingPeople = appDockingPeople;
	}
}