package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.modules.Account.Account;
import com.msjf.finance.cas.modules.Account.AccountDao;
import com.msjf.finance.cas.modules.login.emun.LoginEnum;
import com.msjf.finance.cas.modules.organ.dao.OrganInfoDao;
import com.msjf.finance.cas.modules.organ.emun.OrganInfoEmun;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoEntity;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoKey;
import com.msjf.finance.cas.modules.organ.service.OrganInfoService;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.cas.modules.util.StringUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11509 on 2018/12/18.
 */
@Service("organInfoService")
@Scope("prototype")
public class OrganInfoServiceImpl extends Account implements OrganInfoService {
   @Resource
   OrganInfoDao organInfoDao;
   @Resource
    AccountDao accountDao;
           private String customerno;
        public List queryOrganInfoList() {
            try {
                List<OrganInfoEntity> organInfoEntityList = organInfoDao.queryOrganInfoList();
                List<OrganInfoDomain> organInfoDomainList = new ArrayList();
                organInfoEntityList.stream().forEach(organInfoEntity ->
                        {
                            OrganInfoDomain organInfoDomain = new OrganInfoDomain();
                            BeanUtils.copyProperties(organInfoEntity, organInfoDomain);
                            organInfoDomainList.add(organInfoDomain);
                        }
                );
                return organInfoDomainList;
            }catch (Exception e){
                //打印错误日志
           e.printStackTrace();
        }
        return null;
    }

    @Override
    public Response companyPersonInfo(HashMap<String, Object> mapParam) {
//        customerno= StringUtil.valueOf(mapParam.get("customerno"));
//        Map<String, String> paramMap = new HashMap<String, String>();
//        if (StringUtils.isEmpty(customerno)){
//            return new Response().fail(OrganInfoEmun.MSG_PARAM_NULL);
//        }
//        OrganInfoKey organInfoKey = new OrganInfoKey();
//        organInfoKey.setCustomerno(customerno);
//        OrganInfoEntity organInfoEntity = organInfoDao.getOrganInfoByKey(organInfoKey);
//        if (ObjectUtils.isEmpty(organInfoEntity)) {
//            return new Response().fail(OrganInfoEmun.QUERY_INFO_NULL);
//        }
//        paramMap.put("organclass", organInfoEntity.getOrganclass());
//        paramMap.put("organtype", organInfoEntity.getOrgantype());
//        paramMap.put("customerno", customerno);
//        HashMap reqMap=new HashMap();
//        reqMap.put("customerno",customerno);
//        try {
//            Map<String, String> infoMap = accountDao.selectCompanyPersonInfo(reqMap);
//            if(!StringUtils.isEmpty(infoMap.get("caremarkettype"))){
//                infoMap.put("caremarkettypename", CommonUtil.getDictValueBatch("dict20025",infoMap.get("caremarkettype")));
//            }
////			if(!CheckUtil.isNull(infoMap.get("fundprojecttrade"))){
////			    infoMap.put("fundprojecttradename",CommonUtil.getDictValueBatch("dict20025",infoMap.get("fundprojecttrade")));
////			}
//            if(!StringUtils.isEmpty(infoMap.get("companytrade"))){
//                infoMap.put("companytradename",CommonUtil.getDictValueBatch("dict20025",infoMap.get("companytrade")));
//            }
//            if(!StringUtils.isEmpty(infoMap.get("projecttrade"))){
//                infoMap.put("projecttradename",CommonUtil.getDictValueBatch("dict20025",infoMap.get("projecttrade")));
//            }
////			if(!CheckUtil.isNull(infoMap.get("fundprojectphase"))){
////				infoMap.put("fundprojectphasename",CommonUtil.getDictValueBatch("dict20026",infoMap.get("fundprojectphase")));
////			}
//            if(!StringUtils.isEmpty(infoMap.get("projectphase"))) {
//                infoMap.put("projectphasename", CommonUtil.getDictValueBatch("dict20026", infoMap.get("projectphase")));
//            }
//            ResultUtil.makerSusResults("查询成功", infoMap, rs);
//        } catch (Exception e) {
//            logger.error(e);
//            throw new RuntimeException("查询失败");
//        }
        return null;
    }
}
