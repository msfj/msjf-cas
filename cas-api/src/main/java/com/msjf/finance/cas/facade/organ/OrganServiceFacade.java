package com.msjf.finance.cas.facade.organ;

import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    对外开放的接口
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 19:01
 */
public interface OrganServiceFacade {
    /**
     * 添加拟设立-第一步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response setAddApplyFirst(HashMap<String, Object> mapParam);

    /**
     * 添加拟设立-第二步
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response setAddApplySecond(HashMap<String, Object> mapParam);
    /**
     * 添加拟设立-第三步
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response setAddApplyThirdly(HashMap<String, Object> mapParam);
    /**
     * 添加拟设立-第四步-其它信息
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response setAddApplyFourthly(HashMap<String, Object> mapParam);

}
