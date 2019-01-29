package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.entity.OrganFlowEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.entity.OrganRollinEntity;
import com.msjf.finance.cas.common.dao.key.OrganFlowKey;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
import com.msjf.finance.cas.common.dao.persistence.CustDao;
import com.msjf.finance.cas.common.dao.persistence.OrganFlowDao;
import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.dao.persistence.OrganRollinDao;
import com.msjf.finance.cas.common.joindao.persistence.OrganInfoJoinDao;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.MacroDefine;
import com.msjf.finance.cas.modules.util.SpringContextUtil;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    此类定义企业相关服务的一些公共方法和常量
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 8:42
 */
public class BaseService extends IBaseService {

    /**
     * 企业名称唯一性检查
     *
     * @param organName 企业名称
     * @param rs        结果集
     * @return false 失败  true 成功
     */
    public static boolean checkOrganName(String organName, Response rs) {

        //获取：企业迁入基本信息表 持久层操作dao
        OrganRollinDao organRollinDao = SpringContextUtil.getBean("organRollinDao");
        //获取:企业基本信息表 持久层操作dao
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        //获取：自定义dao
        OrganInfoJoinDao organInfoJoinDao = SpringContextUtil.getBean("organInfoJoinDao");

        //1-企业基本信息表检查
        OrganInfoEntity organInfoEntity = new OrganInfoEntity();
        organInfoEntity.setMembername(organName);
        List<OrganInfoEntity> organInfoEntityList = organInfoDao.getListEntity(organInfoEntity);
        if (!CheckUtil.isNull(organInfoEntityList) && organInfoEntityList.size() > 1) {
            rs.fail(serviceName, "企业名称已存在");
            return false;
        }

        //2-在变更记录表检查最新记录企业名称是否已存在
        HashMap<String, Object> mapParam = new HashMap<>();
        mapParam.put("memberName", organName);
        List<Map<String, Object>> checkListMap = organInfoJoinDao.checkExistCompanyNameInChange(mapParam);
        if (!CheckUtil.isNull(checkListMap)) {
            rs.fail(serviceName, "企业名称已存在");
            return false;
        }

        //3-企业迁入表检查
        OrganRollinEntity rollinEntity = new OrganRollinEntity();
        rollinEntity.setCompanyname(organName);
        List<OrganRollinEntity> organRollinEntityList = organRollinDao.getListEntity(rollinEntity);
        if (!CheckUtil.isNull(organRollinEntityList)) {
            rs.fail(serviceName, "企业名称已存在");
            return false;
        }
        return true;
    }

    /**
     * 根据企业代码检查企业基本信息是否存在
     *
     * @param orgCustomerNo 企业客户代码
     * @param rs            结果集
     * @return false 失败  true 成功
     */
    protected boolean CheckOranInfo(String orgCustomerNo, Response rs) {
        //获取：企业迁入基本信息表 持久层操作dao
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        OrganInfoKey organInfoKey = new OrganInfoKey();
        organInfoKey.setKey(orgCustomerNo);
        OrganInfoEntity organInfoEntity = organInfoDao.getEntityKey(organInfoKey);
        if (CheckUtil.isNull(organInfoEntity)) {
            rs.fail(serviceName, "企业基本信息不存在");
            return false;
        }
        return true;
    }

    /**
     * 根据实体更新企业基本信息表
     *
     * @param rs
     * @param organInfoEntity
     * @return false 失败  true 成功
     */
    protected boolean updateOrganInfoEntity(OrganInfoEntity organInfoEntity, Response rs) {
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        try {
            Integer row = organInfoDao.updEntity(organInfoEntity);
            if (row != 1) {
                throw new RuntimeException("organ_info更新失败");
            }
            return true;
        } catch (Exception e) {
            rs.fail(serviceName, "organ_info更新失败");
            logger.error(serviceName, "organ_info更新失败", e);
            throw new RuntimeException("organ_info更新失败", e);
        }
    }

    /**
     * 根据实体新增企业基本信息表
     *
     * @param rs
     * @param organInfoEntity
     * @return false 失败  true 成功
     */
    protected boolean insertOrganInfoEntity(OrganInfoEntity organInfoEntity, Response rs) {
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        try {
            Integer row = organInfoDao.insEntity(organInfoEntity);
            if (row != 1) {
                throw new RuntimeException("organ_info新增失败");
            }
            return true;
        } catch (Exception e) {
            rs.fail(serviceName, "organ_info新增失败");
            logger.error(serviceName, "organ_info新增失败", e);
            throw new RuntimeException("organ_info新增失败", e);
        }
    }

    /**
     * 根据实体更新cust表数据
     *
     * @param entity cust实体
     * @param rs     结果集
     * @return false 失败  true 成功
     */
    protected boolean updateCustEntity(CustEntity entity, Response rs) {
        CustDao custDao = SpringContextUtil.getBean("custDao");
        try {
            Integer row = custDao.updEntity(entity);
            if (row != 1) {
                throw new RuntimeException("cus更新失败");
            }
            return true;
        } catch (Exception e) {
            rs.fail(serviceName, "cus更新失败");
            logger.error(serviceName, "cus更新失败", e);
            throw new RuntimeException("cus更新失败", e);
        }
    }

