package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.CasRegisterInfoKey;
public class CasRegisterInfoEntity extends CasRegisterInfoKey {
	/**用户类型 字典102 0-个人 1-企业	**/
	private String membertype;
	/**注册来源 0-web 1-app	**/
	private String registersource;
	/**证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照	**/
	private String certificatetype;
	/**证件号码	**/
	private String certificateno;
	/**手机号码	**/
	private String mobile;
	/**银行卡号	**/
	private String cardno;
	/**银行	**/
	private String bank;
	/**公司名称	**/
	private String companyname;
	/**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
	private String status;
	/**插入时间	**/
	private String insertdate;
	/**更新时间	**/
	private String updatedate;
	/**法人名称	**/
	private String corname;
	/**证件类型 字典1011 0-身份证 1-护照 1012	**/
	private String corcardtype;
	/**法人证件号码	**/
	private String corcardno;
	/**客户名称	**/
	private String membername;
	public void init() {
	}
	/**null	**/
	public String getId() {
		return this.id;
	}
	/**null	**/
	public void setId(String id) {
		this.id = id;
	}
	/**用户类型 字典102 0-个人 1-企业	**/
	public String getMembertype() {
		return this.membertype;
	}
	/**用户类型 字典102 0-个人 1-企业	**/
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	/**注册来源 0-web 1-app	**/
	public String getRegistersource() {
		return this.registersource;
	}
	/**注册来源 0-web 1-app	**/
	public void setRegistersource(String registersource) {
		this.registersource = registersource;
	}
	/**证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照	**/
	public String getCertificatetype() {
		return this.certificatetype;
	}
	/**证件类型 字典1011 0-身份证 1-护照 1012 A-营业执照	**/
	public void setCertificatetype(String certificatetype) {
		this.certificatetype = certificatetype;
	}
	/**证件号码	**/
	public String getCertificateno() {
		return this.certificateno;
	}
	/**证件号码	**/
	public void setCertificateno(String certificateno) {
		this.certificateno = certificateno;
	}
	/**手机号码	**/
	public String getMobile() {
		return this.mobile;
	}
	/**手机号码	**/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**银行卡号	**/
	public String getCardno() {
		return this.cardno;
	}
	/**银行卡号	**/
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	/**银行	**/
	public String getBank() {
		return this.bank;
	}
	/**银行	**/
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**公司名称	**/
	public String getCompanyname() {
		return this.companyname;
	}
	/**公司名称	**/
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	/**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
	public String getStatus() {
		return this.status;
	}
	/**账户状态 字典103 *-销户 0-正常 1-冻结 2-锁定	**/
	public void setStatus(String status) {
		this.status = status;
	}
	/**插入时间	**/
	public String getInsertdate() {
		return this.insertdate;
	}
	/**插入时间	**/
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	/**更新时间	**/
	public String getUpdatedate() {
		return this.updatedate;
	}
	/**更新时间	**/
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**法人名称	**/
	public String getCorname() {
		return this.corname;
	}
	/**法人名称	**/
	public void setCorname(String corname) {
		this.corname = corname;
	}
	/**证件类型 字典1011 0-身份证 1-护照 1012	**/
	public String getCorcardtype() {
		return this.corcardtype;
	}
	/**证件类型 字典1011 0-身份证 1-护照 1012	**/
	public void setCorcardtype(String corcardtype) {
		this.corcardtype = corcardtype;
	}
	/**法人证件号码	**/
	public String getCorcardno() {
		return this.corcardno;
	}
	/**法人证件号码	**/
	public void setCorcardno(String corcardno) {
		this.corcardno = corcardno;
	}
	/**客户名称	**/
	public String getMembername() {
		return this.membername;
	}
	/**客户名称	**/
	public void setMembername(String membername) {
		this.membername = membername;
	}
}