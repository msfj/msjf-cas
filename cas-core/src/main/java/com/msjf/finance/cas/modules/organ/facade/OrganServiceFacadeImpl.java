package com.msjf.finance.cas.modules.organ.facade;

import com.msjf.finance.cas.facade.organ.OrganServiceFacade;
import com.msjf.finance.cas.modules.organ.service.OrganService;
import com.msjf.finance.cas.modules.util.SpringContextUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class OrganServiceFacadeImpl implements OrganServiceFacade {

    private static final Logger logger = LogManager.getLogger(OrganServiceFacadeImpl.class);

    /**
     * 添加拟设立-第一步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    @Override
    public Response addApplyFirst(HashMap<String, Object> mapParam) {
        logger.log(Level.DEBUG, "cas", mapParam);
        //获取：服务
        OrganService organService = SpringContextUtil.getBean("organPlanPlanBuildApplyFirstImpl");
        Response rs = new Response();
        organService.addApplyFirst(mapParam, rs);
        logger.log(Level.DEBUG, "cas", rs);
        return rs;
    }

    /**
     * 添加拟设立-第二步
     *
     * @param mapParam 入参
     * @return Response 结果集
     */
    @Override
    public Response addApplySecond(HashMap<String, Object> mapParam) {
        logger.log(Level.DEBUG, "cas", mapParam);
        OrganService organService = SpringContextUtil.getBean("organPlanPlanBuildApplySecondImpl");
        Response rs = new Response();
        organService.addApplySecond(mapParam, rs);
        logger.log(Level.DEBUG, "cas", rs);
        return rs;
    }
}
