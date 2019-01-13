package com.msjf.finance.cas.modules.ausAuthone.dao;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneEntity;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneKey;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
import java.util.Map;

/**
 * Created by lzp on 2018/12/28.
 */
@MyBatisDao
public interface AusAuthoneDao {
    /**
     * 写登陆认证表
     */
    void inrAusAuthone(Map<String, Object> mapParams);

    AusAuthoneEntity getAusAuthoneByKeyLock(AusAuthoneKey ausAuthoneKey);

    void update(AusAuthoneEntity ausAuthoneEntity);
}
