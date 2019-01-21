package com.msjf.finance.cas.modules.login.facade;

import com.msjf.finance.cas.facade.login.LoginFacade;
import com.msjf.finance.cas.facade.login.domain.LoginDomain;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.modules.login.emun.LoginEnum;
import com.msjf.finance.cas.modules.login.service.LoginService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("loginFacade")
public class LoginFacadeImpl implements LoginFacade {
    @Resource
    LoginService loginService;
    @Override
    public Response<LoginDomain> memberLogin(HashMap<String, Object> mapParam) {
        Response rs=null;
        try {
            rs=loginService.memberLogin(mapParam);
        }catch (Exception e){
            rs.fail(LoginEnum.LOGIN__EXCEPTION);
            throw new RuntimeException(e.getMessage(),e);
        }
        return rs;
    }

    @Override
    public Response<List<Map>> corporationLogin(HashMap<String, Object> mapParam) {
        Response rs=null;
        try {
            rs=loginService.corporationLogin(mapParam);
        }catch (Exception e){
            rs.fail(LoginEnum.LOGIN__EXCEPTION);
            throw new RuntimeException(e.getMessage(),e);
        }
        return rs;
    }

    @Override
    public Response<List<Map>> getCorporationCompany(HashMap<String, Object> mapParam) {
        Response rs=null;
        try {
            rs=loginService.getCorporationCompany(mapParam);
        }catch (Exception e){
            rs.fail(LoginEnum.LOGIN__EXCEPTION);
            throw new RuntimeException(e.getMessage(),e);
        }
        return rs;
    }


}
