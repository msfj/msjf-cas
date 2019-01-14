package com.msjf.finance.cas.modules.changePwd.facade;
import com.msjf.finance.cas.facade.changePwd.ChangePwdFacade;
import com.msjf.finance.cas.facade.changePwd.domain.ChangePwdDomain;
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
        Response rs=null;
        try {
            rs=changePwdService.changePwd(requestChangePwdDomain);
        }catch (Exception e){
            rs.fail();
            throw new RuntimeException(e.getMessage(),e);
        }
        return rs;
    }

    @Override
    public Response<Map> echoMobile(HashMap<String, Object> mapParam) {
        return null;
    }
}
