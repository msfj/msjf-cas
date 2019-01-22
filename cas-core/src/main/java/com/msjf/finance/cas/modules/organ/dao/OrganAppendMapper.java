package com.msjf.finance.cas.modules.organ.dao;

import com.msjf.finance.cas.modules.organ.entity.OrganAppendEntity;
import com.msjf.finance.cas.modules.organ.entity.OrganAppendEntityWithBLOBs;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

@MyBatisDao
public interface OrganAppendMapper {
    int deleteByPrimaryKey(String customerno);

    int insert(OrganAppendEntityWithBLOBs record);

    int insertSelective(OrganAppendEntityWithBLOBs record);

    OrganAppendEntityWithBLOBs selectByPrimaryKey(String customerno);

    int updateByPrimaryKeySelective(OrganAppendEntityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrganAppendEntityWithBLOBs record);

    int updateByPrimaryKey(OrganAppendEntity record);
}