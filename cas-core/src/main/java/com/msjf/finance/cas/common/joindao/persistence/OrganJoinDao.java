package com.msjf.finance.cas.common.joindao.persistence;

import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    企业相关的操作
 *  <pre/>
 * @author kevin
 * @create 2019-01-29 17:49
 */
@MyBatisDao
public interface OrganJoinDao {

    /**
     * 查询企业基本信息和相关联信息
     * @param mapParam 入参
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getOrganInfoRelateList(HashMap<String,Object> mapParam);
}
