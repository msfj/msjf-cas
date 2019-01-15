package com.msjf.finance.cas.modules.util;


import com.msjf.finance.cas.modules.login.dao.SysParamsConfigEntityMapper;
import com.msjf.finance.cas.modules.login.entity.SysParamsConfigEntity;
import com.msjf.finance.cas.modules.login.entity.SysParamsConfigEntityKey;
import com.msjf.finance.cas.modules.util.emun.CommonUtilEnum;
import com.msjf.finance.mcs.facade.sms.SendVerificationCodeFacade;
import com.msjf.finance.mcs.facade.sms.domain.VerificationCodeDomain;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
/**
 * 公用参数
 * Created by lzp on 2018/12/26.
 */
@Component
public final class CommonUtil {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String MAC_NAME = "SHA-256";
    private static final String ENCODING = "UTF-8";
    /**
     * 认证类型 0-服务平台注册 1-管理平台登录 2-修改密码 3-手机换绑 4-业务平台登陆
     */
    public static final String SMS_REGISTER_TYPE = "0";
    public static final String SMS_LOGIN_TYPE = "1";
    public static final String SMS_CHANGE_PWD_TYPE = "2";
    public static final String SMS_CHANGE_MOBILE_TYPE = "3";
    public static final String SMS_SERVICE_LOGIN_TYPE = "4";
    /**
     * 注册,忘记密码，登陆模板id
     * //您的验证码是{xxxxxxxxxxxxxxx}在{xxxxxxxx}内有效{x}
     * // 您的验证码是3212，在30分钟内有效。
     */
    public static final String SMS_REGISTER_TEMPLATE = "2031012026749";
    /**
     * 日期格式 yyyyMMdd
     */
    public static final String DATE_FMT_DATE = "yyyyMMdd";

    /**
     * 日期格式 HHmmss
     */
    public static final String DATE_FMT_TIME = "HHmmss";

    /**
     * 日期格式 yyyyMMddHHmmss
     */
    public static final String DATE_FMT_DATETIME = "yyyyMMddHHmmss";

    /**
     * 序列编号
     */
    public static final String SERVERID = "1";

    /**
     * 交易所编号
     */
    public static final String EXCHANGEID = "1";

    /**
     * 经纪商代码
     */
    private static final String DISTRIBUTORID = "100";

    /**
     * 是
     */
    public static final String YES = "1";

    /**
     * 否
     */
    public static final String NO = "0";

    /**
     * 是
     */
    public static final Integer I_YES = 1;

    /**
     * 否
     */
    public static final Integer I_NO = 0;

    /**
     * 个人手机号码允许重复数量
     */
    public static final Integer init_phone_count_person = 1;

    /**
     * 个人手机号码允许重复数量
     */
    public static final Integer init_phone_count_organ = 50;

    /**
     * 加解密机构代码
     */
    private static final String ADEncrypNo="MSJFmsjf";

    @Resource
    SysParamsConfigEntityMapper sysParamsConfigEntityMapper;

