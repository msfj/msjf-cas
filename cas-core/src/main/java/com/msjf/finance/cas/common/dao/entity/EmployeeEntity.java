package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.EmployeeKey;
/***
  *EmployeeEntity
  *员工基本信息表
  */
public class EmployeeEntity extends EmployeeKey {
	/**员工名称	**/
	private String employeename;
	/**登录账号	**/
	private String loginname;
	/**所属部门编号	**/
	private String branchid;
	/**证件类型	**/
	private String certificatetype;
	/**证件号码	**/
	private String certificateno;
	/**手机号码	**/
	private String mobile;
	/**邮箱地址	**/
	private String email;
	/**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
	private String status;
	/**部门所在省	**/
	private String province;
	/**部门所在市	**/
	private String city;
	/**部门所在区/县	**/
	private String county;
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
	/**客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**员工名称	**/
	public String getEmployeename() {
		return this.employeename;
	}
	/**员工名称	**/
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	/**登录账号	**/
	public String getLoginname() {
		return this.loginname;
	}
	/**登录账号	**/
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**所属部门编号	**/
	public String getBranchid() {
		return this.branchid;
	}
	/**所属部门编号	**/
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	/**证件类型	**/
	public String getCertificatetype() {
		return this.certificatetype;
	}
	/**证件类型	**/
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
	/**手机号码	**/
	public String getMobile() {
		return this.mobile;
	}
	/**手机号码	**/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**邮箱地址	**/
	public String getEmail() {
		return this.email;
	}
	/**邮箱地址	**/
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
	/**部门所在省	**/
	public String getProvince() {
		return this.province;
	}
	/**部门所在省	**/
	public void setProvince(String province) {
		this.province = province;
	}
	/**部门所在市	**/
	public String getCity() {
		return this.city;
	}
	/**部门所在市	**/
	public void setCity(String city) {
		this.city = city;
	}
	/**部门所在区/县	**/
	public String getCounty() {
		return this.county;
	}
	/**部门所在区/县	**/
	public void setCounty(String county) {
		this.county = county;
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