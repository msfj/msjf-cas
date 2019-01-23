package com.msjf.finance.cas.common.entity;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class IBaseEntity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -628812159934562820L;

    public IBaseEntity() {

    }

    public IBaseEntity(Map<String, Object> mapAttributes) {
        generator(mapAttributes);
    }

    public int rowsCount = 0;

    /**
     * 操作方式 I-insert U-update D-delete
      */
    protected String operateMode = "";

    public String getOperateMode() {
        return operateMode;
    }

    public void setOperateMode(String operateMode) {
        this.operateMode = operateMode;
    }

    public void generator(Map<String, Object> mapAttributes) {
        if (null == mapAttributes) {
            return;
        }
        try {
            Class<? extends IBaseEntity> clazz = this.getClass();
            List<Field> fields = new ArrayList<Field>();
            Class<?> currentClazz = clazz;
            while (currentClazz != null) {
                Field[] fs = currentClazz.getDeclaredFields();
                for (Field f : fs) {
                    String fieldName = f.getName();
                    // Exclude serialVersionUID in order to avoid PropertyDescriptor error
                    if (!fieldName.equals("operateMode") && !fieldName.equals("serialVersionUID")) {
                        fields.add(f);
                    }
                }
                currentClazz = currentClazz.getSuperclass();
            }
            for (Field field : fields) {
                PropertyDescriptor thisPropertyDescriptor = new PropertyDescriptor(field.getName(), this.getClass());
                Method setMethodOfThis = thisPropertyDescriptor.getWriteMethod();
                field.setAccessible(true);
                Object attributeValue = mapAttributes.get(field.getName());
                Class<?>[] paramClazz = setMethodOfThis.getParameterTypes();

                if (null != attributeValue) {
                    if (paramClazz[0].getName().equals("float") || paramClazz[0].getName().equals("java.lang.Float")) {
                        attributeValue = Float.valueOf(attributeValue.toString()).floatValue();
                    } else if (paramClazz[0].getName().equals("int") || paramClazz[0].getName().equals("java.lang" +
                            ".Integer")) {
                        attributeValue = Integer.parseInt(attributeValue.toString());
                    } else if (paramClazz[0].getName().equals("java.util.Date")) {
                        attributeValue = new SimpleDateFormat().parse(attributeValue.toString());
                        //attributeValue = java.util.Date.parse(attributeValue.toString());
                    } else if (paramClazz[0].getName().equals("double") || paramClazz[0].getName().equals("java.lang"
                            + ".Double")) {
                        attributeValue = Double.parseDouble(attributeValue.toString());
                    } else if (paramClazz[0].getName().equals("short") || paramClazz[0].getName().equals("java.lang"
                            + ".Short")) {
                        attributeValue = Short.parseShort(attributeValue.toString());
                    } else if (paramClazz[0].getName().equals("boolean") || paramClazz[0].getName().equals("java" +
                            ".lang" + ".Boolean")) {
                        attributeValue = Boolean.valueOf(attributeValue.toString()).booleanValue();
                    } else if (paramClazz[0].getName().equals("byte") || paramClazz[0].getName().equals("java.lang" +
                            ".Byte")) {
                        attributeValue = Byte.parseByte(attributeValue.toString());
                    } else if (paramClazz[0].getName().equals("long") || paramClazz[0].getName().equals("java.lang" +
                            ".Long")) {
                        attributeValue = Long.parseLong(attributeValue.toString());
                    }
                    field.set(this, attributeValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        try {
            Class<? extends IBaseEntity> clazz = this.getClass();
            List<Field> fields = new ArrayList<Field>();
            Class<?> currentClazz = clazz;
            while (currentClazz != null) {
                Field[] fs = currentClazz.getDeclaredFields();
                for (Field f : fs) {
                    String fieldName = f.getName();
                    // Exclude serialVersionUID in order to avoid PropertyDescriptor error
                    if (!fieldName.equals("operateMode") && !fieldName.equals("rowsCount") && !fieldName.equals
                            ("serialVersionUID")) {
                        fields.add(f);
                    }
                }
                currentClazz = currentClazz.getSuperclass();
            }
            for (Field field : fields) {
                int modifier = field.getModifiers();
                modifier = modifier & 0x00000008;
                if (modifier == 0) {
                    PropertyDescriptor thisPropertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
                    Method getMethodOfThis = thisPropertyDescriptor.getReadMethod();
                    buffer.append(field.getName() + "=" + getMethodOfThis.invoke(this) + ", ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int length = buffer.length();
        // If current object not have any custom filed, substring will trigger StringIndexOutOfBoundsException
        if (length > 2) {
            buffer.substring(0, length - 2);
        }
        return buffer.append("}").toString();
    }

    @Override
    public int hashCode() {
        try {
            Class<? extends IBaseEntity> clazz = this.getClass();
            List<Field> fields = new ArrayList<Field>();
            Class<?> currentClazz = clazz;
            while (currentClazz != null) {
                Field[] fs = currentClazz.getDeclaredFields();
                for (Field f : fs) {
                    String fieldName = f.getName();
                    // Exclude serialVersionUID in order to avoid PropertyDescriptor error
                    if (!fieldName.equals("operateMode") && !fieldName.equals("serialVersionUID")) {
                        fields.add(f);
                    }
                }
                currentClazz = currentClazz.getSuperclass();
            }
            StringBuffer buffer = new StringBuffer();
            for (Field field : fields) {
                PropertyDescriptor thisPropertyDescriptor = new PropertyDescriptor(field.getName(), this.getClass());
                Method getMethodOfThis = thisPropertyDescriptor.getReadMethod();
                Object thisFieldValue = getMethodOfThis.invoke(this);
                buffer.append(thisFieldValue);
            }
            return buffer.toString().hashCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Random rd = new Random();
        return rd.nextInt();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Class<? extends IBaseEntity> clazz = this.getClass();
            List<Field> fields = new ArrayList<Field>();
            Class<?> currentClazz = clazz;
            while (currentClazz != null) {
                Field[] fs = currentClazz.getDeclaredFields();
                for (Field f : fs) {
                    String fieldName = f.getName();
                    // Exclude serialVersionUID in order to avoid PropertyDescriptor error
                    if (!fieldName.equals("serialVersionUID")) {
                        fields.add(f);
                    }
                }
                currentClazz = currentClazz.getSuperclass();
            }
            for (Field field : fields) {
                PropertyDescriptor thisPropertyDescriptor = new PropertyDescriptor(field.getName(), this.getClass());
                Method getMethodOfThis = thisPropertyDescriptor.getReadMethod();
                PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(field.getName(), obj.getClass());
                Method getMethodOfObj = objPropertyDescriptor.getReadMethod();
                Object thisFieldValue = getMethodOfThis.invoke(this);
                Object objFieldValue = getMethodOfObj.invoke(obj);
                if (thisFieldValue != null || objFieldValue != null) {
                    boolean bol = (thisFieldValue != null && objFieldValue == null) || (thisFieldValue == null &&
                            objFieldValue != null) || (false == thisFieldValue.equals(objFieldValue));
                    if (bol) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }
}

