package com.msjf.finance.cas.modules.loginAuth.facade;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.login.LoginFacade;
import com.msjf.finance.cas.facade.loginAuth.LoginAuthFacade;
import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;
import com.msjf.finance.cas.modules.loginAuth.service.LoginAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service("loginAuthFacade")
public class LoginAuthFacadeImpl implements LoginAuthFacade {
    @Resource
    LoginAuthService loginAuthService;
    @Override
    public Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam) {
        Response rs=null;
        try {
            rs=loginAuthService.selectLoginInfo(mapParam);
        }catch (Exception e){
            rs.fail();
            throw new RuntimeException(e.getMessage(),e);
        }
        return rs;
    }
}
