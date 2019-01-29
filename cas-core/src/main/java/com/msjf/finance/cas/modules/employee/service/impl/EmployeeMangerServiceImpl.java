package com.msjf.finance.cas.modules.employee.service.impl;


import com.github.pagehelper.PageHelper;
import com.msjf.finance.cas.common.dao.entity.AusAuthoneEntity;
import com.msjf.finance.cas.common.dao.entity.EmployeeEntity;
import com.msjf.finance.cas.common.dao.key.AusAuthoneKey;
import com.msjf.finance.cas.common.dao.key.EmployeeKey;
import com.msjf.finance.cas.common.dao.persistence.AusAuthoneDao;
import com.msjf.finance.cas.common.dao.persistence.EmployeeDao;
import com.msjf.finance.cas.common.joindao.persistence.EmployeeJoinDao;
import com.msjf.finance.cas.common.utils.DateUtils;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.employee.service.EmployeeMangerService;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.msjf.core.page.Page;
import com.msjf.finance.msjf.core.page.PageUtils;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.msjf.finance.cas.common.utils.DateUtils.DATE_FMT_DATE;
import static com.msjf.finance.cas.common.utils.DateUtils.DATE_FMT_TIME;
import static com.msjf.finance.cas.modules.Account.Account.CERTIFICATETYPE_0;
import static com.msjf.finance.cas.modules.Account.Account.STATUS_0;
import static com.msjf.finance.cas.modules.Account.Account.SYS_INIT_PASSWORD;

/**
 * Created by cheng on 2019/1/25.
 */
@Service("employeeMangerService")
@Transactional
public class EmployeeMangerServiceImpl implements EmployeeMangerService {

    @Resource
    EmployeeDao dao;

    @Resource
    AusAuthoneDao authoneDao;

    @Resource
    EmployeeJoinDao joinDao;

    @Override
    public Response insEmployee(EmployeeEntity employeeEntity)throws RuntimeException {
        Response response = new Response();
        if(!check(employeeEntity,response)){
            return response;
        }
        try{
            EmployeeEntity a = new EmployeeEntity();
            a.setCertificateno(employeeEntity.getCertificateno());
            List<EmployeeEntity> alist = dao.getListEntity(a);
            if(!ObjectUtils.isEmpty(alist)){
                return new Response().fail("0","当前证件号码已被使用");
            }
            EmployeeEntity b = new EmployeeEntity();
            b.setLoginname(employeeEntity.getLoginname());
            List<EmployeeEntity> blist = dao.getListEntity(b);
            if(!ObjectUtils.isEmpty(blist)){
                return new Response().fail("0","当前登陆账号已被使用");
            }
            String custno = StringUtil.getUUID();
            employeeEntity.setCustomerno(custno);
            employeeEntity.setCertificatetype(CERTIFICATETYPE_0);
            employeeEntity.setStatus(STATUS_0);
            employeeEntity.setInsertdate(DateUtils.getUserDate(DATE_FMT_DATE));
            employeeEntity.setInserttime(DateUtils.getUserDate(DATE_FMT_TIME));
            dao.insEntity(employeeEntity);
            AusAuthoneEntity authoneEntity = new AusAuthoneEntity();
            authoneEntity.setCustomerno(custno);
            authoneEntity.setFailcount(0);
            authoneEntity.setPassword(CommonUtil.HmacSHA1Encrypt(SYS_INIT_PASSWORD,custno));
            authoneEntity.setInsertdate(DateUtils.getUserDate(DATE_FMT_DATE));
            authoneEntity.setInserttime(DateUtils.getUserDate(DATE_FMT_TIME));
            authoneDao.insEntity(authoneEntity);
            response.success("1","新增成功","");
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","新增失败");
            throw new RuntimeException(e.getMessage(),e);
        }

        return response;
    }

    private Boolean check(EmployeeEntity employeeEntity,Response re){
        if(ObjectUtils.isEmpty(employeeEntity.getBranchid())){
            re.fail("0","部门id不能为空");
            return  false;
        }
        if(ObjectUtils.isEmpty(employeeEntity.getCertificateno())){
            re.fail("0","证件号码不能为空");
            return  false;
        }
        if(ObjectUtils.isEmpty(employeeEntity.getEmail())){
            re.fail("0","邮箱不能为空");
            return  false;
        }
        if(ObjectUtils.isEmpty(employeeEntity.getMobile())){
            re.fail("0","手机号码不能为空");
            return  false;
        }
        if(ObjectUtils.isEmpty(employeeEntity.getLoginname())){
            re.fail("0","登录账号不能为空");
            return  false;
        }
        if(ObjectUtils.isEmpty(employeeEntity.getEmployeename())){
            re.fail("0","员工名称不能为空");
            return  false;
        }
        return true;
    }

