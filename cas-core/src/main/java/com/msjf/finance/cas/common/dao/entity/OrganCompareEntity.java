package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganCompareKey;
/***
  *OrganCompareEntity
  *企业信息变更比对结果表
  */
public class OrganCompareEntity extends OrganCompareKey {
	/**原变更事项	**/
	private String beforeitem;
	/**变更后事项	**/
	private String afteritem;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	public void init() {
	}
	/**企业客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**企业客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**原版本号	**/
	public String getVersion() {
		return this.version;
	}
	/**原版本号	**/
	public void setVersion(String version) {
		this.version = version;
	}
	/**原变更事项	**/
	public String getBeforeitem() {
		return this.beforeitem;
	}
	/**原变更事项	**/
	public void setBeforeitem(String beforeitem) {
		this.beforeitem = beforeitem;
	}
	/**变更后事项	**/
	public String getAfteritem() {
		return this.afteritem;
	}
	/**变更后事项	**/
	public void setAfteritem(String afteritem) {
		this.afteritem = afteritem;
	}
	/**插入日期	**/
	public String getInsertdate() {
		return this.insertdate;
	}
	/**插入日期	**/
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	/**插入时间	**/
	public String getInserttime() {
		return this.inserttime;
	}
	/**插入时间	**/
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
}