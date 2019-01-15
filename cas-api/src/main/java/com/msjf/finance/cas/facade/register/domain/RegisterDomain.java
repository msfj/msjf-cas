package com.msjf.finance.cas.facade.register.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

/**
 * Created by chengjunping on 2019/1/15.
 */
public class RegisterDomain extends BaseDomain {

    /**
     * 用户类型
     */
    private String membertype;

    /**
     * 注册来源 0-web 1-app
     */
    private String registersource;



    /**
     * 用户名称
     */
    private String membername;

    /**
     * 证件类型 0-身份证 1-护照 A-营业执照
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
     * 银行卡号
     */
    private String cardno;

    /**
     * 银行
     */
    private String bank;

    /**
     * 验证码
     */
    private String msgcode;

    /**
     * 密码
     */
    private String password;


    /**
     * 就职单位
     */
    private String companyname;

    /**
     * 法人名称
     */
    private String corname;


    /**
     * 法人证件类型
     */
    private String corcardtype;


    /**
     * 法人证件号码
     */
    private String corcardno;


    /**
     * 法注册步骤
     */
    private String step;

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public String getRegistersource() {
        return registersource;
    }

    public void setRegistersource(String registersource) {
        this.registersource = registersource;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
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

    public String getMsgcode() {
        return msgcode;
    }

    public void setMsgcode(String msgcode) {
        this.msgcode = msgcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
