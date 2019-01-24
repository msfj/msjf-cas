package com.msjf.finance.cas.common.dao.key;
import com.msjf.finance.cas.common.dao.IBaseEntity;
public class SysParamsConfigKey  extends IBaseEntity {
	/**交易所ID	**/
	protected String exchangeId;
	/**经纪商ID	**/
	protected String distributorId;
	/**参数类型	**/
	protected String paramType;
	/**参数ID	**/
	protected String paramId;
	/**null	**/
	public String getExchangeId() {
		return this.exchangeId;
	}
	/**null	**/
	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}
	/**null	**/
	public String getDistributorId() {
		return this.distributorId;
	}
	/**null	**/
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	/**null	**/
	public String getParamType() {
		return this.paramType;
	}
	/**null	**/
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	/**null	**/
	public String getParamId() {
		return this.paramId;
	}
	/**null	**/
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	public void setKey(String exchangeId,String distributorId,String paramType,String paramId) {
		this.exchangeId = exchangeId;
		this.distributorId = distributorId;
		this.paramType = paramType;
		this.paramId = paramId;
	}
}