package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class SysCertificationConfigKey  extends IBaseEntity {
	/**产品代码	**/
	protected String messagecode;
	/**null	**/
	public String getMessagecode() {
		return this.messagecode;
	}
	/**null	**/
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	public void setKey(String messagecode) {
		this.messagecode = messagecode;
	}
}