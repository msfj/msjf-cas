package com.msjf.finance.cas.modules.register.emun;

import com.msjf.finance.msjf.core.emun.ResponseService;

public enum RealNameAuthEnum implements ResponseService {
    MSG_PARAM_ERROR("CAS0001", "入参不合法"),
    MSG_CONFIG_NULL("CAS0002", "查询实名认证配置为空"),
    LOGIN_SOURCE_NULL("CAS0003", "登录来源不能为空"),
    MSG_USER_LOCK("CAS0004", "账户已锁定"),
    MOBILE_NULL("CAS0005", "手机号码不能为空"),
    MSG_USER_FROZEN("CAS0006", "账户已冻结"),
    MSG_USER_CANCEL("CAS0007", "账户已销户"),
    MSGCODE_NULL("CAS0008", "验证码不能为空"),
    PWD_ENCRYPT_ERROR("CAS0009", "密码加密对比失败"),
    CHECK_FILED("CAS0010", "验证码校验失败"),
    IMAGE_CODE_NULL("CAS0011", "图形验证码不能为空"),
    PWD_NULL("CAS0012", "密码不能为空"),
    LOGIN_NAME_NULL("CAS0013", "登录账号不能为空"),
    CORPORATION_QUERY_NULL("CAS0014", "查无该法人企业信息"),
    PWD_ERROR_LOCK("CAS0015", "用户名或密码错误,账户已锁定"),
    AUTH__FAILED("CAS0016", "认证失败"),
    DICT_QUERY_NULL("CAS0017", "企业分类字典值不存在字典中"),
    AUTH_SUCCESS("CAS0018", "认证成功"),
    LOGIN_TYPE_NULL("CAS0019", "登陆方式不能为空"),
    AUTH__EXCEPTION("CAS0019", "认证异常"),
    QUERY_COMPANY_SUCCESS("CAS0018", "查询法人企业信息成功");
    private String errorCode;
    private String errorDesc;

    RealNameAuthEnum(String errorCode, String errorDesc) {
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