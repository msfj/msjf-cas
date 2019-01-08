
package organ;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.common.test.SpringTestCase;

import com.msjf.finance.cas.facade.employee.EmployeeInfoFacade;
import com.msjf.finance.cas.facade.organ.OrganInfoFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.facade.register.RegisterFacade;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;


/**
 * Created by 11509 on 2018/12/18.
 */

public class OrganInfoFacadeTest   extends SpringTestCase{
   /*@Resource
   SendVerificationCodeFacade sendVerificationCodeFacade;*/
/*@Resource
    EmployeeInfoFacade employeeInfoFacade;*/
   @Resource
    RegisterFacade registerFacade;

    @Test
    public  void  queryOrganInfoList(){
        HashMap<String, Object> mapParam = new HashMap<>();
        mapParam.put("membertype","1");
        mapParam.put("registersource","0");
       /* mapParam.put("mobile","13574768695");*/
        mapParam.put("step","3");
        mapParam.put("membername","镇魂街漫画有限公司");
        mapParam.put("certificatetype","A");
        mapParam.put("certificateno","qwwe343535353533");
        /*mapParam.put("cardno","22123314412");
        mapParam.put("bank","中国银行1");
        mapParam.put("corcardtype","0");
        mapParam.put("corcardno","324242412421");
        mapParam.put("corname","郑国1");*/
        mapParam.put("password","123456");
        Response rs = new Response();
        try{
            registerFacade.inserRegister(mapParam,rs);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
