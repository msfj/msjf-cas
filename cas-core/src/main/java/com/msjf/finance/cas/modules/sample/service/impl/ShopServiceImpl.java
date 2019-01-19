package com.msjf.finance.cas.modules.sample.service.impl;

import com.msjf.finance.cas.modules.sample.service.ShopService;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 描述:
 *    测试用例
 *  <pre/>
 * @author 95494
 * @create 2019-01-15 17:11
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Override
    public String say(String str) {
        return "服务调用成功:" + str;
    }
}
