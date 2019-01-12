package com.msjf.finance.cas.modules.changePwd.Service;

import com.msjf.finance.cas.common.response.Response;

import java.util.HashMap;
import java.util.Map;

public interface ChangePwdService {
    /**
     * 密码变更
     * @param mapParam
     * @return
     */
    Response<Map> changePwd(HashMap<String, Object> mapParam);

    /**
     * 手机号码回显
     * @param mapParam
     * @return
     */
    Response<Map> echoMobile(HashMap<String, Object> mapParam);
}
