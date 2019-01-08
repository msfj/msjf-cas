package com.msjf.finance.cas.facade.register;

import com.msjf.finance.cas.common.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzp on 2018/12/25.
 */
public interface RegisterFacade {
    /**
     * 业务用户注册
     */
    public Response  inserRegister(HashMap<String,Object> mapParam,Response rs ) throws Exception;
}
