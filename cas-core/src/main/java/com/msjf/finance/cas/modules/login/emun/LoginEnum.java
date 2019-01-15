package com.msjf.finance.cas.modules.login.emun;

import com.msjf.finance.msjf.core.emun.ResponseService;

/**
 * Created by kanglong on 2019/1/15.
 */
public enum  LoginEnum implements ResponseService {
    MSG_PARAM_ERROR("CAS0001", "入参不合法"),
    MSG_USER_NULL("CAS0002", "查询用户信息为空"),
    LOGIN_SOURCE_NULL("CAS0003", "登录来源不能为空"),
    MSG_USER_LOCK("CAS0004", "账户已锁定"),
    MOBILE_NULL("CAS0005", "手机号码不能为空"),
    MSG_USER_FROZEN("CAS0006", "账户已冻结"),
    MSG_USER_CANCEL("CAS0007", "账户已销户"),
    MSGCODE_NULL("CAS0008", "验证码不能为空"),
    PWD_ENCRYPT_ERROR("CAS0009", "密码加密对比失败"),
    CHECK_FILED("CAS0010", "校验失败"),
    IMAGE_CODE_NULL("CAS0011", "图形验证码不能为空"),
    PWD_NULL("CAS0012", "密码不能为空"),
    LOGIN_NAME_NULL("CAS0013", "登录账号不能为空"),
    CORPORATION_QUERY_NULL("CAS0014", "查无该法人企业信息"),
    PWD_ERROR_LOCK("CAS0015", "用户名或密码错误,账户已锁定"),
    LOGIN_FAILED("CAS0016", "登陆失败"),
    DICT_QUERY_NULL("CAS0017", "企业分类字典值不存在字典中"),
    LOGIN_SUCCESS("CAS0018", "登陆成功"),
    LOGIN_TYPE_NULL("CAS0019", "登陆方式");
    private String errorCode;
    private String errorDesc;

    LoginEnum(String errorCode, String errorDesc) {
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
