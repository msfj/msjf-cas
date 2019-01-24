package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganInfoKey  extends IBaseEntity {
	/**企业客户代码	**/
	protected String customerno;
	/**null	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**null	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	public void setKey(String customerno) {
		this.customerno = customerno;
	}
}