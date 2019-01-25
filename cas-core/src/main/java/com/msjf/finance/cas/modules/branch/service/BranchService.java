package com.msjf.finance.cas.modules.branch.service;


import com.msjf.finance.cas.common.dao.entity.BranchEntity;
import com.msjf.finance.msjf.core.response.Response;

import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2019/1/24.
 */
public interface BranchService {

    /**
     * 新增部门基本信息表
     */
    Response insBranchInfo(BranchEntity branchEntity) throws RuntimeException;


    Response delBranchInfo(Map<String, Object> mapParams)throws RuntimeException;

    Response updBranchInfo(BranchEntity branchEntity)throws RuntimeException;

    Response queryBranch(Map<String, Object> mapParams)throws RuntimeException;

}
