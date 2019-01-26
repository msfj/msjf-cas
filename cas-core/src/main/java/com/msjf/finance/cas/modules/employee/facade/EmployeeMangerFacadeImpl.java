package com.msjf.finance.cas.modules.employee.facade;

import com.msjf.finance.cas.common.dao.entity.EmployeeEntity;
import com.msjf.finance.cas.common.dao.key.EmployeeKey;
import com.msjf.finance.cas.facade.employee.EmployeeMangerFacade;
import com.msjf.finance.cas.facade.employee.domain.EmployeeDomain;
import com.msjf.finance.cas.modules.employee.service.EmployeeMangerService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 2019/1/25.
 */
@Service("employeeMangerFacade")
public class EmployeeMangerFacadeImpl implements EmployeeMangerFacade{

    @Resource
    EmployeeMangerService employeeMangerService;

    @Override
    public Response insEmployee(EmployeeDomain employeeDomain) throws RuntimeException {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDomain, employeeEntity);
        return employeeMangerService.insEmployee(employeeEntity);
    }

    @Override
    public Response delEmployee(EmployeeDomain employeeDomain) throws RuntimeException {
        EmployeeKey key = new EmployeeKey();
        BeanUtils.copyProperties(employeeDomain, key);
        return employeeMangerService.delEmployee(key);
    }

    @Override
    public Response updEmployee(EmployeeDomain employeeDomain) throws RuntimeException {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDomain, employeeEntity);
        return employeeMangerService.updEmployee(employeeEntity);
    }

    @Override
    public Response updEmployeeState(EmployeeDomain employeeDomain) throws RuntimeException {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDomain, employeeEntity);
        return employeeMangerService.updEmployeeState(employeeEntity);
    }

    @Override
    public Response updpasCount(EmployeeDomain employeeDomain) throws RuntimeException {
        Map<String,Object> map = new HashMap();
        map.put("customerno",employeeDomain.getCustomerno());
        return employeeMangerService.updpasCount(map);
    }

    @Override
    public Response queryEmployee(EmployeeDomain employeeDomain) throws RuntimeException {
        Map<String,Object> map = new HashMap();
        map.put("customerno",employeeDomain.getCustomerno());
        map.put("employeename",employeeDomain.getEmployeename());
        map.put("mobile",employeeDomain.getMobile());
        map.put("certificateno",employeeDomain.getCertificateno());
        map.put("loginname",employeeDomain.getLoginname());
        map.put("email",employeeDomain.getEmail());
        map.put("pageNum",employeeDomain.getPageNum());
        map.put("pageSize",employeeDomain.getPageSize());
        return employeeMangerService.queryEmployee(map);
    }
}
