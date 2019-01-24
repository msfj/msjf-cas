package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.EmployeeOrganKey;
/***
  *EmployeeOrganEntity
  *员工关注企业信息表
  */
public class EmployeeOrganEntity extends EmployeeOrganKey {
	/**是否关注 0-否 1-是	**/
	private String status;
	public void init() {
	}
	/**员工客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**员工客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**企业客户代码	**/
	public String getOrgcustomerno() {
		return this.orgcustomerno;
	}
	/**企业客户代码	**/
	public void setOrgcustomerno(String orgcustomerno) {
		this.orgcustomerno = orgcustomerno;
	}
	/**是否关注 0-否 1-是	**/
	public String getStatus() {
		return this.status;
	}
	/**是否关注 0-否 1-是	**/
	public void setStatus(String status) {
		this.status = status;
	}
}