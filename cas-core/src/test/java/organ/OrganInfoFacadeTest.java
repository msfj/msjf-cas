
package organ;

import com.msjf.finance.cas.common.test.SpringTestCase;

import com.msjf.finance.cas.facade.employee.EmployeeInfoFacade;
import com.msjf.finance.cas.facade.organ.OrganInfoFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.mcs.facade.sms.SendVerificationCodeFacade;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;


/**
 * Created by 11509 on 2018/12/18.
 */

public class OrganInfoFacadeTest   extends SpringTestCase{
   @Resource
   SendVerificationCodeFacade sendVerificationCodeFacade;
/*@Resource
    EmployeeInfoFacade employeeInfoFacade;*/

    @Test
    public  void  queryOrganInfoList(){

     //   System.out.println(  employeeInfoFacade.queryEmployeeInfoList())
      try {
            Thread.sleep(3000);
          //  System.out.println("-------------queryOrganInfoList-------------" + organInfoFacade.queryOrganInfoList(new OrganInfoDomain()));
          System.out.println( "****************************:"+sendVerificationCodeFacade.SendRegisterVerificationCode(new HashMap<>()));
        }catch (Exception e){

        }
/*        while (true){

        }*/
    }
}
