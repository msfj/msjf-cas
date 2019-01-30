package com.msjf.finance.cas.facade.organ;

import com.alibaba.fastjson.JSONObject;
import com.msjf.finance.cas.modules.organ.facade.OrganServiceFacadeImpl;
import com.msjf.finance.msjf.core.response.Response;
import common.SpringTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-23 16:09
 */
public class OrganServiceFacadeTest extends SpringTestCase {

    private static final Logger logger = LogManager.getLogger(OrganServiceFacadeTest.class);


    @Resource
    OrganServiceFacade organBuildApplyFacade;


    @Test
    public void addApplyFirst() {

        HashMap parmap = new HashMap();
        //home data parmap.put("orgcustomerno", "154848745158416");
        //work data
        parmap.put("orgcustomerno", "154881631818808");
        parmap.put("customerno", "20e82fa7095f4eeaa21155de44a13fa6");
        parmap.put("membername","测试用在");
        parmap.put("organtype","1");
        parmap.put("organclass","1");
        Response rs = organBuildApplyFacade.setAddApplyFirst(parmap);
        System.out.println(rs);
        Map map = (Map) rs.getData();
        logger.info(map);
        logger.info(JSONObject.toJSONString(map));
    }

    @Test
    public void addApplySecond() {
        //入参
        HashMap parmap = new HashMap();
        parmap.put("orgcustomerno", "154881631818808");
        parmap.put("customerno", "20e82fa7095f4eeaa21155de44a13fa6");
        parmap.put("dockingpeople", "111111");
        parmap.put("dealflow", "0");
        parmap.put("managelimit", "30");
        parmap.put("paydatelimit", "30");
        parmap.put("regicapitalbz", "50");
        parmap.put("realprovince", "1");
        parmap.put("realcity", "35");
        parmap.put("realcounty", "380");
        parmap.put("realtreet", "xxx街道");
        parmap.put("businessscope", "经营范围/主营业务");
        parmap.put("organPhone", "00000000");
        parmap.put("organEmail", "1522@qq.com");

        Response rs = organBuildApplyFacade.setAddApplySecond(parmap);
        logger.debug(rs);
    }


    @Test
    public void setAddApplyThirdly() {
        //入参
        HashMap parmap = new HashMap();
        parmap.put("orgcustomerno", "154881631818808");
        parmap.put("customerno", "20e82fa7095f4eeaa21155de44a13fa6");
        parmap.put("partnertype", "20e82fa7095f4eeaa21155de44a13fa6");


        logger.debug("添加拟设立-第三步服务调用入参",parmap);
        Response rs = organBuildApplyFacade.setAddApplyThirdly(parmap);
        logger.debug("添加拟设立-第三步服务调用结果",rs);
    }
}