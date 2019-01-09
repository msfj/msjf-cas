package com.msjf.finance.cas.modules.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.modules.login.dao.SysParamsConfigEntityMapper;
import com.msjf.finance.cas.modules.login.entity.SysParamsConfigEntity;
import com.msjf.finance.cas.modules.login.entity.SysParamsConfigEntityKey;

import javax.annotation.Resource;
import java.util.*;
/**
 * 公用参数
 * Created by lzp on 2018/12/26.
 */
public final class CommonUtil {
    /**
     * 认证类型 0-服务平台注册 1-管理平台登录 2-修改密码 3-手机换绑 4-登陆平台登陆
     */
    public static final String SMS_REGISTER_TYPE = "0";
    public static final String SMS_LOGIN_TYPE = "1";
    public static final String SMS_CHANGE_PWD_TYPE = "2";
    public static final String SMS_CHANGE_MOBILE_TYPE = "3";
    public static final String SMS_SERVICE_LOGIN_TYPE = "4";
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
     * 检查图像验证码正确性
     *
     * @param uniqueID
     * @param inputValidecode
     * @param rs
     * @return
     */
    public static boolean checkImageValidecode(String uniqueID, String inputValidecode, Response rs) {
        if (CheckUtil.isNull(uniqueID)) {
            rs.fail("入参uniqueID不能为空");
            return false;
        }
        if (CheckUtil.isNull(inputValidecode)) {
            rs.fail("未传入输入的验证码");
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
                rs.fail("uniqueID格式非法");
                return false;
            }
        } else {
            rs.fail("uniqueID格式非法");
            return false;
        }
        if (generateTime != null && !"".equals(generateTime)) {
            long genTime = Long.parseLong(generateTime);
            if (System.currentTimeMillis() - genTime > 10 * 60 * 1000) {
                rs.fail("图形码验证已经失效");
                return false;
            }
        } else {
            rs.fail("图形码验证时间参数解析错误");
            return false;
        }
        if (md5Validecode != null && !"".equals(md5Validecode)) {
            if (!md5Validecode.toLowerCase().equals(MD5Util.string2MD5(inputValidecode.toLowerCase()))) {
                rs.fail("验证码校验失败");
                return false;
            }
        } else {
            rs.fail("图形码验证MD5参数解析错误");
            return false;
        }
        return true;
    }
}
