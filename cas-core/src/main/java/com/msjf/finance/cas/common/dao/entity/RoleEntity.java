package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.RoleKey;
public class RoleEntity extends RoleKey {
	/**角色名称	**/
	private String roleName;
	/**是否默认用户组（0-否 1-是 ）	**/
	private String isdefault;
	/**新增时间	**/
	private String inserttime;
	/**更新时间	**/
	private String updatetime;
	public void init() {
	}
	/**角色ID	**/
	public String getRoleId() {
		return this.roleId;
	}
	/**角色ID	**/
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**角色名称	**/
	public String getRoleName() {
		return this.roleName;
	}
	/**角色名称	**/
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**是否默认用户组（0-否 1-是 ）	**/
	public String getIsdefault() {
		return this.isdefault;
	}
	/**是否默认用户组（0-否 1-是 ）	**/
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	/**新增时间	**/
	public String getInserttime() {
		return this.inserttime;
	}
	/**新增时间	**/
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
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