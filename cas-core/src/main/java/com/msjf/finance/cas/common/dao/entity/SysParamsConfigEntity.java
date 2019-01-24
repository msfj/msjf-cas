package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.SysParamsConfigKey;
public class SysParamsConfigEntity extends SysParamsConfigKey {
	/**参数值	**/
	private String paramValue;
	/**参数说明	**/
	private String comments;
	/**参数状态	**/
	private Integer paramStatus;
	/**排序	**/
	private Integer sortNo;
	public void init() {
	}
	/**交易所ID	**/
	public String getExchangeId() {
		return this.exchangeId;
	}
	/**交易所ID	**/
	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}
	/**经纪商ID	**/
	public String getDistributorId() {
		return this.distributorId;
	}
	/**经纪商ID	**/
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	/**参数类型	**/
	public String getParamType() {
		return this.paramType;
	}
	/**参数类型	**/
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	/**参数ID	**/
	public String getParamId() {
		return this.paramId;
	}
	/**参数ID	**/
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	/**参数值	**/
	public String getParamValue() {
		return this.paramValue;
	}
	/**参数值	**/
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	/**参数说明	**/
	public String getComments() {
		return this.comments;
	}
	/**参数说明	**/
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**参数状态	**/
	public Integer getParamStatus() {
		return this.paramStatus;
	}
	/**参数状态	**/
	public void setParamStatus(Integer paramStatus) {
		this.paramStatus = paramStatus;
	}
	/**排序	**/
	public Integer getSortNo() {
		return this.sortNo;
	}
	/**排序	**/
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
}