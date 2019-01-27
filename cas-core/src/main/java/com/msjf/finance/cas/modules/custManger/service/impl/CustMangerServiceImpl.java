package com.msjf.finance.cas.modules.custManger.service.impl;

import com.github.pagehelper.PageHelper;
import com.msjf.finance.cas.common.dao.entity.AusAuthoneEntity;
import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.entity.PersonInfoEntity;
import com.msjf.finance.cas.common.dao.key.AusAuthoneKey;
import com.msjf.finance.cas.common.dao.key.CustKey;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
import com.msjf.finance.cas.common.dao.key.PersonInfoKey;
import com.msjf.finance.cas.common.dao.persistence.AusAuthoneDao;
import com.msjf.finance.cas.common.dao.persistence.CustDao;
import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.dao.persistence.PersonInfoDao;
import com.msjf.finance.cas.common.joindao.persistence.CustJoinDao;
import com.msjf.finance.cas.common.utils.DateUtils;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.facade.custManger.domain.CustMangerDomain;
import com.msjf.finance.cas.facade.custManger.domain.CustOutDomain;
import com.msjf.finance.cas.modules.custManger.service.CustMangerService;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.msjf.core.page.Page;
import com.msjf.finance.msjf.core.page.PageUtils;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static com.msjf.finance.cas.modules.Account.Account.*;
import static com.msjf.finance.cas.modules.util.CommonUtil.DATE_FMT_DATE;
import static com.msjf.finance.cas.modules.util.CommonUtil.DATE_FMT_TIME;

@Service("custMangerService")
@Transactional
public class CustMangerServiceImpl implements CustMangerService {

    @Resource
    CustDao custDao;

    @Resource
    PersonInfoDao personInfoDao;

    @Resource
    OrganInfoDao organInfoDao;

    @Resource
    AusAuthoneDao authoneDao;

    @Resource
    CustJoinDao custJoinDao;

    @Override
    public Response insCust(CustMangerDomain custMangerDomain) throws RuntimeException {
        Response response = new Response();
        if(!checkParam(custMangerDomain,response)){
            return  response;
        }
        try {
            CustEntity custEntity = new CustEntity();
            custEntity.setCertificateno(custMangerDomain.getCertificateno());
            custEntity.setMembertype(custMangerDomain.getMembertype());
            if(!ObjectUtils.isEmpty(custDao.getListEntity(custEntity))){
                return new Response().fail("0","当前证件号码已被注册");
            }
            BeanUtils.copyProperties(custMangerDomain, custEntity);
            String custNo = StringUtil.getUUID();
            custEntity.setCustomerno(custNo);
            custEntity.setLoginname(custMangerDomain.getCertificateno());
            if(person.equals(custEntity.getMembertype())){
                CustEntity a = new CustEntity();
                a.setMobile(custMangerDomain.getMobile());
                if(!ObjectUtils.isEmpty(custDao.getListEntity(a))){
                    return new Response().fail("0","当前手机号码已被使用");
                }
                PersonInfoEntity personInfoEntity = new PersonInfoEntity();
                personInfoEntity.setCustomerno(custNo);
                personInfoEntity.setMembername(custMangerDomain.getCustname());
                personInfoEntity.setInsertdate(DateUtils.getUserDate(DATE_FMT_DATE));
                personInfoEntity.setInserttime(DateUtils.getUserDate(DATE_FMT_TIME));
                personInfoDao.insEntity(personInfoEntity);
            }else if(company.equals(custEntity.getMembertype())){
                OrganInfoEntity organInfoEntity = new OrganInfoEntity();
                organInfoEntity.setCustomerno(custNo);
                organInfoEntity.setMembername(custMangerDomain.getCustname());
                organInfoEntity.setOrganstatus(ORGSTATUS_1);
                organInfoEntity.setOrganEmail(custMangerDomain.getEmail());
                organInfoEntity.setInsertdate(DateUtils.getUserDate(DATE_FMT_DATE));
                organInfoEntity.setInserttime(DateUtils.getUserDate(DATE_FMT_TIME));
                organInfoDao.insEntity(organInfoEntity);
            }
            custEntity.setInsertdate(DateUtils.getUserDate(DATE_FMT_DATE));
            custEntity.setInserttime(DateUtils.getUserDate(DATE_FMT_TIME));
            custDao.insEntity(custEntity);
            AusAuthoneEntity authoneEntity = new AusAuthoneEntity();
            authoneEntity.setCustomerno(custNo);
            authoneEntity.setFailcount(0);
            authoneEntity.setPassword(CommonUtil.HmacSHA1Encrypt(SYS_INIT_PASSWORD,custNo));
            authoneEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            authoneEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
            authoneDao.insEntity(authoneEntity);
            response.success("1","新增成功",custMangerDomain.getCustname());
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","操作失败");
            throw new RuntimeException(e.getMessage(),e);
        }
        return response;
    }

    @Override
    public Response delCust(CustMangerDomain custMangerDomain) throws RuntimeException {
        Response response = new Response();
        try {
            String custNo = custMangerDomain.getCustno();
            if(ObjectUtils.isEmpty(custNo)){
                return new Response().fail("0","被删除用户id不能为空");
            }
            CustKey custKey = new CustKey();
            custKey.setKey(custNo);
            CustEntity custEntity = custDao.getEntityKey(custKey);
            if(ObjectUtils.isEmpty(custEntity)){
                return new Response().fail("0","被删除用户信息不存在");
            }
            if(person.equals(custEntity.getMembertype())){
                PersonInfoKey personInfoKey = new PersonInfoKey();
                personInfoKey.setKey(custNo);
                personInfoDao.delEntityKey(personInfoKey);
            }else if(company.equals(custEntity.getMembertype())){
                OrganInfoKey organInfoKey = new OrganInfoKey();
                organInfoKey.setKey(custNo);
                organInfoDao.delEntityKey(organInfoKey);
            }
            custDao.delEntityKey(custKey);
            AusAuthoneKey authoneKey = new AusAuthoneKey();
            authoneKey.setKey(custNo);
            authoneDao.delEntityKey(authoneKey);
            response.success("1","删除成功",custMangerDomain.getCustno());
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","操作失败");
            throw new RuntimeException(e.getMessage(),e);
        }
        return response;
    }

