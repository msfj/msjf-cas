package com.msjf.finance.cas.common.entity;

public class OrganCounterSignKey {
    //企业客户代码
    protected String orgcustomerno;
    //登记事项 0-新设 1-变更 2-迁入
    protected String registertype;

    public String getOrgcustomerno() {
        return this.orgcustomerno;
    }

    public void setOrgcustomerno(String orgcustomerno) {
        this.orgcustomerno = orgcustomerno;
    }

    public String getRegistertype() {
        return this.registertype;
    }

    public void setRegistertype(String registertype) {
        this.registertype = registertype;
    }

    public void setKey(String orgcustomerno, String registertype) {
        this.orgcustomerno = orgcustomerno;
        this.registertype = registertype;
    }
}