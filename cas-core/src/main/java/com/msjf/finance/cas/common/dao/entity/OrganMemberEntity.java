package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganMemberKey;
/***
  *OrganMemberEntity
  *企业成员信息表
  */
public class OrganMemberEntity extends OrganMemberKey {
	/**企业客户代码	**/
	private String customerno;
	/**成员类型	**/
	private String membertype;
	/**成员名称或姓名	**/
	private String membername;
	/**证件类型 字典 个人+企业	**/
	private String certificatetype;
	/**证件号码	**/
	private String certificateno;
	/**联系电话	**/
	private String mobile;
	/**备注	**/
	private String remark;
	/**是否认证 0-未认证 1-已认证	**/
	private String isauth;
	/**是否发送邀请码 0-否 1-是	**/
	private String isinvite;
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
	/**成员编号	**/
	public String getMemberid() {
		return this.memberid;
	}
	/**成员编号	**/
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	/**企业客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**企业客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**成员类型	**/
	public String getMembertype() {
		return this.membertype;
	}
	/**成员类型	**/
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	/**成员名称或姓名	**/
	public String getMembername() {
		return this.membername;
	}
	/**成员名称或姓名	**/
	public void setMembername(String membername) {
		this.membername = membername;
	}
	/**证件类型 字典 个人+企业	**/
	public String getCertificatetype() {
		return this.certificatetype;
	}
	/**证件类型 字典 个人+企业	**/
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
	/**联系电话	**/
	public String getMobile() {
		return this.mobile;
	}
	/**联系电话	**/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**备注	**/
	public String getRemark() {
		return this.remark;
	}
	/**备注	**/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**是否认证 0-未认证 1-已认证	**/
	public String getIsauth() {
		return this.isauth;
	}
	/**是否认证 0-未认证 1-已认证	**/
	public void setIsauth(String isauth) {
		this.isauth = isauth;
	}
	/**是否发送邀请码 0-否 1-是	**/
	public String getIsinvite() {
		return this.isinvite;
	}
	/**是否发送邀请码 0-否 1-是	**/
	public void setIsinvite(String isinvite) {
		this.isinvite = isinvite;
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