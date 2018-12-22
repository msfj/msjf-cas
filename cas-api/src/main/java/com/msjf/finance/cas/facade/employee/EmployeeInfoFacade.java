package com.msjf.finance.cas.facade.employee;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.employee.domain.EmployeeInfoDomain;

import java.util.List;

/**
 * Created by 95494 on 2018/12/22.
 */
public interface EmployeeInfoFacade {
    public Response<List<EmployeeInfoDomain>>  queryEmployeeInfoList();
}
