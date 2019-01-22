package com.msjf.finance.cas.modules.organ.dao;

import com.msjf.finance.cas.modules.organ.entity.OrganAppendEntity;
import com.msjf.finance.cas.modules.organ.entity.OrganAppendEntityWithBLOBs;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

/**
 * 企业附属信息表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:20:44
 */
@MyBatisDao
public interface OrganAppendDao {
    int deleteByPrimaryKey(String customerno);

    int insert(OrganAppendEntityWithBLOBs record);

    int insertSelective(OrganAppendEntityWithBLOBs record);

    OrganAppendEntityWithBLOBs selectByPrimaryKey(String customerno);

    int updateByPrimaryKeySelective(OrganAppendEntityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrganAppendEntityWithBLOBs record);

    int updateByPrimaryKey(OrganAppendEntity record);


}
