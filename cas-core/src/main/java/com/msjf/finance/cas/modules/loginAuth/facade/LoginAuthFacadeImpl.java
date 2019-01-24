package com.msjf.finance.cas.modules.loginAuth.facade;
import com.msjf.finance.cas.facade.loginAuth.LoginAuthFacade;
import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;
import com.msjf.finance.cas.modules.loginAuth.emun.LoginAuthEmun;
import com.msjf.finance.cas.modules.loginAuth.service.LoginAuthService;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import javax.annotation.Resource;
import java.util.HashMap;
/**
 * leixiaorui  2019/1/13  用于给GWS调用的方法
 */
@Service("loginAuthFacade")
public class LoginAuthFacadeImpl implements LoginAuthFacade {
    @Resource
    LoginAuthService loginAuthService;
    @Override
    public Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam) {
           //打印开始日志log4j
        try {
            if (ObjectUtils.isEmpty(mapParam)||
                    StringUtil.isEmpty((String) mapParam.get("userName"))||
                    StringUtil.isEmpty((String) mapParam.get("loginPlat"))){
                //打印警告日志log4j
                return new Response<>().fail(LoginAuthEmun.MSG_PARAM_ERROR);
            }
            //打印成功日志log4j
            return  loginAuthService.selectLoginInfo(mapParam);
        }catch (Exception e){
              //打印错误日志log4j
            return new Response<>().fail(LoginAuthEmun.MSG_USER_EXCEPTION);
        }
    }
}
