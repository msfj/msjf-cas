package com.msjf.finance.cas.modules.organ.emun;


import com.msjf.finance.msjf.core.emun.ResponseService;

public enum  OrganInfoEmun implements ResponseService {
    MSG_PARAM_ERROR("CAS0001", "入参不合法"),
    MSG_SYS_ERROR("CAS0002", "系统调用异常！"),
    MSG_PARAM_NULL("CAS0003", "入参为空");

    private String errorCode;
    private String errorDesc;

    OrganInfoEmun(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    @Override
    public String getResponseCode() {
        return errorCode;
    }

    @Override
    public String getResponseMessage() {
        return errorDesc;
    }
}
