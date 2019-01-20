package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 企业迁入基本信息表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:08
 */
public class OrganRollinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 申请编号
     */

    private String serialno;
    /**
     * 申请人客户代码
     */
    private String customerno;
    /**
     * 企业名称
     */
    private String companyname;
    /**
     * 营业执照
     */
    private String businessno;
    /**
     * 企业负责人
     */
    private String leader;
    /**
     * 注册资本（万元）
     */
    private String regicapital;
    /**
     * 注册资本金币种
     */
    private String regicapitalbz;
    /**
     * 联系人
     */
    private String linkmanname;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 服务人员代码
     */
    private String servicecustomerno;
    /**
     * 主要经营范围
     */
    private String businessscope;
    /**
     * 公司简介
     */
    private String companyintro;
    /**
     * 办公地址
     */
    private String workaddress;
    /**
     * 注册地址
     */
    private String registeraddress;
    /**
     * 插入日期
     */
    private String insertdate;
    /**
     * 插入时间
     */
    private String inserttime;
    /**
     * 更新日期
     */
    private String updatedate;
    /**
     * 更新时间
     */
    private String updatetime;

    /**
     * 设置：申请编号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    /**
     * 获取：申请编号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * 设置：申请人客户代码
     */
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    /**
     * 获取：申请人客户代码
     */
    public String getCustomerno() {
        return customerno;
    }

    /**
     * 设置：企业名称
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    /**
     * 获取：企业名称
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * 设置：营业执照
     */
    public void setBusinessno(String businessno) {
        this.businessno = businessno;
    }

    /**
     * 获取：营业执照
     */
    public String getBusinessno() {
        return businessno;
    }

    /**
     * 设置：企业负责人
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * 获取：企业负责人
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 设置：注册资本（万元）
     */
    public void setRegicapital(String regicapital) {
        this.regicapital = regicapital;
    }

    /**
     * 获取：注册资本（万元）
     */
    public String getRegicapital() {
        return regicapital;
    }

    /**
     * 设置：注册资本金币种
     */
    public void setRegicapitalbz(String regicapitalbz) {
        this.regicapitalbz = regicapitalbz;
    }

    /**
     * 获取：注册资本金币种
     */
    public String getRegicapitalbz() {
        return regicapitalbz;
    }

    /**
     * 设置：联系人
     */
    public void setLinkmanname(String linkmanname) {
        this.linkmanname = linkmanname;
    }

    /**
     * 获取：联系人
     */
    public String getLinkmanname() {
        return linkmanname;
    }

    /**
     * 设置：手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置：服务人员代码
     */
    public void setServicecustomerno(String servicecustomerno) {
        this.servicecustomerno = servicecustomerno;
    }

    /**
     * 获取：服务人员代码
     */
    public String getServicecustomerno() {
        return servicecustomerno;
    }

    /**
     * 设置：主要经营范围
     */
    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope;
    }

    /**
     * 获取：主要经营范围
     */
    public String getBusinessscope() {
        return businessscope;
    }

    /**
     * 设置：公司简介
     */
    public void setCompanyintro(String companyintro) {
        this.companyintro = companyintro;
    }

    /**
     * 获取：公司简介
     */
    public String getCompanyintro() {
        return companyintro;
    }

    /**
     * 设置：办公地址
     */
    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress;
    }

    /**
     * 获取：办公地址
     */
    public String getWorkaddress() {
        return workaddress;
    }

    /**
     * 设置：注册地址
     */
    public void setRegisteraddress(String registeraddress) {
        this.registeraddress = registeraddress;
    }

    /**
     * 获取：注册地址
     */
    public String getRegisteraddress() {
        return registeraddress;
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
     * 设置：更新日期
     */
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取：更新日期
     */
    public String getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取：更新时间
     */
    public String getUpdatetime() {
        return updatetime;
    }
}
