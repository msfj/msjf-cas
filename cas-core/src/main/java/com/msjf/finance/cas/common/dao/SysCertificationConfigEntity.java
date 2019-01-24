package com.msjf.finance.cas.common.entity;

public class SysCertificationConfigEntity extends IBaseEntity{
    private String messagecode;

    private String isopen;

    private String orgcode;

    private String chnlid;

    private String authcode;

    private String authdate;

    private String username;

    private String userpassword;

    private String nettype;

    private String transname;

    private String productid;

    private String apiver;

    private String cerCheckCode;

    private String storealias;

    private String storepassword;

    private String url;

    public String getMessagecode() {
        return messagecode;
    }

    public void setMessagecode(String messagecode) {
        this.messagecode = messagecode == null ? null : messagecode.trim();
    }

    public String getIsopen() {
        return isopen;
    }

    public void setIsopen(String isopen) {
        this.isopen = isopen == null ? null : isopen.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getChnlid() {
        return chnlid;
    }

    public void setChnlid(String chnlid) {
        this.chnlid = chnlid == null ? null : chnlid.trim();
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode == null ? null : authcode.trim();
    }

    public String getAuthdate() {
        return authdate;
    }

    public void setAuthdate(String authdate) {
        this.authdate = authdate == null ? null : authdate.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getNettype() {
        return nettype;
    }

    public void setNettype(String nettype) {
        this.nettype = nettype == null ? null : nettype.trim();
    }

    public String getTransname() {
        return transname;
    }

    public void setTransname(String transname) {
        this.transname = transname == null ? null : transname.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getApiver() {
        return apiver;
    }

    public void setApiver(String apiver) {
        this.apiver = apiver == null ? null : apiver.trim();
    }

    public String getCerCheckCode() {
        return cerCheckCode;
    }

    public void setCerCheckCode(String cerCheckCode) {
        this.cerCheckCode = cerCheckCode == null ? null : cerCheckCode.trim();
    }

    public String getStorealias() {
        return storealias;
    }

    public void setStorealias(String storealias) {
        this.storealias = storealias == null ? null : storealias.trim();
    }

    public String getStorepassword() {
        return storepassword;
    }

    public void setStorepassword(String storepassword) {
        this.storepassword = storepassword == null ? null : storepassword.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}