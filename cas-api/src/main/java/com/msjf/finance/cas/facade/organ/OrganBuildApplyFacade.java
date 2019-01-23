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
public interface OrganBuildApplyFacade {
    /**
     * 企业设立申请
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response organBuildApply(HashMap<String, Object> mapParam);

    /**
     * 添加拟设立
     * @param mapParam 入参
     */
    Response addApply(HashMap<String, Object> mapParam);

}
