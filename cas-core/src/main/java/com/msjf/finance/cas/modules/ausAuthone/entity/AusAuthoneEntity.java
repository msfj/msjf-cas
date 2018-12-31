package com.msjf.finance.cas.modules.ausAuthone.entity;

/**
 * 登录认证表
 * Created by lzp on 2018/12/28.
 */
public class AusAuthoneEntity {
    //客户代码
    private  String customerno;
    //登录密码
    private String password;
    //认证累计失败次数
    private Integer failcount;
    //在线状态 N-不在线 Y-在线
    private String onlinestatus;
    //注册来源 100 0-web 1-app
    private String registersource;
    //登录来源 100
    private String loginsource;
    //插入日期
    private String insertdate;
    //插入时间
    private String inserttime;
    //更新日期（最后认证时间）
    private String updatedate;
    //更新时间（最后认证时间）
    private String updatetime;
    //来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
    private String source;
    public void init() {
    }
    public String getCustomerno() {
        return this.customerno;
    }
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getFailcount() {
        return this.failcount;
    }
    public void setFailcount(Integer failcount) {
        this.failcount = failcount;
    }
    public String getOnlinestatus() {
        return this.onlinestatus;
    }
    public void setOnlinestatus(String onlinestatus) {
        this.onlinestatus = onlinestatus;
    }
    public String getRegistersource() {
        return this.registersource;
    }
    public void setRegistersource(String registersource) {
        this.registersource = registersource;
    }
    public String getLoginsource() {
        return this.loginsource;
    }
    public void setLoginsource(String loginsource) {
        this.loginsource = loginsource;
    }
    public String getInsertdate() {
        return this.insertdate;
    }
    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }
    public String getInserttime() {
        return this.inserttime;
    }
    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }
    public String getUpdatedate() {
        return this.updatedate;
    }
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }
    public String getUpdatetime() {
        return this.updatetime;
    }
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
