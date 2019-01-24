package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.SysDictEntity;
import com.msjf.finance.cas.common.dao.key.SysDictKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface SysDictDao extends IBaseDao<SysDictEntity,SysDictKey> {
}