package com.msjf.finance.cas.common.joindao.persistence;

import com.msjf.finance.cas.common.dao.entity.EmployeeEntity;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface EmployeeJoinDao {
    List<EmployeeEntity> selectByMap(Map<String,Object> map);
}
