package com.msjf.finance.cas.modules.employee.facade;

import com.msjf.finance.cas.facade.employee.EmployeeLoginFacade;
import com.msjf.finance.cas.facade.employee.domain.EmployeeInfoDomain;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service("employeeLoginFacade")
public class EmployeeLoginFacadeImpl implements EmployeeLoginFacade {
    @Override
    public Response<EmployeeInfoDomain> employeeLogin(HashMap<String, Object> mapParam) {
        return null;
    }
}
