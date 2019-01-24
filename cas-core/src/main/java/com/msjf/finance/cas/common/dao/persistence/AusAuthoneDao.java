package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.AusAuthoneEntity;
import com.msjf.finance.cas.common.dao.key.AusAuthoneKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.Map;

/**
 * @author 
 */
@MyBatisDao
public interface AusAuthoneDao extends IBaseDao<AusAuthoneEntity,AusAuthoneKey> {

    /**
     * 写登陆认证表
     */
    void inrAusAuthone(Map<String, Object> mapParams);

    AusAuthoneEntity getAusAuthoneByKeyLock(AusAuthoneKey ausAuthoneKey);

    void update(AusAuthoneEntity ausAuthoneEntity);
}