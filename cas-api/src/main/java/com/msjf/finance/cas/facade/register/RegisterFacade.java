package com.msjf.finance.cas.facade.register;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;


/**
 * Created by lzp on 2018/12/25.
 */
public interface RegisterFacade {
    /**
     * 业务用户注册
     */
    public Response inserRegister(HashMap<String,Object> mapParam ) throws Exception;
}
