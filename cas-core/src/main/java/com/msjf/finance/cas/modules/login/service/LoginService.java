package com.msjf.finance.cas.modules.login.service;

import com.msjf.finance.cas.common.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginService {
    public Response<List<Map>> memberLogin(HashMap<String, Object> mapParam);
}
