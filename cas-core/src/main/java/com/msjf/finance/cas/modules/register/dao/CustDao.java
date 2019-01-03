package com.msjf.finance.cas.modules.register.dao;


import com.msjf.finance.cas.common.dao.MyBatisDao;
import com.msjf.finance.cas.modules.register.entity.CustEntity;

import java.util.List;

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
    void insCust(CustEntity custEntity);
}