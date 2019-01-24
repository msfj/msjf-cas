package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.BranchEntity;
import com.msjf.finance.cas.common.dao.key.BranchKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @author 
 */
@MyBatisDao
public interface BranchDao extends IBaseDao<BranchEntity,BranchKey> {

    List<BranchEntity> queryBranch(Map<String, Object> mapParams);
}