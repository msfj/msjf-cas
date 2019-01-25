package com.msjf.finance.cas.modules.organ.service;

import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.dao.persistence.OrganRollinDao;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.entity.OrganRollinEntity;
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
public class BaseService extends IBaseService{


    /**
     * 企业名称唯一性检查
     *
     * @param organName 企业名称
     * @param rs 结果集
     * @return false 失败  true 成功
     */
    public static boolean checkOrganName(String organName, Response rs) {

        //
        OrganRollinDao organRollinDao = SpringContextUtil.getBean("organRollinDao");
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");

        //1-企业基本信息表检查
        OrganInfoEntity c = new OrganInfoEntity();
        c.setMembername(organName);
        List<OrganInfoEntity> clist = organInfoDao.getListEntity(c);
        if (clist!= null || clist.size() > 0) {
            rs.fail("cas","企业名称已存在");
            return false;
        }

        //2-在变更记录表检查企业名称是否已存在
        HashMap<String, Object> mapParam = new HashMap<>();
        mapParam.put("membername", organName);
        //todo 此处需修改
        List<Map<String, Object>> checkListMap = null;//organInfoDao.checkExistCompanynameInChange(mapParam);
        if (!CheckUtil.isNull(checkListMap)) {
            rs.fail("cas","企业名称已存在");
            return false;
        }

        //3-企业迁入表检查
        OrganRollinEntity rollinEntity = new OrganRollinEntity();
        rollinEntity.setCompanyname(organName);
        List<OrganRollinEntity> organRollinEntityList = organRollinDao.getListEntity(rollinEntity);
        if (!CheckUtil.isNull(organRollinEntityList)) {
            rs.fail("cas","企业名称已存在");
            return false;
        }
        return true;
    }

}
