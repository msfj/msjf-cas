package com.msjf.finance.cas.modules.util;

import com.msjf.finance.cas.common.dao.entity.SysCertificationConfigEntity;
import com.msjf.finance.cas.common.utils.DateUtils;
import com.msjf.finance.cas.modules.register.dimain.ReqRealNameAuthDomain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageUtil
{
    public static String getMHeader(SysCertificationConfigEntity sysCertificationConfigEntity)
    {
        StringBuffer sb = new StringBuffer(
                "{\"orgCode\":\""+sysCertificationConfigEntity.getOrgcode()+"\","
                + "\"chnlId\":\""+sysCertificationConfigEntity.getChnlid()+"\","
                + "\"transNo\":\""+DateUtils.getCurrDateTime()+"\","//请先修改该值，再发起请求！！！保持每次请求其唯一性！！！
                + "\"transDate\":\""+DateUtils.getUserDate("yyyy-MM-dd HH:mm:ss")+"\","
                + "\"authCode\":\""+sysCertificationConfigEntity.getAuthcode()+"\","
                + "\"authDate\":\""+sysCertificationConfigEntity.getAuthdate()+"\"}");
        return sb.toString();
    }
    public static String getBusiData(ReqRealNameAuthDomain reqRealNameAuthDomain)
        {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        StringBuffer sb = new StringBuffer(
                "{\"batchNo\":\""+"msjf" + format.format(new Date())+"\","
                        + "\"records\":[{\"idNo\":\""+reqRealNameAuthDomain.getIdNo()+"\","
                        + "\"idType\":\""+reqRealNameAuthDomain.getIdType()+"\","
                        + "\"name\":\""+reqRealNameAuthDomain.getName()+"\","
                        + "\"reasonCode\":\"99\","
                        + "\"authType\":\"A4\","
                        + "\"mobileNo\":\""+reqRealNameAuthDomain.getMobileNo()+"\","
                        + "\"bankCardNo\":\""+reqRealNameAuthDomain.getBankCardNo()+"\","
                        + "\"entityAuthCode\":\"A0000012\","
                        + "\"entityAuthDate\":\"2018-1-16\","
                        + "\"seqNo\":\""+"msjf" + format.format(new Date())+"\"}]}");
        return sb.toString();
    }
    public static String getSecurityInfo(String signatureValue,String pwd, SysCertificationConfigEntity sysCertificationConfigEntity)
    {
        StringBuffer sb = new StringBuffer("{\"signatureValue\":\"" + signatureValue
                + "\",\"userName\":\""+sysCertificationConfigEntity.getUsername()+"\",\"userPassword\":\"" + pwd+ "\"}");
        return sb.toString();
    }
}
