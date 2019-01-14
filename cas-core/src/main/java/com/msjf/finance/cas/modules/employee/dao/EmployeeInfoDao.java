package com.msjf.finance.cas.modules.employee.dao;

import com.msjf.finance.cas.modules.employee.entity.EmployeeInfoEntity;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;

/**
 * Created by lzp on 2018/12/22.
 */
@MyBatisDao
public interface EmployeeInfoDao {
    List<EmployeeInfoEntity> getEmployeeInfoList();
}
