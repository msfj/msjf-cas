package com.msjf.finance.cas.common.dao;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-21 17:59
 */
public interface IBaseDao<K extends IBaseEntity,V extends IBaseEntity> {

    /**
     * 按主键查询锁表
     *
     * @param v 主键
     * @return 实体
     */
    K getEntityKeyLock(V v);

    /**
     * 按主键查询
     *
     * @param v
     * @return
     */
    K getEntityKey(V v);

    /**
     * 按主键查询锁表
     *
     * @param v
     * @return
     */
    Map getHashMapKey(V v);

    /**
     * 按实体查询锁表
     *
     * @param K
     * @return
     */
    List<K> getListEntityLock(K K);

    /**
     * 按实体查询
     *
     * @param K
     * @return
     */
    List<K> getListEntity(K K);

    /**
     * 按实体查询
     *
     * @param K
     * @return
     */
    List<Map> getListMap(K K);

    /**
     * 按实体新增记录
     *
     * @param K
     * @return
     */
    Integer insEntity(K K);

    /**
     * 按批量实体新增记录
     *
     * @param K
     * @return
     */
    Integer insEntityBatch(List<K> K);


    /**
     * 按实体更新记录
     *
     * @param K
     * @return
     */
    Integer updEntity(K K);

    /**
     * 批量实体更新记录
     *
     * @param K
     * @return
     */
    Integer updEntityBatch(List<K> K);

    /**
     * 按实体更新记录
     *
     * @param K
     * @return
     */
    Integer updAllowEmptyEntity(K K);

    /**
     * 批量实体更新记录
     *
     * @param K
     * @return
     */
    Integer updAllowEmptyBatchEntity(List<K> K);


    /**
     * 按主键删除记录
     *
     * @param v
     * @return
     */
    Integer delEntityKey(V v);

    /**
     * 根据主键批量删除记录
     *
     * @param v
     * @return
     */
    Integer delEntityKeyBatch(List<V> v);


}
