package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:09
 */
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */

    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 是否默认用户组（0-否 1-是 ）
     */
    private String isdefault;
    /**
     * 新增时间
     */
    private String inserttime;
    /**
     * 更新时间
     */
    private String updatetime;

    /**
     * 设置：角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取：角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置：角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取：角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置：是否默认用户组（0-否 1-是 ）
     */
    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * 获取：是否默认用户组（0-否 1-是 ）
     */
    public String getIsdefault() {
        return isdefault;
    }

    /**
     * 设置：新增时间
     */
    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * 获取：新增时间
     */
    public String getInserttime() {
        return inserttime;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取：更新时间
     */
    public String getUpdatetime() {
        return updatetime;
    }
}
