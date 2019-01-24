package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.OrganMemberEntity;
import com.msjf.finance.cas.common.dao.key.OrganMemberKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface OrganMemberDao extends IBaseDao<OrganMemberEntity,OrganMemberKey> {
}