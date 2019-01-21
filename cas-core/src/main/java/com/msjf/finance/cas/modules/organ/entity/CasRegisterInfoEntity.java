package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:08
 */
public class CasRegisterInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */

    private String id;
    /**
     * 用户类型 字典102 0-个人 1-企业
     */
    private String membertype;
    /**
     * 注册来源 0-web 1-app
     */
    private String registersource;
    /**
     * 证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照
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
     * 公司名称
     */
    private String companyname;
    /**
     * 账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定
     */
    private String status;
    /**
     * 插入时间
     */
    private String insertdate;
    /**
     * 更新时间
     */
    private String updatedate;
    /**
     * 法人名称
     */
    private String corname;
    /**
     * 证件类型 字典1011 0-身份证 1-护照 1012
     */
    private String corcardtype;
    /**
     * 法人证件号码
     */
    private String corcardno;
    /**
     * 客户名称
     */
    private String membername;

    /**
     * 设置：
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public String getId() {
        return id;
    }

    /**
     * 设置：用户类型 字典102 0-个人 1-企业
     */
    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    /**
     * 获取：用户类型 字典102 0-个人 1-企业
     */
    public String getMembertype() {
        return membertype;
    }

    /**
     * 设置：注册来源 0-web 1-app
     */
    public void setRegistersource(String registersource) {
        this.registersource = registersource;
    }

    /**
     * 获取：注册来源 0-web 1-app
     */
    public String getRegistersource() {
        return registersource;
    }

    /**
     * 设置：证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照
     */
    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype;
    }

    /**
     * 获取：证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照
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
     * 设置：银行卡号
     */
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    /**
     * 获取：银行卡号
     */
    public String getCardno() {
        return cardno;
    }

    /**
     * 设置：银行
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 获取：银行
     */
    public String getBank() {
        return bank;
    }

    /**
     * 设置：公司名称
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    /**
     * 获取：公司名称
     */
    public String getCompanyname() {
        return companyname;
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
     * 设置：插入时间
     */
    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }

    /**
     * 获取：插入时间
     */
    public String getInsertdate() {
        return insertdate;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取：更新时间
     */
    public String getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置：法人名称
     */
    public void setCorname(String corname) {
        this.corname = corname;
    }

    /**
     * 获取：法人名称
     */
    public String getCorname() {
        return corname;
    }

    /**
     * 设置：证件类型 字典1011 0-身份证 1-护照 1012
     */
    public void setCorcardtype(String corcardtype) {
        this.corcardtype = corcardtype;
    }

    /**
     * 获取：证件类型 字典1011 0-身份证 1-护照 1012
     */
    public String getCorcardtype() {
        return corcardtype;
    }

    /**
     * 设置：法人证件号码
     */
    public void setCorcardno(String corcardno) {
        this.corcardno = corcardno;
    }

    /**
     * 获取：法人证件号码
     */
    public String getCorcardno() {
        return corcardno;
    }

    /**
     * 设置：客户名称
     */
    public void setMembername(String membername) {
        this.membername = membername;
    }

    /**
     * 获取：客户名称
     */
    public String getMembername() {
        return membername;
    }
}
