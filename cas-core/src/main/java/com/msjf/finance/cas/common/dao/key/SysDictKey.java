package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class SysDictKey  extends IBaseEntity {
	/**字典ＩＤ	**/
	protected String dictId;
	/**字典ＫＥＹ	**/
	protected String dictKey;
	/**null	**/
	public String getDictId() {
		return this.dictId;
	}
	/**null	**/
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	/**null	**/
	public String getDictKey() {
		return this.dictKey;
	}
	/**null	**/
	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}
	public void setKey(String dictId,String dictKey) {
		this.dictId = dictId;
		this.dictKey = dictKey;
	}
}