package com.msjf.finance.cas.modules.organ.facade;

import com.msjf.finance.cas.facade.organ.OrganBuildApplyFacade;
import com.msjf.finance.cas.modules.organ.service.OrganPlanBuildApplyService;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 14:48
 */
@Service
public class OrganBuildApplyFacadeImpl implements OrganBuildApplyFacade {

    private static final Logger logger = LogManager.getLogger(OrganBuildApplyFacadeImpl.class);

    @Autowired
    @Qualifier("organBuildApplyServiceImpl")
    OrganPlanBuildApplyService organPlanBuildApplyService;

     /**
     * 企业设立申请
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    @Override
    public Response organBuildApply(HashMap<String, Object> mapParam) {
        Response rs = new Response();
        organPlanBuildApplyService.organBuildApply(mapParam, rs);
        return rs;
    }
}
