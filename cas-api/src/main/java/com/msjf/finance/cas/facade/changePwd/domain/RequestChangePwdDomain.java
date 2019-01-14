package com.msjf.finance.cas.facade.changePwd.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

public class RequestChangePwdDomain extends BaseDomain {
    private String certificateno;
    private String msgCode;
    private String step;
    private String password;

    public String getCertificateno() {
        return certificateno;
    }

    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
