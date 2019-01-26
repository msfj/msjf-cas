package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.entity.OrganRollinEntity;
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
        if (!CheckUtil.isNull(organInfoEntityList)) {
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

}
