package com.msjf.finance.cas.modules.organ.facade;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.organ.OrganInfoFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.modules.organ.service.OrganInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 11509 on 2018/12/18.
 *
 *  对入参的校验
 */
@Service("organInfoFacade")
public class OrganInfoFacadeImpl implements OrganInfoFacade {
    @Resource
    OrganInfoService organInfoService;

    public Response<List<OrganInfoDomain>> queryOrganInfoList(OrganInfoDomain  organInfoDomain) {
        try {
            if(ObjectUtils.isEmpty(organInfoDomain)){
                return new Response<>().fail();
            }
            List<OrganInfoDomain> organInfoDomainList = organInfoService.queryOrganInfoList();
            return new Response<>().success(organInfoDomainList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>().fail();
        }
    }
}
