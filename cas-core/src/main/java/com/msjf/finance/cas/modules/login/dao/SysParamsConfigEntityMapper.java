package com.msjf.finance.cas.modules.login.dao;


import com.msjf.finance.cas.modules.login.entity.SysParamsConfigEntity;
import com.msjf.finance.cas.modules.login.entity.SysParamsConfigEntityKey;
import com.msjf.finance.msjf.core.dao.MyBatisDao;


@MyBatisDao
public interface SysParamsConfigEntityMapper {
    int deleteByPrimaryKey(SysParamsConfigEntityKey key);

    int insert(SysParamsConfigEntity record);

    int insertSelective(SysParamsConfigEntity record);

    SysParamsConfigEntity selectByPrimaryKey(SysParamsConfigEntityKey key);

    int updateByPrimaryKeySelective(SysParamsConfigEntity record);

    int updateByPrimaryKey(SysParamsConfigEntity record);
}