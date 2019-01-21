package com.msjf.finance.cas.modules.sample.facade;

import com.msjf.finance.cas.modules.sample.service.ShopService;
import common.SpringTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-21 19:17
 */
public class ShopServiceFacadeImplTest extends SpringTestCase {

    @Autowired
    ShopService shopService;

    @Test
    public void say() {
        shopService.say("sd");
    }
}