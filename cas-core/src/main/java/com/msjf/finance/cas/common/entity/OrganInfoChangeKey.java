package com.msjf.finance.cas.common.entity;

public class OrganInfoChangeKey {
    //企业客户代码
    protected String customerno;
    //版本号（由小到大）
    protected Integer version;

    public String getCustomerno() {
        return this.customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setKey(String customerno, Integer version) {
        this.customerno = customerno;
        this.version = version;
    }
}