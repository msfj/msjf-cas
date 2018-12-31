package com.msjf.finance.cas.modules.person.dao;

import com.msjf.finance.cas.common.dao.MyBatisDao;
import com.msjf.finance.cas.modules.person.entity.PersonInfoEntity;

/**
 * Created by lzp on 2018/12/26.
 */
@MyBatisDao
public interface PersonInfoDao {
    /**
     * 写企业基本信息表
     */
    void insPersonInfo(PersonInfoEntity personInfoEntity);
}
