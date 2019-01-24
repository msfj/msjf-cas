package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganCounterSignKey  extends IBaseEntity {
	/**企业客户代码	**/
	protected String orgcustomerno;
	/**登记事项 0-新设 1-变更 2-迁入	**/
	protected String registertype;
	/**null	**/
	public String getOrgcustomerno() {
		return this.orgcustomerno;
	}
	/**null	**/
	public void setOrgcustomerno(String orgcustomerno) {
		this.orgcustomerno = orgcustomerno;
	}
	/**null	**/
	public String getRegistertype() {
		return this.registertype;
	}
	/**null	**/
	public void setRegistertype(String registertype) {
		this.registertype = registertype;
	}
	public void setKey(String orgcustomerno,String registertype) {
		this.orgcustomerno = orgcustomerno;
		this.registertype = registertype;
	}
}