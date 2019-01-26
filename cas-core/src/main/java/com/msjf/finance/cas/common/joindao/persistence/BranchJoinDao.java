package com.msjf.finance.cas.common.joindao.persistence;

import com.msjf.finance.cas.common.dao.entity.BranchEntity;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface BranchJoinDao {

    List<BranchEntity> queryBranch(Map<String, Object> mapParams);
}
