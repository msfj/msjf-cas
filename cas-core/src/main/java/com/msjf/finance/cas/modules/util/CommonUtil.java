package com.msjf.finance.cas.modules.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
/**
 * 公用参数
 * Created by lzp on 2018/12/26.
 */
public final class CommonUtil {
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
}
