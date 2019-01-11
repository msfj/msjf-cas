package com.msjf.finance.cas.modules.login.facade;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.login.LoginFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.modules.login.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("loginFacade")
public class LoginFacadeImpl implements LoginFacade {
    @Resource
    LoginService loginService;
    @Override
    public Response<Map> memberLogin(HashMap<String, Object> mapParam) {
        Response rs=null;
        try {
            rs=loginService.memberLogin(mapParam);
        }catch (Exception e){
            rs.fail();
            throw new RuntimeException(e.getMessage(),e);
        }
        return rs;
    }

    @Override
    public Response<Map> corporationLogin(HashMap<String, Object> mapParam) {
        Response rs=null;
        try {
            rs=loginService.corporationLogin(mapParam);
        }catch (Exception e){
            rs.fail();
            throw new RuntimeException(e.getMessage(),e);
        }
        return rs;
    }

    @Override
    public Response<Map> changePwd(HashMap<String, Object> mapParam) {
        Response rs=null;
        try {
            rs=loginService.changePwd(mapParam);
        }catch (Exception e){
            rs.fail();
            throw new RuntimeException(e.getMessage(),e);
        }
        return rs;
    }
}
