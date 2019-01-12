package com.msjf.finance.cas.modules.loginAuth.facade;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.login.LoginFacade;
import com.msjf.finance.cas.facade.loginAuth.LoginAuthFacade;
import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;
import com.msjf.finance.cas.modules.loginAuth.emun.LoginAuthEmun;
import com.msjf.finance.cas.modules.loginAuth.service.LoginAuthService;
import com.msjf.finance.cas.modules.util.CheckUtil;
import com.msjf.finance.cas.modules.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service("loginAuthFacade")
public class LoginAuthFacadeImpl implements LoginAuthFacade {
    @Resource
    LoginAuthService loginAuthService;
    @Override
    public Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam) {
        try {
            if (ObjectUtils.isEmpty(mapParam)||
                    StringUtil.isEmpty((String) mapParam.get("userName"))||
                    StringUtil.isEmpty((String) mapParam.get("loginType"))){
                return new Response<>().fail(LoginAuthEmun.MSG_PARAM_ERROR);
            }

            return  loginAuthService.selectLoginInfo(mapParam);
        }catch (Exception e){
              //打印错误日志log4j
            return new Response<>().fail();
        }
    }
}
