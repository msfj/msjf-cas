package com.msjf.finance.cas.modules.organ.dao;

import com.msjf.finance.cas.modules.organ.entity.IBaseEntity;

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
public interface IBaseDao<T extends IBaseEntity> {

    /**
     * 按主键查询锁表
     *
     * @param t 主键
     * @return 实体
     */
    T getTableInfoKeyLock(T t);

    /**
     * 按主键查询
     *
     * @param t
     * @return
     */
    T getInfoKey(T t);

    /**
     * 按主键查询锁表
     *
     * @param t
     * @return
     */
    Map getInfoKeyHashmap(T t);

    /**
     * 按实体查询锁表
     *
     * @param t
     * @return
     */
    T getInfoLockEntity(T t);

    /**
     * 按实体查询
     *
     * @param t
     * @return
     */
    T getInfoEntity(T t);

    /**
     * 按实体查询
     *
     * @param t
     * @return
     */
    Map getInfoHashmap(T t);

    /**
     * 按实体新增记录
     *
     * @param t
     * @return
     */
    Integer insInfoEntity(T t);

    /**
     * 按批量实体新增记录
     *
     * @param t
     * @return
     */
    Integer insInfoBatchEntity(List<T> t);


    /**
     * 按实体更新记录
     *
     * @param t
     * @return
     */
    Integer updOrganInfoEntity(T t);

    /**
     * 批量实体更新记录
     *
     * @param t
     * @return
     */
    Integer updInfoBatchEntity(T t);

    /**
     * 按实体更新记录
     *
     * @param t
     * @return
     */
    Integer updAllowEmptyInfoEntity(T t);

    /**
     * 批量实体更新记录
     *
     * @param t
     * @return
     */
    Integer updAllowEmptyInfoBatchEntity(T t);


    /**
     * 按主键删除记录
     *
     * @param t
     * @return
     */
    Integer delInfoKey(T t);

    /**
     * 根据主键批量删除记录
     *
     * @param t
     * @return
     */
    Integer delInfoKeyBatch(T t);


}
