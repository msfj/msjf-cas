package regist;

import com.msjf.finance.cas.facade.branch.BranchFacade;
import com.msjf.finance.cas.facade.branch.domain.BranchDomain;
import com.msjf.finance.cas.facade.login.LoginFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.facade.register.domain.RegisterDomain;
import com.msjf.finance.cas.modules.register.service.RegisterService;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

public class Regist extends SpringTestCase {

    @Resource
    BranchFacade branchFacade;

    @Test
    public  void  queryOrganInfoList(){
        BranchDomain branchDomain = new BranchDomain();
        branchFacade.queryBranch(branchDomain);
    }
}
