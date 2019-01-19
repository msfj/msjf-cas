package com.msjf.finance.cas.facade.employee;
import com.msjf.finance.cas.facade.employee.domain.EmployeeInfoDomain;
import com.msjf.finance.msjf.core.response.Response;
import java.util.List;


public interface EmployeeInfoFacade {
    /**
     *
     * @return
     */
    public Response<List<EmployeeInfoDomain>> queryEmployeeInfoList();

}
