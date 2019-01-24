package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.ApplyEntity;
import com.msjf.finance.cas.common.dao.key.ApplyKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface ApplyDao extends IBaseDao<ApplyEntity,ApplyKey> {
}