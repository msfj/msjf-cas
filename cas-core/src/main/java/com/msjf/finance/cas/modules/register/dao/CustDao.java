package com.msjf.finance.cas.modules.register.dao;


import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * Created by lzp on 2018/12/25.
 */
@MyBatisDao
public interface CustDao {
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
    void insCust(Map<String, Object> mapParams);

    /**
     * 按实体更新
     */
    void update(CustEntity custEntity);
}
