package com.msjf.finance.cas.facade.organ;

import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11509 on 2018/12/18.
 */
public interface OrganInfoFacade {
    /**
     * 查询企业信息
     * @param organInfoDomain
     * @return
     */
    Response<List<OrganInfoDomain>> queryOrganInfoList(OrganInfoDomain  organInfoDomain);

    /**
     * 企业个人信息入口
     *
     * @param mapParam
     * @throws Exception
     */
    Response companyPersonInfo(HashMap<String, Object> mapParam);


}
