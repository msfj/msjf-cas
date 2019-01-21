package com.msjf.finance.cas.modules.person.dao;

import com.msjf.finance.cas.modules.person.entity.PersonInfoEntity;
import com.msjf.finance.cas.modules.person.entity.PersonInfoKey;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * Created by lzp on 2018/12/26.
 */
@MyBatisDao
public interface PersonInfoDao {
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
