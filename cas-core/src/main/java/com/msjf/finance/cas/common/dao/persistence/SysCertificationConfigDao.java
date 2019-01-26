package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.RoleEntity;
import com.msjf.finance.cas.common.dao.entity.SysCertificationConfigEntity;
import com.msjf.finance.cas.common.dao.key.RoleKey;
import com.msjf.finance.cas.common.dao.key.SysCertificationConfigKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface SysCertificationConfigDao extends IBaseDao<SysCertificationConfigEntity, SysCertificationConfigKey>{
}