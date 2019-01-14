package com.msjf.finance.cas.modules.changePwd.Service.impl;
import com.msjf.finance.cas.facade.changePwd.domain.ChangePwdDomain;
import com.msjf.finance.cas.facade.changePwd.domain.RequestChangePwdDomain;
import com.msjf.finance.cas.modules.Account;
import com.msjf.finance.cas.modules.ausAuthone.dao.AusAuthoneDao;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneEntity;
import com.msjf.finance.cas.modules.changePwd.Service.ChangePwdService;
import com.msjf.finance.cas.modules.changePwd.emun.ChangePwdEnum;
import com.msjf.finance.cas.modules.register.dao.CustDao;
import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.cas.modules.util.StringUtil;
import com.msjf.finance.mcs.facade.sms.domain.VerificationCodeDomain;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("changePwdServiceImpl")
@Scope("prototype")
public class ChangePwdServiceImpl extends Account implements ChangePwdService {
    @Resource
    CustDao custDao;
    @Resource
    AusAuthoneDao ausAuthoneDao;

    private String mobile;

    private String customerno;

    /**
     * 法人手机号码
     */
    private String cormob;

    @Override
    public Response<ChangePwdDomain> changePwd(RequestChangePwdDomain requestChangePwdDomain) {
        ChangePwdDomain changePwdDomain=new ChangePwdDomain();
        Response<ChangePwdDomain> rs=new Response();
        rs.fail();
        String certificateno= requestChangePwdDomain.getCertificateno();
        String msgCode=requestChangePwdDomain.getMsgCode();
        String step= requestChangePwdDomain.getStep();
        String password=requestChangePwdDomain.getPassword();
        if(StringUtils.isEmpty(step)){
            return rs.fail(ChangePwdEnum.MSG_PARAM_ERROR);
        }
        if(StringUtils.isEmpty(certificateno)){
            return  rs.fail(ChangePwdEnum.MSG_PARAM_ERROR);
        }
        CustEntity custEntity=new CustEntity();
        custEntity.setCertificateno(certificateno);
        List<CustEntity> custEntityList= custDao.queryCustEntityList(custEntity);
        if(StringUtils.isEmpty(custEntityList)){
            rs.fail(ChangePwdEnum.MSG_USER_NULL);
        }
        mobile=custEntityList.get(0).getMobile();
        cormob=custEntityList.get(0).getCormob();
        customerno=custEntityList.get(0).getCustomerno();
        if(step.equals(step_1)){
            Response<VerificationCodeDomain> mcsRs= CommonUtil.sendVerificationCode(SMS_CHANGE_PWD_TYPE,mobile);
            if(mcsRs.checkIfSuccess()){
                String SeqNum=mcsRs.getData().getSeqNum();
                String ActiveSeconds=mcsRs.getData().getActiveSeconds();
                changePwdDomain.setActiveSeconds(ActiveSeconds);
                changePwdDomain.setSeqNum(SeqNum);
                return rs.success(ChangePwdEnum.SMS_SEND_SUCCESS,changePwdDomain);
            }else {
                return rs.success(ChangePwdEnum.SMS_SEND_ERROR);
            }
        }
        else if(step.equals(step_2)){
            if(StringUtils.isEmpty(msgCode)){
                return rs.fail(ChangePwdEnum.MSG_PARAM_ERROR);
            }
            if(StringUtils.isEmpty(password)){
                return rs.fail(ChangePwdEnum.MSG_PARAM_ERROR);
            }
            Boolean flag=CommonUtil.isExistVerificationCode(SMS_CHANGE_PWD_TYPE,mobile,msgCode);
            if(flag){
                AusAuthoneEntity ausAuthoneEntity=new AusAuthoneEntity();
                ausAuthoneEntity.setCustomerno(custEntityList.get(0).getCustomerno());
                ausAuthoneEntity.setPassword(CommonUtil.HmacSHA1Encrypt(password,customerno));
                ausAuthoneDao.update(ausAuthoneEntity);
                return rs.success(ChangePwdEnum.CHANGE_SUCCESS);
            }else{
                return rs.fail(ChangePwdEnum.CHANGE_FAILED);
            }
        }
        return rs;
    }

    @Override
    public Response<Map> echoMobile(HashMap<String, Object> mapParam) {
        Response<Map> rs=new Response();
        HashMap resMap=new HashMap();
        rs.fail();
        String certificateno= StringUtil.valueOf(mapParam.get("certificateno"));
        CustEntity custEntity=new CustEntity();
        custEntity.setCertificateno(certificateno);
        List<CustEntity> custEntityList= custDao.queryCustEntityList(custEntity);
        if(StringUtils.isEmpty(custEntityList)){
            return rs.fail(ChangePwdEnum.MSG_USER_NULL);
        }
        mobile=custEntityList.get(0).getMobile();
        resMap.put("mobile",mobile.replaceAll("(\\d{3})\\d{6}(\\d{2})", "$1****$2"));
        rs.success(ChangePwdEnum.QUERY_SUCCESS,resMap);
        return rs;
    }
}
