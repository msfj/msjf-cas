package com.msjf.finance.cas.facade.login;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginFacade {
    /**
     * 会员登陆
     * @param mapParam
     * @return
     */
    Response<Map> memberLogin(HashMap<String, Object> mapParam);

    /**
     * 法人登陆
     * @param mapParam
     * @return
     */
    Response<List<Map>> corporationLogin(HashMap<String, Object> mapParam);

    /**
     * 密码变更
     * @param mapParam
     * @return
     */
    Response<Map> changePwd(HashMap<String, Object> mapParam);
}
