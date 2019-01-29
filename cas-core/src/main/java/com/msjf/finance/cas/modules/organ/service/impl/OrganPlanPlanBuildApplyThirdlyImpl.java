package com.msjf.finance.cas.modules.organ.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.msjf.finance.cas.common.dao.entity.MemberSubmitEntity;
import com.msjf.finance.cas.common.dao.entity.OrganFlowEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
import com.msjf.finance.cas.common.dao.persistence.MemberSubmitDao;
import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.joindao.persistence.OrganInfoJoinDao;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.DateUtils;
import com.msjf.finance.cas.common.utils.EntityUtil;
import com.msjf.finance.cas.common.utils.IDUtils;
import com.msjf.finance.cas.common.utils.MacroDefine;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.organ.facade.OrganServiceFacadeImpl;
import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.cas.modules.util.SpringContextUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 * 描述:
 *    添加拟设立-第三步
 *  <pre/>
 * @author 95494
 * @create 2019-01-27 15:39
 */
@Service
public class OrganPlanPlanBuildApplyThirdlyImpl extends BaseService {

    private static final Logger logger = LogManager.getLogger(OrganPlanPlanBuildApplyThirdlyImpl.class);

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
     * 企业基本信息
     */
    private OrganInfoEntity organInfoEntity;


    //==================TODO 备用属性-暂时未用到==========================//

    /**
     * 是否存在董事会 0-否 1-是 -有限公司属性
     */
    private String isboard;

    /**
     * 是否存在监事会 0-否 1-是 -有限公司属性
     */
    private String issupervision;

    //==================TODO 备用属性-暂时未用到==========================//


