package com.msjf.finance.cas.modules.employee.service;

import com.msjf.finance.cas.facade.employee.domain.EmployeeInfoDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.List;

public interface EmployeeLoginService {

    /**
     *员工登陆
     * @return
     */
    Response<EmployeeInfoDomain> employeeLogin(HashMap<String, Object> mapParam);
}
