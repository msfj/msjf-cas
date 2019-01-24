package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganMemberMenulimitKey;
/***
  *OrganMemberMenulimitEntity
  *成员菜单权限表
  */
public class OrganMemberMenulimitEntity extends OrganMemberMenulimitKey {
	/**企业客户代码	**/
	private String customerno;
	/**成员证件号码	**/
	private String certificateno;
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
	/**成员证件号码	**/
	public String getCertificateno() {
		return this.certificateno;
	}
	/**成员证件号码	**/
	public void setCertificateno(String certificateno) {
		this.certificateno = certificateno;
	}
	/**菜单权限 108 0-企业变更 1-企业注销 2-税收测算表报送 3-补助申请 4-基金管理人报送 5-基金产品报送	**/
	public String getMenulimit() {
		return this.menulimit;
	}
	/**菜单权限 108 0-企业变更 1-企业注销 2-税收测算表报送 3-补助申请 4-基金管理人报送 5-基金产品报送	**/
	public void setMenulimit(String menulimit) {
		this.menulimit = menulimit;
	}
}