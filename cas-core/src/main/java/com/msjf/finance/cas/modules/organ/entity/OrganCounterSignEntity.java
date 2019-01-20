package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 会签结果表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:09
 */
public class OrganCounterSignEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 企业客户代码
     */

    private String orgcustomerno;
    /**
     * 登记事项 0-新设 1-变更 2-迁入
     */
    private String registertype;
    /**
     * 会签编号
     */
    private String signid;
    /**
     * 会签报告地址
     */
    private String fileurl;
    /**
     * 上传时间
     */
    private String createtime;

    /**
     * 设置：企业客户代码
     */
    public void setOrgcustomerno(String orgcustomerno) {
        this.orgcustomerno = orgcustomerno;
    }

    /**
     * 获取：企业客户代码
     */
    public String getOrgcustomerno() {
        return orgcustomerno;
    }

    /**
     * 设置：登记事项 0-新设 1-变更 2-迁入
     */
    public void setRegistertype(String registertype) {
        this.registertype = registertype;
    }

    /**
     * 获取：登记事项 0-新设 1-变更 2-迁入
     */
    public String getRegistertype() {
        return registertype;
    }

    /**
     * 设置：会签编号
     */
    public void setSignid(String signid) {
        this.signid = signid;
    }

    /**
     * 获取：会签编号
     */
    public String getSignid() {
        return signid;
    }

    /**
     * 设置：会签报告地址
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    /**
     * 获取：会签报告地址
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * 设置：上传时间
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取：上传时间
     */
    public String getCreatetime() {
        return createtime;
    }
}
