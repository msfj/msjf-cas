package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.OrganGrantEntity;
import com.msjf.finance.cas.common.dao.key.OrganGrantKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface OrganGrantDao extends IBaseDao<OrganGrantEntity,OrganGrantKey> {
}