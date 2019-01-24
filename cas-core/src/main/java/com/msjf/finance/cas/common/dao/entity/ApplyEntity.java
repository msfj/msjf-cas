package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.ApplyKey;
/***
  *ApplyEntity
  *申请流水表
  */
public class ApplyEntity extends ApplyKey {
	/**客户代码	**/
	private String customerno;
	/**业务代码 0-服务平台注册 1-管理平台用户新增 2-业务平台用户删除	**/
	private String businesscode;
	/**业务内容 json串	**/
	private String content;
	/**处理状态 *-初始状态 0-成功 1-失败	**/
	private String status;
	/**备注	**/
	private String remark;
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
	/**流水号	**/
	public String getSerialno() {
		return this.serialno;
	}
	/**流水号	**/
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	/**客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**业务代码 0-服务平台注册 1-管理平台用户新增 2-业务平台用户删除	**/
	public String getBusinesscode() {
		return this.businesscode;
	}
	/**业务代码 0-服务平台注册 1-管理平台用户新增 2-业务平台用户删除	**/
	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}
	/**业务内容 json串	**/
	public String getContent() {
		return this.content;
	}
	/**业务内容 json串	**/
	public void setContent(String content) {
		this.content = content;
	}
	/**处理状态 *-初始状态 0-成功 1-失败	**/
	public String getStatus() {
		return this.status;
	}
	/**处理状态 *-初始状态 0-成功 1-失败	**/
	public void setStatus(String status) {
		this.status = status;
	}
	/**备注	**/
	public String getRemark() {
		return this.remark;
	}
	/**备注	**/
	public void setRemark(String remark) {
		this.remark = remark;
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