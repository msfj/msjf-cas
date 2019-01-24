package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganTaxKey;
/***
  *OrganTaxEntity
  *税收收入测算表
  */
public class OrganTaxEntity extends OrganTaxKey {
	/**关联其他企业名称	**/
	private String relatename;
	/**增值税	**/
	private String zzfee;
	/**消费税	**/
	private String xffee;
	/**企业所得税	**/
	private String qysdfee;
	/**个人所得税	**/
	private String grsdfee;
	/**城建税	**/
	private String cjfee;
	/**印花税	**/
	private String yhfee;
	/**其他	**/
	private String otherfee;
	/**合计	**/
	private String total;
	/**税源变化原因	**/
	private String taxcause;
	/**报送状态 字典 0-未报送 1-已报送	**/
	private String substatus;
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
	/**企业客户代码	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**企业客户代码	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**报告期	**/
	public String getReportperiod() {
		return this.reportperiod;
	}
	/**报告期	**/
	public void setReportperiod(String reportperiod) {
		this.reportperiod = reportperiod;
	}
	/**关联其他企业名称	**/
	public String getRelatename() {
		return this.relatename;
	}
	/**关联其他企业名称	**/
	public void setRelatename(String relatename) {
		this.relatename = relatename;
	}
	/**增值税	**/
	public String getZzfee() {
		return this.zzfee;
	}
	/**增值税	**/
	public void setZzfee(String zzfee) {
		this.zzfee = zzfee;
	}
	/**消费税	**/
	public String getXffee() {
		return this.xffee;
	}
	/**消费税	**/
	public void setXffee(String xffee) {
		this.xffee = xffee;
	}
	/**企业所得税	**/
	public String getQysdfee() {
		return this.qysdfee;
	}
	/**企业所得税	**/
	public void setQysdfee(String qysdfee) {
		this.qysdfee = qysdfee;
	}
	/**个人所得税	**/
	public String getGrsdfee() {
		return this.grsdfee;
	}
	/**个人所得税	**/
	public void setGrsdfee(String grsdfee) {
		this.grsdfee = grsdfee;
	}
	/**城建税	**/
	public String getCjfee() {
		return this.cjfee;
	}
	/**城建税	**/
	public void setCjfee(String cjfee) {
		this.cjfee = cjfee;
	}
	/**印花税	**/
	public String getYhfee() {
		return this.yhfee;
	}
	/**印花税	**/
	public void setYhfee(String yhfee) {
		this.yhfee = yhfee;
	}
	/**其他	**/
	public String getOtherfee() {
		return this.otherfee;
	}
	/**其他	**/
	public void setOtherfee(String otherfee) {
		this.otherfee = otherfee;
	}
	/**合计	**/
	public String getTotal() {
		return this.total;
	}
	/**合计	**/
	public void setTotal(String total) {
		this.total = total;
	}
	/**税源变化原因	**/
	public String getTaxcause() {
		return this.taxcause;
	}
	/**税源变化原因	**/
	public void setTaxcause(String taxcause) {
		this.taxcause = taxcause;
	}
	/**报送状态 字典 0-未报送 1-已报送	**/
	public String getSubstatus() {
		return this.substatus;
	}
	/**报送状态 字典 0-未报送 1-已报送	**/
	public void setSubstatus(String substatus) {
		this.substatus = substatus;
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