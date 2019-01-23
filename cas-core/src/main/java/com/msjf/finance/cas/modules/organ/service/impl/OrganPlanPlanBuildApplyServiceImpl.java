package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.dao.OrganInfoDao;
import com.msjf.finance.cas.common.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.DateUtils;
import com.msjf.finance.cas.common.utils.IDUtils;
import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.cas.modules.organ.service.OrganPlanBuildApplyService;
import com.msjf.finance.cas.modules.register.dao.CustDao;
import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.cas.modules.util.SpringContextUtil;
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
public class OrganPlanPlanBuildApplyServiceImpl extends BaseService implements OrganPlanBuildApplyService {


    /**
     * 发起人客户代码
     */
    private String customerno;

    /**
     * 企业客户代码
     */
    private String orgcustomerno;

    /**
     * 企业地区 注册地址(省) dict101021
     */
    private String registerprovince;

    /**
     * 企业地区 注册地址(市) dict101022
     */
    private String registercity;

    /**
     * 企业地区 注册地址(区/县) dict101023
     */
    private String registercounty;

    /**
     * 企业地区 注册地址(街道)
     */
    private String registertreet;

    /**
     * 企业名称
     */
    private String membername;

    /**
     * 企业类型 字典104 0-有限公司 1-合伙企业
     */
    private String organtype;

    /**
     * 企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业
     */
    private String organclass;


    @Resource
    CustDao custDao;

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

        String customerNo = String.valueOf(mapParam.get("customerno"));
        membername = String.valueOf(mapParam.get("membername"));
        organtype = String.valueOf(mapParam.get("organtype"));
        organclass = String.valueOf(mapParam.get("organclass"));

        //检查发起人账户信息不存在
        CustEntity custEntity = new CustEntity();
        custEntity.setCustomerno(customerNo);
        List<CustEntity> custEntityList = custDao.queryCustEntityList(custEntity);
        if (CheckUtil.isNull(custEntityList)) {
            rs.fail("cas", "发起人账户信息不存在");
            return;
        }
        if (CheckUtil.isNull(membername)) {
            rs.fail("cas", "企业名称为空");
            return;
        }
        if (CheckUtil.isNull(organtype)) {
            rs.fail("cas", "企业类型为空");
            return;
        }
        if (CheckUtil.isNull(organclass)) {
            rs.fail("cas", "企业分类为空");
            return;
        }

        //企业名称唯一性检查
        if (!super.checkOrganName(membername, rs)) {
            return;
        }

        //查询随机分配的服务人员(查询金服人员失败)

        //生成企业ID
        orgcustomerno = String.valueOf(IDUtils.genItemId());

        //写企业基本信息表
        addOrganInfo();

    }


    /**
     * 写企业基本信息表
     *
     * @param
     */
    private void addOrganInfo() {
        try {
            OrganInfoEntity organInfoEntity = new OrganInfoEntity();
            organInfoEntity.setCustomerno(orgcustomerno);
            organInfoEntity.setStartcustomerno(customerno);
            organInfoEntity.setMembername(membername);
            organInfoEntity.setOrgantype(organtype);
            organInfoEntity.setOrganclass(organclass);
            organInfoEntity.setOrganstatus("0");//0-设立中
            organInfoEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            organInfoEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
            organInfoEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            organInfoEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
            organInfoDao.insInfoEntity(organInfoEntity);
        } catch (Exception e) {
            throw new RuntimeException("organ_info表写失败", e);
        }
    }


    /**
     * 企业设立申请
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */

    @Override
    public void organBuildApply(HashMap<String, Object> mapParam, Response rs) {

    }


}
