package com.msjf.finance.cas.facade.branch;

import com.msjf.finance.cas.facade.branch.domain.BranchDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.Map;

/**
 * Created by Jsan on 2019/1/24.
 */
public interface BranchFacade {

    Response delBranchInfo(BranchDomain branchDomain)throws RuntimeException;

    Response updBranchInfo(BranchDomain branchDomain)throws RuntimeException;

    Response queryBranch(BranchDomain branchDomain)throws RuntimeException;
}
