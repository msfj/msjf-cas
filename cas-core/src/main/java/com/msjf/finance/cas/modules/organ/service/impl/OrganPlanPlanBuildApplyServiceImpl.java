package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.dao.OrganInfoDao;
import com.msjf.finance.cas.common.entity.OrganInfoEntity;
import com.msjf.finance.cas.modules.organ.service.OrganPlanBuildApplyService;
import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 * 描述:
 *    服务平台拟设立新增申请
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 8:37
 */
@Service
public class OrganPlanPlanBuildApplyServiceImpl implements OrganPlanBuildApplyService {


    /** 发起人客户代码*/
    private String customerno;

    /** 企业客户代码*/
    private String orgcustomerno;

    /** 企业地区 注册地址(省) dict101021*/
    private String registerprovince;

    /** 企业地区 注册地址(市) dict101022*/
    private String registercity;

    /** 企业地区 注册地址(区/县) dict101023*/
    private String registercounty;

    /** 企业地区 注册地址(街道)*/
    private String registertreet;

    /** 企业名称*/
    private String membername;

    /** 企业类型 字典104 0-有限公司 1-合伙企业*/
    private String organtype;

    /** 企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业*/
    private String organclass;

    @Resource
    OrganInfoDao organInfoDao;

    /**
     * 添加拟设立
     *
     * @param mapParam 入参
     * @param rs       返回结果
     */
    @Override
    public void addApply(HashMap<String, Object> mapParam, Response rs) {
        String customerno = String.valueOf(mapParam.get("customerno"));

        //检查发起人账户信息不存在
        CustEntity cifCustEntity = null;//cifCustPersistence.queryEntity(customerno);
/*        if (StringUtils.isEmpty(cifCustEntity)) {
            rs.fail("cas","发起人账户信息不存在");
            return;
        }*/

        //

    }



    /**
     * 企业设立申请
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */

    @Override
    public void organBuildApply(HashMap<String, Object> mapParam, Response rs) {
        rs.fail("cas", "设立申请失败");

        List<OrganInfoEntity> organInfoEntityList = organInfoDao.getOrganInfo(new OrganInfoEntity());
        rs.success();
    }




}
