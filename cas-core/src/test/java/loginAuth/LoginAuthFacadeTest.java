package loginAuth;

import com.msjf.finance.cas.facade.login.LoginFacade;
import com.msjf.finance.cas.facade.loginAuth.LoginAuthFacade;
import com.msjf.finance.msjf.core.response.Response;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

public class LoginAuthFacadeTest extends SpringTestCase {

       /*@Resource
   SendVerificationCodeFacade sendVerificationCodeFacade;*/
/*@Resource
    EmployeeInfoFacade employeeInfoFacade;*/
   @Resource
       LoginAuthFacade loginAuthFacade;

    @Test
    public  void  queryOrganInfoList(){
        HashMap<String, Object> mapParam = new HashMap<>();
//        mapParam.put("loginname","432343535353533");
//        mapParam.put("password","123456");
        mapParam.put("userName","432343535353533");
        mapParam.put("loginType","1");
        Response rs ;
        try{
            rs=loginAuthFacade.selectLoginInfo(mapParam);
            System.out.println(rs);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
