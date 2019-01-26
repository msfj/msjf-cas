package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.key.CustKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @author 
 */
@MyBatisDao
public interface CustDao extends IBaseDao<CustEntity,CustKey> {

}