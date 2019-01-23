package com.msjf.finance.cas.facade.organ;

import com.msjf.finance.cas.modules.util.SpringContextUtil;
import common.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.HashMap;

import static org.junit.Assert.*;

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
        organBuildApplyFacade.addApply(new HashMap<>());
    }
}