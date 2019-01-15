package com.msjf.finance.cas.facade.login.domain;

/**
 * Created by kanglong on 2019/1/15.
 */
public class LoginDomain {
    /**
     * 客户代码
     */
    private String customerno;
    /**
     * 是否已经完成
     */
    private String isfinish;
    /**
     * 客户类型 1-企业 0-个人
     */
    private String membertype;
    /**
     * 客户名称
     */
    private String membername;
    /**
     * 登陆名称
     */
    private String name;
    /**
     * 企业类型
     */
    private String organtype;
    /**
     * 企业分类
     */
    private String organclass;

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(String isfinish) {
        this.isfinish = isfinish;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgantype() {
        return organtype;
    }

    public void setOrgantype(String organtype) {
        this.organtype = organtype;
    }

    public String getOrganclass() {
        return organclass;
    }

    public void setOrganclass(String organclass) {
        this.organclass = organclass;
    }
}
