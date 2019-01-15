package com.msjf.finance.cas.modules.changePwd.facade;
import com.msjf.finance.cas.facade.changePwd.ChangePwdFacade;
import com.msjf.finance.cas.facade.changePwd.domain.ChangePwdDomain;
import com.msjf.finance.cas.facade.changePwd.domain.EchoMobileDomain;
import com.msjf.finance.cas.facade.changePwd.domain.RequestChangePwdDomain;
import com.msjf.finance.cas.modules.changePwd.Service.ChangePwdService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service("changePwdFacade")
public class ChangePwdFacadeImpl implements ChangePwdFacade {
    @Resource
    ChangePwdService changePwdService;
    @Override
    public Response<ChangePwdDomain> changePwd(RequestChangePwdDomain requestChangePwdDomain) {
        try {
            return changePwdService.changePwd(requestChangePwdDomain);
        }catch (Exception e){
            return new Response<>().fail();
        }
    }

    @Override
    public Response<EchoMobileDomain> echoMobile(String certificateno) {
        try {
            return changePwdService.echoMobile(certificateno);
        }catch (Exception e){
            return new Response<>().fail();
        }
    }
}
