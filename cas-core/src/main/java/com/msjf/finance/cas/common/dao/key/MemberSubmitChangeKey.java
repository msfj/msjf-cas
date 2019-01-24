package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class MemberSubmitChangeKey  extends IBaseEntity {
	/**流水号	**/
	protected String serialno;
	/**当前版本号	**/
	protected Integer version;
	/**null	**/
	public String getSerialno() {
		return this.serialno;
	}
	/**null	**/
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	/**null	**/
	public Integer getVersion() {
		return this.version;
	}
	/**null	**/
	public void setVersion(Integer version) {
		this.version = version;
	}
	public void setKey(String serialno,Integer version) {
		this.serialno = serialno;
		this.version = version;
	}
}