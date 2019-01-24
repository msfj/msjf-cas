package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.MemberSubmitChangeEntity;
import com.msjf.finance.cas.common.dao.key.MemberSubmitChangeKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface MemberSubmitChangeDao extends IBaseDao<MemberSubmitChangeEntity,MemberSubmitChangeKey> {
}