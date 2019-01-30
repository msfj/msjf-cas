package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.joindao.persistence.OrganJoinDao;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.cas.modules.util.SpringContextUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    查询企业设立首页列表信息
 *  <pre/>
 * @author kevin
 * @create 2019-01-29 17:09
 */
@Service
public class GetOrganInfoListImpl extends BaseService {


    /**
     * 发起人客户代码
     */
    private String customerno;

    /**
     * 查询条件：企业客户代码
     */
    private String orgcustomerno;


    /**
     * 查询条件：企业公司名称
     */
    private String membername;

    /**
     * 查询企业设立列表信息
     *
     * @param mapParam 入参
     * @param rs       返回结果
     */
    @Transactional(rollbackFor = Exception.class, readOnly = true, timeout = 300)
    @Override
    public void getOrganInfoList(HashMap<String, Object> mapParam, Response rs) {
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
        customerno = StringUtil.valueOf(mapParam.get("customerno"));
        orgcustomerno = StringUtil.valueOf(mapParam.get("orgcustomerno"));
        membername = StringUtil.valueOf(mapParam.get("membername"));
    }


    /**
     * 入参检查
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean preCheck(HashMap<String, Object> mapParam, Response rs) {
        if (CheckUtil.checkNull(customerno, serviceName, "发起人客户代码", rs)) {
            return false;
        }
        return super.preCheck(mapParam, rs);
    }

    /**
     * 业务处理
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean clear(HashMap<String, Object> mapParam, Response rs) {
        //查询数据：企业客户代码、企业名称、企业状态、流程类型
        OrganJoinDao organJoinDao = SpringContextUtil.getBean("organJoinDao");
        HashMap<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("membername", membername);
        List<Map<String, Object>> resultList = organJoinDao.getOrganInfoRelateList(paramMap);
        rs.success(serviceName, "查询成功", resultList);
        return super.clear(mapParam, rs);
    }
}
