package com.msjf.finance.cas.modules.register.service;

import com.msjf.finance.cas.facade.register.domain.RegisterDomain;
import com.msjf.finance.msjf.core.response.Response;

public interface RegisterService {

    /**
     * 注册
     * @return
     */
    Response Register(RegisterDomain registerDomain);
}
