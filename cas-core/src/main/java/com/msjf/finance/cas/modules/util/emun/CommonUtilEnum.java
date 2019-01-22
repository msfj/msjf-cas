package com.msjf.finance.cas.modules.util.emun;

import com.msjf.finance.msjf.core.emun.ResponseService;

/**
 * Created by kanglong on 2019/1/15.
 */
public enum CommonUtilEnum implements ResponseService {
    MSG_PARAM_ERROR("CAS0001", "入参不合法"),
    MSG_USER_NULL("CAS0002", "查询用户信息为空"),
    IMAGE_CHECK_EXCEPTION("CAS0003", "图形校验异常"),
    TEMPLE_ID_NULL("CAS0004", "模板ID不能为空"),
    MOBILE_NULL("CAS0005", "手机号码不能为空"),
    IMAGE_MAKE_SUCCESS("CAS0006", "生成图形验证码成功"),
    IMAGE_GET_EXCEPTION("CAS0007", "图形验证码获取异常"),
    IMAGE_OVER_TIME("CAS0008", "图形码验证已经失效"),
    IMAGE_TIME_GET_ERROR("CAS0009", "图形码验证时间参数解析错误"),
    IMAGE_CHECK_FAILED("CAS0010", "验证码校验失败"),
    CHANGE_MOBILE_EXCEPTION("CAS0011", "换绑手机不能与原手机相同"),
    VERIFICATION_SUCCESS("CAS0012", "校验成功"),
    MSGCODE_NOT_EXIST("CAS0013", "校验码不存在"),
    MSGCODE_NULL("CAS0014", "验证码不能为空"),
    QUERY_SUCCESS("CAS0015", "获取成功"),
    CHANGE_FAILED("CAS0016", "修改失败"),
    IMAGE_MD5_ERROR("CAS0017", "图形码验证MD5参数解析错误"),
    CHECK_SUCCESS("CAS0018", "验证成功"),
    SMS_SEND_ERROR("CAS0019", "发送失败"),
    DICT_QUERY_NULL("CAS0020", "字典查询为空");
    private String errorCode;
    private String errorDesc;

    CommonUtilEnum(String errorCode, String errorDesc) {
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
