package com.msjf.finance.cas.facade.loginAuth;
import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;


public interface LoginAuthFacade {
    Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam);
}
