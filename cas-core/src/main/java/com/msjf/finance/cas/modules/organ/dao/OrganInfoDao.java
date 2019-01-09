package com.msjf.finance.cas.modules.organ.dao;
import com.msjf.finance.cas.common.dao.MyBatisDao;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoEntity;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoKey;

import java.util.List;
import java.util.Map;

/**
 * Created by 11509 on 2018/12/18.
 */
@MyBatisDao
public interface OrganInfoDao{
    List<OrganInfoEntity> queryOrganInfoList();

    /**
     * 查询企业基本信息
     */
    List<OrganInfoEntity> getOrganInfo(OrganInfoEntity organInfoEntity);

    /**
     * 查询企业基本信息
     */
    OrganInfoEntity getOrganInfoByKey(OrganInfoKey organInfoKey);
    /**
     * 写企业基本信息表
     */
    void insOrganInfo(Map<String, Object> mapParams);
}
