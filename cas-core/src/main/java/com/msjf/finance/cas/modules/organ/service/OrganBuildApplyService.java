package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 19:35
 */
public interface OrganBuildApplyService {
    /**
     * 企业设立申请
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    void organBuildApply(HashMap<String, Object> mapParam, Response rs);
}
