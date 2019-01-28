package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.MacroDefine;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    服务平台拟设立新增申请第二步
 *  <pre/>
 * @author kevin
 * @create 2019-01-25 10:40
 */
@Service
public class OrganPlanPlanBuildApplySecondImpl extends BaseService {

    /**
     * 发起人客户代码
     */
    private String customerno;

    /**
     * 企业客户代码
     */
    private String orgcustomerno;


    /**
     * 招商对接人
     */
    private String dockingpeople;

    /**
     * 办理流程 字典120 0-现场 1-半电子 2-全电子
     */
    private String dealflow;

    /**
     * 经营期限
     */
    private String managelimit;

    /**
     * 缴付期限
     */
    private String paydatelimit;

    /**
     * 注册资本金币种
     */
    private String regicapitalbz;

    /**
     * 实际地址(省) dict101021
     **/
    private String realprovince;
    /**
     * 实际地址(市) dict101022
     **/
    private String realcity;
    /**
     * 实际地址(区/县) dict101023
     **/
    private String realcounty;
    /**
     * 实际地址(街道)
     **/
    private String realtreet;

    /**
     * 经营范围/主营业务
     */
    private String businessscope;
    /**
     * 企业电话
     */
    private String organPhone;

    /**
     * 企业邮箱
     */
    private String organEmail;

    /**
     * 服务平台拟设立新增申请第二步
     *
     * @param mapParam 入参
     */
    @Transactional
    @Override
    public void addApplySecond(HashMap<String, Object> mapParam, Response rs) {
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
        dockingpeople = StringUtil.valueOf(mapParam.get("dockingpeople"));
        dealflow = StringUtil.valueOf(mapParam.get("dealflow"));
        managelimit = StringUtil.valueOf(mapParam.get("managelimit"));
        paydatelimit = StringUtil.valueOf(mapParam.get("paydatelimit"));
        regicapitalbz = StringUtil.valueOf(mapParam.get("regicapitalbz"));
        realprovince = StringUtil.valueOf(mapParam.get("realprovince"));
        realcity = StringUtil.valueOf(mapParam.get("realcity"));
        realcounty = StringUtil.valueOf(mapParam.get("realcounty"));
        realtreet = StringUtil.valueOf(mapParam.get("realtreet"));
        businessscope = StringUtil.valueOf(mapParam.get("businessscope"));
        organPhone = StringUtil.valueOf(mapParam.get("organPhone"));
        organEmail = StringUtil.valueOf(mapParam.get("organEmail"));
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
        if (CheckUtil.isNull(customerno)) {
            rs.fail("cas", "发起人客户代码不能为空");
            return false;
        }
        if (CheckUtil.isNull(orgcustomerno)) {
            rs.fail("cas", "企业客户代码不能为空");
            return false;
        }
        if (CheckUtil.isNull(dockingpeople)) {
            rs.fail("cas", "招商对接人代码不能为空");
            return false;
        }
        if (!MacroDefine.DEAL_FLOW.isExistsEnum(dealflow)) {
            rs.fail("cas", "办理流程类型错误");
            return false;
        }
        if (CheckUtil.isNull(managelimit)) {
            rs.fail("cas", "经营期限不能为空");
            return false;
        }
        if (CheckUtil.isNull(paydatelimit)) {
            rs.fail("cas", "缴付期限不能为空");
            return false;
        }
        if (CheckUtil.isNull(regicapitalbz)) {
            rs.fail("cas", "注册资本金币种不能为空");
            return false;
        }
        if (CheckUtil.isNull(realprovince)) {
            rs.fail("cas", "企业联系地址所属省不能为空");
            return false;
        }
        if (CheckUtil.isNull(realcity)) {
            rs.fail("cas", "企业联系地址所属市不能为空");
            return false;
        }
        return super.preCheck(mapParam, rs);
    }

    /**
     * 业务参数检查
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean check(HashMap<String, Object> mapParam, Response rs) {
        //1-根据企业代码检查企业信息是否存在
        if (!CheckOranInfo(orgcustomerno, rs)) {
            return false;
        }
        return super.check(mapParam, rs);
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

        //1-更新企业客户对应的招商对接人
        if (!updCifCust(rs)) {
            return false;
        }
        //2-更新企业基本信息表信息
        if (!UpdateOranInfo(rs)) {
            return false;
        }
        return super.clear(mapParam, rs);
    }

    /**
     * 更新企业基本信息表信息
     *
     * @param rs 结果集
     * @return false 失败 true 成功
     */
    private boolean UpdateOranInfo(Response rs) {
        //2-更新企业基本信息表
        OrganInfoEntity organInfoEntity = new OrganInfoEntity();
        organInfoEntity.setCustomerno(orgcustomerno);
        organInfoEntity.setDealflow(dealflow);
        organInfoEntity.setManagelimit(managelimit);
        organInfoEntity.setPaydatelimit(paydatelimit);
        organInfoEntity.setRegicapitalbz(regicapitalbz);
        organInfoEntity.setRealprovince(realprovince);
        organInfoEntity.setRealcity(realcity);
        organInfoEntity.setRealcounty(realcounty);
        organInfoEntity.setRealtreet(realtreet);
        organInfoEntity.setBusinessscope(businessscope);
        organInfoEntity.setOrganPhone(organPhone);
        organInfoEntity.setOrganEmail(organEmail);
        return updateOrganInfoEntity(organInfoEntity, rs);
    }


    /**
     * 更新企业客户对应的招商对接人
     *
     * @param rs 结果集
     */
    private boolean updCifCust(Response rs) {
        CustEntity entity = new CustEntity();
        entity.setCustomerno(orgcustomerno);
        //企业招商对接人=发起人招商对接人
        entity.setDockingPeople(dockingpeople);
        return updateCustEntity(entity, rs);
    }


}
