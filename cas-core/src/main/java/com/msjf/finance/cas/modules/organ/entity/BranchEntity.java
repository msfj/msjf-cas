package com.msjf.finance.cas.modules.organ.entity;

import java.io.Serializable;

/**
 * 分支表
 *
 * @author kevin
 * @email
 * @date 2019-01-20 20:26:09
 */
public class BranchEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 组织编号
     */

    private String branchid;
    /**
     * 组织名称
     */
    private String branchname;
    /**
     * 上级组织编号
     */
    private String parentid;
    /**
     * 组织类型 0- 机构 1-部门
     */
    private String branchtype;
    /**
     * 所在省  dict101021
     */
    private String province;
    /**
     * 所在市  dict101022
     */
    private String city;
    /**
     * 所在区/县 dict101023
     */
    private String county;
    /**
     * 街道
     */
    private String stertreet;
    /**
     * 显示顺序
     */
    private Integer showorder;
    /**
     * 当前序号
     */
    private Integer curnumber;

    /**
     * 设置：组织编号
     */
    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    /**
     * 获取：组织编号
     */
    public String getBranchid() {
        return branchid;
    }

    /**
     * 设置：组织名称
     */
    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    /**
     * 获取：组织名称
     */
    public String getBranchname() {
        return branchname;
    }

    /**
     * 设置：上级组织编号
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取：上级组织编号
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 设置：组织类型 0- 机构 1-部门
     */
    public void setBranchtype(String branchtype) {
        this.branchtype = branchtype;
    }

    /**
     * 获取：组织类型 0- 机构 1-部门
     */
    public String getBranchtype() {
        return branchtype;
    }

    /**
     * 设置：所在省  dict101021
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取：所在省  dict101021
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置：所在市  dict101022
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：所在市  dict101022
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置：所在区/县 dict101023
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 获取：所在区/县 dict101023
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置：街道
     */
    public void setStertreet(String stertreet) {
        this.stertreet = stertreet;
    }

    /**
     * 获取：街道
     */
    public String getStertreet() {
        return stertreet;
    }

    /**
     * 设置：显示顺序
     */
    public void setShoworder(Integer showorder) {
        this.showorder = showorder;
    }

    /**
     * 获取：显示顺序
     */
    public Integer getShoworder() {
        return showorder;
    }

    /**
     * 设置：当前序号
     */
    public void setCurnumber(Integer curnumber) {
        this.curnumber = curnumber;
    }

    /**
     * 获取：当前序号
     */
    public Integer getCurnumber() {
        return curnumber;
    }
}
