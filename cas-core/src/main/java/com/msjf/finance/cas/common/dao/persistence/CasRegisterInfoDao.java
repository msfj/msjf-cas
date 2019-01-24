package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.CasRegisterInfoEntity;
import com.msjf.finance.cas.common.dao.key.CasRegisterInfoKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @author 
 */
@MyBatisDao
public interface CasRegisterInfoDao extends IBaseDao<CasRegisterInfoEntity,CasRegisterInfoKey> {
    /**
     * 新增用户
     */
    void insCasRegister(Map<String, Object> mapParams);

    /**
     * 用户注册基本信息表按实体查询
     */
    List<Map> queryCasRegisterList(Map<String, Object> mapParams);


    /**
     * 修改用户
     */
    void updCasRegister(Map<String, Object> mapParams);
}