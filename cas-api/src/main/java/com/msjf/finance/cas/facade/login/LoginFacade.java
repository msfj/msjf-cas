package com.msjf.finance.cas.facade.login;


import com.msjf.finance.cas.facade.login.domain.LoginDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginFacade {
    /**
     * 会员登陆
     * @param mapParam
     * @return
     */
    Response<LoginDomain> memberLogin(HashMap<String, Object> mapParam);

    /**
     * 法人登陆
     * @param mapParam
     * @return
     */
    Response<List<Map>> corporationLogin(HashMap<String, Object> mapParam);


}
