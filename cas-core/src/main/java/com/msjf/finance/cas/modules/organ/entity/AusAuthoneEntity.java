package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 登录认证表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:08
 */
public class AusAuthoneEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 客户代码
     */
    private String customerno;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 认证累计失败次数
     */
    private Integer failcount;
    /**
     * 注册来源 100 0-web 1-app
     */
    private String registersource;
    /**
     * 插入日期
     */
    private String insertdate;
    /**
     * 插入时间
     */
    private String inserttime;
    /**
     * 更新日期（最后认证时间）
     */
    private String updatedate;
    /**
     * 更新时间（最后认证时间）
     */
    private String updatetime;
    /**
     * 来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
     */
    private String source;
    /**
     * 在线状态(N-不在线 Y-在线)
     */
    private String onlinestatus;
    /**
     * 登陆来源(0-web 1-app)
     */
    private String loginsource;

    /**
     * 设置：客户代码
     */
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    /**
     * 获取：客户代码
     */
    public String getCustomerno() {
        return customerno;
    }

    /**
     * 设置：登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：认证累计失败次数
     */
    public void setFailcount(Integer failcount) {
        this.failcount = failcount;
    }

    /**
     * 获取：认证累计失败次数
     */
    public Integer getFailcount() {
        return failcount;
    }

    /**
     * 设置：注册来源 100 0-web 1-app
     */
    public void setRegistersource(String registersource) {
        this.registersource = registersource;
    }

    /**
     * 获取：注册来源 100 0-web 1-app
     */
    public String getRegistersource() {
        return registersource;
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

    /**
     * 设置：更新日期（最后认证时间）
     */
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取：更新日期（最后认证时间）
     */
    public String getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置：更新时间（最后认证时间）
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取：更新时间（最后认证时间）
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置：来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取：来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置：在线状态(N-不在线 Y-在线)
     */
    public void setOnlinestatus(String onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    /**
     * 获取：在线状态(N-不在线 Y-在线)
     */
    public String getOnlinestatus() {
        return onlinestatus;
    }

    /**
     * 设置：登陆来源(0-web 1-app)
     */
    public void setLoginsource(String loginsource) {
        this.loginsource = loginsource;
    }

    /**
     * 获取：登陆来源(0-web 1-app)
     */
    public String getLoginsource() {
        return loginsource;
    }
}
