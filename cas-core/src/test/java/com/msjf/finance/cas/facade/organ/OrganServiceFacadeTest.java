package com.msjf.finance.cas.facade.organ;

import com.msjf.finance.msjf.core.response.Response;
import common.SpringTestCase;
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


    @Resource
    OrganServiceFacade organBuildApplyFacade;

    @Test
    public void addApplyFirst() {

        HashMap parmap = new HashMap();
        parmap.put("customerno", "20e82fa7095f4eeaa21155de44a13fa6");
        parmap.put("membername","测试用在");
        parmap.put("organtype","1");
        parmap.put("organclass","1");
        Response rs = organBuildApplyFacade.addApplyFirst(parmap);
        System.out.println(rs);
    }

    @Test
    public void addApplySecond() {
        Response rs = organBuildApplyFacade.addApplySecond(new HashMap<>());
        System.out.println(rs);
    }
}