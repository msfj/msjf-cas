package com.msjf.finance.cas.modules.organRollin.dao;

import com.msjf.finance.cas.common.dao.MyBatisDao;
import com.msjf.finance.cas.modules.organRollin.entity.OrganRollinEntity;

import java.util.List;

/**
 * Created by 11509 on 2018/12/18.
 */
@MyBatisDao
public interface OrganRollinDao {
    /**
     *查询企业迁入基本信息
     */
    List<OrganRollinEntity> getOrganRollin(OrganRollinEntity organRollinEntity);
}
