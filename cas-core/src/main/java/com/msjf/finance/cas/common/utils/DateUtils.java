package com.msjf.finance.cas.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-23 15:47
 */
public class DateUtils {

    /** 日期格式 yyyyMMdd */
    public static final String DATE_FMT_DATE = "yyyyMMdd";

    /** 日期格式 HHmmss */
    public static final String DATE_FMT_TIME = "HHmmss";

    /** 日期格式 yyyyMMddHHmmss */
    public static final String DATE_FMT_DATETIME = "yyyyMMddHHmmss";


    // 获取系统日期及时间 formatString 格式：yyyyMMdd hh:mm:ss
    public static String getUserDate(String fromat) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(fromat);
        String dateString = formatter.format(date);
        return dateString;
    }
}
