package com.msjf.finance.cas.modules.login.service;


import com.msjf.finance.cas.facade.login.domain.LoginDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginService {
    Response<LoginDomain> memberLogin(HashMap<String, Object> mapParam);

    Response<List<Map>> corporationLogin(HashMap<String, Object> mapParam);


}
