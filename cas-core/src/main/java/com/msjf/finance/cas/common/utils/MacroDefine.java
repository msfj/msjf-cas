package com.msjf.finance.cas.common.utils;

public class MacroDefine {


    public static final String YES = "1";

    public static final String NO = "0";

    /** 短信验证 */
    public static enum MSG_CHECK {
        CHECK("1", "验证"), UNCHECK("0", "不验证");
        private String value;
        private String name;

        private MSG_CHECK(String value, String name) {
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

    /** 短信验证码验证状态 */
    public static enum MSG_CHECK_STATUS {
        CHECK("0", "未验证"), CHECKED("1", "已验证");
        private String value;
        private String name;

        private MSG_CHECK_STATUS(String value, String name) {
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
     * */
    public static enum MSG_SEND_MODE {
        UNSEND("0", "未验证"), MNO("1", "模拟发送"), SIMULATION("2", "模拟发送");
        private String value;
        private String name;

        private MSG_SEND_MODE(String value, String name) {
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
     * */
    public static enum DEFAULT_CODE_LEN {
        DEF_LENGTH("6", "默认6位长度");
        private String value;
        private String name;

        private DEFAULT_CODE_LEN(String value, String name) {
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
     * 融资申请类型
     **/
    public static enum FINANCING_APPLY_TYPE {
        ORG_FINANCING_APPLY("0", "机构融资"), PERSON_CREDIT_APPLY("1", "个人信用融资"), PERSON_PLEDGE_APPLY(
                "2", "个人抵押融资");
        private String value;
        private String name;

        private FINANCING_APPLY_TYPE(String value, String name) {
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
            for (FINANCING_APPLY_TYPE p : FINANCING_APPLY_TYPE.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 审核状态
     **/
    public static enum AUDIT_STATUS {

        AUDIT_STATUS_APPLY("0", "未审核"), AUDIT_STATUS_PASS("1", "审核通过"), AUDIT_STATUS_FAIL(
                "2", "审核不通过");
        private String value;
        private String name;

        private AUDIT_STATUS(String value, String name) {
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
     * 期限单位
     **/
    public static enum DEADLINE_UNIT {
        UNIT_DAY("D", "天"), UNIT_MONTH("M", "月"), UNIT_YEAR("Y", "年");
        private String value;
        private String name;

        private DEADLINE_UNIT(String value, String name) {
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
            for (DEADLINE_UNIT p : DEADLINE_UNIT.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 计息方式
     **/
    public static enum INTEREST_TYPE {
        TYPE_360("1", "ACT/360"), TYPE_365("2", "ACT/365"), TYPE_MONTH("3",
                "按月计息");
        private String value;
        private String name;

        private INTEREST_TYPE(String value, String name) {
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
            for (INTEREST_TYPE p : INTEREST_TYPE.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 计息方式
     **/
    public static enum REPAY_TYPE {
        REPAY_MONTH("1", "按月付息，到期还本"), REPAY_QUARTER("2", "按季度付息，到期还本"), REPAY_HALFYEAR(
                "3", "按半年付息，到期还本"), REPAY_YEAR("4", "按年付息，到期还本"), REPAY_FINAL(
                "5", "到期还本付息"), REPAY_PER_PRINC("6", "等额本金"), REPAY_PER_INTEREST(
                "7", "等额本息");

        private String value;
        private String name;

        private REPAY_TYPE(String value, String name) {
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
            for (REPAY_TYPE p : REPAY_TYPE.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 收益计算方式
     **/
    public static enum RECEIPTS_CAL_TYPE {
        CAL_TYPE_1("1", "约定收益"), CAL_TYPE_2("2", "净值浮动"), CAL_TYPE_3("3",
                "分配收益"), CAL_TYPE_4("4", "额度浮动"), CAL_TYPE_5("5", "预期收益"), CAL_TYPE_6(
                "6", "期限浮动"), CAL_TYPE_7("7", "固定+浮动");

        private String value;
        private String name;

        private RECEIPTS_CAL_TYPE(String value, String name) {
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
            for (RECEIPTS_CAL_TYPE p : RECEIPTS_CAL_TYPE.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 计息起点
     **/
    public static enum INTEREST_START_POINT {
        POINT_0("0", "结束募集开始计息"), POINT_1("1", "按投资时间开始计息"), POINT_2("2",
                "募集期内按活期利率计息");

        private String value;
        private String name;

        private INTEREST_START_POINT(String value, String name) {
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
            for (INTEREST_START_POINT p : INTEREST_START_POINT.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 产品状态
     */
    public static enum PRODUCT_STATUS {
        STATUS_0("0", "初始状态"), STATUS_1("1", "待发行"), STATUS_2("2", "募集中"), STATUS_3(
                "3", "募集结束"), STATUS_4("4", "募集失败"), STATUS_5("5", "合同成立"), STATUS_6(
                "6", "还款中"), STATUS_7("7", "代偿中"), STATUS_8("8", "追偿中"), STATUS_9(
                "9", "已结清"),STATUS_10("10","到期下架"),STATUS_11("11","异常下架");
        private String value;
        private String name;

        private PRODUCT_STATUS(String value, String name) {
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
            for (PRODUCT_STATUS p : PRODUCT_STATUS.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 订单支付状态
     */
    public static enum ORDER_PAY_STATUS {
        STATUS_NOPAY("0", "未支付"), STATUS_PAID("1", "已支付"), STATUS_PARTPAY("2",
                "部分支付"), STATUS_CANCLE("3", "已取消"),STATUS_DRAWBACK("4","已退款");
        private String value;
        private String name;

        private ORDER_PAY_STATUS(String value, String name) {
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
            for (ORDER_PAY_STATUS p : ORDER_PAY_STATUS.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }
    /**
     * 订单状态
     */
    public static enum ORDER_STATUS {
        STATUS_INI("0", "初始状态"), STATUS_CONFIRMING("1", "成交确认中"), STATUS_SUCCESS("2",
                "成功"), STATUS_DRAWBACK("3", "退款"),STATUS_CANCLE("4","取消");
        private String value;
        private String name;

        private ORDER_STATUS(String value, String name) {
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
            for (ORDER_STATUS p : ORDER_STATUS.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 兑付状态
     */
    public static enum REPAY_STATUS {
        STATUS_NOREPAY("0", "未兑付"),
        STATUS_PARTREPAY("1", "部分兑付"),
        STATUS_REPAIED("2","已兑付"),
        STATUS_STOP("3","停止兑付");
        private String value;
        private String name;

        private REPAY_STATUS(String value, String name) {
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
            for (REPAY_STATUS p : REPAY_STATUS.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }
    /**
     * 还款冻结状态
     */
    public static enum REPAY_FROZEN_STATUS {
        STATUS_1("1", "未冻结"),
        STATUS_2("2", "线上还款冻结"),
        STATUS_3("3","线上还款已确认"),
        STATUS_4("4","线下已还款");
        private String value;
        private String name;

        private REPAY_FROZEN_STATUS(String value, String name) {
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
            for (REPAY_FROZEN_STATUS p : REPAY_FROZEN_STATUS.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }
    /**
     * 还款冻结状态
     */
    public static enum REPAY_MODE {
        MODE_0("0","未还款"),
        MODE_1("1", "正常还款"),
        MODE_2("2", "提前还款"),
        MODE_3("3","余额增值归还赎回");
        private String value;
        private String name;

        private REPAY_MODE(String value, String name) {
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
            for (REPAY_MODE p : REPAY_MODE.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 产品展示分类
     */
    public static enum CLASSFICATION_TYPE {
        TYPE_0("0","所有"),
        TYPE_1("1", "新手"),
        TYPE_2("2", "APP"),
        TYPE_3("3","VIP"),
        TYPE_4("4","热卖"),
        TYPE_5("5","重点推荐"),
        TYPE_6("6","优选");
        private String value;
        private String name;
        private CLASSFICATION_TYPE(String value, String name) {
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
            for (CLASSFICATION_TYPE p : CLASSFICATION_TYPE.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 转让状态
     */
    public static enum TRANSFER_STATUS {
        STATUS_0("0","转让发布预埋中"),
        STATUS_1("1", "部分成交"),
        STATUS_2("2", "全部成交"),
        STATUS_3("3","已撤销"),
        STATUS_4("4","已过期"),
        STATUS_5("5","初始状态"),
        STATUS_6("6","处理失败"),
        STATUS_7("7","转让撤销预处理中");
        private String value;
        private String name;

        private TRANSFER_STATUS(String value, String name) {
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
            for (TRANSFER_STATUS p : TRANSFER_STATUS.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 产品类型
     */
    public static enum PRODUCT_TYPE {
        TYPE_1("1", "债权收益权"),
        TYPE_2("2", "余额增值"),
        TYPE_3("3","养老计划理财"),
        TYPE_4("4","交易所理财"),
        TYPE_5("5","券商大集合"),
        TYPE_6("6","股票质押借款"),
        TYPE_7("7","投资收益权"),
        TYPE_8("8","应收账款合约"),
        TYPE_9("9","票据收益权"),
        TYPE_10("10","信托理财类"),
        TYPE_11("11","债券理财类");
        private String value;
        private String name;
        private PRODUCT_TYPE(String value, String name) {
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
            for (PRODUCT_TYPE p : PRODUCT_TYPE.values()) {
                if (p.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 还款类型
     */
    public static enum REPAY_FROM {
        FROM_0("0", "融资方分步还款"),
        FROM_1("1", "融资方直接还款"),
        FROM_2("2",	"平台风险金代偿"),
        FROM_3("3",	"担保公司代偿");
        private String value;
        private String name;
        private REPAY_FROM(String value, String name) {
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
            for (REPAY_FROM p : REPAY_FROM.values()) {
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
    public static enum CUST_STATUS {
        CANCEL("*", "销户"), NORMAL("0", "正常"), FROZEN("1", "冻结"), LOCK("2", "锁定");

        private String value;

        private String name;

        private CUST_STATUS(String value, String name) {
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

        public static String getAcctStatusName(String statusCode) {
            for (CUST_STATUS p : CUST_STATUS.values()) {
                if (p.value.equals(statusCode)) {
                    return p.name;
                }
            }
            return null;
        }
    }

    /**
     * 流程类型 字典118 0-企业预核名 1-企业设立 2-企业变更 3-企业注销 4-企业迁入
     */
    public static enum FLOW_TYPE {
        NAME("0", "拟申请企业设立"), BUILD("1", "企业设立"), MODIFY("2", "企业变更"), CANCLE("3", "企业注销"), IN("4", "企业迁入");

        private String value;

        private String name;

        private FLOW_TYPE(String value, String name) {
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

        public static String getAcctStatusName(String statusCode) {
            for (FLOW_TYPE p : FLOW_TYPE.values()) {
                if (p.value.equals(statusCode)) {
                    return p.name;
                }
            }
            return null;
        }
    }

}
