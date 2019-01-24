package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.OrganInfoChangeEntity;
import com.msjf.finance.cas.common.dao.key.OrganInfoChangeKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface OrganInfoChangeDao extends IBaseDao<OrganInfoChangeEntity,OrganInfoChangeKey> {
}