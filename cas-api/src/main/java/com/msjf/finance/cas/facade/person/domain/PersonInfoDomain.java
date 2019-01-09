package com.msjf.finance.cas.facade.person.domain;

/**
 * Created by oumingwei on 2019/01/08.
 * 向外使用的domain
 */
public class PersonInfoDomain {

    private String membername;//姓名
    private String cardType;//证件类型 0：身份证 1：港澳通行证 2：护照 3：台胞证
    private String cardNo;//证件号码
    private String mobile;//手机号码
    private String education;//学历 0：高中以下 1：高中 2：大专 3：本科 4：研究生 5：博士
    private String email;//邮箱
    private String workexp;//从业经历
    private String investexp;//投资经历
    private String isamac;//是否拥有基金资格证 0：否 1：是
    private String[] cardImgAddrs;//证件照上传保存地址



    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String[] getCardImgAddrs() {
        return cardImgAddrs;
    }

    public void setCardImgAddrs(String[] cardImgAddrs) {
        this.cardImgAddrs = cardImgAddrs;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getWorkexp() {
        return workexp;
    }

    public void setWorkexp(String workexp) {
        this.workexp = workexp;
    }

    public String getInvestexp() {
        return investexp;
    }

    public void setInvestexp(String investexp) {
        this.investexp = investexp;
    }

    public String getIsamac() {
        return isamac;
    }

    public void setIsamac(String isamac) {
        this.isamac = isamac;
    }
}