    /**
     * 根据实体更新cust表数据
     *
     * @param entity cust实体
     * @param rs     结果集
     * @return false 失败  true 成功
     */
    protected boolean insertCustEntity(CustEntity entity, Response rs) {
        CustDao custDao = SpringContextUtil.getBean("custDao");
        try {
            Integer row = custDao.insEntity(entity);
            if (row != 1) {
                throw new RuntimeException("cus新增失败");
            }
            return true;
        } catch (Exception e) {
            rs.fail(serviceName, "cus新增失败");
            logger.error(serviceName, "cus新增失败", e);
            throw new RuntimeException("cus新增失败", e);
        }
    }

    /**
     * 根据实体更新organ_flow表数据
     *
     * @param organFlowEntity 实体
     * @param rs              结果集
     * @return false 失败  true 成功
     */
    protected boolean updateOrganFlowEntity(OrganFlowEntity organFlowEntity, Response rs) {
        OrganFlowDao organFlowDao = SpringContextUtil.getBean("organFlowDao");
        try {
            Integer row = organFlowDao.updEntity(organFlowEntity);
            if (row != 1) {
                throw new RuntimeException("organ_flow更新失败");
            }
            return true;
        } catch (Exception e) {
            rs.fail(serviceName, "organ_flow更新失败");
            logger.error(serviceName, "organ_flow更新失败", e);
            throw new RuntimeException("organ_flow更新失败", e);
        }
    }

    /**
     * 根据实体organ_flow新增表数据
     *
     * @param organFlowEntity 实体
     * @param rs              结果集
     * @return false 失败  true 成功
     */
    protected boolean insertOrganFlowEntity(OrganFlowEntity organFlowEntity, Response rs) {
        OrganFlowDao organFlowDao = SpringContextUtil.getBean("organFlowDao");
        try {
            Integer row = organFlowDao.insEntity(organFlowEntity);
            if (row != 1) {
                throw new RuntimeException("organ_flow新增失败");
            }
            return true;
        } catch (Exception e) {
            rs.fail(serviceName, "organ_flow新增失败");
            logger.error(serviceName, "organ_flow新增失败", e);
            throw new RuntimeException("organ_flow新增失败", e);
        }
    }

    /**
     * 根据客户代码检查客户信息是否存在
     *
     * @param rs
     * @return
     */
    protected boolean CheckCustomerInfo(String customerNo, Response rs) {
        CustDao custDao = SpringContextUtil.getBean("custDao");
        CustEntity custEntity = new CustEntity();
        custEntity.setCustomerno(customerNo);
        List<CustEntity> customerEntityList = custDao.getListEntity(custEntity);
        if (CheckUtil.isNull(customerEntityList)) {
            rs.fail(serviceName, "发起人账户信息不存在");
            return false;
        }
        return true;
    }

    /**
     * 检查企业设立/变更申请下 成员信息是否存在空白字段
     *
     * @param memberList 投资人/合伙人信息
     * @param rs         结果集
     * @return false 失败 true 成功
     */
    protected static boolean checkOrganMemberParam(List<HashMap> memberList, Response rs) {
        for (HashMap<String, Object> a : memberList) {
            //成员信息检查
            if (CheckUtil.checkNull(a.get("username"), serviceName, "成员信息[姓名]", rs)) {
                return false;
            }
            if (CheckUtil.checkNull(a.get("certificatetype"), serviceName, "成员信息[证件类型]", rs)) {
                return false;
            }
            if (CheckUtil.checkNull(a.get("certificateno"), serviceName, "成员信息[证件号]", rs)) {
                return false;
            }
            if (CheckUtil.checkNull(a.get("mobile"), serviceName, "成员信息[手机号码]", rs) && (MacroDefine.POSITION_TYPE
                    .POSITION_TYPE_0.getValue().equals(a.get("position")) || MacroDefine.POSITION_TYPE
                    .POSITION_TYPE_1.getValue().equals(a.get("position")))) {
                rs.fail(serviceName, "联络员和财务负责人[手机号码]不能为空");
                return false;
            }
            if (CheckUtil.checkNull(a.get("position"), serviceName, "成员信息[身份类型]", rs)) {
                return false;
            }
            //10-股东 即投资人 合伙人流表数据
            if (MacroDefine.POSITION_TYPE.POSITION_TYPE_10.getValue().equals(a.get("position"))) {
                if (CheckUtil.checkNull(a.get("dutyway"), serviceName, "成员信息[承担责任方式]", rs)) {
                    return false;
                }
                if (CheckUtil.checkNull(a.get("dutyway"), serviceName, "成员信息[出资方式]", rs)) {
                    return false;
                }
                if (CheckUtil.checkNull(a.get("amount"), serviceName, "成员信息[认缴出资额]", rs)) {
                    return false;
                }
                if (CheckUtil.checkNull(a.get("paydatelimit"), serviceName, "成员信息[缴付期限]", rs)) {
                    return false;
                }
                if (CheckUtil.checkNull(a.get("address"), serviceName, "成员信息[住所]", rs)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 根据 企业客户代码和流程类型查询流程信息
     * @param orgCustomerNo 企业客户代码
     * @param flowType 流程类型
     * @return OrganFlowEntity 企业业务流程信息表
     */
    protected OrganFlowEntity getOrganFlowEntity(String orgCustomerNo,String flowType) {
        OrganFlowDao organFlowDao = SpringContextUtil.getBean(OrganFlowDao.class);
        OrganFlowKey organFlowKey = new OrganFlowKey();
        organFlowKey.setKey(orgCustomerNo, flowType);
        return organFlowDao.getEntityKey(organFlowKey);
    }

}
