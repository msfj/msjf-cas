package com.msjf.finance.cas.modules.changePwd.emun;

import com.msjf.finance.msjf.core.emun.ResponseService;

public enum ChangePwdEnum implements ResponseService {
    MSG_PARAM_ERROR("CAS0001", "入参不合法"),
    MSG_USER_NULL("CAS0002", "查询用户信息为空"),
    MSG_STEP_NULL("CAS0002", "步骤不能为空"),
    MSG_CERTIFICATENO_NULL("CAS0002", "证件号码不能为空"),
    MSG_USER_EXCEPTION("CAS0003", "获取用户信息异常"),
    TEMPLE_ID_NULL("CAS0004", "模板ID不能为空"),
    MOBILE_NULL("CAS0005", "手机号码不能为空"),
    SYSTEM_PARA_ERROR("CAS0006", "系统参数异常"),
    MSG_CHECK_EXCEPTION("CAS0007", "信息修改异常"),
    MSG_SEND_EXCEPTION("CAS0008", "发送信息异常"),
    SEND_SMS_FAILD("CAS0009", "短信发送失败"),
    OLD_MOBILE_CHECK_ERROR("CAS0010", "原手机号码校验不通过"),
    CHANGE_MOBILE_EXCEPTION("CAS0011", "换绑手机不能与原手机相同"),
    VERIFICATION_SUCCESS("CAS0012", "校验成功"),
    MSGCODE_NOT_EXIST("CAS0013", "校验码不存在"),
    MSGCODE_NULL("CAS0014", "验证码不能为空"),
    QUERY_SUCCESS("CAS0015", "获取成功"),
    CHANGE_FAILED("CAS0016", "修改失败"),
    CHANGE_SUCCESS("CAS0017", "修改成功"),
    SMS_SEND_SUCCESS("CAS0018", "发送成功"),
    SMS_SEND_ERROR("CAS0019", "发送失败"),
    VERIFICATION_FAILED("CAS0020", "短信校验未通过");
    private String errorCode;
    private String errorDesc;

    ChangePwdEnum(String errorCode, String errorDesc) {
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
