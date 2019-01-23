package com.msjf.finance.cas.modules.organ.facade;

import com.msjf.finance.cas.facade.organ.OrganBuildApplyFacade;
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
 * @create 2019-01-22 15:02
 */
public class OrganBuildApplyFacadeImplTest extends SpringTestCase {

    @Resource
    OrganBuildApplyFacade organBuildApplyFacade;


    @Test
    public void organBuildApply() {
        organBuildApplyFacade.organBuildApply(new HashMap<>());
    }


}