package com.msjf.finance.cas.modules.branch.service.impl;


import com.msjf.finance.cas.common.dao.entity.BranchEntity;
import com.msjf.finance.cas.common.dao.entity.EmployeeEntity;
import com.msjf.finance.cas.common.dao.key.BranchKey;
import com.msjf.finance.cas.common.dao.persistence.BranchDao;
import com.msjf.finance.cas.common.dao.persistence.EmployeeDao;
import com.msjf.finance.cas.common.joindao.persistence.BranchJoinDao;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.branch.service.BranchService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.msjf.finance.cas.modules.Account.Account.BRANCH_TYPE_BM;
import static com.msjf.finance.cas.modules.Account.Account.BRANCH_TYPE_JG;

/**
 * Created by Jsan on 2019/1/24.
 */

@Service("branchService")
@Transactional
public class BranchServiceImpl implements BranchService {

    @Resource
    BranchDao branchDao;

    @Resource
    EmployeeDao employeeInfoDao;

    @Resource
    BranchJoinDao branchJoinDao;

    @Override
    public Response insBranchInfo(BranchEntity branchEntity) throws RuntimeException{
        Response re = new Response();
        try {
            int i = branchDao.insEntity(branchEntity);
            re.success("1","操作成功",i);
        }catch (Exception e){
            e.printStackTrace();
            re.fail("0","操作失败");
        }

        return re;
    }

    @Override
    public Response delBranchInfo(Map<String, Object> mapParams) throws RuntimeException{
        Response re = new Response();
        if(StringUtils.isEmpty(mapParams.get("branchid"))){
            return new Response().fail("0","branchid不能为空");
        }
        String branchid = (String)mapParams.get("branchid");
        try {
            BranchEntity b = new BranchEntity();
            b.setBranchid(branchid);
            List<BranchEntity> list = branchDao.getListEntity(b);
            if(ObjectUtils.isEmpty(list)){
                return new Response().fail("0","操作失败,当前部门id不存在");
            }
            BranchEntity branchEntity = list.get(0);
            if(BRANCH_TYPE_JG.equals(branchEntity.getBranchtype())){
                return new Response().fail("0","操作失败,不能删除机构");
            }
            Map<String, Object> parentMap = new HashMap();
            BranchEntity c = new BranchEntity();
            c.setParentid(branchEntity.getBranchid());
            List<BranchEntity> sonlist = branchDao.getListEntity(c);
            if(!ObjectUtils.isEmpty(sonlist)){
                return new Response().fail("0","操作失败,当前部门存在子部门，请先删除子部门后再进行删除");
            }
            EmployeeEntity entity = new EmployeeEntity();
            entity.setBranchid(branchEntity.getBranchid());
            List<EmployeeEntity> emlist = employeeInfoDao.getListEntity(entity);
            if(!ObjectUtils.isEmpty(emlist)){
                return new Response().fail("0","操作失败,当前部门存在员工，请先删除员工后再进行删除");
            }
            BranchKey key = new BranchKey();
            key.setBranchid(branchEntity.getBranchid());
            int i = branchDao.delEntityKey(key);
            re.success("1","删除成功",i);
        }catch (Exception e){
            e.printStackTrace();
            re.fail("0","操作失败");
        }

        return re;
    }

    @Override
    public Response updBranchInfo(BranchEntity branchEntity) throws RuntimeException{
        Response re = new Response();
        if(ObjectUtils.isEmpty(branchEntity.getBranchname())){
            return new Response().fail("0","部门名称不能为空");
        }
        try {
            BranchEntity a =new BranchEntity();
            a.setBranchname(branchEntity.getBranchname());
            List<BranchEntity> namelist = branchDao.getListEntity(a);
            Integer i = 0;
            if(ObjectUtils.isEmpty(branchEntity.getBranchid())){
                if(!ObjectUtils.isEmpty(namelist)){
                    return new Response().fail("0","当前部门名称已存在");
                }
                branchEntity.setBranchid(StringUtil.getUUID());
                branchEntity.setBranchtype(BRANCH_TYPE_BM);
                i= branchDao.insEntity(branchEntity);
            }else{
                if(!ObjectUtils.isEmpty(namelist)&&!namelist.get(0).getBranchid().equals(branchEntity.getBranchid())){
                    return new Response().fail("0","当前部门名称已存在");
                }
                i=branchDao.updEntity(branchEntity);
            }
            re.success("1","操作成功",i);
        }catch (Exception e){
            e.printStackTrace();
            re.fail("0","操作失败");
        }

        return re;
    }

    @Override
    public Response queryBranch(Map<String, Object> mapParams) throws RuntimeException{
        Response re = new Response();
        try {
            List<BranchEntity> list = branchJoinDao.queryBranch(mapParams);
            re.success("1","操作成功",list);
        }catch (Exception e){
            e.printStackTrace();
            re.fail("0","操作失败");
        }

        return re;
    }
}
