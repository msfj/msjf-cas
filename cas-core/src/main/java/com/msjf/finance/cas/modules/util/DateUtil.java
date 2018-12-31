package com.msjf.finance.cas.modules.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

    /**
     * Created by lzp on 2018/12/25.
     */
    public final class DateUtil {

        /**
         * 获取系统日期及时间 formatString 格式：yyyyMMdd hh:mm:ss
         * @param fromat
         * @return
         */
        public static String getUserDate(String fromat) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(fromat);
            String dateString = formatter.format(date);
            return dateString;
        }

        /**
         * 取得指定日期 （dateFrom日期格式与strFormat必须一致）
         *
         * @param dateFrom
         *            指定日期的字符串 (20080810)
         * @param amount
         *            日期增加变量 正数为加一天，负数为减一天
         * @param strFormat
         * @return
         */
        public static String getSelfDay(String dateFrom, int amount, String strFormat) {
            SimpleDateFormat formatYMD = new SimpleDateFormat(strFormat);

            Date date = null;
            try {
                date = formatYMD.parse(dateFrom);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, amount);
            return formatYMD.format(cal.getTime());
        }

        /**
         * 时间戳转换成日期格式字符串
         *
         * @param seconds 精确到秒的字符串
         * @param format
         * @return
         */
        public static String setTimeStamp2Date(String seconds, String format) {
            if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
                return "";
            }
            if (format == null || format.isEmpty()) {
                format = "yyyyMMddHHmmss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date(Long.valueOf(seconds + "000")));
        }

        /**
         * 日期格式字符串转换成时间戳
         * @param date 字符串日期
         * @param format 如：yyyy-MM-dd HH:mm:ss
         * @return
         */
        public static String setDate2TimeStamp(String date, String format) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                return String.valueOf(sdf.parse(date).getTime() / 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        /**
         * 取得当前时间戳（精确到秒）
         * @return
         */
        public static String getTimeStamp() {
            long time = System.currentTimeMillis();
            String t = String.valueOf(time / 1000);
            return t;
        }

        /**
         * 得到当前日期时间
         * @return yyyyMMddHHmmss
         */
        public static String getCurrDateTime() {
            Date now = new Date();
            SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String s = outFormat.format(now);
            return s;
        }

    }


