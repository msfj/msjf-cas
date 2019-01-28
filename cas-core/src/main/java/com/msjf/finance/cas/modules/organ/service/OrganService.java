package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    企业相关
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 19:35
 */
public interface OrganService {

    /**
     * 添加拟设立-第一步
     * @param mapParam 入参
     * @param rs 返回结果
     */
    void addApplyFirst(HashMap<String, Object> mapParam, Response rs);

    /**
     * 添加拟设立-第二步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    void addApplySecond(HashMap<String, Object> mapParam, Response rs);

    /**
     * 添加拟设立-第三步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    void addApplyThirdly(HashMap<String, Object> mapParam, Response rs);
}
