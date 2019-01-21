package com.msjf.finance.cas.modules.organ.entity;

/***
 *OrganRollinEntity
 *企业迁入基本信息表
 */
public class OrganRollinEntity extends OrganRollinKey {
    //申请人客户代码
    private String customerno;
    //企业名称
    private String companyname;
    //营业执照
    private String businessno;
    //企业负责人
    private String leader;
    //注册资本（万元）
    private String regicapital;
    //注册资本金币种
    private String regicapitalbz;
    //联系人
    private String linkmanname;
    //手机号码
    private String mobile;
    //服务人员代码
    private String servicecustomerno;
    //主要经营范围
    private String businessscope;
    //公司简介
    private String companyintro;
    //办公地址
    private String workaddress;
    //注册地址
    private String registeraddress;
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

    public String getSerialno() {
        return this.serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getCustomerno() {
        return this.customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getCompanyname() {
        return this.companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getBusinessno() {
        return this.businessno;
    }

    public void setBusinessno(String businessno) {
        this.businessno = businessno;
    }

    public String getLeader() {
        return this.leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getRegicapital() {
        return this.regicapital;
    }

    public void setRegicapital(String regicapital) {
        this.regicapital = regicapital;
    }

    public String getRegicapitalbz() {
        return this.regicapitalbz;
    }

    public void setRegicapitalbz(String regicapitalbz) {
        this.regicapitalbz = regicapitalbz;
    }

    public String getLinkmanname() {
        return this.linkmanname;
    }

    public void setLinkmanname(String linkmanname) {
        this.linkmanname = linkmanname;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getServicecustomerno() {
        return this.servicecustomerno;
    }

    public void setServicecustomerno(String servicecustomerno) {
        this.servicecustomerno = servicecustomerno;
    }

    public String getBusinessscope() {
        return this.businessscope;
    }

    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope;
    }

    public String getCompanyintro() {
        return this.companyintro;
    }

    public void setCompanyintro(String companyintro) {
        this.companyintro = companyintro;
    }

    public String getWorkaddress() {
        return this.workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress;
    }

    public String getRegisteraddress() {
        return this.registeraddress;
    }

    public void setRegisteraddress(String registeraddress) {
        this.registeraddress = registeraddress;
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