package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 企业成员申报信息变更记录表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:09
 */
public class MemberSubmitChangeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */

    private String serialno;
    /**
     * 企业客户代码
     */
    private String customerno;
    /**
     * 当前版本号
     */
    private Integer version;
    /**
     * 姓名
     */
    private String username;
    /**
     * 证件类型 字典 个人+企业
     */
    private String certificatetype;
    /**
     * 证件号码
     */
    private String certificateno;
    /**
     * 出资比例
     */
    private String moneyscale;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 承担责任方式 字典 115 0-有限责任 1-无限责任
     */
    private String dutyway;
    /**
     * 出资方式 字典116 0-货币
     */
    private String moneytype;
    /**
     * 认缴出资额（万元）
     */
    private String amount;
    /**
     * 缴付期限
     */
    private String paydatelimit;
    /**
     * 住所
     */
    private String address;
    /**
     * 身份类型 字典 117 0-联络员 1-财务负责人 2-执行董事 3-董事长 4-董事 5-法定代表人/执行事务合伙人/委托代表 6-监事长 7-监事 8-经理 9-其他成员 10-股东
     */
    private String position;
    /**
     * 排序
     */
    private Integer sortnum;
    /**
     * 插入日期
     */
    private String insertdate;
    /**
     * 插入时间
     */
    private String inserttime;

    /**
     * 设置：流水号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    /**
     * 获取：流水号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * 设置：企业客户代码
     */
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    /**
     * 获取：企业客户代码
     */
    public String getCustomerno() {
        return customerno;
    }

    /**
     * 设置：当前版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取：当前版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置：姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：证件类型 字典 个人+企业
     */
    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype;
    }

    /**
     * 获取：证件类型 字典 个人+企业
     */
    public String getCertificatetype() {
        return certificatetype;
    }

    /**
     * 设置：证件号码
     */
    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }

    /**
     * 获取：证件号码
     */
    public String getCertificateno() {
        return certificateno;
    }

    /**
     * 设置：出资比例
     */
    public void setMoneyscale(String moneyscale) {
        this.moneyscale = moneyscale;
    }

    /**
     * 获取：出资比例
     */
    public String getMoneyscale() {
        return moneyscale;
    }

    /**
     * 设置：联系电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：联系电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置：承担责任方式 字典 115 0-有限责任 1-无限责任
     */
    public void setDutyway(String dutyway) {
        this.dutyway = dutyway;
    }

    /**
     * 获取：承担责任方式 字典 115 0-有限责任 1-无限责任
     */
    public String getDutyway() {
        return dutyway;
    }

    /**
     * 设置：出资方式 字典116 0-货币
     */
    public void setMoneytype(String moneytype) {
        this.moneytype = moneytype;
    }

    /**
     * 获取：出资方式 字典116 0-货币
     */
    public String getMoneytype() {
        return moneytype;
    }

    /**
     * 设置：认缴出资额（万元）
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 获取：认缴出资额（万元）
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置：缴付期限
     */
    public void setPaydatelimit(String paydatelimit) {
        this.paydatelimit = paydatelimit;
    }

    /**
     * 获取：缴付期限
     */
    public String getPaydatelimit() {
        return paydatelimit;
    }

    /**
     * 设置：住所
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：住所
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：身份类型 字典 117 0-联络员 1-财务负责人 2-执行董事 3-董事长 4-董事 5-法定代表人/执行事务合伙人/委托代表 6-监事长 7-监事 8-经理 9-其他成员 10-股东
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取：身份类型 字典 117 0-联络员 1-财务负责人 2-执行董事 3-董事长 4-董事 5-法定代表人/执行事务合伙人/委托代表 6-监事长 7-监事 8-经理 9-其他成员 10-股东
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置：排序
     */
    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    /**
     * 获取：排序
     */
    public Integer getSortnum() {
        return sortnum;
    }

    /**
     * 设置：插入日期
     */
    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }

    /**
     * 获取：插入日期
     */
    public String getInsertdate() {
        return insertdate;
    }

    /**
     * 设置：插入时间
     */
    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * 获取：插入时间
     */
    public String getInserttime() {
        return inserttime;
    }
}
