
package organ;

import com.msjf.finance.cas.common.test.SpringTestCase;

import com.msjf.finance.cas.facade.employee.EmployeeInfoFacade;
import com.msjf.finance.cas.facade.organ.OrganInfoFacade;
import org.junit.Test;

import javax.annotation.Resource;


/**
 * Created by 11509 on 2018/12/18.
 */

public class OrganInfoFacadeTest   extends SpringTestCase{
/*    @Resource
    OrganInfoFacade organInfoFacade;*/
@Resource
    EmployeeInfoFacade employeeInfoFacade;

    @Test
    public  void  queryOrganInfoList(){
        System.out.println(  employeeInfoFacade.queryEmployeeInfoList());
     //   System.out.println("--------------------------"+organInfoFacade.queryOrganInfoList());
        while (true){

        }
    }
}
