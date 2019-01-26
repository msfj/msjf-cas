package com.msjf.finance.cas.facade.changePwd.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

/**
 * Created by kanglong on 2019/1/15.
 */
public class EchoMobileDomain extends BaseDomain {
    private String mobile;
    private String certificateno;
    private String seqNum;
    private String activeSeconds;

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        this.seqNum = seqNum;
    }

    public String getActiveSeconds() {
        return activeSeconds;
    }

    public void setActiveSeconds(String activeSeconds) {
        this.activeSeconds = activeSeconds;
    }

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
