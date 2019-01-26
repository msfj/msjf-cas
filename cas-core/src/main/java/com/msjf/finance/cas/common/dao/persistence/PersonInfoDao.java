package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.PersonInfoEntity;
import com.msjf.finance.cas.common.dao.key.PersonInfoKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @author 
 */
@MyBatisDao
public interface PersonInfoDao extends IBaseDao<PersonInfoEntity,PersonInfoKey> {

}