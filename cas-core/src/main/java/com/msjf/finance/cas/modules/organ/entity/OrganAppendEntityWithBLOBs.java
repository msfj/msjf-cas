package com.msjf.finance.cas.modules.organ.entity;

import com.msjf.finance.cas.modules.organ.entity.OrganAppendEntity;

public class OrganAppendEntityWithBLOBs extends OrganAppendEntity {
    private String profittype;

    private String fundmanagerintro;

    private String fundprojectintro;

    private String companyinfo;

    private String prointro;

    private String projectintro;

    private String mainworkexp;

    private String othersintro;

    private String partnerintro;

    public String getProfittype() {
        return profittype;
    }

    public void setProfittype(String profittype) {
        this.profittype = profittype == null ? null : profittype.trim();
    }

    public String getFundmanagerintro() {
        return fundmanagerintro;
    }

    public void setFundmanagerintro(String fundmanagerintro) {
        this.fundmanagerintro = fundmanagerintro == null ? null : fundmanagerintro.trim();
    }

    public String getFundprojectintro() {
        return fundprojectintro;
    }

    public void setFundprojectintro(String fundprojectintro) {
        this.fundprojectintro = fundprojectintro == null ? null : fundprojectintro.trim();
    }

    public String getCompanyinfo() {
        return companyinfo;
    }

    public void setCompanyinfo(String companyinfo) {
        this.companyinfo = companyinfo == null ? null : companyinfo.trim();
    }

    public String getProintro() {
        return prointro;
    }

    public void setProintro(String prointro) {
        this.prointro = prointro == null ? null : prointro.trim();
    }

    public String getProjectintro() {
        return projectintro;
    }

    public void setProjectintro(String projectintro) {
        this.projectintro = projectintro == null ? null : projectintro.trim();
    }

    public String getMainworkexp() {
        return mainworkexp;
    }

    public void setMainworkexp(String mainworkexp) {
        this.mainworkexp = mainworkexp == null ? null : mainworkexp.trim();
    }

    public String getOthersintro() {
        return othersintro;
    }

    public void setOthersintro(String othersintro) {
        this.othersintro = othersintro == null ? null : othersintro.trim();
    }

    public String getPartnerintro() {
        return partnerintro;
    }

    public void setPartnerintro(String partnerintro) {
        this.partnerintro = partnerintro == null ? null : partnerintro.trim();
    }
}