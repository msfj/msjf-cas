package com.msjf.finance.cas.modules.organ.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.MacroDefine;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.organ.facade.OrganServiceFacadeImpl;
import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.cas.modules.util.SpringContextUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-27 15:39
 */
@Service
public class OrganPlanPlanBuildApplyThirdlyImpl extends BaseService {

    private static final Logger logger = LogManager.getLogger(OrganServiceFacadeImpl.class);

    /**
     * 发起人客户代码
     */
    private String customerno;

    /**
     * 企业客户代码
     */
    private String orgcustomerno;
    /**
     * 执行事务合伙人类型 字典 107  0-个人 1-公司 -合伙企业属性
     */
    private String partnertype;
    /**
     * 执行事务合伙人名称
     */
    private String partnername;
    /**
     * 投资人/合伙人信息 list<map> Str
     */
    private String memberinfo;

    /**
     * 投资人/合伙人信息 list<map>
     */
    private List<HashMap> memberList = new ArrayList<>();


    /**
     * 添加拟设立-第三步
     *
     * @param mapParam 入参
     * @param rs
     * @return Response 返回结果
     */
    @Transactional
    @Override
    public void addApplyThirdly(HashMap<String, Object> mapParam, Response rs) {

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
        partnertype = StringUtil.valueOf(mapParam.get("partnertype"));
        partnername = StringUtil.valueOf(mapParam.get("partnername"));
        memberinfo = StringUtil.valueOf(mapParam.get("memberinfo"));
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
        if (CheckUtil.checkNull(orgcustomerno, serviceName, "企业代码", rs)) {
            return false;
        }

        //检查：执行事务合伙人类型是否匹配
        if (MacroDefine.PARTNER_TYPE.isExistsEnum(partnertype)) {
            rs.fail(serviceName, "执行事务合伙人类型暂不支持【" + MacroDefine.PARTNER_TYPE.values() + "】");
            return false;
        }
        if (CheckUtil.checkNull(partnername, serviceName, "执行事务合伙人名称", rs)) {
            return false;
        }

        if (CheckUtil.checkNull(memberinfo, serviceName, "投资人/合伙人信息", rs)) {
            return false;
        }

        try {
            memberList = JSONArray.parseArray(memberinfo.trim(), HashMap.class);
        } catch (Exception e) {
            rs.fail(serviceName, "memberinfo数据格式不合法");
            logger.debug("memberinfo数据格式不合法", e);
            throw new RuntimeException("memberinfo数据格式不合法", e);
        }
        if (CheckUtil.checkNull(memberList, serviceName, "投资人/合伙人信息", rs)) {
            return false;
        }
        //检查成员基本信息
        if (!checkOrganMemberParam(memberList, rs)) {
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
        //1-检查发起人账户信息不存在
        if (!CheckCustomerInfo(customerno, rs)) {
            return false;
        }
        //根据主键缓存企业基本信息
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        OrganInfoKey organInfoKey = new OrganInfoKey();
        organInfoKey.setKey(orgcustomerno);
        OrganInfoEntity organInfoEntity = organInfoDao.getEntityKey(organInfoKey);


        //合伙企业的执行事务合伙人为无限责任
        if (MacroDefine.ORGAN_TYPE.ORGAN_TYPE_1.getValue().equals(organInfoEntity.getOrgantype()) && MacroDefine
                .POSITION_TYPE.POSITION_TYPE_0.getValue().equals(partnertype)) {
            for (HashMap<String, Object> mmap : memberList) {
                if ("10".equals(StringUtil.valueOf(mmap.get("position"))) && partnername.equals(StringUtil.valueOf
                        (mmap.get("username")))) {
                    if (!"1".equals(StringUtil.valueOf(mmap.get("dutyway")))) { //dutyway-承担责任方式
                       // rs.failed("执行事务合伙人类型为‘个人’时，其【承担责任方式】应为‘无限责任’");
                        return false;
                    }
                }
            }
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


        return super.clear(mapParam, rs);
    }


}
