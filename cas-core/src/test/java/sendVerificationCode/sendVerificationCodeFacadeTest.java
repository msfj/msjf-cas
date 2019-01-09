//package sendVerificationCode;
//
//import com.msjf.finance.cas.common.test.SpringTestCase;
//import com.msjf.finance.cas.facade.register.RegisterFacade;
//import com.msjf.finance.mcs.common.response.Response;
//import com.msjf.finance.mcs.facade.sms.SendVerificationCodeFacade;
//import com.msjf.finance.mcs.facade.sms.domain.VerificationCodeDomain;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//
//public class sendVerificationCodeFacadeTest extends SpringTestCase {
//    @Resource
//    SendVerificationCodeFacade sendVerificationCodeFacade;
///*@Resource
//    EmployeeInfoFacade employeeInfoFacade;*/
//
//    @Test
//    public  void  queryOrganInfoList(){
//        HashMap map= new HashMap();
//        map.put("verificateType","1");
//        map.put("templateId","2031012026749");
//        map.put("mobile","18565641675");
//        map.put("msgCode","6098");
//        Response<VerificationCodeDomain> rs=sendVerificationCodeFacade.SendRegisterVerificationCode(map);
//        System.out.println(rs);
//    }
//}
