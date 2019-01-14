package com.msjf.finance.cas.facade.changePwd.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

public class ChangePwdDomain extends BaseDomain {
    private String seqNum;
    private String activeSeconds;

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        seqNum = seqNum;
    }

    public String getActiveSeconds() {
        return activeSeconds;
    }

    public void setActiveSeconds(String activeSeconds) {
        activeSeconds = activeSeconds;
    }
}
