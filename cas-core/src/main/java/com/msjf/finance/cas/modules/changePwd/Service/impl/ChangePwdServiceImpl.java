package com.msjf.finance.cas.modules.changePwd.Service.impl;
import com.msjf.finance.cas.common.dao.entity.AusAuthoneEntity;
import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.persistence.CustDao;
import com.msjf.finance.cas.common.joindao.persistence.CustJoinDao;
import com.msjf.finance.cas.facade.changePwd.domain.ChangePwdDomain;
import com.msjf.finance.cas.facade.changePwd.domain.EchoMobileDomain;
import com.msjf.finance.cas.facade.changePwd.domain.RequestChangePwdDomain;
import com.msjf.finance.cas.modules.Account.Account;
import com.msjf.finance.cas.common.dao.persistence.AusAuthoneDao;
import com.msjf.finance.cas.modules.changePwd.Service.ChangePwdService;
import com.msjf.finance.cas.modules.changePwd.emun.ChangePwdEnum;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.mcs.facade.sms.domain.VerificationCodeDomain;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("changePwdServiceImpl")
@Scope("prototype")
public class ChangePwdServiceImpl extends Account implements ChangePwdService {
    @Resource
    CustDao custDao;
    @Resource
    AusAuthoneDao ausAuthoneDao;
    @Resource
    CustJoinDao custJoinDao;

    private String mobile;

    private String customerno;


    @Override
    public Response<ChangePwdDomain> changePwd(RequestChangePwdDomain requestChangePwdDomain) {
        Response<ChangePwdDomain> rs=new Response();
        rs.fail();
        String certificateno= requestChangePwdDomain.getCertificateno();
        String msgCode=requestChangePwdDomain.getMsgCode();
        String step= requestChangePwdDomain.getStep();
        String password=requestChangePwdDomain.getPassword();
        if(StringUtils.isEmpty(step)){
            return rs.fail(ChangePwdEnum.MSG_STEP_NULL);
        }
        if(StringUtils.isEmpty(certificateno)){
            return  rs.fail(ChangePwdEnum.MSG_CERTIFICATENO_NULL);
        }
        CustEntity custEntity=new CustEntity();
        custEntity.setCertificateno(certificateno);
        List<CustEntity> custEntityList= custJoinDao.queryCustEntityList(custEntity);
        if(ObjectUtils.isEmpty(custEntityList)){
            return rs.fail(ChangePwdEnum.MSG_USER_NULL);
        }
        if(StringUtils.isEmpty(msgCode)){
            return rs.fail(ChangePwdEnum.MSG_PARAM_ERROR);
        }
        if(company.equals(custEntityList.get(0).getMembertype())){
            mobile=custEntityList.get(0).getCormob();
        }else{
            mobile=custEntityList.get(0).getMobile();
        }
        if(StringUtils.isEmpty(mobile)){
            return rs.fail(ChangePwdEnum.MSG_PARAM_ERROR);
        }
        customerno=custEntityList.get(0).getCustomerno();
        if(step.equals(step_1)){
            Boolean flag=CommonUtil.checkVerificationCode(CommonUtil.SMS_CHANGE_PWD_TYPE, mobile,msgCode);
            if(flag){
                return rs.success(ChangePwdEnum.VERIFICATION_SUCCESS);
            }else{
                return rs.fail(ChangePwdEnum.VERIFICATION_FAILED);
            }
        }else if(step.equals(step_2)){
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
                return rs.fail(ChangePwdEnum.VERIFICATION_FAILED);
            }
        }
        return rs;
    }

    @Override
    public Response<EchoMobileDomain> echoMobile(HashMap<String, Object> mapParam){
        Response<EchoMobileDomain> rs=new Response();
        EchoMobileDomain echoMobileDomain=new EchoMobileDomain();
        rs.fail();
        String certificateno=StringUtil.valueOf(mapParam.get("certificateno"));
        if(StringUtils.isEmpty(certificateno)){
            return rs.fail(ChangePwdEnum.MSG_PARAM_ERROR);
        }
        CustEntity custEntity=new CustEntity();
        custEntity.setCertificateno(certificateno);
        List<CustEntity> custEntityList= custJoinDao.queryCustEntityList(custEntity);
        if(ObjectUtils.isEmpty(custEntityList)){
            return rs.fail(ChangePwdEnum.MSG_USER_NULL);
        }
        if(company.equals(custEntityList.get(0).getMembertype())){
            mobile=custEntityList.get(0).getCormob();
        }else{
            mobile=custEntityList.get(0).getMobile();
        }
        Response<VerificationCodeDomain> mcsRs= CommonUtil.sendVerificationCode(SMS_CHANGE_PWD_TYPE,mobile);
        mobile=mobile.replaceAll("(\\d{3})\\d{6}(\\d{2})", "$1****$2");
        if(mcsRs.checkIfSuccess()){
            String SeqNum=mcsRs.getData().getSeqNum();
            String ActiveSeconds=mcsRs.getData().getActiveSeconds();
            echoMobileDomain.setActiveSeconds(ActiveSeconds);
            echoMobileDomain.setSeqNum(SeqNum);
            echoMobileDomain.setCertificateno(certificateno);
            echoMobileDomain.setMobile(mobile);
            return rs.success(ChangePwdEnum.QUERY_SUCCESS,echoMobileDomain);
        }else {
            return rs.success(ChangePwdEnum.SMS_SEND_ERROR);
        }
    }
}
