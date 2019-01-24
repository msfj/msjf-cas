package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.SysParamsConfigEntity;
import com.msjf.finance.cas.common.dao.key.SysParamsConfigKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface SysParamsConfigDao extends IBaseDao<SysParamsConfigEntity,SysParamsConfigKey> {
}