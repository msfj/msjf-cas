package com.msjf.finance.cas.modules.employee.dao;

import com.msjf.finance.cas.modules.employee.entity.EmployeeEntity;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;

@MyBatisDao
public interface EmployeeMapper {
    int deleteByPrimaryKey(String customerno);

    int insert(EmployeeEntity record);

    int insertSelective(EmployeeEntity record);

    EmployeeEntity selectByPrimaryKey(String customerno);

    int updateByPrimaryKeySelective(EmployeeEntity record);

    int updateByPrimaryKey(EmployeeEntity record);

    List<EmployeeEntity> selectByEntity(EmployeeEntity record);
}