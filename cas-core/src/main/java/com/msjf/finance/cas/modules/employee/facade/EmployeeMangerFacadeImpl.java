package com.msjf.finance.cas.modules.employee.facade;

import com.msjf.finance.cas.common.dao.entity.EmployeeEntity;
import com.msjf.finance.cas.common.dao.key.EmployeeKey;
import com.msjf.finance.cas.facade.employee.EmployeeMangerFacade;
import com.msjf.finance.cas.facade.employee.domain.EmployeeDomain;
import com.msjf.finance.cas.modules.employee.service.EmployeeMangerService;
import com.msjf.finance.cas.modules.organ.facade.OrganInfoFacadeImpl;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(OrganInfoFacadeImpl.class);

    @Resource
    EmployeeMangerService employeeMangerService;

    @Override
    public Response insEmployee(EmployeeDomain employeeDomain) throws RuntimeException {
        logger.info("开始查询机构信息 organInfoDomain={}", employeeDomain);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDomain, employeeEntity);
        logger.info("开始查询机构信息 employeeEntity={}", employeeEntity);
        return employeeMangerService.insEmployee(employeeEntity);
    }

    @Override
    public Response delEmployee(EmployeeDomain employeeDomain) throws RuntimeException {
        logger.info("开始查询机构信息 organInfoDomain={}", employeeDomain);
        EmployeeKey key = new EmployeeKey();
        key.setKey(employeeDomain.getCustno());
        logger.info("开始查询机构信息 EmployeeKey={}", key);
        return employeeMangerService.delEmployee(key);
    }

    @Override
    public Response updEmployee(EmployeeDomain employeeDomain) throws RuntimeException {
        logger.info("开始查询机构信息 organInfoDomain={}", employeeDomain);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDomain, employeeEntity);
        employeeEntity.setCustomerno(employeeDomain.getCustno());
        logger.info("开始查询信息 employeeEntity={}", employeeEntity);
        return employeeMangerService.updEmployee(employeeEntity);
    }

    @Override
    public Response updEmployeeState(EmployeeDomain employeeDomain) throws RuntimeException {
        logger.info("开始查询机构信息 organInfoDomain={}", employeeDomain);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDomain, employeeEntity);
        employeeEntity.setCustomerno(employeeDomain.getCustno());
        logger.info("开始查询信息 employeeEntity={}", employeeEntity);
        return employeeMangerService.updEmployeeState(employeeEntity);
    }

    @Override
    public Response updpasCount(EmployeeDomain employeeDomain) throws RuntimeException {
        logger.info("开始查询机构信息 organInfoDomain={}", employeeDomain);
        Map<String,Object> map = new HashMap();
        map.put("customerno",employeeDomain.getCustno());
        logger.info("开始查询信息 map={}", map);
        return employeeMangerService.updpasCount(map);
    }

    @Override
    public Response queryEmployee(EmployeeDomain employeeDomain) throws RuntimeException {
        logger.info("开始查询机构信息 organInfoDomain={}", employeeDomain);
        Map<String,Object> map = new HashMap();
        map.put("employeename",employeeDomain.getEmployeename());
        map.put("mobile",employeeDomain.getMobile());
        map.put("certificateno",employeeDomain.getCertificateno());
        map.put("loginname",employeeDomain.getLoginname());
        map.put("email",employeeDomain.getEmail());
        map.put("pageNum",employeeDomain.getPageNum());
        map.put("pageSize",employeeDomain.getPageSize());
        map.put("branchid",employeeDomain.getBranchid());
        logger.info("开始查询信息 map={}", map);
        return employeeMangerService.queryEmployee(map);
    }
}
