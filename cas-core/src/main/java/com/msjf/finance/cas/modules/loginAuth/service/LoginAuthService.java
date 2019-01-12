package com.msjf.finance.cas.modules.loginAuth.service;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;

import java.util.HashMap;
import java.util.Map;

public interface LoginAuthService {
    Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam);
}
