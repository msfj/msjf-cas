package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.MemberSubmitChangeKey;
/***
  *MemberSubmitChangeEntity
  *企业成员申报信息变更记录表
  */
public class MemberSubmitChangeEntity extends MemberSubmitChangeKey {
	/**企业客户代码	**/
	private String customerno;
	/**姓名	**/
	private String username;
	/**证件类型 字典 个人+企业	**/
	private String certificatetype;
	/**证件号码	**/
	private String certificateno;
	/**出资比例	**/
	private String moneyscale;
	/**联系电话	**/
	private String mobile;
	/**承担责任方式 字典 115 0-有限责任 1-无限责任	**/
	private String dutyway;
	/**出资方式 字典116 0-货币	**/
	private String moneytype;
	/**认缴出资额（万元）	**/
	private String amount;
	/**缴付期限	**/
	private String paydatelimit;
	/**住所	**/
	private String address;
	/**身份类型 字典 117 0-联络员 1-财务负责人 2-执行董事 3-董事长 4-董事 5-法定代表人/执行事务合伙人/委托代表 6-监事长 7-监事 8-经理 9-其他成员 10-股东	**/
	private String position;
	/**排序	**/
	private Integer sortnum;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	public void init() {
	}
	/**流水号	**/
	public String getSerialno() {
		return this.serialno;
	}
	/**流水号	**/
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	/**企业客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**企业客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**当前版本号	**/
	public Integer getVersion() {
		return this.version;
	}
	/**当前版本号	**/
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**姓名	**/
	public String getUsername() {
		return this.username;
	}
	/**姓名	**/
	public void setUsername(String username) {
		this.username = username;
	}
	/**证件类型 字典 个人+企业	**/
	public String getCertificatetype() {
		return this.certificatetype;
	}
	/**证件类型 字典 个人+企业	**/
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
	/**出资比例	**/
	public String getMoneyscale() {
		return this.moneyscale;
	}
	/**出资比例	**/
	public void setMoneyscale(String moneyscale) {
		this.moneyscale = moneyscale;
	}
	/**联系电话	**/
	public String getMobile() {
		return this.mobile;
	}
	/**联系电话	**/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**承担责任方式 字典 115 0-有限责任 1-无限责任	**/
	public String getDutyway() {
		return this.dutyway;
	}
	/**承担责任方式 字典 115 0-有限责任 1-无限责任	**/
	public void setDutyway(String dutyway) {
		this.dutyway = dutyway;
	}
	/**出资方式 字典116 0-货币	**/
	public String getMoneytype() {
		return this.moneytype;
	}
	/**出资方式 字典116 0-货币	**/
	public void setMoneytype(String moneytype) {
		this.moneytype = moneytype;
	}
	/**认缴出资额（万元）	**/
	public String getAmount() {
		return this.amount;
	}
	/**认缴出资额（万元）	**/
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**缴付期限	**/
	public String getPaydatelimit() {
		return this.paydatelimit;
	}
	/**缴付期限	**/
	public void setPaydatelimit(String paydatelimit) {
		this.paydatelimit = paydatelimit;
	}
	/**住所	**/
	public String getAddress() {
		return this.address;
	}
	/**住所	**/
	public void setAddress(String address) {
		this.address = address;
	}
	/**身份类型 字典 117 0-联络员 1-财务负责人 2-执行董事 3-董事长 4-董事 5-法定代表人/执行事务合伙人/委托代表 6-监事长 7-监事 8-经理 9-其他成员 10-股东	**/
	public String getPosition() {
		return this.position;
	}
	/**身份类型 字典 117 0-联络员 1-财务负责人 2-执行董事 3-董事长 4-董事 5-法定代表人/执行事务合伙人/委托代表 6-监事长 7-监事 8-经理 9-其他成员 10-股东	**/
	public void setPosition(String position) {
		this.position = position;
	}
	/**排序	**/
	public Integer getSortnum() {
		return this.sortnum;
	}
	/**排序	**/
	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}
	/**插入日期	**/
	public String getInsertdate() {
		return this.insertdate;
	}
	/**插入日期	**/
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	/**插入时间	**/
	public String getInserttime() {
		return this.inserttime;
	}
	/**插入时间	**/
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
}