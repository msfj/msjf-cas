package com.msjf.finance.cas.common.joindao.persistence;

import com.msjf.finance.cas.common.dao.entity.MemberSubmitEntity;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-26 10:07
 */
@MyBatisDao
public interface OrganInfoJoinDao {

    /**
     * 在变更记录表检查企业名称是否已存在
     * @param mapParam 入参
     * @return List<Map<String,Object>>
     */
    List<Map<String,Object>> checkExistCompanyNameInChange(HashMap<String,Object> mapParam);


    /**
     * 根据企业代码删除企业迁入信息(企业成员申报信息表)
     * @param memberSubmitEntity  企业成员申报信息实体
     * @return Integer 删除条数
     */
    Integer delMemberSubmitByCustomerNo(MemberSubmitEntity memberSubmitEntity);

}
