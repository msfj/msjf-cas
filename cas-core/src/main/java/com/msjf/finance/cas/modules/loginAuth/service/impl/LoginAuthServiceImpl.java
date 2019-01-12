package com.msjf.finance.cas.modules.loginAuth.service.impl;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;
import com.msjf.finance.cas.modules.AccountDao;
import com.msjf.finance.cas.modules.loginAuth.service.LoginAuthService;
import com.msjf.finance.cas.modules.util.CheckUtil;
import com.msjf.finance.cas.modules.util.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("loginAuthService")
@Scope("prototype")
public class LoginAuthServiceImpl  implements LoginAuthService {
    private String userName;

    /**
     * 0-业务平台
     * 1-管理平台
     */
    private String loginType;

    @Resource
    AccountDao accountDao;
    @Override
    public Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam) {
        Response<LoginAuthDomain> rs=new Response<LoginAuthDomain>();
        rs.fail();
        userName= StringUtil.valueOf(mapParam.get("userName"));
        loginType= StringUtil.valueOf(mapParam.get("loginType"));
        if(CheckUtil.isNull(userName)){
            rs.fail("用户名不能为空");
            return rs;
        }
        if(CheckUtil.isNull(loginType)){
            rs.fail("登陆平台不能为空");
            return rs;
        }
        LoginAuthDomain loginAuthDomain=new LoginAuthDomain();
        HashMap reqMap=new HashMap();
        if("0".equals(loginType)){
            reqMap.put("loginname",userName);
            List<Map> list=accountDao.selectLoginInfo(reqMap);
            if(!CheckUtil.isNull(list)){
                loginAuthDomain.setCertificateno(StringUtil.valueOf(list.get(0).get("certificateno")));
                loginAuthDomain.setCustomerno(StringUtil.valueOf(list.get(0).get("customerno")));
                loginAuthDomain.setLoginname(StringUtil.valueOf(list.get(0).get("loginname")));
                loginAuthDomain.setPassword(StringUtil.valueOf(list.get(0).get("password")));
                rs.success("认证通过",loginAuthDomain);
            }
        }else if("1".equals(loginType)){
            reqMap.put("loginname",userName);
            List<Map> list=accountDao.selectEmployeeInfo(reqMap);
            if(!CheckUtil.isNull(list)){
                loginAuthDomain.setCertificateno(StringUtil.valueOf(list.get(0).get("certificateno")));
                loginAuthDomain.setCustomerno(StringUtil.valueOf(list.get(0).get("customerno")));
                loginAuthDomain.setLoginname(StringUtil.valueOf(list.get(0).get("loginname")));
                loginAuthDomain.setPassword(StringUtil.valueOf(list.get(0).get("password")));
                rs.success("认证通过",loginAuthDomain);
            }
        }else{
            rs.fail();
        }
        return rs;
    }
}
