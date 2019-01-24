package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganFlowConfigKey;
/***
  *OrganFlowConfigEntity
  *流程进度配置表
  */
public class OrganFlowConfigEntity extends OrganFlowConfigKey {
	/**流程名称	**/
	private String name;
	/**流程进度配置	**/
	private String step;
	/**备注	**/
	private String remark;
	public void init() {
	}
	/**流程类型	**/
	public String getType() {
		return this.type;
	}
	/**流程类型	**/
	public void setType(String type) {
		this.type = type;
	}
	/**流程名称	**/
	public String getName() {
		return this.name;
	}
	/**流程名称	**/
	public void setName(String name) {
		this.name = name;
	}
	/**流程进度配置	**/
	public String getStep() {
		return this.step;
	}
	/**流程进度配置	**/
	public void setStep(String step) {
		this.step = step;
	}
	/**备注	**/
	public String getRemark() {
		return this.remark;
	}
	/**备注	**/
	public void setRemark(String remark) {
		this.remark = remark;
	}
}