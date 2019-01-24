package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.OrganFlowEntity;
import com.msjf.finance.cas.common.dao.key.OrganFlowKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface OrganFlowDao extends IBaseDao<OrganFlowEntity,OrganFlowKey> {
}