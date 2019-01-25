package com.msjf.finance.cas.modules.organ.facade;

import com.msjf.finance.cas.facade.organ.OrganServiceFacade;
import com.msjf.finance.cas.modules.organ.service.OrganService;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class OrganServiceFacadeImpl implements OrganServiceFacade {

    private static final Logger logger = LogManager.getLogger(OrganServiceFacadeImpl.class);



    @Resource(name = "organPlanPlanBuildApplyFirstImpl")
    private OrganService organPlanPlanBuildApplyFirstImpl;

    /**
     * 添加拟设立-第一步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    @Override
    public Response addApplyFirst(HashMap<String, Object> mapParam) {
        logger.log(Level.DEBUG,"cas",mapParam);
        Response rs = new Response();
        organPlanPlanBuildApplyFirstImpl.addApplyFirst(mapParam, rs);
        logger.log(Level.DEBUG,"cas",rs);
        return rs;
    }


    @Resource(name = "organPlanPlanBuildApplySecondImpl")
    private OrganService organPlanPlanBuildApplySecondImpl;
    /**
     * 添加拟设立-第二步
     *
     * @param mapParam 入参
     */
    @Override
    public Response addApplySecond(HashMap<String, Object> mapParam) {
        logger.log(Level.DEBUG,"cas",mapParam);
        Response rs = new Response();
        organPlanPlanBuildApplySecondImpl.addApplySecond(mapParam,rs);
        logger.log(Level.DEBUG,"cas",rs);
        return rs;
    }
}
