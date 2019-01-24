package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class RoleKey  extends IBaseEntity {
	/**角色ID	**/
	protected String roleId;
	/**null	**/
	public String getRoleId() {
		return this.roleId;
	}
	/**null	**/
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setKey(String roleId) {
		this.roleId = roleId;
	}
}