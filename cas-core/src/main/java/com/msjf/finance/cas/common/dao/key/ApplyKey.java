package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class ApplyKey  extends IBaseEntity {
	/**流水号	**/
	protected String serialno;
	/**null	**/
	public String getSerialno() {
		return this.serialno;
	}
	/**null	**/
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public void setKey(String serialno) {
		this.serialno = serialno;
	}
}