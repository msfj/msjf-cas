package com.msjf.finance.cas.modules.login.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.msjf.finance.cas.common.dao.persistence.SysCertificationConfigDao;
import com.msjf.finance.cas.common.dao.entity.SysCertificationConfigEntity;
import com.msjf.finance.cas.modules.Account.Account;
import com.msjf.finance.cas.modules.util.DataSecurityUtil;
import com.msjf.finance.cas.modules.util.HttpRequestUtil;
import com.msjf.finance.cas.modules.util.MessageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created by csw on 2019/1/23.
 */
@Service("RealNameAuthService")
public class RealNameAuthServiceImpl extends Account {
    @Resource
    SysCertificationConfigDao sysCertificationConfigDao;
    public static void main(String[] args) throws Exception
    {
        // 发送HTTP请求
        //postHttpRequest();
        // 发送HTTPS请求
        postHttpsRequest();
    }
    private static void postHttpsRequest() throws Exception
    {
//        SysCertificationConfigEntity sysCertificationConfigEntity=sysCertificationConfigDao.selectByPrimaryKey("MSC8036");
        String sfUrl = "https://test-qhzx.pingan.com.cn:5443/do/dmz//verify/eChkPkgsCard/v1/MSC8169";//请求不同产品需要修改产品ID（如rskdoo）、产品代码（如MSC8036） loanee
//        String url=sysCertificationConfigEntity.getUrl()+File.separator+sysCertificationConfigEntity.getNettype()+File.separator+
//                sysCertificationConfigEntity.getTransname()+File.separator+sysCertificationConfigEntity.getProductid()+File.separator+sysCertificationConfigEntity.getApiver()+
//                File.separator+ sysCertificationConfigEntity.getMessagecode();
        String header = "\"header\":" + MessageUtil.getMHeader();
        String encBusiData = DataSecurityUtil.encrypt(MessageUtil.getBusiData().getBytes(),
                "SK803@!QLF-D25WEDA5E52DA");
        String busiData = "\"busiData\":\"" + encBusiData + "\"";
        String sigValue = DataSecurityUtil.signData(encBusiData);
        String pwd = DataSecurityUtil.digest("weblogic1".getBytes());
        String securityInfo = "\"securityInfo\":" + MessageUtil.getSecurityInfo(sigValue, pwd);
        String message = "{" + header + "," + busiData + "," + securityInfo + "}";
        System.out.println("请求：" + message);

        String res = HttpRequestUtil.sendJsonWithHttps(sfUrl, message);

        System.out.println("响应Message：" + res);
//        JSONObject msgJSON = net.sf.json.JSONObject.fromObject(res);
        JSONObject msgJSON =JSONUtil.parseObj(res);
        System.out.println("响应BusiData密文：" + msgJSON.getStr("busiData"));

        // 一定要验证签名的合法性！！！！！！！！
        DataSecurityUtil.verifyData(msgJSON.getStr("busiData").replace("\\n","\n"), msgJSON.getJSONObject("securityInfo").getStr(
                "signatureValue").replace("\\n","\n"));

        System.out.println("响应BusiData明文："
                + DataSecurityUtil.decrypt(msgJSON.getStr("busiData").replace("\\n","\n"), "SK803@!QLF-D25WEDA5E52DA"));
    }

    /**
     * 发送HTTP请求
     *
     * @throws Exception
    */
    private static void postHttpRequest() throws Exception
     {
        String sfUrl = "http://localhost:7012/dcs-dmz/do/dmz/query/rskdoo/v1/MSC8036";//请求不同产品需要修改产品ID（如rskdoo）、产品代码（如MSC8036）
        String header = "\"header\":" + MessageUtil.getMHeader();
        String encBusiData = DataSecurityUtil.encrypt(MessageUtil.getBusiData().getBytes(),
        "SK803@!QLF-D25WEDA5E52DA");
        String busiData = "\"busiData\":\"" + encBusiData + "\"";
        String sigValue = DataSecurityUtil.signData(encBusiData);
        String pwd = DataSecurityUtil.digest("weblogic1".getBytes());
        String securityInfo = "\"securityInfo\":" + MessageUtil.getSecurityInfo(sigValue, pwd);
        String message = "{" + header + "," + busiData + "," + securityInfo + "}";
        System.out.println("请求：" + message);

        String res = HttpRequestUtil.sendJsonWithHttp(sfUrl, message);

        System.out.println("响应Message：" + res);
        JSONObject msgJSON =JSONUtil.parseObj(res);
        System.out.println("响应BusiData密文：" + msgJSON.getStr("busiData"));

        // 一定要验证签名的合法性！！！！！！！！
        DataSecurityUtil.verifyData(msgJSON.getStr("busiData"), msgJSON.getJSONObject("securityInfo").getStr(
        "signatureValue"));

        System.out.println("响应BusiData明文："
        + DataSecurityUtil.decrypt(msgJSON.getStr("busiData"), "SK803@!QLF-D25WEDA5E52DA"));
     }
}
