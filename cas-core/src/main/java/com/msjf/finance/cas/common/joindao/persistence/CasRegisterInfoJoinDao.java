package com.msjf.finance.cas.common.joindao.persistence;

import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CasRegisterInfoJoinDao {
    /**
     * 新增用户
     */
    void insCasRegister(Map<String, Object> mapParams);

    /**
     * 用户注册基本信息表按实体查询
     */
    List<Map> queryCasRegisterList(Map<String, Object> mapParams);


    /**
     * 修改用户
     */
    void updCasRegister(Map<String, Object> mapParams);
}
