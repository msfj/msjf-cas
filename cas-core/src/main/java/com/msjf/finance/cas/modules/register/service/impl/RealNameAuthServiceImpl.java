package com.msjf.finance.cas.modules.register.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.msjf.finance.cas.common.dao.entity.SysDictEntity;
import com.msjf.finance.cas.common.dao.key.SysCertificationConfigKey;
import com.msjf.finance.cas.common.dao.key.SysDictKey;
import com.msjf.finance.cas.common.dao.persistence.SysCertificationConfigDao;
import com.msjf.finance.cas.common.dao.entity.SysCertificationConfigEntity;
import com.msjf.finance.cas.common.dao.persistence.SysDictDao;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.Account.Account;
import com.msjf.finance.cas.modules.register.dimain.ReqRealNameAuthDomain;
import com.msjf.finance.cas.modules.register.dimain.ResRealNameAuthDomain;
import com.msjf.finance.cas.modules.register.emun.RealNameAuthEnum;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.cas.modules.util.DataSecurityUtil;
import com.msjf.finance.cas.modules.util.HttpRequestUtil;
import com.msjf.finance.cas.modules.util.MessageUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * Created by csw on 2019/1/23.
 */
@Service("RealNameAuthService")
@Scope("prototype")
public class RealNameAuthServiceImpl extends Account {
    @Resource
    SysCertificationConfigDao sysCertificationConfigDao;
    @Resource
    SysDictDao sysDictDao;
    /**
     * 开户人证件号码
     */
    private String idNo;
    /**
     * 开户人证件类型
     * I-居民身份证
     * P-外国护照
     * M-军官证
     * S-港澳通行证或台胞证
     * C-中国护照
     * L-中国临时身份证
     * H-户口本编号
     * B-士兵证
     * J-警官证
     * R-外国公民永久居留证
     * O-其他
     */
    private String idType;
    /**
     * 开户人证件名称
     */
    private String name;
    /**
     * 开户人手机号
     */
    private String mobileNo;
    /**
     * 开户人银行卡
     */
    private String bankCardNo;
    public static void main(String[] args) throws Exception
    {
        String BusiDataResMINGW="{\"batchNo\":\"abc123\",\"records\":[{\"authResult\":\"1\",\"bankName\":\"招商银行\",\"cardType\":\"借记卡\",\"erCode\":\"E000000\",\"erMsg\":\"查询成功(L)\",\"seqNo\":\"a123456789\"}]}";

        // 发送HTTP请求
        //postHttpRequest();
        // 发送HTTPS请求
        //postHttpsRequest();
    }
    /**
     * 获取入参
     *
     * @param
     */
    private void getParam(ReqRealNameAuthDomain reqRealNameAuthDomain) {
        idNo=reqRealNameAuthDomain.getIdNo();
        idType=reqRealNameAuthDomain.getIdType();
        name=reqRealNameAuthDomain.getName();
        mobileNo=reqRealNameAuthDomain.getMobileNo();
        bankCardNo=reqRealNameAuthDomain.getBankCardNo();
    }

