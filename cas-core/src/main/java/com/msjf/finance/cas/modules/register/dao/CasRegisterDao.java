package com.msjf.finance.cas.modules.register.dao;

import com.msjf.finance.cas.common.dao.MyBatisDao;
import com.msjf.finance.cas.modules.register.entity.CasRegisterInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2019/01/05.
 */
@MyBatisDao
public interface CasRegisterDao {

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
