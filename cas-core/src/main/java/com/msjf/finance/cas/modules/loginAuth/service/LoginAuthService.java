package com.msjf.finance.cas.modules.loginAuth.service;

import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.Map;

public interface LoginAuthService {
    Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam);
}