    @Override
    public Response updCust(CustMangerDomain custMangerDomain)throws RuntimeException {
        Response response = new Response();
        if(!checkParam(custMangerDomain,response)){
            return  response;
        }
        try {
            String custNo = custMangerDomain.getCustno();
            if(ObjectUtils.isEmpty(custNo)){
                return new Response().fail("0","用户id不能为空");
            }
            CustKey key = new CustKey();
            key.setKey(custNo);
            CustEntity ce = custDao.getEntityKey(key);
            if(ObjectUtils.isEmpty(ce)){
                return new Response().fail("0","用户信息不存在");
            }
            if(!ce.getMembertype().equals(custMangerDomain.getMembertype())){
                return new Response().fail("0","用户类型不能修改");
            }
            CustEntity custEntity = new CustEntity();
            custEntity.setCertificateno(custMangerDomain.getCertificateno());
            custEntity.setMembertype(custMangerDomain.getMembertype());
            List<CustEntity> alist = custDao.getListEntity(custEntity);
            if(!ObjectUtils.isEmpty(alist)&&!alist.get(0).getCustomerno().equals(custNo)){
                return new Response().fail("0","当前证件号码已被注册");
            }
            BeanUtils.copyProperties(custMangerDomain, custEntity);
            custEntity.setCustomerno(custNo);
            custEntity.setLoginname(custMangerDomain.getCertificateno());
            if(person.equals(custEntity.getMembertype())){
                CustEntity a = new CustEntity();
                a.setMobile(custMangerDomain.getMobile());
                List<CustEntity> blist = custDao.getListEntity(a);
                if(!ObjectUtils.isEmpty(blist)&&!blist.get(0).getCustomerno().equals(custNo)){
                    return new Response().fail("0","当前手机号码已被使用");
                }
                PersonInfoEntity personInfoEntity = new PersonInfoEntity();
                personInfoEntity.setCustomerno(custNo);
                personInfoEntity.setMembername(custMangerDomain.getCustname());
                personInfoEntity.setInsertdate(DateUtils.getUserDate(DATE_FMT_DATE));
                personInfoEntity.setInserttime(DateUtils.getUserDate(DATE_FMT_TIME));
                personInfoDao.updEntity(personInfoEntity);
            }else if(company.equals(custEntity.getMembertype())){
                OrganInfoEntity organInfoEntity = new OrganInfoEntity();
                organInfoEntity.setCustomerno(custNo);
                organInfoEntity.setMembername(custMangerDomain.getCustname());
                organInfoEntity.setOrganEmail(custMangerDomain.getEmail());
                organInfoEntity.setUpdatedate(DateUtils.getUserDate(DATE_FMT_DATE));
                organInfoEntity.setUpdatetime(DateUtils.getUserDate(DATE_FMT_TIME));
                organInfoDao.updEntity(organInfoEntity);
            }
            custEntity.setUpdatedate(DateUtils.getUserDate(DATE_FMT_DATE));
            custEntity.setUpdatetime(DateUtils.getUserDate(DATE_FMT_TIME));
            custDao.updEntity(custEntity);
            response.success("1","修改成功",custMangerDomain.getCustno());
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","操作失败");
            throw new RuntimeException(e.getMessage(),e);
        }
        return response;
    }

    @Override
    public Response queryCust(Map<String, Object> map) throws RuntimeException {
        Response response = new Response();

        try {
            if(ObjectUtils.isEmpty(map.get("pageNum"))){
                return new Response().fail("0","pageNum不能为空");
            }
            if(ObjectUtils.isEmpty(map.get("pageSize"))){
                return new Response().fail("0","pageSize不能为空");
            }

            int pagNub = (Integer) map.get("pageNum");
            int pagSize = (Integer) map.get("pageSize");
            PageHelper.startPage(pagNub,pagSize);

            List<CustOutDomain> list = custJoinDao.queryCustList(map);
            Page<CustOutDomain> pageInfo = PageUtils.toPage(list,(CustOutDomain em) -> em);
            response.success("1","查询成功",pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            response.fail("0","查询失败");
        }
        return response;
    }

    public Boolean checkParam(CustMangerDomain custMangerDomain, Response response){
        if(ObjectUtils.isEmpty(custMangerDomain.getMembertype())){
            response.fail("0","用户类型不能为空");
            return false;
        }
        if(ObjectUtils.isEmpty(custMangerDomain.getCustname())){
            response.fail("0","用户名称不能为空");
            return false;
        }
        if(ObjectUtils.isEmpty(custMangerDomain.getCertificatetype())){
            response.fail("0","用户证件类型不能为空");
            return false;
        }
        if(ObjectUtils.isEmpty(custMangerDomain.getCertificateno())){
            response.fail("0","用户证件号码不能为空");
            return false;
        }
        if(ObjectUtils.isEmpty(custMangerDomain.getMobile())){
            response.fail("0","手机号码不能为空");
            return false;
        }
        if(ObjectUtils.isEmpty(custMangerDomain.getEmail())){
            response.fail("0","邮箱不能为空");
            return false;
        }
        return  true;
    }
}
