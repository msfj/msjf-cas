package com.msjf.finance.cas.common.utils;

public class MacroDefine {


    public static final String YES = "1";

    public static final String NO = "0";

    /**
     * 短信验证
     */
    public enum MSG_CHECK {
        CHECK("1", "验证"), UNCHECK("0", "不验证");
        private String value;
        private String name;

        MSG_CHECK(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    /**
     * 短信验证码验证状态
     */
    public enum MSG_CHECK_STATUS {
        CHECK("0", "未验证"), CHECKED("1", "已验证");
        private String value;
        private String name;

        MSG_CHECK_STATUS(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    /**
     * 短信验证码验证状态 MNO:Mobile Networks Operator 移动通信运营商 SIMULATION:不使用MNO，用于系统仿真
     */
    public enum MSG_SEND_MODE {
        UNSEND("0", "未验证"), MNO("1", "模拟发送"), SIMULATION("2", "模拟发送");
        private String value;
        private String name;

        MSG_SEND_MODE(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

        public static boolean isExistsEnum(String value) {
            for (MSG_SEND_MODE p : MSG_SEND_MODE.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 短信验证码默认长度，最低6位
     */
    public enum DEFAULT_CODE_LEN {
        DEF_LENGTH("6", "默认6位长度");
        private String value;
        private String name;

        DEFAULT_CODE_LEN(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

    }

    /**
     * 审核状态
     **/
    public enum AUDIT_STATUS {

        AUDIT_STATUS_INIT("0", "初始状态"), AUDIT_STATUS_APPLY("1", "未审核"), AUDIT_STATUS_PASS("2", "审核通过"),
        AUDIT_STATUS_FAIL("3", "审核不通过");
        private String value;
        private String name;

        AUDIT_STATUS(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.value;
        }

        public static boolean isExistsEnum(String value) {
            for (AUDIT_STATUS p : AUDIT_STATUS.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }


    /**
     * 账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定
     */
    public enum CUST_STATUS {
        CANCEL("*", "销户"), NORMAL("0", "正常"), FROZEN("1", "冻结"), LOCK("2", "锁定");

        private String value;

        private String name;

        CUST_STATUS(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static String getAcctStatusName(String value) {
            for (CUST_STATUS p : CUST_STATUS.values()) {
                if (p.value.equals(value)) {
                    return p.name;
                }
            }
            return null;
        }
    }

    /**
     * 流程类型 字典118 0-企业预核名 1-企业设立 2-企业变更 3-企业注销 4-企业迁入
     */
    public enum FLOW_TYPE {
        FLOW_TYPE_0("0", "拟申请企业设立"), FLOW_TYPE_1("1", "企业设立"), FLOW_TYPE_2("2", "企业变更"), FLOW_TYPE_3("3", "企业注销"),
        FLOW_TYPE_4("4", "企业迁入");

        private String value;

        private String name;

        FLOW_TYPE(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static String getAcctStatusName(String value) {
            for (FLOW_TYPE p : FLOW_TYPE.values()) {
                if (p.value.equals(value)) {
                    return p.name;
                }
            }
            return null;
        }
    }


    /**
     * 企业状态 字典 106 0-企业设立中 1-企业已注册 2-企业已注销
     */
    public enum ORGAN_STATUS {
        ORGAN_STATUS_0("0", "企业设立中"), ORGAN_STATUS_1("1", "企业已注册"), ORGAN_STATUS_2("2", "企业已注销");
        private String value;

        private String name;

        ORGAN_STATUS(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static String getAcctStatusName(String value) {
            for (ORGAN_STATUS p : ORGAN_STATUS.values()) {
                if (p.value.equals(value)) {
                    return p.name;
                }
            }
            return null;
        }
    }

    /**
     * 用户类型 字典 102 0-个人 1-企业
     */
    public enum MEMBER_TYPE {
        MEMBER_TYPE_0("0", "个人"), MEMBER_TYPE_1("1", "企业");
        private String value;

        private String name;

        MEMBER_TYPE(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static String getAcctStatusName(String value) {
            for (MEMBER_TYPE p : MEMBER_TYPE.values()) {
                if (p.value.equals(value)) {
                    return p.name;
                }
            }
            return null;
        }
    }

    /**
     * 是否申请退回 0否 1是
     */
    public enum IS_RETURN {
        IS_RETURN_0("0", "否"), IS_RETURN_1("1", "是");
        private String value;

        private String name;

        IS_RETURN(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        /**
         * 根据值获取名称
         *
         * @param value 值
         * @return 名称
         */
        public static String getAcctStatusName(String value) {
            for (IS_RETURN p : IS_RETURN.values()) {
                if (p.value.equals(value)) {
                    return p.name;
                }
            }
            return null;
        }
    }


}
