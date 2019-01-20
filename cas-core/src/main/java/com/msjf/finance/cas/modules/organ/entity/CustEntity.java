package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 用户基本信息表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:08
 */
public class CustEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 客户代码
     */

    private String customerno;
    /**
     * 登录名
     */
    private String loginname;
    /**
     * 注册来源 0-web 1-app
     */
    private String registersource;
    /**
     * 用户类型 字典102 0-个人 1-企业
     */
    private String membertype;
    /**
     * 证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照
     */
    private String certificatetype;
    /**
     * 证件号码
     */
    private String certificateno;
    /**
     * 主要联系人
     */
    private String linkmanname;
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
     * 就职单位
     */
    private String companyname;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定
     */
    private String status;
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
     * 基本信息是否保存(0：否，1：是)
     */
    private String issave;
    /**
     * 来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
     */
    private String source;
    /**
     * 法人名称
     */
    private String corname;
    /**
     * 法人证件类型
     */
    private String corcardtype;
    /**
     * 法人证件号
     */
    private String corcardno;
    /**
     * 法人电话号码
     */
    private String cormob;

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
     * 设置：登录名
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * 获取：登录名
     */
    public String getLoginname() {
        return loginname;
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
     * 设置：主要联系人
     */
    public void setLinkmanname(String linkmanname) {
        this.linkmanname = linkmanname;
    }

    /**
     * 获取：主要联系人
     */
    public String getLinkmanname() {
        return linkmanname;
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
     * 设置：就职单位
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    /**
     * 获取：就职单位
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * 设置：联系邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：联系邮箱
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

    /**
     * 设置：基本信息是否保存(0：否，1：是)
     */
    public void setIssave(String issave) {
        this.issave = issave;
    }

    /**
     * 获取：基本信息是否保存(0：否，1：是)
     */
    public String getIssave() {
        return issave;
    }

    /**
     * 设置：来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取：来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
     */
    public String getSource() {
        return source;
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
     * 设置：法人证件类型
     */
    public void setCorcardtype(String corcardtype) {
        this.corcardtype = corcardtype;
    }

    /**
     * 获取：法人证件类型
     */
    public String getCorcardtype() {
        return corcardtype;
    }

    /**
     * 设置：法人证件号
     */
    public void setCorcardno(String corcardno) {
        this.corcardno = corcardno;
    }

    /**
     * 获取：法人证件号
     */
    public String getCorcardno() {
        return corcardno;
    }

    /**
     * 设置：法人电话号码
     */
    public void setCormob(String cormob) {
        this.cormob = cormob;
    }

    /**
     * 获取：法人电话号码
     */
    public String getCormob() {
        return cormob;
    }
}
