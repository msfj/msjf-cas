package com.msjf.finance.cas.common.dao;
import com.msjf.finance.cas.common.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.entity.OrganInfoKey;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 11509
 * @date 2018/12/18
 */
@MyBatisDao
public interface OrganInfoDao extends IBaseDao<OrganInfoEntity>{
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
