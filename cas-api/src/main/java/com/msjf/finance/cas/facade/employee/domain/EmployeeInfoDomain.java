package com.msjf.finance.cas.facade.employee.domain;


import com.msjf.finance.msjf.core.domian.BaseDomain;

/**
 * Created by lzp on 2018/12/22.
 */
public class EmployeeInfoDomain extends BaseDomain {
    private String employeename;  //员工名称
    private String name;  //登录账号

    private String certificateno;  //证件号码

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertificateno() {
        return certificateno;
    }

    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }
}
