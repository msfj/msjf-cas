package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganGrantKey;
/***
  *OrganGrantEntity
  *税收补助申请表
  */
public class OrganGrantEntity extends OrganGrantKey {
	/**税收补助网址	**/
	private String granturl;
	/**开启状态 0-开启 *-关闭	**/
	private String status;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	/**更新日期	**/
	private String updatedate;
	/**更新时间	**/
	private String updatetime;
	public void init() {
	}
	/**记录id	**/
	public String getId() {
		return this.id;
	}
	/**记录id	**/
	public void setId(String id) {
		this.id = id;
	}
	/**税收补助网址	**/
	public String getGranturl() {
		return this.granturl;
	}
	/**税收补助网址	**/
	public void setGranturl(String granturl) {
		this.granturl = granturl;
	}
	/**开启状态 0-开启 *-关闭	**/
	public String getStatus() {
		return this.status;
	}
	/**开启状态 0-开启 *-关闭	**/
	public void setStatus(String status) {
		this.status = status;
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
	/**更新日期	**/
	public String getUpdatedate() {
		return this.updatedate;
	}
	/**更新日期	**/
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**更新时间	**/
	public String getUpdatetime() {
		return this.updatetime;
	}
	/**更新时间	**/
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}