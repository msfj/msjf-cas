package com.msjf.finance.cas.modules.changePwd.facade;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.changePwd.ChangePwdFacade;
import com.msjf.finance.cas.modules.changePwd.Service.ChangePwdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service("changePwdFacade")
public class ChangePwdFacadeImpl implements ChangePwdFacade {
    @Resource
    ChangePwdService changePwdService;
    @Override
    public Response<Map> changePwd(HashMap<String, Object> mapParam) {
        Response rs=null;
        try {
            rs=changePwdService.changePwd(mapParam);
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
