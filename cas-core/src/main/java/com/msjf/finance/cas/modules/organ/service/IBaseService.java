package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.cas.modules.IApp;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    用于实现接口的方法
 *  <pre/>
 * @author kevin
 * @create 2019-01-25 9:53
 */
public abstract class IBaseService implements OrganService, IApp {

    /**
     * 服务名称
     */
    protected final static String serviceName = "cas";


    /**
     * 入参检查
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean preCheck(HashMap<String, Object> mapParam, Response rs) {
        return true;
    }

    /**
     * 缓存数据
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean cache(HashMap<String, Object> mapParam, Response rs) {
        return true;
    }

    /**
     * 业务参数检查
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean check(HashMap<String, Object> mapParam, Response rs) {
        return true;
    }

    /**
     * 业务处理前操作
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean before(HashMap<String, Object> mapParam, Response rs) {
        return true;
    }

    /**
     * 业务处理
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean clear(HashMap<String, Object> mapParam, Response rs) {
        return true;
    }

    /**
     * 业务处理后操作
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean after(HashMap<String, Object> mapParam, Response rs) {
        return true;
    }

    /**
     * 添加拟设立-第一步
     *
     * @param mapParam 入参
     */
    @Override
    public void addApplyFirst(HashMap<String, Object> mapParam, Response rs) {

    }

    /**
     * 服务平台拟设立新增申请第二步
     *
     * @param mapParam 入参
     */
    @Override
    public void addApplySecond(HashMap<String, Object> mapParam, Response rs) {

    }

    /**
     * 添加拟设立-第三步
     *
     * @param mapParam 入参
     * @param rs
     * @return Response 返回结果
     */
    @Override
    public void addApplyThirdly(HashMap<String, Object> mapParam, Response rs) {

    }

    /**
     * 添加拟设立-第四步-其它信息
     *
     * @param mapParam 入参
     * @param rs       返回结果
     */
    @Override
    public void addApplyFourthly(HashMap<String, Object> mapParam, Response rs) {

    }

    /**
     * 查询企业设立列表信息
     *
     * @param mapParam 入参
     * @param rs       返回结果
     */
    @Override
    public void getOrganInfoList(HashMap<String, Object> mapParam, Response rs) {

    }
}
