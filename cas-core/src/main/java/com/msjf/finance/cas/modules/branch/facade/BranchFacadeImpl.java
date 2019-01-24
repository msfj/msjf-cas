package com.msjf.finance.cas.modules.branch.facade;

import com.msjf.finance.cas.common.dao.entity.BranchEntity;
import com.msjf.finance.cas.facade.branch.BranchFacade;
import com.msjf.finance.cas.facade.branch.domain.BranchDomain;
import com.msjf.finance.cas.modules.branch.service.BranchService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 2019/1/24.
 */
@Service("branchFacade")
public class BranchFacadeImpl implements BranchFacade {

    @Resource
    BranchService branchService;

    @Override
    public Response delBranchInfo(BranchDomain branchDomain) throws RuntimeException {
        Map<String, Object> map = new HashMap();
        map.put("branchid",branchDomain.getBranchid());
        return branchService.delBranchInfo(map);
    }

    @Override
    public Response updBranchInfo(BranchDomain branchDomain) throws RuntimeException {
        BranchEntity branchEntity = new BranchEntity();
        BeanUtils.copyProperties(branchDomain, branchEntity);
        return branchService.updBranchInfo(branchEntity);
    }

    @Override
    public Response queryBranch(BranchDomain branchDomain) throws RuntimeException {
        Map<String, Object> map = new HashMap();
        map.put("branchid",branchDomain.getBranchid());
        map.put("branchname",branchDomain.getBranchname());
        return branchService.queryBranch(map);
    }
}
