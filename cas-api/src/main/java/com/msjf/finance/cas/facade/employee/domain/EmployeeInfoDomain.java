package com.msjf.finance.cas.facade.employee.domain;


import com.msjf.finance.msjf.core.domian.BaseDomain;

/**
 * Created by lzp on 2018/12/22.
 */
public class EmployeeInfoDomain extends BaseDomain {
    private String customerno; //客户号
    private String employeename;  //员工名称
    private String loginname;  //登录账号

    private String branchid; //所属部门编号
    private String certificatetype;  //证件类型 字典
    private String certificateno;  //证件号码

    private String mobile; //手机号码
    private String email;  //邮箱地址
    private String status;  //账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定

    private String insertdate; //插入日期
    private String inserttime;  //插入时间
    private String updatedate;  //更新日期

    private String updatetime; //更新时间

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

    public String getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }

    public String getInserttime() {
        return inserttime;
    }

    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

}
