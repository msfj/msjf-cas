package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.InviteCodeEntity;
import com.msjf.finance.cas.common.dao.key.InviteCodeKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface InviteCodeDao extends IBaseDao<InviteCodeEntity,InviteCodeKey> {
}