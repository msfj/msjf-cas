package com.msjf.finance.cas.modules.organ.facade;

import com.msjf.finance.cas.facade.organ.OrganServiceFacade;
import com.msjf.finance.cas.modules.organ.service.OrganService;
import com.msjf.finance.cas.modules.util.SpringContextUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    企业服务
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 14:48
 */
@Service("organServiceFacade")
public class OrganServiceFacadeImpl implements OrganServiceFacade {

    private static final Logger logger = LogManager.getLogger(OrganServiceFacadeImpl.class);


    /**
     * 添加拟设立-第一步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    @Override
    public Response setAddApplyFirst(HashMap<String, Object> mapParam) {
        //获取：服务
        OrganService organService = SpringContextUtil.getBean("organPlanPlanBuildApplyFirstImpl");
        Response rs = new Response();
        logger.debug("cas", "=====调用业务开始=====", mapParam);
        organService.addApplyFirst(mapParam, rs);
        logger.debug("cas", "=====调用业务结束=====", rs);
        return rs;
    }

    /**
     * 添加拟设立-第二步
     *
     * @param mapParam 入参
     * @return Response 结果集
     */
    @Override
    public Response setAddApplySecond(HashMap<String, Object> mapParam) {
        OrganService organService = SpringContextUtil.getBean("organPlanPlanBuildApplySecondImpl");
        Response rs = new Response();
        logger.debug("cas", "=====调用业务开始=====", mapParam);
        organService.addApplySecond(mapParam, rs);
        logger.debug("cas", "=====调用业务结束=====", rs);
        return rs;
    }

    /**
     * 添加拟设立-第三步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    @Override
    public Response setAddApplyThirdly(HashMap<String, Object> mapParam) {
        Response rs = new Response();
        //调用业务
        OrganService organService = SpringContextUtil.getBean("organPlanPlanBuildApplyThirdlyImpl");
        logger.debug("cas", "=====调用业务开始=====", mapParam);
        organService.addApplyThirdly(mapParam, rs);
        logger.debug("cas", "=====调用业务结束=====", rs);
        return rs;
    }

    /**
     * 添加拟设立-第四步-其它信息
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    @Override
    public Response setAddApplyFourthly(HashMap<String, Object> mapParam) {
        Response rs = new Response();
        //调用业务
        OrganService organService = SpringContextUtil.getBean("organPlanPlanBuildApplyFourthlyImpl");
        logger.debug("cas", "=====调用业务开始=====", mapParam);
        organService.addApplyFourthly(mapParam, rs);
        logger.debug("cas", "=====调用业务结束=====", rs);
        return rs;
    }

    /**
     * 查询企业设立列表信息
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    @Override
    public Response getOrganInfoList(HashMap<String, Object> mapParam) {
        Response rs = new Response();
        //调用业务
        OrganService organService = SpringContextUtil.getBean("getOrganInfoListImpl");
        logger.debug("cas", "=====调用业务开始=====", mapParam);
        organService.getOrganInfoList(mapParam, rs);
        logger.debug("cas", "=====调用业务结束=====", rs);
        return rs;
    }

    /**
     * 删除未提交确认设立的企业设立信息
     *
     * @param mapParam 入参
     * @return 返回结果
     */
    @Override
    public Response setDeleteOrgan(HashMap<String, Object> mapParam) {
        Response rs = new Response();
        //调用业务
        OrganService organService = SpringContextUtil.getBean("setDeleteOrgan");
        logger.debug("cas", "=====调用业务开始=====", mapParam);
        organService.getOrganInfoList(mapParam, rs);
        logger.debug("cas", "=====调用业务结束=====", rs);
        return rs;
    }
}
