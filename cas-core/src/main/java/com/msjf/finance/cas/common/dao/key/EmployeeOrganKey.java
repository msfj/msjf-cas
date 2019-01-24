package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class EmployeeOrganKey  extends IBaseEntity {
	/**员工客户代码	**/
	protected String customerno;
	/**企业客户代码	**/
	protected String orgcustomerno;
	/**null	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**null	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**null	**/
	public String getOrgcustomerno() {
		return this.orgcustomerno;
	}
	/**null	**/
	public void setOrgcustomerno(String orgcustomerno) {
		this.orgcustomerno = orgcustomerno;
	}
	public void setKey(String customerno,String orgcustomerno) {
		this.customerno = customerno;
		this.orgcustomerno = orgcustomerno;
	}
}