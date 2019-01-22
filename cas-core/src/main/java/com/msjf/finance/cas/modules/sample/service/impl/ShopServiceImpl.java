package com.msjf.finance.cas.modules.sample.service.impl;

import com.msjf.finance.cas.modules.organ.dao.OrganInfoDao;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoEntity;
import com.msjf.finance.cas.modules.sample.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    OrganInfoDao organInfoDao;

    @Override
    public String say(String str) {

        List<OrganInfoEntity> organInfoEntity = organInfoDao.getOrganInfo(new OrganInfoEntity());
        System.out.println("organInfoEntity="+organInfoEntity);

        return "服务调用成功:" + str;
    }
}
