package com.msjf.finance.cas.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-26 17:13
 */
public class EntityUtil {

    /**
     * 单实例对象转为map
     * @param obj  单实例对象
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Map<String, Object> entity2map(Object obj) throws IllegalArgumentException, IllegalAccessException {
        if (obj == null) {
            return null;
        }
        Map hashMap = new HashMap();
        Class clazz = obj.getClass();
        while (clazz instanceof Class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Object objVal = null;
                field.setAccessible(true);
                objVal = field.get(obj);
                hashMap.put(field.getName(), objVal);
            }
            clazz = clazz.getSuperclass();
        }
        return hashMap;
    }


    /**
     * List实体转listmap
     * @param entityList
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static List<Map<String, Object>> entityListToMapList(List entityList)
            throws IllegalArgumentException, IllegalAccessException {
        if (entityList == null || entityList.size() == 0) {
            return null;
        }
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < entityList.size(); i++) {
            mapList.add(entity2map(entityList.get(i)));
        }
        return mapList;
    }

    /**
     * map转化成实体
     * @param map
     * @param cls
     * @return
     */
    public static Object mapToEntity(Map map, Class cls) {
        Object obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 取出Entity里的所有方法
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            String method = methods[i].getName();
            Class[] cc = methods[i].getParameterTypes();
            if (cc.length != 1) continue;
            // 如果方法名没有以set开头的则退出本次for
            if (method.indexOf("set") < 0) continue;
            String type = cc[0].getSimpleName();
            try {
                // 转成小写
                // Object value = method.substring(3).toLowerCase();
                Object value = method.substring(3, 4).toLowerCase() + method.substring(4);
                if (map.containsKey(value) && map.get(value) != null) {
                    setValue(type, map.get(value), i, methods, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * 调用底层方法设置值
     * @param type
     * @param value
     * @param i
     * @param method
     * @param bean
     */
    private static void setValue(String type, Object value, int i, Method[] method, Object bean) {
        if (value != null && !value.equals("")) {
            try {
                if (type.equals("String")) {
                    // 第一个参数:从中调用基础方法的对象 第二个参数:用于方法调用的参数
                    method[i].invoke(bean, new Object[]{value});
                } else if (type.equals("int") || type.equals("Integer")) {
                    method[i].invoke(bean, new Object[]{new Integer("" + value)});
                } else if (type.equals("long") || type.equals("Long")) {
                    method[i].invoke(bean, new Object[]{new Long("" + value)});
                } else if (type.equals("boolean") || type.equals("Boolean")) {
                    method[i].invoke(bean, new Object[]{Boolean.valueOf("" + value)});
                } else if (type.equals("BigDecimal")) {
                    method[i].invoke(bean, new Object[]{new BigDecimal("" + value)});
                } else if (type.equals("double") || type.equals("Double")) {
                    method[i].invoke(bean, new Object[]{new Double("" + value)});
                } else if (type.equals("Date")) {
                    // 日期暂时没有实现
                    Date date = null;
                    if (value.getClass().getName().equals("java.util.Date")) {
                        date = (Date) value;
                    } else {
                        //String format = ((String) value).indexOf(":") > 0 ? "yyyy-MM-dd hh:mm:ss" : "yyyy-MM-dd";
                        // date =
                        // DateUtil.convertStrtoDateIsss((String)(value),format);
                    }
                    if (date != null) {
                        method[i].invoke(bean, new Object[]{date});
                    }
                } else if (type.equals("byte[]")) {
                    method[i].invoke(bean, new Object[]{new String(value + "").getBytes()});
                }
            } catch (Exception e) {
                System.out.println("Map转化成Entity失败");
                e.printStackTrace();
            }
        }

    }
}
