package com.msjf.finance.cas.modules.login.facade;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.login.LoginFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("LoginFacade")
public class LoginFacadeImpl implements LoginFacade {
    @Override
    public Response<List<Map>> memberLogin(HashMap<String, Object> mapParam) {
        return null;
    }
}
