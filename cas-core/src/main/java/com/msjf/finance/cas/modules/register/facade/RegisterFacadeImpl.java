package com.msjf.finance.cas.modules.register.facade;

import com.msjf.finance.cas.facade.register.RegisterFacade;
import com.msjf.finance.cas.facade.register.domain.RegisterDomain;
import com.msjf.finance.cas.modules.Account.Account;
import com.msjf.finance.cas.modules.register.service.RegisterService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 业务用户注册
 * Created by lzp on 2018/12/25.
 */
@Service("registerFacade")
@Transactional(rollbackFor = Exception.class)
public class RegisterFacadeImpl extends Account implements RegisterFacade{

   @Resource
    RegisterService registerService;

    @Override
    public Response  inserRegister(RegisterDomain res) throws Exception{
        Response re =new Response();
        try {
             re = registerService.Register(res);
        }catch (Exception e){
            e.printStackTrace();
        }
       return  re;
    }



}