    /**
     * 生成 pwdLength长度的随机码
     * @param a
     * @param pwdLength
     * @return int
     */
    public static int getRandomCode(int a,int pwdLength){
        Random random = new Random();
        int b = random.nextInt(10);
        a = a * 10 + b;
        while (a < 100000){
            return getRandomCode(a,pwdLength);
        }
        return a;
    }
    public String getSysConfigValue(String paramId, String paramType){
        SysParamsConfigEntityKey sysParamsConfigKey=new SysParamsConfigEntityKey();
        sysParamsConfigKey.setDistributorId(DISTRIBUTORID);
        sysParamsConfigKey.setExchangeId(EXCHANGEID);
        sysParamsConfigKey.setParamId(paramId);
        sysParamsConfigKey.setParamType(paramType);
        SysParamsConfigEntity sysParamsConfig=sysParamsConfigEntityMapper.selectByPrimaryKey(sysParamsConfigKey);
        return sysParamsConfig.getParamValue();
    }
    /**
     * 生成客户代码
     *
     * @return
     */
    public static String generatorCustid() {
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        return result;
    }

    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String encryptPassword(String password){
        byte[] bytes=ADEncrypUtil.encrypt(password,ADEncrypNo);
        return ParseSystemUtil.parseByte2HexStr(bytes);
    }
    /**
     * 密码解密
     * @param password
     * @return
     */
    public static String decryptPassword(String password){
        byte[] bytes=ParseSystemUtil.parseHexStr2Byte(password);
        return ParseSystemUtil.parseByte2HexStr(ADEncrypUtil.decrypt(bytes,ADEncrypNo));
    }
    /**
     * HMAC-SHA1
     * @param   password 密码
     * @param  customerno 客户代码
     * @return
     * @throws Exception
     */
    public static String HmacSHA1Encrypt(String password, String customerno) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance(MAC_NAME);
            md.update(customerno.getBytes(ENCODING));
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(),e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
        return generatedPassword;
    }

    /**
     * 检查图像验证码正确性
     *
     * @param uniqueID
     * @param inputValidecode
     * @param rs
     * @return
     */
    public static boolean checkImageValidecode(String uniqueID, String inputValidecode, Response rs) {
        if (StringUtils.isBlank(uniqueID)) {
            rs.fail(CommonUtilEnum.MSG_PARAM_ERROR);
            return false;
        }
        if (StringUtils.isEmpty(inputValidecode)) {
            rs.fail(CommonUtilEnum.MSG_PARAM_ERROR);
            return false;
        }
        String generateTime = "";
        String md5Validecode = "";
        if (uniqueID.contains(":")) {
            String[] parts = uniqueID.split(":");
            if (parts != null && parts.length == 3) {
                generateTime = parts[0];
                md5Validecode = parts[2];
            } else {
                rs.fail(CommonUtilEnum.MSG_PARAM_ERROR);
                return false;
            }
        } else {
            rs.fail(CommonUtilEnum.MSG_PARAM_ERROR);
            return false;
        }
        if (generateTime != null && !"".equals(generateTime)) {
            long genTime = Long.parseLong(generateTime);
            if (System.currentTimeMillis() - genTime > 10 * 60 * 1000) {
                rs.fail(CommonUtilEnum.IMAGE_OVER_TIME);
                return false;
            }
        } else {
            rs.fail(CommonUtilEnum.IMAGE_TIME_GET_ERROR);
            return false;
        }
        if (md5Validecode != null && !"".equals(md5Validecode)) {
            if (!md5Validecode.toLowerCase().equals(MD5Util.string2MD5(inputValidecode.toLowerCase()))) {
                rs.fail(CommonUtilEnum.IMAGE_CHECK_FAILED);
                return false;
            }
        } else {
            rs.fail(CommonUtilEnum.IMAGE_MD5_ERROR);
            return false;
        }
        return true;
    }

    /**
     * 0-服务平台注册 1-管理平台登录 2-修改密码 4-业务平台登陆 等无登陆状态下,不传customerno
     */
    public static Response<VerificationCodeDomain> sendVerificationCode(String verificateType, String mobile){
        if(StringUtils.isEmpty(verificateType)){
            return new Response<>().fail(CommonUtilEnum.MSG_PARAM_ERROR);
        }
        if(StringUtils.isEmpty(mobile)){
            return new Response<>().fail(CommonUtilEnum.MSG_PARAM_ERROR);
        }
        if(verificateType.equals(SMS_REGISTER_TYPE)||verificateType.equals(SMS_CHANGE_PWD_TYPE)||verificateType.equals(SMS_LOGIN_TYPE)||verificateType.equals(SMS_SERVICE_LOGIN_TYPE)){
            HashMap map=new HashMap();
            map.put("verificateType",verificateType);
            map.put("mobile",mobile);
            map.put("templateId",SMS_REGISTER_TEMPLATE);//您的验证码是{xxxxxxxxxxxxxxx}在{xxxxxxxx}内有效{x}
            SendVerificationCodeFacade sendVerificationCodeFacade=SpringContextUtil.getBean("sendVerificationCodeFacade");
           //todo 这里入参错误 sendVerificationCodeFacade.SendRegisterVerificationCode(map);
            return sendVerificationCodeFacade.SendRegisterVerificationCode(null);
        }else{
            return new Response<>().fail();
        }
    }
    /**
     * 3-手机号码换绑 传customerno
     */
    public static Response<VerificationCodeDomain> sendChangeMobileCode(String customerno,String verificateType,String mobile){
        Response rs=null;
        if(StringUtils.isEmpty(verificateType)){
            return new Response<>().fail(CommonUtilEnum.MSG_PARAM_ERROR);
        }
        if(StringUtils.isEmpty(mobile)){
            return new Response<>().fail(CommonUtilEnum.MSG_PARAM_ERROR);
        }
        if(StringUtils.isEmpty(customerno)){
            return new Response<>().fail(CommonUtilEnum.MSG_PARAM_ERROR);
        }
        if(verificateType.equals(SMS_CHANGE_MOBILE_TYPE)){
            HashMap map=new HashMap();
            map.put("customerno",customerno);
            map.put("verificateType",verificateType);
            map.put("mobile",mobile);
            map.put("templateId",SMS_CHANGE_MOBILE_TYPE);//您的验证码是{xxxxxxxxxxxxxxx}在{xxxxxxxx}内有效{x}
            SendVerificationCodeFacade sendVerificationCodeFacade=SpringContextUtil.getBean("sendVerificationCodeFacade");
            //todo 这里入参错误 sendVerificationCodeFacade.SendRegisterVerificationCode(map);
            rs=sendVerificationCodeFacade.SendRegisterVerificationCode(null);
        }else{
            return rs;
        }
        return rs;
    }
    /**
     * 3-手机号码换绑 传customerno
     */
    public static Boolean isExistCodeChangeMobile(String customerno,String verificateType,String mobile,String msgCode){
        Response rs=null;
        if(StringUtils.isEmpty(verificateType)){
            return false;
        }
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        if(StringUtils.isEmpty(msgCode)){
            return false;
        }
        if(StringUtils.isEmpty(customerno)){
            return false;
        }
        if(SMS_CHANGE_MOBILE_TYPE.equals(verificateType)) {
            HashMap map=new HashMap();
            map.put("verificateType",SMS_CHANGE_MOBILE_TYPE);
            map.put("mobile",mobile);
            map.put("msgCode",msgCode);
            map.put("customerno",customerno);
            SendVerificationCodeFacade sendVerificationCodeFacade=SpringContextUtil.getBean("sendVerificationCodeFacade");
            rs=sendVerificationCodeFacade.isExistVerificationCode(map);
        }else{
            return false;
        }
        return rs.checkIfFail()?false:true;
    }
    /**
     * 0-服务平台注册 1-管理平台登录 2-修改密码 4-业务平台登陆 等无登陆状态下,不传customerno
     */
    public static Boolean isExistVerificationCode(String verificateType,String mobile,String msgCode){
        Response rs;
        if(StringUtils.isEmpty(verificateType)){
            return false;
        }
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        if(StringUtils.isEmpty(msgCode)){
            return false;
        }
        if(verificateType.equals(SMS_REGISTER_TYPE)||verificateType.equals(SMS_CHANGE_PWD_TYPE)||verificateType.equals(SMS_LOGIN_TYPE)||verificateType.equals(SMS_SERVICE_LOGIN_TYPE)) {
            HashMap map=new HashMap();
            map.put("verificateType",verificateType);
            map.put("mobile",mobile);
            map.put("msgCode",msgCode);
            SendVerificationCodeFacade sendVerificationCodeFacade=SpringContextUtil.getBean("sendVerificationCodeFacade");
            rs=sendVerificationCodeFacade.isExistVerificationCode(map);
        }else{
            return false;
        }
        return rs.checkIfFail()?false:true;
    }
    /**
     * 0-服务平台注册 1-管理平台登录 2-修改密码 4-业务平台登陆 等无登陆状态下,不传customerno
     */
    public static Boolean checkVerificationCode(String verificateType,String mobile,String msgCode){
        Response rs=null;
        if(StringUtils.isEmpty(verificateType)){
            return false;
        }
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        if(StringUtils.isEmpty(msgCode)){
            return false;
        }
        if(verificateType.equals(SMS_REGISTER_TYPE)||verificateType.equals(SMS_CHANGE_PWD_TYPE)||verificateType.equals(SMS_LOGIN_TYPE)||verificateType.equals(SMS_SERVICE_LOGIN_TYPE)) {
            HashMap map=new HashMap();
            map.put("verificateType",verificateType);
            map.put("mobile",mobile);
            map.put("msgCode",msgCode);
            SendVerificationCodeFacade sendVerificationCodeFacade=SpringContextUtil.getBean("sendVerificationCodeFacade");
            rs=sendVerificationCodeFacade.checkVerificationCode(map);
        }else{
            return false;
        }
        return rs.checkIfFail()?false:true;
    }
    /**
     * 3-手机号码换绑 传customerno
     */
    public static Boolean checkCodeChangeMobile(String customerno,String verificateType,String mobile,String msgCode){
        Response rs=null;
        if(StringUtils.isEmpty(verificateType)){
            return false;
        }
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        if(StringUtils.isEmpty(msgCode)){
            return false;
        }
        if(StringUtils.isEmpty(customerno)){
            return false;
        }
        if(SMS_CHANGE_MOBILE_TYPE.equals(verificateType)) {
            HashMap map=new HashMap();
            map.put("verificateType",SMS_CHANGE_MOBILE_TYPE);
            map.put("mobile",mobile);
            map.put("msgCode",msgCode);
            map.put("customerno",customerno);
            SendVerificationCodeFacade sendVerificationCodeFacade=SpringContextUtil.getBean("sendVerificationCodeFacade");
            rs=sendVerificationCodeFacade.checkVerificationCode(map);
        }else{
            return false;
        }
        return rs.checkIfFail()?false:true;
    }
    public static void main(String[] args){
        try{
            System.out.println(HmacSHA1Encrypt("123456","0008"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
