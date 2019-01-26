package com.msjf.finance.cas.facade.branch.domain;

import com.msjf.finance.msjf.core.domian.BaseDomain;

/**
 * Created by Jsan on 2019/1/24.
 */
public class BranchDomain extends BaseDomain {
    private String branchid;

    private String branchname;

    private String parentid;

    private String branchtype;

    private String province;

    private String city;

    private String county;

    private String stertreet;

    private int showorder;

    private int curnumber;

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getBranchtype() {
        return branchtype;
    }

    public void setBranchtype(String branchtype) {
        this.branchtype = branchtype;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStertreet() {
        return stertreet;
    }

    public void setStertreet(String stertreet) {
        this.stertreet = stertreet;
    }

    public int getShoworder() {
        return showorder;
    }

    public void setShoworder(int showorder) {
        this.showorder = showorder;
    }

    public int getCurnumber() {
        return curnumber;
    }

    public void setCurnumber(int curnumber) {
        this.curnumber = curnumber;
    }
}
