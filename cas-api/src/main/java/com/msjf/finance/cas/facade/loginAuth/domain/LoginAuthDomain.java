package com.msjf.finance.cas.facade.loginAuth.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

public class LoginAuthDomain extends BaseDomain{
    private String customerno;
    private String loginname;
    private String certificateno;
    private String password;

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getCertificateno() {
        return certificateno;
    }

    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
