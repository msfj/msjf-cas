package com.msjf.finance.cas.common.dao;

import com.msjf.finance.msjf.core.dao.MyBatisDao;

@MyBatisDao
public interface SysCertificationConfigDao{
    int deleteByPrimaryKey(String messagecode);

    int insert(SysCertificationConfigEntity record);

    int insertSelective(SysCertificationConfigEntity record);

    SysCertificationConfigEntity selectByPrimaryKey(String messagecode);

    int updateByPrimaryKeySelective(SysCertificationConfigEntity record);

    int updateByPrimaryKey(SysCertificationConfigEntity record);
}