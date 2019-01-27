package com.msjf.finance.cas.facade.custManger.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

import java.io.Serializable;

public class CustOutDomain implements Serializable {
    /**客户代码	**/
    private String custno;

    /**客户名称	**/
    private String custname;
    /**登录名	**/
    private String loginname;
    /**用户类型 字典102 0-个人 1-企业	**/
    private String membertype;

    private String membertypeName;

    /**证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照	**/
    private String certificatetype;

    private String certificatetypeName;
    /**证件号码	**/
    private String certificateno;
    /**手机号码	**/
    private String mobile;
    /**联系邮箱	**/
    private String email;
    /**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
    private String status;

    private String statusName;

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public String getMembertypeName() {
        return membertypeName;
    }

    public void setMembertypeName(String membertypeName) {
        this.membertypeName = membertypeName;
    }

    public String getCertificatetype() {
        return certificatetype;
    }

    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype;
    }

    public String getCertificatetypeName() {
        return certificatetypeName;
    }

    public void setCertificatetypeName(String certificatetypeName) {
        this.certificatetypeName = certificatetypeName;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
