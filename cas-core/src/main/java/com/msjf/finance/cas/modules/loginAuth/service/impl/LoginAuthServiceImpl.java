package com.msjf.finance.cas.modules.loginAuth.service.impl;

import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;
import com.msjf.finance.cas.modules.AccountDao;
import com.msjf.finance.cas.modules.loginAuth.emun.LoginAuthEmun;
import com.msjf.finance.cas.modules.loginAuth.service.LoginAuthService;
import com.msjf.finance.cas.modules.util.StringUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("loginAuthService")
public class LoginAuthServiceImpl implements LoginAuthService {
    @Resource
    AccountDao accountDao;

    @Override
    public Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam) {
        LoginAuthDomain loginAuthDomain = new LoginAuthDomain();
        HashMap reqMap = new HashMap();
        List<Map> list = null;
        reqMap.put("loginname",mapParam.get("userName"));
            //日志
        if ("0".equals( mapParam.get("loginType"))) {
            list = accountDao.selectLoginInfo(reqMap);
        } else if ("1".equals(mapParam.get("loginType"))) {
            list = accountDao.selectEmployeeInfo(reqMap);
        }
        if (CollectionUtils.isEmpty(list)) {
            //日志
            return new Response<>().fail(LoginAuthEmun.MSG_USER_NULL);
        }
        loginAuthDomain.setCertificateno(StringUtil.valueOf(list.get(0).get("certificateno")));
        loginAuthDomain.setCustomerno(StringUtil.valueOf(list.get(0).get("customerno")));
        loginAuthDomain.setLoginname(StringUtil.valueOf(list.get(0).get("loginname")));
        loginAuthDomain.setPassword(StringUtil.valueOf(list.get(0).get("password")));
        //日志
        return new Response<>().success(loginAuthDomain);
    }
}
