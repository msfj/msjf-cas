package com.msjf.finance.cas.modules.util;

public class MessageUtil
{
    public static String getMHeader()
    {
        StringBuffer sb = new StringBuffer(
                "{\"orgCode\":\"10000000\","
                + "\"chnlId\":\"qhcs-dcs\","
                + "\"transNo\":\""+DateUtil.getCurrDateTime()+"\","//请先修改该值，再发起请求！！！保持每次请求其唯一性！！！
                + "\"transDate\":\""+DateUtil.getUserDate("yyyy-MM-dd HH:mm:ss")+"\","
                + "\"authCode\":\"CRT001A2\","
                + "\"authDate\":\"2017-8-10 14:12:14\"}");
        return sb.toString();
    }

    public static String getBusiDataMSC8037()
    {
        StringBuffer sb = new StringBuffer(
        		 "{\"batchNo\":\"abc123\","
        	                + "\"records\":[{\"idNo\":\"210202195901160032\","
        	                	+ "\"idType\":\"0\","
        	                	+ "\"name\":\"褚宝刚\","
        	                	+ "\"reasonCode\":\"99\","
        	                	+ "\"entityAuthCode\":\"A0000012\","
        	                	+ "\"entityAuthDate\":\"2018-1-16\","
        	                	+ "\"seqNo\":\"a123456789\"}]}");
        return sb.toString();
    }
    public static String getBusiData()
    {
        StringBuffer sb = new StringBuffer(
                "{\"batchNo\":\"abc123\","
                        + "\"records\":[{\"idNo\":\"445121199401015137\","
                        + "\"idType\":\"I\","
                        + "\"name\":\"陈树武\","
                        + "\"reasonCode\":\"99\","
                        + "\"authType\":\"A4\","
                        + "\"mobileNo\":\"18565641675\","
                        + "\"bankCardNo\":\"6214837848529628\","
                        + "\"entityAuthCode\":\"A0000012\","
                        + "\"entityAuthDate\":\"2018-1-16\","
                        + "\"seqNo\":\"a123456789\"}]}");
        return sb.toString();
    }
    public static String getSecurityInfo(String signatureValue, String pwd)
    {
        StringBuffer sb = new StringBuffer("{\"signatureValue\":\"" + signatureValue
                + "\",\"userName\":\"V_PA025_QHCS_DCS\",\"userPassword\":\"" + pwd + "\"}");
        return sb.toString();
    }
}
