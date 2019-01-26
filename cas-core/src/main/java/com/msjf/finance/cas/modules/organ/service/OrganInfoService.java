package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.msjf.core.page.Page;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 11509 on 2018/12/18.
 */

public interface OrganInfoService {
     /**
      * 查询企业基本信息
      * @return
      */
     Page<OrganInfoDomain> queryOrganInfoList(OrganInfoDomain organInfoDomain);

     /**
      * 企业个人信息入口
      *
      * @param mapParam
      */
     Response companyPersonInfo(HashMap<String, Object> mapParam);


}
