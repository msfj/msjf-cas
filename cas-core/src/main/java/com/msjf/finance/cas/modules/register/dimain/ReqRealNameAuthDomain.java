package com.msjf.finance.cas.modules.register.dimain;

public class ReqRealNameAuthDomain {
    /**
     * 开户人证件号码
     */
    private String idNo;
    /**
     * 开户人证件类型
     */
    private String idType;
    /**
     * 开户人证件名称
     */
    private String name;
    /**
     * 开户人手机号
     */
    private String mobileNo;
    /**
     * 开户人银行卡
     */
    private String bankCardNo;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
}
