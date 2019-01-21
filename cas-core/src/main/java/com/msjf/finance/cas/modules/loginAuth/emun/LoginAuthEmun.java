package com.msjf.finance.cas.modules.loginAuth.emun;


import com.msjf.finance.msjf.core.emun.ResponseService;

public enum LoginAuthEmun implements ResponseService {
    MSG_PARAM_ERROR("GWS0001", "入参不合法"),
    MSG_USER_NULL("GWS0002", "查询用户信息为空"),
    MSG_USER_EXCEPTION("GWS0003", "获取用户信息异常"),
    USER_QUERY_SUCCESS("GWS0004", "获取用户信息成功");

    private String errorCode;
    private String errorDesc;

    LoginAuthEmun(String errorCode, String errorDesc) {
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