    @Override
    public Response delEmployee(EmployeeKey key) throws RuntimeException{
        Response response = new Response();
        try {
            EmployeeEntity e = dao.getEntityKey(key);
            if(ObjectUtils.isEmpty(e)){
                return  new Response().fail("0","当前员工信息不存在");
            }
            dao.delEntityKey(key);
            AusAuthoneKey authoneKey = new AusAuthoneKey();
            authoneKey.setKey(key.getCustomerno());
            authoneDao.delEntityKey(authoneKey);
            response.success("1","删除成功","");
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","删除失败");
            throw new RuntimeException(e.getMessage(),e);
        }
        return response;
    }

    @Override
    public Response updEmployee(EmployeeEntity employeeEntity) throws RuntimeException{
        Response response = new Response();
        if(!check(employeeEntity,response)){
            return response;
        }
        try{
            EmployeeKey key = new EmployeeKey();
            key.setCustomerno(employeeEntity.getCustomerno());
            EmployeeEntity a = dao.getEntityKey(key);
            if(ObjectUtils.isEmpty(a)){
                return new Response().fail("0","员工信息不存在");
            }
            EmployeeEntity b = new EmployeeEntity();
            b.setCertificateno(employeeEntity.getCertificateno());
            List<EmployeeEntity> alist = dao.getListEntity(b);
            if(!ObjectUtils.isEmpty(alist)&&!alist.get(0).getCustomerno().equals(employeeEntity.getCustomerno())){
                return new Response().fail("0","当前证件号码已被使用");
            }
            employeeEntity.setUpdatedate(DateUtils.getUserDate(DATE_FMT_DATE));
            employeeEntity.setUpdatetime(DateUtils.getUserDate(DATE_FMT_TIME));
            dao.updEntity(employeeEntity);
            response.success("1","操作成功",employeeEntity.getCustomerno());
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","操作失败");
            throw new RuntimeException(e.getMessage(),e);
        }

        return response;
    }

    @Override
    public Response updEmployeeState(EmployeeEntity employeeEntity) throws RuntimeException {
        Response response = new Response();
        if(ObjectUtils.isEmpty(employeeEntity.getCustomerno())){
            return  new Response().fail("0","员工id不能为空");
        }
        if(ObjectUtils.isEmpty(employeeEntity.getStatus())){
            return  new Response().fail("0","员工状态不能为空");
        }
        try{
            EmployeeKey key = new EmployeeKey();
            key.setCustomerno(employeeEntity.getCustomerno());
            EmployeeEntity a = dao.getEntityKey(key);
            if(ObjectUtils.isEmpty(a)){
                return new Response().fail("0","员工信息不存在");
            }
            a.setStatus(employeeEntity.getStatus());
            a.setUpdatedate(DateUtils.getUserDate(DATE_FMT_DATE));
            a.setUpdatetime(DateUtils.getUserDate(DATE_FMT_TIME));
            dao.updEntity(a);
            response.success("1","操作成功",a.getCustomerno());
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","操作失败");
            throw new RuntimeException(e.getMessage(),e);
        }
        return response;
    }

    @Override
    public Response updpasCount(Map<String,Object> map) throws RuntimeException {
        Response response = new Response();
        if(ObjectUtils.isEmpty(map.get("customerno"))){
            return  new Response().fail("0","员工id不能为空");
        }
        String customerno = (String)map.get("customerno");
        try{
            EmployeeKey key = new EmployeeKey();
            key.setCustomerno(customerno);
            EmployeeEntity a = dao.getEntityKey(key);
            if(ObjectUtils.isEmpty(a)){
                return new Response().fail("0","员工信息不存在");
            }
            AusAuthoneKey authoneKey = new AusAuthoneKey();
            authoneKey.setCustomerno(customerno);
            AusAuthoneEntity authoneEntity = authoneDao.getEntityKey(authoneKey);
            if(ObjectUtils.isEmpty(authoneEntity)){
                return new Response().fail("0","员工账号信息不存在");
            }
            authoneEntity.setFailcount(0);
            authoneEntity.setUpdatedate(DateUtils.getUserDate(DATE_FMT_DATE));
            authoneEntity.setUpdatetime(DateUtils.getUserDate(DATE_FMT_TIME));
            authoneDao.updEntity(authoneEntity);
            response.success("1","操作成功",map.get("customerno"));
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","操作失败");
            throw new RuntimeException(e.getMessage(),e);
        }
        return response;
    }

    @Override
    public Response queryEmployee(Map<String, Object> map) throws RuntimeException{
        Response response = new Response();
        if(ObjectUtils.isEmpty(map.get("pageNum"))){
            return new Response().fail("0","pageNum不能为空");
        }
        if(ObjectUtils.isEmpty(map.get("pageSize"))){
            return new Response().fail("0","pageSize不能为空");
        }
        int pagNub = (Integer) map.get("pageNum");
        int pagSize = (Integer) map.get("pageSize");
        PageHelper.startPage(pagNub,pagSize);
        try {
            List<EmployeeEntity> list = joinDao.selectByMap(map);
            Page<EmployeeEntity> pageInfo = PageUtils.toPage(list,(EmployeeEntity em) -> em);
            response.success("1","查询成功",pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","查询失败");
        }
        return response;
    }
}
