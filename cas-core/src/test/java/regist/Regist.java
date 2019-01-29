package regist;

import com.msjf.finance.cas.facade.branch.BranchFacade;
import com.msjf.finance.cas.facade.branch.domain.BranchDomain;
import com.msjf.finance.cas.facade.employee.EmployeeMangerFacade;
import com.msjf.finance.cas.facade.employee.domain.EmployeeDomain;
import com.msjf.finance.cas.facade.login.LoginFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.facade.register.RegisterFacade;
import com.msjf.finance.cas.facade.register.domain.RegisterDomain;
import com.msjf.finance.cas.modules.register.service.RegisterService;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

public class Regist extends SpringTestCase {

    @Resource
    BranchFacade branchFacade;

    @Resource
    RegisterFacade registerFacade;

    @Resource
    EmployeeMangerFacade mangerFacade;

    @Test
    public  void  queryOrganInfoList() throws Exception {
       RegisterDomain registerDomain =new RegisterDomain();
       registerDomain.setStep("1");
       registerDomain.setMobile("17190308842");
       registerDomain.setRegistersource("0");
        registerDomain.setMembertype("0");
        registerDomain.setMsgcode("111");
        registerFacade.inserRegister(registerDomain);
    }
}
