package com.msjf.finance.cas.modules.organ.facade;

import com.msjf.finance.cas.facade.organ.OrganInfoFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.modules.organ.emun.OrganInfoEmun;
import com.msjf.finance.cas.modules.organ.service.OrganInfoService;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 11509 on 2018/12/18.
 * <p>
 * 对入参的校验
 */
@Service("organInfoFacade")
public class OrganInfoFacadeImpl implements OrganInfoFacade {

    private static final Logger logger = LogManager.getLogger(OrganInfoFacadeImpl.class);
    @Resource
    OrganInfoService organInfoService;

    @Override
    public Response<List<OrganInfoDomain>> queryOrganInfoList(OrganInfoDomain organInfoDomain) {
        logger.info("开始查询机构信息 organInfoDomain={}", organInfoDomain);
        try {
            if (ObjectUtils.isEmpty(organInfoDomain)) {
                logger.warn("入参不能为空 organInfoDomain={}", organInfoDomain);
                return new Response<>().fail(OrganInfoEmun.MSG_PARAM_ERROR);
            }
            List<OrganInfoDomain> organInfoDomainList = organInfoService.queryOrganInfoList();
            logger.warn("查询机构信息成功 organInfoDomain={}，organInfoDomainList={}", organInfoDomain, organInfoDomainList);
            return new Response<>().success(organInfoDomainList);
        } catch (Exception e) {
            logger.warn("查询机构信息异常 organInfoDomain={}，e={}", organInfoDomain, e);
            return new Response<>().fail(OrganInfoEmun.MSG_SYS_ERROR);
        }
    }

    /**
     * 企业个人信息查询
     *
     * @param mapParam
     * @return
     */
    @Override
    public Response companyPersonInfo(HashMap<String, Object> mapParam) {
        if (ObjectUtils.isEmpty(mapParam)) {
            logger.warn("入参不能为空 mapParam={}", mapParam);
            return new Response<>().fail(OrganInfoEmun.MSG_PARAM_ERROR);
        }
        return null;
    }
}
