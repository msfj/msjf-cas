package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.EmployeeOrganEntity;
import com.msjf.finance.cas.common.dao.key.EmployeeOrganKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface EmployeeOrganDao extends IBaseDao<EmployeeOrganEntity,EmployeeOrganKey> {
}