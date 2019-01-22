package com.msjf.finance.cas.modules.organ.dao;

import com.msjf.finance.cas.modules.organ.entity.OrganRollinEntity;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;

/**
 * 企业迁入基本信息表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:20:45
 */
@MyBatisDao
public interface OrganRollinDao {
    /**
     *查询企业迁入基本信息
     */
    List<OrganRollinEntity> getOrganRollin(OrganRollinEntity organRollinEntity);

}