    public Response<ResRealNameAuthDomain> postHttpsRequest(ReqRealNameAuthDomain reqRealNameAuthDomain)
    {
        ResRealNameAuthDomain resRealNameAuthDomain=new ResRealNameAuthDomain();
        getParam(reqRealNameAuthDomain);
        dealCertificate(idType,reqRealNameAuthDomain);
        try {
        SysCertificationConfigKey sysCertificationConfigKey=new SysCertificationConfigKey();
        sysCertificationConfigKey.setKey("MSC8169");
        SysCertificationConfigEntity sysCertificationConfigEntity=sysCertificationConfigDao.getEntityKey(sysCertificationConfigKey);
        if(ObjectUtils.isEmpty(sysCertificationConfigEntity)){
            return new Response<>().fail(RealNameAuthEnum.MSG_CONFIG_NULL);
        }
//        String sfUrl = "https://test-qhzx.pingan.com.cn:5443/do/dmz//verify/eChkPkgsCard/v1/MSC8169";//请求不同产品需要修改产品ID（如rskdoo）、产品代码（如MSC8036） loanee
        String sfUrl=sysCertificationConfigEntity.getUrl()+"/"+sysCertificationConfigEntity.getNettype()+"/"+
                sysCertificationConfigEntity.getTransname()+"/"+sysCertificationConfigEntity.getProductid()+"/"+sysCertificationConfigEntity.getApiver()+
                "/"+ sysCertificationConfigEntity.getMessagecode();
        String header = "\"header\":" + MessageUtil.getMHeader(sysCertificationConfigEntity);
        String encBusiData = DataSecurityUtil.encrypt(MessageUtil.getBusiData(reqRealNameAuthDomain).getBytes(),
                sysCertificationConfigEntity.getCerCheckCode());
        String busiData = "\"busiData\":\"" + encBusiData + "\"";
        String sigValue = DataSecurityUtil.signData(encBusiData);
        String pwd = DataSecurityUtil.digest(sysCertificationConfigEntity.getUserpassword().getBytes());
        String securityInfo = "\"securityInfo\":" + MessageUtil.getSecurityInfo(sigValue,pwd, sysCertificationConfigEntity);
        String message = "{" + header + "," + busiData + "," + securityInfo + "}";
        System.out.println("请求：" + message);

        String res = HttpRequestUtil.sendJsonWithHttps(sfUrl, message);

        System.out.println("响应Message：" + res);
//        JSONObject msgJSON = net.sf.json.JSONObject.fromObject(res);
        if(ObjectUtils.isEmpty(res)){
            return new Response<>().fail(RealNameAuthEnum.AUTH__FAILED);
        }
        JSONObject msgJSON =JSONUtil.parseObj(res);
        System.out.println("响应BusiData密文：" + msgJSON.getStr("busiData"));

        // 一定要验证签名的合法性！！！！！！！！
        DataSecurityUtil.verifyData(msgJSON.getStr("busiData").replace("\\n","\n"), msgJSON.getJSONObject("securityInfo").getStr(
                "signatureValue").replace("\\n","\n"));

        System.out.println("响应BusiData明文："
                + DataSecurityUtil.decrypt(msgJSON.getStr("busiData").replace("\\n","\n"), sysCertificationConfigEntity.getCerCheckCode()));
        String BusiDataResMIW=msgJSON.getStr("busiData");
        if(StringUtils.isEmpty(BusiDataResMIW)){
            return new Response<>().fail(RealNameAuthEnum.AUTH__FAILED);
        }
        String BusiDataResMINGW=DataSecurityUtil.decrypt(BusiDataResMIW.replace("\\n","\n"), sysCertificationConfigEntity.getCerCheckCode());
        JSONObject resJSON =JSONUtil.parseObj(BusiDataResMINGW);
        JSONArray recordsMINGW=(JSONArray)resJSON.get("records");
        if(ObjectUtils.isEmpty(recordsMINGW)){
            return new Response<>().fail(RealNameAuthEnum.AUTH__FAILED);
        }
        JSONObject recordMINGW=(JSONObject)recordsMINGW.get(0);

        String bankName= StringUtil.valueOf(recordMINGW.get("bankName"));
        String authResult=StringUtil.valueOf(recordMINGW.get("authResult"));
        if(StringUtils.isEmpty(authResult)){
            return new Response<>().fail(RealNameAuthEnum.AUTH__FAILED);
        }
        String cardType=StringUtil.valueOf(recordMINGW.get("cardType"));
        String erMsg=StringUtil.valueOf(recordMINGW.get("erMsg"));
            resRealNameAuthDomain.setBankName(bankName);
            resRealNameAuthDomain.setAuthResult(authResult=="1"?true:false);
            resRealNameAuthDomain.setBankName(cardType);
            resRealNameAuthDomain.setBankName(erMsg);
            return new Response<>().success(RealNameAuthEnum.AUTH_SUCCESS,resRealNameAuthDomain);
        }catch (Exception e){
            return new Response().fail(RealNameAuthEnum.AUTH__EXCEPTION);
        }
    }
    public void dealCertificate(String idType,ReqRealNameAuthDomain reqRealNameAuthDomain){
        /**
         * 居民身份证
         */
        if("0".equals(idType)){
            idType="I";
        }
        /**
         * 居民身份证
         */
        else if("1".equals(idType)){
            idType="C";
        }
        else if("2".equals(idType)){
            idType="S";
        }
        reqRealNameAuthDomain.setIdType(idType);
    }
}
