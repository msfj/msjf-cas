package com.msjf.finance.cas.common.joindao.persistence;

import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.facade.custManger.domain.CustOutDomain;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CustJoinDao {

    /**
     * 用户信息：证件号唯一性检查
     * 忽略大小写
     * @return
     */
    List<CustEntity> checkCustCertificatenoIsExist(CustEntity custEntity);

    /**
     * 用户基本信息表按实体查询
     */
    List<CustEntity> queryCustEntityList(CustEntity custEntity);

    /**
     * 新增用户
     */
    void insCustMap(Map<String, Object> mapParams);

    /**
     * 按实体更新
     */
    void update(CustEntity custEntity);

    List<CustOutDomain> queryCustList(Map<String, Object> mapParams);
}
