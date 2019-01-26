package com.msjf.finance.cas.facade.organ;

import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
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

}
