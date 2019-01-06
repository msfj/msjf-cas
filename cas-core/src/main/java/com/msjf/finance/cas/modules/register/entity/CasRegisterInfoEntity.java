package com.msjf.finance.cas.modules.register.entity;

public class CasRegisterInfoEntity {
    //客户代码
    private  String id;
    //手机号码
    private String mobile;
    //银行卡号cardno
    private String cardno;
    //银行
    private String bank;

    private String registersource;
    //注册来源 0-web 1-app

    //用户类型 字典102 0-个人 1-企业
    private String membertype;
    //证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照
    private String certificatetype;
    //证件号码
    private String certificateno;
    //就职单位
    private String companyname;
    //账户状态 字典103 0-正常  2-锁定
    private String status;
    //插入日期
    private String insertdate;
    //更新日期
    private String updatedate;

    //法人名称
    private String corname;

    //法人证件类型
    private String corcardtype;

    //法人证件号
    private String corcardno;

    //客户名称
    private String membername;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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


    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
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

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }
}
