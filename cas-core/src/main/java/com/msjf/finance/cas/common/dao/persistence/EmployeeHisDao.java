package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.EmployeeHisEntity;
import com.msjf.finance.cas.common.dao.key.EmployeeHisKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface EmployeeHisDao extends IBaseDao<EmployeeHisEntity,EmployeeHisKey> {
}