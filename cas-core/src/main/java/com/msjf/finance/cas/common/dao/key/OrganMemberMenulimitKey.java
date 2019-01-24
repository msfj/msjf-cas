package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganMemberMenulimitKey  extends IBaseEntity {
	/**成员编号	**/
	protected String memberid;
	/**菜单权限 108 0-企业变更 1-企业注销 2-税收测算表报送 3-补助申请 4-基金管理人报送 5-基金产品报送	**/
	protected String menulimit;
	/**null	**/
	public String getMemberid() {
		return this.memberid;
	}
	/**null	**/
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	/**null	**/
	public String getMenulimit() {
		return this.menulimit;
	}
	/**null	**/
	public void setMenulimit(String menulimit) {
		this.menulimit = menulimit;
	}
	public void setKey(String memberid,String menulimit) {
		this.memberid = memberid;
		this.menulimit = menulimit;
	}
}