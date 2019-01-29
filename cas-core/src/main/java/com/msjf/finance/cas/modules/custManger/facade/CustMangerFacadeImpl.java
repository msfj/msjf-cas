package com.msjf.finance.cas.modules.custManger.facade;

import com.msjf.finance.cas.facade.custManger.CustMangerFacade;
import com.msjf.finance.cas.facade.custManger.domain.CustMangerDomain;
import com.msjf.finance.cas.modules.custManger.service.CustMangerService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("custMangerFacade")
@Transactional
public class CustMangerFacadeImpl implements CustMangerFacade {

    @Resource
    CustMangerService mangerService;

    @Override
    public Response insCust(CustMangerDomain custEntity) throws RuntimeException {
        return mangerService.insCust(custEntity);
    }

    @Override
    public Response delCust(CustMangerDomain custEntity) throws RuntimeException {
        return mangerService.delCust(custEntity);
    }

    @Override
    public Response updCust(CustMangerDomain custEntity) throws RuntimeException {
        return mangerService.updCust(custEntity);
    }

    @Override
    public Response queryCust(CustMangerDomain custEntity) throws RuntimeException {
        Map<String,Object> map = new HashMap<>();
        map.put("membername",custEntity.getCustname());
        map.put("mobile",custEntity.getMobile());
        map.put("certificateno",custEntity.getCertificateno());
        map.put("loginname",custEntity.getLoginname());
        map.put("email",custEntity.getEmail());
        map.put("pageNum",custEntity.getPageNum());
        map.put("pageSize",custEntity.getPageSize());
        return mangerService.queryCust(map);
    }
}
