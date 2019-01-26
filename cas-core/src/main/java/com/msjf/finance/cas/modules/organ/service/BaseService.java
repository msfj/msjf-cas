package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.entity.OrganFlowEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.entity.OrganRollinEntity;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
import com.msjf.finance.cas.common.dao.persistence.CustDao;
import com.msjf.finance.cas.common.dao.persistence.OrganFlowDao;
import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.dao.persistence.OrganRollinDao;
import com.msjf.finance.cas.common.joindao.persistence.OrganInfoJoinDao;
import com.msjf.finance.cas.common.utils.CheckUtil;
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
        if (!CheckUtil.isNull(organInfoEntityList)&&organInfoEntityList.size()>1) {
            rs.fail("cas", "企业名称已存在");
            return false;
        }

        //2-在变更记录表检查最新记录企业名称是否已存在
        HashMap<String, Object> mapParam = new HashMap<>();
        mapParam.put("memberName", organName);
        List<Map<String, Object>> checkListMap = organInfoJoinDao.checkExistCompanyNameInChange(mapParam);
        if (!CheckUtil.isNull(checkListMap)) {
            rs.fail("cas", "企业名称已存在");
            return false;
        }

        //3-企业迁入表检查
        OrganRollinEntity rollinEntity = new OrganRollinEntity();
        rollinEntity.setCompanyname(organName);
        List<OrganRollinEntity> organRollinEntityList = organRollinDao.getListEntity(rollinEntity);
        if (!CheckUtil.isNull(organRollinEntityList)) {
            rs.fail("cas", "企业名称已存在");
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
            rs.fail("cas", "企业基本信息不存在");
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
            rs.fail("cas", "organ_info更新失败");
            logger.error("cas", "organ_info更新失败", e);
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
            rs.fail("cas", "organ_info新增失败");
            logger.error("cas", "organ_info新增失败", e);
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
            rs.fail("cas", "cus更新失败");
            logger.error("cas", "cus更新失败", e);
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
            rs.fail("cas", "cus新增失败");
            logger.error("cas", "cus新增失败", e);
            throw new RuntimeException("cus新增失败", e);
        }
    }

    /**
     * 根据实体更新organ_flow表数据
     *
     * @param organFlowEntity 实体
     * @param rs     结果集
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
            rs.fail("cas", "organ_flow更新失败");
            logger.error("cas", "organ_flow更新失败", e);
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
            rs.fail("cas", "organ_flow新增失败");
            logger.error("cas", "organ_flow新增失败", e);
            throw new RuntimeException("organ_flow新增失败", e);
        }
    }
}
