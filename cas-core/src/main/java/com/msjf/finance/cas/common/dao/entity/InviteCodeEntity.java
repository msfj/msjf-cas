package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.InviteCodeKey;
/***
  *InviteCodeEntity
  *邀请码信息表
  */
public class InviteCodeEntity extends InviteCodeKey {
	/**邀请者客户代码	**/
	private String customerno;
	/**企业账户客户代码	**/
	private String orgcustomerno;
	/**受邀人证件类型	**/
	private String certificatetype;
	/**受邀人证件号码	**/
	private String certificateno;
	/**受邀人是否为成员 0-否 1-是	**/
	private String ismember;
	/**邀请码	**/
	private String invitecode;
	/**使用状态 0-未使用 1-已使用	**/
	private String status;
	/**失效时间	**/
	private String failuretime;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	/**更新日期	**/
	private String updatedate;
	/**更新时间	**/
	private String updatetime;
	private String issendsms;
	public void init() {
	}
	/**流水号	**/
	public String getSerialno() {
		return this.serialno;
	}
	/**流水号	**/
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	/**邀请者客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**邀请者客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**企业账户客户代码	**/
	public String getOrgcustomerno() {
		return this.orgcustomerno;
	}
	/**企业账户客户代码	**/
	public void setOrgcustomerno(String orgcustomerno) {
		this.orgcustomerno = orgcustomerno;
	}
	/**受邀人证件类型	**/
	public String getCertificatetype() {
		return this.certificatetype;
	}
	/**受邀人证件类型	**/
	public void setCertificatetype(String certificatetype) {
		this.certificatetype = certificatetype;
	}
	/**受邀人证件号码	**/
	public String getCertificateno() {
		return this.certificateno;
	}
	/**受邀人证件号码	**/
	public void setCertificateno(String certificateno) {
		this.certificateno = certificateno;
	}
	/**受邀人是否为成员 0-否 1-是	**/
	public String getIsmember() {
		return this.ismember;
	}
	/**受邀人是否为成员 0-否 1-是	**/
	public void setIsmember(String ismember) {
		this.ismember = ismember;
	}
	/**邀请码	**/
	public String getInvitecode() {
		return this.invitecode;
	}
	/**邀请码	**/
	public void setInvitecode(String invitecode) {
		this.invitecode = invitecode;
	}
	/**使用状态 0-未使用 1-已使用	**/
	public String getStatus() {
		return this.status;
	}
	/**使用状态 0-未使用 1-已使用	**/
	public void setStatus(String status) {
		this.status = status;
	}
	/**失效时间	**/
	public String getFailuretime() {
		return this.failuretime;
	}
	/**失效时间	**/
	public void setFailuretime(String failuretime) {
		this.failuretime = failuretime;
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
	/**null	**/
	public String getIssendsms() {
		return this.issendsms;
	}
	/**null	**/
	public void setIssendsms(String issendsms) {
		this.issendsms = issendsms;
	}
}