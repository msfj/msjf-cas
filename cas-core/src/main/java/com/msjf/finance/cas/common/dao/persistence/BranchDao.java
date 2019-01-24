package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.BranchEntity;
import com.msjf.finance.cas.common.dao.key.BranchKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface BranchDao extends IBaseDao<BranchEntity,BranchKey> {
}