package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganFlowKey  extends IBaseEntity {
	/**企业账户客户代码	**/
	protected String orgcustomerno;
	/**流程类型 字典118 0-企业预核名 1-企业设立 2-企业变更 3-企业注销 4-企业迁入	**/
	protected String type;
	/**null	**/
	public String getOrgcustomerno() {
		return this.orgcustomerno;
	}
	/**null	**/
	public void setOrgcustomerno(String orgcustomerno) {
		this.orgcustomerno = orgcustomerno;
	}
	/**null	**/
	public String getType() {
		return this.type;
	}
	/**null	**/
	public void setType(String type) {
		this.type = type;
	}
	public void setKey(String orgcustomerno,String type) {
		this.orgcustomerno = orgcustomerno;
		this.type = type;
	}
}