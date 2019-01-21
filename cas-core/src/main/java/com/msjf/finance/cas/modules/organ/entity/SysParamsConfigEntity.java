package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:08
 */
public class SysParamsConfigEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 交易所ID
     */

    private String exchangeId;
    /**
     * 经纪商ID
     */
    private String distributorId;
    /**
     * 参数类型
     */
    private String paramType;
    /**
     * 参数ID
     */
    private String paramId;
    /**
     * 参数值
     */
    private String paramValue;
    /**
     * 参数说明
     */
    private String comments;
    /**
     * 参数状态
     */
    private Integer paramStatus;
    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 设置：交易所ID
     */
    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    /**
     * 获取：交易所ID
     */
    public String getExchangeId() {
        return exchangeId;
    }

    /**
     * 设置：经纪商ID
     */
    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }

    /**
     * 获取：经纪商ID
     */
    public String getDistributorId() {
        return distributorId;
    }

    /**
     * 设置：参数类型
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    /**
     * 获取：参数类型
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * 设置：参数ID
     */
    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    /**
     * 获取：参数ID
     */
    public String getParamId() {
        return paramId;
    }

    /**
     * 设置：参数值
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * 获取：参数值
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * 设置：参数说明
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取：参数说明
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置：参数状态
     */
    public void setParamStatus(Integer paramStatus) {
        this.paramStatus = paramStatus;
    }

    /**
     * 获取：参数状态
     */
    public Integer getParamStatus() {
        return paramStatus;
    }

    /**
     * 设置：排序
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取：排序
     */
    public Integer getSortNo() {
        return sortNo;
    }
}
