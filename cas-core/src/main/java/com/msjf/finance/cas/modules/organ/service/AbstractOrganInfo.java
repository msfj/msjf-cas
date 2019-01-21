package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.msjf.core.response.Response;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 * 描述:
 *    企业基本信息抽象类
 *  <pre/>
 * @author 95494
 * @create 2019-01-20 21:35
 */
public class AbstractOrganInfo implements OrganInfoService{

    /**
     * 查询企业基本信息
     *
     * @return
     */
    @Override
    public List queryOrganInfoList() {
        return null;
    }

    /**
     * 企业个人信息入口
     *
     * @param mapParam
     */
    @Override
    public Response companyPersonInfo(HashMap<String, Object> mapParam) {
        return null;
    }
}
