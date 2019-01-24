package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganCompareKey  extends IBaseEntity {
	/**企业客户代码	**/
	protected String customerno;
	/**原版本号	**/
	protected String version;
	/**null	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**null	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**null	**/
	public String getVersion() {
		return this.version;
	}
	/**null	**/
	public void setVersion(String version) {
		this.version = version;
	}
	public void setKey(String customerno,String version) {
		this.customerno = customerno;
		this.version = version;
	}
}