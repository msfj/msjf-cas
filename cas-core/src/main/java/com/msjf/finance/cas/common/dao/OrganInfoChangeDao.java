package com.msjf.finance.cas.common.dao;


import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lzp on 2018/12/26.
 */
@MyBatisDao
public interface OrganInfoChangeDao {
    /**
     * 在变更记录表检查企业名称是否已存在
     */
    List<HashMap<String, Object>>  checkExistCompanynameInChange(HashMap<String, Object> map);
}
