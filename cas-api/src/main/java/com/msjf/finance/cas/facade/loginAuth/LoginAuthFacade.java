package com.msjf.finance.cas.facade.loginAuth;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;

import java.util.HashMap;
import java.util.Map;

public interface LoginAuthFacade {
    Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam);
}
