package com.msjf.finance.cas.common.utils;

import com.msjf.finance.msjf.core.response.Response;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    务无关通用检查方法
 *  <pre/>
 * @author 95494
 * @create 2019-01-23 14:53
 */
public class CheckUtil {


    /**
     * @author keivn
     * @Title: checkNoNull
     * @Description: 检查参数是否为空
     */
    public static boolean checkNull(Object b,String serviceName, String errMsg, Response rs) {
        boolean flag = true;
        if (b != null) {
            if (b instanceof String) {
                String str = (String) b;
                flag = ("").equals(str) ? true : ("null".equalsIgnoreCase(str) ? true : false);
            } else {
                flag = false;
            }
        }
        if (flag) {
            rs.fail(serviceName,errMsg + "不能为空");
        }
        return flag;
    }

    /**
     * 字符是否为空或"null"
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (str == null) {
            return true;
        }
        if ("null".equalsIgnoreCase(str)) {
            return true;
        }
        if ("".equals(str)) {
            return true;
        }
        return false;
    }

    // 判断是否为空
    public static boolean isNull(Object b) {
        if (b == null) {
            return true;
        }

        if (b instanceof String) {
            String strObj = String.valueOf(b);
            return "".equals(strObj);
        }
        return false;
    }

    // 判断Map是否为空
    public static boolean isNull(Map<?, ?> mp) {
        if (mp == null || mp.isEmpty() || mp.size() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断list 是否为null，size<=0
     *
     * @param list
     * @return
     */
    public static boolean isNull(List<?> list) {
        if (list == null || list.isEmpty() || list.size() <= 0) {
            return true;
        }
        return false;
    }

}
