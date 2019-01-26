package com.msjf.finance.cas.common.joindao.persistence;

import com.msjf.finance.cas.common.dao.entity.PersonInfoEntity;
import com.msjf.finance.cas.common.dao.key.PersonInfoKey;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface PersonInfoJoinDao {
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
