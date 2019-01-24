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
    /**
     * 写企业基本信息表
     */
    void insPersonInfo(Map<String, Object> mapParams);
    /**
     * 查询实体
     */
    PersonInfoEntity selectByKey(PersonInfoKey personInfoKey);

    /**
     * 查询个人基本信息
     * @return
     */
    List queryPersonInfoList();
}