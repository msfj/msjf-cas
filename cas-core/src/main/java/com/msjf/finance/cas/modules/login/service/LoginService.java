package com.msjf.finance.cas.modules.login.service;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.modules.register.entity.CustEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginService {
    Response<Map> memberLogin(HashMap<String, Object> mapParam);

    Response<Map> corporationLogin(HashMap<String, Object> mapParam);

    /**
     * 密码变更
     * @param mapParam
     * @return
     */
    Response<Map> changePwd(HashMap<String, Object> mapParam);
}
