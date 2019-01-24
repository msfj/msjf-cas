package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.OrganCounterSignKey;
/***
  *OrganCounterSignEntity
  *会签结果表
  */
public class OrganCounterSignEntity extends OrganCounterSignKey {
	/**会签编号	**/
	private String signid;
	/**会签报告地址	**/
	private String fileurl;
	/**上传时间	**/
	private String createtime;
	public void init() {
	}
	/**企业客户代码	**/
	public String getOrgcustomerno() {
		return this.orgcustomerno;
	}
	/**企业客户代码	**/
	public void setOrgcustomerno(String orgcustomerno) {
		this.orgcustomerno = orgcustomerno;
	}
	/**登记事项 0-新设 1-变更 2-迁入	**/
	public String getRegistertype() {
		return this.registertype;
	}
	/**登记事项 0-新设 1-变更 2-迁入	**/
	public void setRegistertype(String registertype) {
		this.registertype = registertype;
	}
	/**会签编号	**/
	public String getSignid() {
		return this.signid;
	}
	/**会签编号	**/
	public void setSignid(String signid) {
		this.signid = signid;
	}
	/**会签报告地址	**/
	public String getFileurl() {
		return this.fileurl;
	}
	/**会签报告地址	**/
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	/**上传时间	**/
	public String getCreatetime() {
		return this.createtime;
	}
	/**上传时间	**/
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}