package com.msjf.finance.cas.facade.organ;

import com.msjf.finance.msjf.core.response.Response;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-23 16:09
 */
public class OrganBuildApplyFacadeTest extends SpringTestCase {


    @Resource
    OrganBuildApplyFacade organBuildApplyFacade;

    @Test
    public void organBuildApply() {
    }

    @Test
    public void addApply() {
        Response rs = organBuildApplyFacade.addApply(new HashMap<>());
        System.out.println(rs);
    }
}