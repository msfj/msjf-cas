package com.msjf.finance.cas.modules.ausAuthone.dao;

import com.msjf.finance.cas.common.dao.MyBatisDao;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneEntity;

import java.util.Map;

/**
 * Created by lzp on 2018/12/28.
 */
@MyBatisDao
public interface AusAuthoneDao {
    /**
     * 写登陆认证表
     */
    void inrAusAuthone(Map<String, Object> mapParams);
}
