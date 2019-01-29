package com.msjf.finance.cas.facade.custManger;

import com.msjf.finance.cas.facade.custManger.domain.CustMangerDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.Map;

public interface CustMangerFacade {
    Response insCust(CustMangerDomain custEntity) throws RuntimeException;

    Response delCust(CustMangerDomain custEntity)throws RuntimeException;

    Response updCust(CustMangerDomain custEntity)throws RuntimeException;

    Response queryCust(CustMangerDomain custEntity)throws RuntimeException;
}
