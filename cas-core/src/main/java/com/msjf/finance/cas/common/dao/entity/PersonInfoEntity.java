package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.PersonInfoKey;
/***
  *PersonInfoEntity
  *个人基本信息表
  */
public class PersonInfoEntity extends PersonInfoKey {
	/**客户姓名	**/
	private String membername;
	/**学历	**/
	private String education;
	/**从业经历	**/
	private String workexp;
	/**投资经历	**/
	private String investexp;
	/**身份证上传（正反面满框）	**/
	private String idcard;
	/**基金从业资格证编码	**/
	private String amacno;
	/**是否拥有基金从业资格证 0-否 1-是	**/
	private String isamac;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	/**更新日期	**/
	private String updatedate;
	/**更新时间	**/
	private String updatetime;
	public void init() {
	}
	/**客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**客户姓名	**/
	public String getMembername() {
		return this.membername;
	}
	/**客户姓名	**/
	public void setMembername(String membername) {
		this.membername = membername;
	}
	/**学历	**/
	public String getEducation() {
		return this.education;
	}
	/**学历	**/
	public void setEducation(String education) {
		this.education = education;
	}
	/**从业经历	**/
	public String getWorkexp() {
		return this.workexp;
	}
	/**从业经历	**/
	public void setWorkexp(String workexp) {
		this.workexp = workexp;
	}
	/**投资经历	**/
	public String getInvestexp() {
		return this.investexp;
	}
	/**投资经历	**/
	public void setInvestexp(String investexp) {
		this.investexp = investexp;
	}
	/**身份证上传（正反面满框）	**/
	public String getIdcard() {
		return this.idcard;
	}
	/**身份证上传（正反面满框）	**/
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**基金从业资格证编码	**/
	public String getAmacno() {
		return this.amacno;
	}
	/**基金从业资格证编码	**/
	public void setAmacno(String amacno) {
		this.amacno = amacno;
	}
	/**是否拥有基金从业资格证 0-否 1-是	**/
	public String getIsamac() {
		return this.isamac;
	}
	/**是否拥有基金从业资格证 0-否 1-是	**/
	public void setIsamac(String isamac) {
		this.isamac = isamac;
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
	/**更新日期	**/
	public String getUpdatedate() {
		return this.updatedate;
	}
	/**更新日期	**/
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**更新时间	**/
	public String getUpdatetime() {
		return this.updatetime;
	}
	/**更新时间	**/
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}