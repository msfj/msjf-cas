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
    public  void  queryOrganInfoList(){
        EmployeeDomain e = new EmployeeDomain();
        /*e.setBranchid("ab1e12c6bb064890bf2e1e92ea2bfd98");
        e.setCertificateno("12313223212");
        e.setEmail("123@qq.com");
        e.setEmployeename("ces1233");
        e.setLoginname("21232");
        e.setMobile("12331242142");
        e.setCustomerno("3a24b82c202b4860a80d61237842f8db");*/
        e.setPageNum(1);
        e.setPageSize(1);
        mangerFacade.queryEmployee(e);
    }
}
