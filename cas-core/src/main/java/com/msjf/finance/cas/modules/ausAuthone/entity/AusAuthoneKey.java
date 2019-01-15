package com.msjf.finance.cas.modules.ausAuthone.entity;


import com.msjf.finance.msjf.core.entity.BaseEntity;

public class AusAuthoneKey  extends BaseEntity {
    //客户代码
    private  String customerno;

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }
}
