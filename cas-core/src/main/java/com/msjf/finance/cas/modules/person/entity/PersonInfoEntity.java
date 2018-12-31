package com.msjf.finance.cas.modules.person.entity;

/**
 * 个人基本信息表
 * Created by lzp on 2018/12/28.
 */
public class PersonInfoEntity {
    //客户代码
    private String customerno;
    //客户姓名
    private String membername;
    //学历
    private String education;
    //从业经历
    private String workexp;
    //投资经历
    private String investexp;
    //身份证上传（正反面满框）
    private String idcard;
    //是否拥有基金从业资格证 0-否 1-是
    private String isamac;
    //基金从业资格证编码
    private String amacno;
    //插入日期
    private String insertdate;
    //插入时间
    private String inserttime;
    //更新日期
    private String updatedate;
    //更新时间
    private String updatetime;
    public void init() {
    }
    public String getCustomerno() {
        return this.customerno;
    }
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }
    public String getMembername() {
        return this.membername;
    }
    public void setMembername(String membername) {
        this.membername = membername;
    }
    public String getEducation() {
        return this.education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public String getWorkexp() {
        return this.workexp;
    }
    public void setWorkexp(String workexp) {
        this.workexp = workexp;
    }
    public String getInvestexp() {
        return this.investexp;
    }
    public void setInvestexp(String investexp) {
        this.investexp = investexp;
    }
    public String getIdcard() {
        return this.idcard;
    }
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    public String getIsamac() {
        return this.isamac;
    }
    public void setIsamac(String isamac) {
        this.isamac = isamac;
    }
    public String getAmacno() {
        return this.amacno;
    }
    public void setAmacno(String amacno) {
        this.amacno = amacno;
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
}
