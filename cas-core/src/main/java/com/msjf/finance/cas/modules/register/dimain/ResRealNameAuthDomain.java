package com.msjf.finance.cas.modules.register.dimain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

public class ResRealNameAuthDomain extends BaseDomain {
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 是否成功
     */
    private Boolean authResult;
    /**
     * 银行卡类型
     */
    private String cardType;
    /**
     * 返回消息
     */
    private String erMsg;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Boolean getAuthResult() {
        return authResult;
    }

    public void setAuthResult(Boolean authResult) {
        this.authResult = authResult;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getErMsg() {
        return erMsg;
    }

    public void setErMsg(String erMsg) {
        this.erMsg = erMsg;
    }
}
