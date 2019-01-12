package com.msjf.finance.cas.modules.changePwd.Service.impl;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.modules.Account;
import com.msjf.finance.cas.modules.ausAuthone.dao.AusAuthoneDao;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneEntity;
import com.msjf.finance.cas.modules.changePwd.Service.ChangePwdService;
import com.msjf.finance.cas.modules.register.dao.CustDao;
import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.cas.modules.util.CheckUtil;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.cas.modules.util.StringUtil;
import com.msjf.finance.mcs.facade.sms.domain.VerificationCodeDomain;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
    public Response<Map> changePwd(HashMap<String, Object> mapParam) {
        Response<Map> rs=new Response();
        HashMap resMap=new HashMap();
        rs.fail();
        String certificateno= StringUtil.valueOf(mapParam.get("certificateno"));
        String msgCode=StringUtil.valueOf(mapParam.get("msgCode"));
        String step=StringUtil.valueOf(mapParam.get("step"));
        String password=StringUtil.valueOf(mapParam.get("password"));
        if(CheckUtil.checkNull(step,"步骤",rs)){
            return rs;
        }
        if(CheckUtil.checkNull(certificateno,"证件号码",rs)){
            return rs;
        }
        CustEntity custEntity=new CustEntity();
        custEntity.setCertificateno(certificateno);
        List<CustEntity> custEntityList= custDao.queryCustEntityList(custEntity);
        if(CheckUtil.isNull(custEntityList)){
            rs.fail("账户信息不存在");
        }
        mobile=custEntityList.get(0).getMobile();
        cormob=custEntityList.get(0).getCormob();
        customerno=custEntityList.get(0).getCustomerno();
        if(step.equals(step_1)){
            com.msjf.finance.mcs.common.response.Response<VerificationCodeDomain> mcsRs= CommonUtil.sendVerificationCode(SMS_CHANGE_PWD_TYPE,mobile);
            if(mcsRs.checkIfSuccess()){
                String SeqNum=mcsRs.getData().getSeqNum();
                String ActiveSeconds=mcsRs.getData().getActiveSeconds();
                resMap.put("SeqNum",SeqNum);
                resMap.put("ActiveSeconds",ActiveSeconds);
                rs.success("发送成功",resMap);
            }else {
                rs.fail("发送失败");
            }
        }
        else if(step.equals(step_2)){
            if(CheckUtil.checkNull(msgCode,"验证码",rs)){
                return rs;
            }
            if(CheckUtil.checkNull(password,"密码",rs)){
                return rs;
            }
            Boolean flag=CommonUtil.isExistVerificationCode(SMS_CHANGE_PWD_TYPE,mobile,msgCode);
            if(flag){
                AusAuthoneEntity ausAuthoneEntity=new AusAuthoneEntity();
                ausAuthoneEntity.setCustomerno(custEntityList.get(0).getCustomerno());
                ausAuthoneEntity.setPassword(CommonUtil.HmacSHA1Encrypt(password,customerno));
                ausAuthoneDao.update(ausAuthoneEntity);
                rs.success("修改成功");
            }else{
                rs.fail("修改失败");
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
        if(CheckUtil.isNull(custEntityList)){
            rs.fail("账户信息不存在");
        }
        mobile=custEntityList.get(0).getMobile();
        resMap.put("mobile",mobile.replaceAll("(\\d{3})\\d{6}(\\d{2})", "$1****$2"));
        rs.success("获取成功",resMap);
        return rs;
    }
}
