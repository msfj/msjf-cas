package com.msjf.finance.cas.modules.changePwd.Service;

import com.msjf.finance.cas.facade.changePwd.domain.ChangePwdDomain;
import com.msjf.finance.cas.facade.changePwd.domain.EchoMobileDomain;
import com.msjf.finance.cas.facade.changePwd.domain.RequestChangePwdDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.Map;

public interface ChangePwdService {
    /**
     * 密码变更
     * @param requestChangePwdDomain
     * @return
     */
    Response<ChangePwdDomain> changePwd(RequestChangePwdDomain requestChangePwdDomain);

    /**
     * 手机号码回显
     * @param
     * @return
     */
    Response<EchoMobileDomain> echoMobile(String certificateno);
}
