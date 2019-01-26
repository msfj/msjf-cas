package com.msjf.finance.cas.modules.loginAuth.service.impl;

import com.msjf.finance.cas.facade.loginAuth.domain.LoginAuthDomain;
import com.msjf.finance.cas.common.joindao.persistence.AccountJoinDao;
import com.msjf.finance.cas.modules.loginAuth.emun.LoginAuthEmun;
import com.msjf.finance.cas.modules.loginAuth.service.LoginAuthService;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.cas.common.utils.StringUtil;
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
    AccountJoinDao accountJoinDao;

    @Override
    public Response<LoginAuthDomain> selectLoginInfo(HashMap<String, Object> mapParam) {
        LoginAuthDomain loginAuthDomain = new LoginAuthDomain();
        HashMap reqMap = new HashMap();
        List<Map> list = null;
        String userName=StringUtil.valueOf(mapParam.get("userName"));
        reqMap.put("loginname",userName);
        Boolean isMobile=CommonUtil.isMobileNO(userName);
            //日志
        //业务平台获取分两种情况
        // 1个人手机号码
        // 2.企业或个人证件号码获取
        if ("0".equals( mapParam.get("loginPlat"))) {
            if(isMobile){
                list = accountJoinDao.selectPersonInfoByMob(reqMap);
            }else{
                list = accountJoinDao.selectLoginInfo(reqMap);
            }
            //管理平台获取
            //通过登陆名获取信息
        } else if ("1".equals(mapParam.get("loginPlat"))) {
            list = accountJoinDao.selectEmployeeInfo(reqMap);
        }
        if (CollectionUtils.isEmpty(list)) {
            //日志
            return new Response<>().fail(LoginAuthEmun.MSG_USER_NULL);
        }
        loginAuthDomain.setCustomerno(StringUtil.valueOf(list.get(0).get("customerno")));
        loginAuthDomain.setLoginname(StringUtil.valueOf(list.get(0).get("loginname")));
        loginAuthDomain.setPassword(StringUtil.valueOf(list.get(0).get("password")));
        //日志
        return new Response<>().success(LoginAuthEmun.USER_QUERY_SUCCESS,loginAuthDomain);
    }
}
