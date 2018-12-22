package com.msjf.finance.cas.modules.employee.dao;

import com.msjf.finance.cas.common.dao.MyBatisDao;
import com.msjf.finance.cas.modules.employee.entity.EmployeeInfoEntity;

import java.util.List;

/**
 * Created by lzp on 2018/12/22.
 */
@MyBatisDao
public interface EmployeeInfoDao {
    List<EmployeeInfoEntity> getEmployeeInfoList();
}
