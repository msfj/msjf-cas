package com.msjf.finance.cas.facade.employee.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

/**
 * Created by cheng on 2019/1/25.
 */
public class EmployeeDomain extends BaseDomain{

    /**客户代码	**/
    protected String customerno;

    /**员工名称	**/
    private String employeename;
    /**登录账号	**/
    private String loginname;
    /**所属部门编号	**/
    private String branchid;
    /**证件类型	**/
    private String certificatetype;
    /**证件号码	**/
    private String certificateno;
    /**手机号码	**/
    private String mobile;
    /**邮箱地址	**/
    private String email;
    /**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
    private String status;
    /**部门所在省	**/
    private String province;
    /**部门所在市	**/
    private String city;
    /**部门所在区/县	**/
    private String county;

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    public String getCertificatetype() {
        return certificatetype;
    }

    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype;
    }

    public String getCertificateno() {
        return certificateno;
    }

    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
