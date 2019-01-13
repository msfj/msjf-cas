package changePwd;


import com.msjf.finance.cas.facade.changePwd.ChangePwdFacade;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

public class ChangePwdFacadeTest extends SpringTestCase {
        @Resource
        ChangePwdFacade changePwdFacade;
/*@Resource
    EmployeeInfoFacade employeeInfoFacade;*/

    @Test
    public  void  queryOrganInfoList(){

        //   System.out.println(  employeeInfoFacade.queryEmployeeInfoList())
        try {
            Thread.sleep(3000);
            //  System.out.println("-------------queryOrganInfoList-------------" + organInfoFacade.queryOrganInfoList(new OrganInfoDomain()));
            System.out.println( "****************************:"+changePwdFacade.changePwd(new HashMap<>()));
        }catch (Exception e){

        }
/*        while (true){

        }*/
    }
}
