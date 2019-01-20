package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 个人基本信息表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:08
 */
public class PersonInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 客户代码
     */

    private String customerno;
    /**
     * 客户姓名
     */
    private String membername;
    /**
     * 学历
     */
    private String education;
    /**
     * 从业经历
     */
    private String workexp;
    /**
     * 投资经历
     */
    private String investexp;
    /**
     * 身份证上传（正反面满框）
     */
    private String idcard;
    /**
     * 基金从业资格证编码
     */
    private String amacno;
    /**
     * 是否拥有基金从业资格证 0-否 1-是
     */
    private String isamac;
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
     * 设置：客户姓名
     */
    public void setMembername(String membername) {
        this.membername = membername;
    }

    /**
     * 获取：客户姓名
     */
    public String getMembername() {
        return membername;
    }

    /**
     * 设置：学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取：学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置：从业经历
     */
    public void setWorkexp(String workexp) {
        this.workexp = workexp;
    }

    /**
     * 获取：从业经历
     */
    public String getWorkexp() {
        return workexp;
    }

    /**
     * 设置：投资经历
     */
    public void setInvestexp(String investexp) {
        this.investexp = investexp;
    }

    /**
     * 获取：投资经历
     */
    public String getInvestexp() {
        return investexp;
    }

    /**
     * 设置：身份证上传（正反面满框）
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取：身份证上传（正反面满框）
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置：基金从业资格证编码
     */
    public void setAmacno(String amacno) {
        this.amacno = amacno;
    }

    /**
     * 获取：基金从业资格证编码
     */
    public String getAmacno() {
        return amacno;
    }

    /**
     * 设置：是否拥有基金从业资格证 0-否 1-是
     */
    public void setIsamac(String isamac) {
        this.isamac = isamac;
    }

    /**
     * 获取：是否拥有基金从业资格证 0-否 1-是
     */
    public String getIsamac() {
        return isamac;
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
