package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.EmployeeEntity;
import com.msjf.finance.cas.common.dao.key.EmployeeKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;

/**
 * @author 
 */
@MyBatisDao
public interface EmployeeDao extends IBaseDao<EmployeeEntity,EmployeeKey> {
}