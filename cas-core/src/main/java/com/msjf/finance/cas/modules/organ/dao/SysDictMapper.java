package com.msjf.finance.cas.modules.organ.dao;

import com.msjf.finance.cas.modules.organ.entity.SysDictEntity;
import com.msjf.finance.cas.modules.organ.entity.SysDictKey;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

@MyBatisDao
public interface SysDictMapper {
    int deleteByPrimaryKey(SysDictKey key);

    int insert(SysDictEntity record);

    int insertSelective(SysDictEntity record);

    SysDictEntity selectByPrimaryKey(SysDictKey key);

    int updateByPrimaryKeySelective(SysDictEntity record);

    int updateByPrimaryKey(SysDictEntity record);
}