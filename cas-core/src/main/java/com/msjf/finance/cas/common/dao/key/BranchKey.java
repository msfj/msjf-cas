package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class BranchKey  extends IBaseEntity {
	/**组织编号	**/
	protected String branchid;
	/**null	**/
	public String getBranchid() {
		return this.branchid;
	}
	/**null	**/
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	public void setKey(String branchid) {
		this.branchid = branchid;
	}
}