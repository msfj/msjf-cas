package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.utils.StringUtil;
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
     * 服务平台拟设立新增申请第二步
     *
     * @param mapParam 入参
     */
    @Override
    public void addApplySecond(HashMap<String, Object> mapParam, Response rs) {
        rs.fail("cas", "操作失败");
        getParam(mapParam);
        doSingleService(mapParam, rs);
    }

    /**
     * 获取入参
     *
     * @param mapParam 入参
     */
    private void getParam(HashMap<String, Object> mapParam) {

    }

}
