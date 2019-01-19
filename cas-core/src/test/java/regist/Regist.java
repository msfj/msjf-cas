package regist;

import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.facade.register.domain.RegisterDomain;
import com.msjf.finance.cas.modules.register.service.RegisterService;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;

public class Regist extends SpringTestCase {

    @Resource
    RegisterService registerService;

    @Test
    public  void  queryOrganInfoList(){
        RegisterDomain re =new RegisterDomain();
        re.setStep("1");
        re.setMobile("1357647");
        re.setMsgcode("111");
        re.setMembertype("0");
        re.setRegistersource("0");
        registerService.Register(re);
    }
}
