package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.modules.employee.dao.EmployeeInfoDao;
import com.msjf.finance.cas.modules.employee.entity.EmployeeInfoEntity;
import com.msjf.finance.cas.modules.employee.service.EmployeeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lzp on 2018/12/22.
 */
@Service("employeeInfoService")
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    @Resource
    EmployeeInfoDao employeeInfoDao;
    @Override
    public List queryEmployeeInfoList() {
        try{
           List<EmployeeInfoEntity> employeeInfoList = employeeInfoDao.getEmployeeInfoList();
            return employeeInfoList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
