package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.MemberSubmitEntity;
import com.msjf.finance.cas.common.dao.key.MemberSubmitKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface MemberSubmitDao extends IBaseDao<MemberSubmitEntity,MemberSubmitKey> {
}