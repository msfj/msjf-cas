package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganFlowConfigKey  extends IBaseEntity {
	/**流程类型	**/
	protected String type;
	/**null	**/
	public String getType() {
		return this.type;
	}
	/**null	**/
	public void setType(String type) {
		this.type = type;
	}
	public void setKey(String type) {
		this.type = type;
	}
}