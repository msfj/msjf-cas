package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganFlowKey;
/***
  *OrganFlowEntity
  *企业业务流程信息表
  */
public class OrganFlowEntity extends OrganFlowKey {
	/**发起人客户代码	**/
	private String customerno;
	/**流程状态 字典122 0-未提交 1-审核中 2-办理完成 3-审核不通过 4-已暂存	**/
	private String status;
	/**流程id	**/
	private String processid;
	/**是否申请退回	**/
	private String isreturn;
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
	/**企业账户客户代码	**/
	public String getOrgcustomerno() {
		return this.orgcustomerno;
	}
	/**企业账户客户代码	**/
	public void setOrgcustomerno(String orgcustomerno) {
		this.orgcustomerno = orgcustomerno;
	}
	/**发起人客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**发起人客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**流程类型 字典118 0-企业预核名 1-企业设立 2-企业变更 3-企业注销 4-企业迁入	**/
	public String getType() {
		return this.type;
	}
	/**流程类型 字典118 0-企业预核名 1-企业设立 2-企业变更 3-企业注销 4-企业迁入	**/
	public void setType(String type) {
		this.type = type;
	}
	/**流程状态 字典122 0-未提交 1-审核中 2-办理完成 3-审核不通过 4-已暂存	**/
	public String getStatus() {
		return this.status;
	}
	/**流程状态 字典122 0-未提交 1-审核中 2-办理完成 3-审核不通过 4-已暂存	**/
	public void setStatus(String status) {
		this.status = status;
	}
	/**流程id	**/
	public String getProcessid() {
		return this.processid;
	}
	/**流程id	**/
	public void setProcessid(String processid) {
		this.processid = processid;
	}
	/**是否申请退回	**/
	public String getIsreturn() {
		return this.isreturn;
	}
	/**是否申请退回	**/
	public void setIsreturn(String isreturn) {
		this.isreturn = isreturn;
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