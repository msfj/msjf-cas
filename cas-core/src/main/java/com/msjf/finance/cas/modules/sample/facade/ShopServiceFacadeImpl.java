package com.msjf.finance.cas.modules.sample.facade;

import com.msjf.finance.cas.facade.sample.ShopApi;
import com.msjf.finance.cas.modules.sample.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 描述:
 *    示例代码
 *  <pre/>
 * @author 95494
 * @create 2019-01-15 17:24
 */
@Service
public class ShopServiceFacadeImpl implements ShopApi {


    @Autowired
    ShopService shopService;

    /**
     * 示例代码-方法
     *
     * @param str
     * @return
     */
    @Override
    public String say(String str) {
        System.out.println("-----dubbo服务测试方法-----调用dubbo服务测试-----");
        System.out.println("-----dubbo服务测试方法-----调用dubbo服务测试-----");
        System.out.println("-----dubbo服务测试方法-----调用dubbo服务测试-----");
        System.out.println("-----dubbo服务测试方法-----调用dubbo服务测试-----");
        return shopService.say("consumer 请求服务");
    }
}
