package com.msjf.finance.cas.modules.employee.service;

import com.msjf.finance.cas.common.dao.entity.EmployeeEntity;
import com.msjf.finance.cas.common.dao.key.EmployeeKey;
import com.msjf.finance.msjf.core.response.Response;

import java.util.Map;

/**
 * Created by cheng on 2019/1/25.
 */
public interface EmployeeMangerService {

    Response insEmployee(EmployeeEntity employeeEntity) throws RuntimeException;

    Response delEmployee(EmployeeKey key)throws RuntimeException;

    Response updEmployee(EmployeeEntity employeeEntity)throws RuntimeException;

    Response updEmployeeState(EmployeeEntity employeeEntity)throws RuntimeException;

    Response updpasCount(Map<String,Object> map)throws RuntimeException;

    Response queryEmployee(Map<String,Object> map)throws RuntimeException;
}
