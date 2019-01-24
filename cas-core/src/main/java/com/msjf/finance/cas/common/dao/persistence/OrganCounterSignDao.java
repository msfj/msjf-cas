package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.OrganCounterSignEntity;
import com.msjf.finance.cas.common.dao.key.OrganCounterSignKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface OrganCounterSignDao extends IBaseDao<OrganCounterSignEntity,OrganCounterSignKey> {
}