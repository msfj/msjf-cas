package com.msjf.finance.cas.facade.custManger.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

public class CustMangerDomain extends BaseDomain {

    /**客户代码	**/
    private String custno;

    /**客户名称	**/
    private String custname;
    /**登录名	**/
    private String loginname;
    /**注册来源 0-web 1-app	**/
    private String registersource;
    /**用户类型 字典102 0-个人 1-企业	**/
    private String membertype;
    /**证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照	**/
    private String certificatetype;
    /**证件号码	**/
    private String certificateno;
    /**手机号码	**/
    private String mobile;
    /**银行卡号	**/
    private String cardno;
    /**银行	**/
    private String bank;
    /**就职单位	**/
    private String companyname;
    /**联系邮箱	**/
    private String email;
    /**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
    private String status;
    /**插入日期	**/
    private String insertdate;
    /**插入时间	**/
    private String inserttime;
    /**更新日期	**/
    private String updatedate;
    /**更新时间	**/
    private String updatetime;
    /**基本信息是否保存(0：否，1：是)	**/
    private String issave;
    /**来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签	**/
    private String source;
    /**法人名称	**/
    private String corname;
    /**法人证件类型	**/
    private String corcardtype;
    /**法人证件号	**/
    private String corcardno;
    /**法人电话号码	**/
    private String cormob;
    /**所属招商对接人	**/
    private String dockingPeople;

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getRegistersource() {
        return registersource;
    }

    public void setRegistersource(String registersource) {
        this.registersource = registersource;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
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

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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

    public String getIssave() {
        return issave;
    }

    public void setIssave(String issave) {
        this.issave = issave;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCorname() {
        return corname;
    }

    public void setCorname(String corname) {
        this.corname = corname;
    }

    public String getCorcardtype() {
        return corcardtype;
    }

    public void setCorcardtype(String corcardtype) {
        this.corcardtype = corcardtype;
    }

    public String getCorcardno() {
        return corcardno;
    }

    public void setCorcardno(String corcardno) {
        this.corcardno = corcardno;
    }

    public String getCormob() {
        return cormob;
    }

    public void setCormob(String cormob) {
        this.cormob = cormob;
    }

    public String getDockingPeople() {
        return dockingPeople;
    }

    public void setDockingPeople(String dockingPeople) {
        this.dockingPeople = dockingPeople;
    }
}
