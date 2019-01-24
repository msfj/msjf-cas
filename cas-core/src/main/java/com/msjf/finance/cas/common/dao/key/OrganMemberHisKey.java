package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganMemberHisKey  extends IBaseEntity {
	/**成员编号	**/
	protected String memberid;
	/**null	**/
	public String getMemberid() {
		return this.memberid;
	}
	/**null	**/
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public void setKey(String memberid) {
		this.memberid = memberid;
	}
}