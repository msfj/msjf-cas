package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganInfoChangeKey  extends IBaseEntity {
	/**企业客户代码	**/
	protected String customerno;
	/**版本号（由小到大）	**/
	protected Integer version;
	/**null	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**null	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**null	**/
	public Integer getVersion() {
		return this.version;
	}
	/**null	**/
	public void setVersion(Integer version) {
		this.version = version;
	}
	public void setKey(String customerno,Integer version) {
		this.customerno = customerno;
		this.version = version;
	}
}