package com.msjf.finance.cas.facade.employee;

import com.msjf.finance.cas.facade.employee.domain.EmployeeDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.Map;

/**
 * Created by cheng on 2019/1/25.
 */
public interface EmployeeMangerFacade {

    Response insEmployee(EmployeeDomain employeeDomain) throws RuntimeException;

    Response delEmployee(EmployeeDomain employeeDomain)throws RuntimeException;

    Response updEmployee(EmployeeDomain employeeDomain)throws RuntimeException;

    Response updEmployeeState(EmployeeDomain employeeDomain)throws RuntimeException;

    Response updpasCount(EmployeeDomain employeeDomain)throws RuntimeException;

    Response queryEmployee(EmployeeDomain employeeDomain)throws RuntimeException;
}
