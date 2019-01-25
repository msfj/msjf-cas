package employeeLogin;

import com.msjf.finance.cas.facade.employee.EmployeeLoginFacade;
import com.msjf.finance.cas.facade.imagevalidcode.ImageValidcodeFacade;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by kanglong on 2019/1/22.
 */
public class EmployeeLoginFacadeTest extends SpringTestCase {
    @Resource
    EmployeeLoginFacade employeeLoginFacade;
/*@Resource
    EmployeeInfoFacade employeeInfoFacade;*/

    @Test
    public  void  queryOrganInfoList(){

        //   System.out.println(  employeeInfoFacade.queryEmployeeInfoList())
        try {
            HashMap map=new HashMap();
            map.put("loginName","admin");
            map.put("password","q111111");
            map.put("loginSource","1");
            //  System.out.println("-------------queryOrganInfoList-------------" + organInfoFacade.queryOrganInfoList(new OrganInfoDomain()));
            System.out.println( "****************************:"+employeeLoginFacade.employeeLogin(map));
        }catch (Exception e){

        }
/*        while (true){

        }*/
    }
}