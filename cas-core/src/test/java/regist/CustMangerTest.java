package regist;

import com.msjf.finance.cas.facade.custManger.CustMangerFacade;
import com.msjf.finance.cas.facade.custManger.domain.CustMangerDomain;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;

public class CustMangerTest extends SpringTestCase {

    @Resource
    CustMangerFacade custMangerFacade;

    @Test
    public  void  queryOrganInfoList(){
        CustMangerDomain custMangerDomain = new CustMangerDomain();
        /*custMangerDomain.setCertificateno("431121199707238373");
        custMangerDomain.setCertificatetype("0");
        custMangerDomain.setMembertype("0");
        custMangerDomain.setEmail("12235@qq.com");
        custMangerDomain.setMobile("15802595306");
        custMangerDomain.setCustname("128测试");
        custMangerDomain.setMembertype("0");
        custMangerDomain.setCustno("f7764a43f0514abc83395698533b770e");*/
        custMangerDomain.setPageNum(1);
        custMangerDomain.setPageSize(10);
        custMangerDomain.setCustname("王");
        custMangerFacade.queryCust(custMangerDomain);
    }
}