    /**
     * 添加拟设立-第三步
     *
     * @param mapParam 入参
     * @param rs
     * @return Response 返回结果
     */
    @Transactional(rollbackFor = Exception.class, timeout = 30000)
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
            logger.debug(serviceName,"memberinfo数据格式不合法", e);
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
     * 缓存数据
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean cache(HashMap<String, Object> mapParam, Response rs) {
        //2-根据主键缓存企业基本信息
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        OrganInfoKey organInfoKey = new OrganInfoKey();
        organInfoKey.setKey(orgcustomerno);
        organInfoEntity = organInfoDao.getEntityKey(organInfoKey);
        return super.cache(mapParam, rs);
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
        //2-检查企业基本信息是否存在
        if (CheckUtil.isNull(organInfoEntity)) {
            rs.fail(serviceName, "企业基本信息不存在");
            return false;
        }

        //3-合伙企业的执行事务合伙人为无限责任
        if (MacroDefine.ORGAN_TYPE.ORGAN_TYPE_1.getValue().equals(organInfoEntity.getOrgantype()) && MacroDefine
                .PARTNER_TYPE.PARTNER_TYPE_0.getValue().equals(partnertype)) {
            for (HashMap<String, Object> memberMap : memberList) {
                if (MacroDefine.POSITION_TYPE.POSITION_TYPE_10.getValue().equals(memberMap.get("position")) &&
                        partnername.equals(memberMap.get("username"))) {
                    //dutyWay-承担责任方式
                    if (!MacroDefine.DUTY_WAY_TYPE.DUTY_WAY_TYPE_1.getValue().equals(memberMap.get("dutyway"))) {
                        rs.fail(serviceName, "执行事务合伙人类型为【个人】时，其【承担责任方式】应为【无限责任】");
                        return false;
                    }
                }
            }
        }

        //4-合伙企业的承担责任方式必有一个为无限责任
        if (MacroDefine.ORGAN_TYPE.ORGAN_TYPE_1.getValue().equals(organInfoEntity.getOrgantype())) {
            Integer count = 0;
            for (HashMap<String, Object> mmap : memberList) {
                //dutyWay-承担责任方式
                if (MacroDefine.DUTY_WAY_TYPE.DUTY_WAY_TYPE_1.getValue().equals(StringUtil.valueOf(mmap.get
                        ("dutyway")))) {
                    count++;
                }
            }
            if (count <= 0) {
                rs.fail(serviceName, "合伙企业至少有一个投资者的【承担责任方式】为【无限责任】");
                return false;
            }
        }

        //5-没有董事会就没有董事长，但是只有一个执行董事
        if (MacroDefine.ORGAN_TYPE.ORGAN_TYPE_0.getValue().equals(organInfoEntity.getOrgantype()) && MacroDefine.NO
                .equals(isboard)) {
            //董事长数量
            Integer countOne = 0;
            //执行董事数量
            Integer countTwo = 0;
            for (HashMap<String, Object> meberMap : memberList) {
                //position - 身份类型 3.董事长
                if (MacroDefine.POSITION_TYPE.POSITION_TYPE_3.getValue().equals(StringUtil.valueOf(meberMap.get
                        ("position")))) {
                    countOne++;
                }
                //position - 身份类型 2.执行董事
                if (MacroDefine.POSITION_TYPE.POSITION_TYPE_2.getValue().equals(StringUtil.valueOf(meberMap.get
                        ("position")))) {
                    countTwo++;
                }
            }
            if (countOne > 0) {
                rs.fail(serviceName, "公司不存在董事会,不应有董事长");
                return false;
            }
            if (countTwo != 1) {
                rs.fail(serviceName, "公司不存在董事会,只能有一个执行董事");
                return false;
            }
        }

        //6-没有监事会就没有监事长，但是可以有两个监事，三个及以上监事要成立监事会，所以一般公司基本都是一个监事。
        if (MacroDefine.ORGAN_TYPE.ORGAN_TYPE_0.getValue().equals(organInfoEntity.getOrgantype()) && "0".equals
                (issupervision)) {
            //监事长数量
            Integer countOne = 0;
            //监事数量
            Integer countTwo = 0;
            for (HashMap<String, Object> memberMap : memberList) {
                //position - 身份类型 6.监事长
                if (MacroDefine.POSITION_TYPE.POSITION_TYPE_6.getValue().equals(StringUtil.valueOf(memberMap.get
                        ("position")))) {
                    countOne++;
                }
                //position - 身份类型 7.监事
                if (MacroDefine.POSITION_TYPE.POSITION_TYPE_7.equals(StringUtil.valueOf(memberMap.get("position")))) {
                    countTwo++;
                }
            }
            if (countOne > 0) {
                rs.fail(serviceName, "公司不存在监事会,不应有监事长");
                return false;
            }
            if (countOne == 0 || countTwo > 3) {
                rs.fail(serviceName, "公司不存在监事会,可以有一个或者两个监事");
                return false;
            }
        }

        //7-根据企业客户代码和流程类型查询是否有正在执行的流程
        OrganFlowEntity organFlowEntityZero = getOrganFlowEntity(orgcustomerno, MacroDefine.FLOW_TYPE
                .FLOW_TYPE_0.getValue());
        if (!CheckUtil.isNull(organFlowEntityZero)) {
            if (MacroDefine.AUDIT_STATUS.AUDIT_STATUS_APPLY.getValue().equals(organFlowEntityZero.getStatus())) {
                rs.fail(serviceName, "流程处理中，不可修改");
                return false;
            }
        }

        //8-根据企业客户代码和流程类型查询是否有企业设立流程正在处理中或者已经设立完成
        OrganFlowEntity organFlowEntityOne = getOrganFlowEntity(orgcustomerno, MacroDefine.FLOW_TYPE
                .FLOW_TYPE_1.getValue());
        if (!CheckUtil.isNull(organFlowEntityOne)) {
            if (MacroDefine.AUDIT_STATUS.AUDIT_STATUS_APPLY.getValue().equals(organFlowEntityOne.getStatus()) ||
                    MacroDefine.AUDIT_STATUS.AUDIT_STATUS_PASS.getValue().equals(organFlowEntityOne.getStatus())) {
                rs.fail(serviceName, "信息补充流程已提交或已完成，不可修改");
                return false;
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

        //1-写成员申报信息表
        if(!addMemberSubmit(rs)){
            return false;
        }
        //2-更新企业基本信息表
        if(!updOrganInfo(rs)){
            return false;
        }
        rs.success( "操作成功");
        return super.clear(mapParam, rs);
    }


    /**
     * 写成员申报信息表
     *
     * @param rs 结果集
     * @return false 失败  true 成功
     */
    private boolean addMemberSubmit(Response rs) {

        OrganInfoJoinDao organInfoJoinDao = SpringContextUtil.getBean(OrganInfoJoinDao.class);
        MemberSubmitDao memberSubmitDao = SpringContextUtil.getBean(MemberSubmitDao.class);
        //修改成员申报表时，删除再添加
        MemberSubmitEntity delEntity = new MemberSubmitEntity();
        delEntity.setCustomerno(orgcustomerno);
        organInfoJoinDao.delMemberSubmitByCustomerNo(delEntity);

        List<MemberSubmitEntity> submitEntityList = new ArrayList<>();
        for (HashMap<String, Object> memberMap : memberList) {
            MemberSubmitEntity memberSubmitEntity = (MemberSubmitEntity) EntityUtil.mapToEntity(memberMap,
                    MemberSubmitEntity.class);
            memberSubmitEntity.setSerialno(StringUtil.valueOf(IDUtils.genItemId()));
            memberSubmitEntity.setCustomerno(orgcustomerno);
            memberSubmitEntity.setVersion(1);
            memberSubmitEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            memberSubmitEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
            memberSubmitEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            memberSubmitEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
            submitEntityList.add(memberSubmitEntity);
        }
        if(!CheckUtil.isNull(submitEntityList)){
            memberSubmitDao.insEntityBatch(submitEntityList);
        }
        return true;
    }

    /**
     * 更新企业基本信息表
     *
     * @param
     */
    private boolean updOrganInfo(Response rs) {
        OrganInfoEntity organInfoEntity = new OrganInfoEntity();
        organInfoEntity.setCustomerno(orgcustomerno);
        organInfoEntity.setIsboard(isboard);
        organInfoEntity.setIssupervision(issupervision);
        organInfoEntity.setPartnertype(partnertype);
        organInfoEntity.setPartnername(partnername);
        organInfoEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
        organInfoEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
        return updateOrganInfoEntity(organInfoEntity, rs);
    }

}
