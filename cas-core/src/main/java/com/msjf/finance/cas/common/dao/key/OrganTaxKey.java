package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class OrganTaxKey  extends IBaseEntity {
	/**企业客户代码	**/
	protected String customerno;
	/**报告期	**/
	protected String reportperiod;
	/**null	**/
	public String getCustomerno() {
		return this.customerno;
	}
	/**null	**/
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	/**null	**/
	public String getReportperiod() {
		return this.reportperiod;
	}
	/**null	**/
	public void setReportperiod(String reportperiod) {
		this.reportperiod = reportperiod;
	}
	public void setKey(String customerno,String reportperiod) {
		this.customerno = customerno;
		this.reportperiod = reportperiod;
	}
}