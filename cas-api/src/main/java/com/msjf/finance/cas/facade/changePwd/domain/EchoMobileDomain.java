package com.msjf.finance.cas.facade.changePwd.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

/**
 * Created by kanglong on 2019/1/15.
 */
public class EchoMobileDomain extends BaseDomain {
    private String mobile;
    private String certificateno;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCertificateno() {
        return certificateno;
    }

    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }
}
