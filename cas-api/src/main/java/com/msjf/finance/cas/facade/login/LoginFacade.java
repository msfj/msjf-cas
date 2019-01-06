package com.msjf.finance.cas.facade.login;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginFacade {

    Response<List<Map>> memberLogin(HashMap<String, Object> mapParam);

}
