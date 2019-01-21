package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 员工基本信息表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:09
 */
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 客户代码
     */

    private String customerno;
    /**
     * 员工名称
     */
    private String employeename;
    /**
     * 登录账号
     */
    private String loginname;
    /**
     * 所属部门编号
     */
    private String branchid;
    /**
     * 证件类型
     */
    private String certificatetype;
    /**
     * 证件号码
     */
    private String certificateno;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定
     */
    private String status;
    /**
     * 部门所在省
     */
    private String province;
    /**
     * 部门所在市
     */
    private String city;
    /**
     * 部门所在区/县
     */
    private String county;
    /**
     * 插入日期
     */
    private String insertdate;
    /**
     * 插入时间
     */
    private String inserttime;
    /**
     * 更新日期
     */
    private String updatedate;
    /**
     * 更新时间
     */
    private String updatetime;

    /**
     * 设置：客户代码
     */
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    /**
     * 获取：客户代码
     */
    public String getCustomerno() {
        return customerno;
    }

    /**
     * 设置：员工名称
     */
    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    /**
     * 获取：员工名称
     */
    public String getEmployeename() {
        return employeename;
    }

    /**
     * 设置：登录账号
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * 获取：登录账号
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * 设置：所属部门编号
     */
    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    /**
     * 获取：所属部门编号
     */
    public String getBranchid() {
        return branchid;
    }

    /**
     * 设置：证件类型
     */
    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype;
    }

    /**
     * 获取：证件类型
     */
    public String getCertificatetype() {
        return certificatetype;
    }

    /**
     * 设置：证件号码
     */
    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }

    /**
     * 获取：证件号码
     */
    public String getCertificateno() {
        return certificateno;
    }

    /**
     * 设置：手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置：邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置：部门所在省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取：部门所在省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置：部门所在市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：部门所在市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置：部门所在区/县
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 获取：部门所在区/县
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置：插入日期
     */
    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }

    /**
     * 获取：插入日期
     */
    public String getInsertdate() {
        return insertdate;
    }

    /**
     * 设置：插入时间
     */
    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * 获取：插入时间
     */
    public String getInserttime() {
        return inserttime;
    }

    /**
     * 设置：更新日期
     */
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取：更新日期
     */
    public String getUpdatedate() {
        return updatedate;
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
