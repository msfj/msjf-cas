package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    服务平台拟设立新增申请第二步
 *  <pre/>
 * @author kevin
 * @create 2019-01-25 10:40
 */
@Service
public class OrganPlanPlanBuildApplySecondImpl extends BaseService {
    /**
     * 企业设立申请
     *
     * @param mapParam 入参
     * @param rs
     * @return Response 返回结果
     */
    @Override
    public void addApplySecond(HashMap<String, Object> mapParam, Response rs) {
        super.addApplySecond(mapParam, rs);
        rs.success("cas", "成功",null);
    }
}
