package com.msjf.finance.cas.common.entity;

/***
 *OrganCounterSignEntity
 *会签结果表
 */
public class OrganCounterSignEntity extends OrganCounterSignKey {
    //会签编号
    private String signid;
    //会签报告地址
    private String fileurl;
    //上传时间
    private String createtime;

    public void init() {
    }

    public String getOrgcustomerno() {
        return this.orgcustomerno;
    }

    public void setOrgcustomerno(String orgcustomerno) {
        this.orgcustomerno = orgcustomerno;
    }

    public String getRegistertype() {
        return this.registertype;
    }

    public void setRegistertype(String registertype) {
        this.registertype = registertype;
    }

    public String getSignid() {
        return this.signid;
    }

    public void setSignid(String signid) {
        this.signid = signid;
    }

    public String getFileurl() {
        return this.fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}