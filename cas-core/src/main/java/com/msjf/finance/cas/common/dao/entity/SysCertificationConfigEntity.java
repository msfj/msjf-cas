package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.SysCertificationConfigKey;
/***
  *SysCertificationConfigEntity
  *实名认证平安一账通接口配置表
  */
public class SysCertificationConfigEntity extends SysCertificationConfigKey {
	/**是否开启认证 1-开启 0-关闭	**/
	private String isopen;
	/**机构代码	**/
	private String orgcode;
	/**是否关注 0-否 1-是	**/
	private String chnlid;
	/**授权代码	**/
	private String authcode;
	/**授权时间(yyyy-MM-dd)	**/
	private String authdate;
	/**用户名	**/
	private String username;
	/**用户密码	**/
	private String userpassword;
	/**网络类型	**/
	private String nettype;
	/**交易名称	**/
	private String transname;
	/**产品ID	**/
	private String productid;
	/**API版本	**/
	private String apiver;
	/**证书校验码	**/
	private String cerCheckCode;
	/**私钥别名	**/
	private String storealias;
	/**私钥密码	**/
	private String storepassword;
	/**访问平安一账通url	**/
	private String url;
	public void init() {
	}
	/**是否开启认证 1-开启 0-关闭	**/
	public String getIsopen() {
		return this.isopen;
	}
	/**是否开启认证 1-开启 0-关闭	**/
	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}
	/**机构代码	**/
	public String getOrgcode() {
		return this.orgcode;
	}
	/**机构代码	**/
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	/**是否关注 0-否 1-是	**/
	public String getChnlid() {
		return this.chnlid;
	}
	/**是否关注 0-否 1-是	**/
	public void setChnlid(String chnlid) {
		this.chnlid = chnlid;
	}
	/**授权代码	**/
	public String getAuthcode() {
		return this.authcode;
	}
	/**授权代码	**/
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}
	/**授权时间(yyyy-MM-dd)	**/
	public String getAuthdate() {
		return this.authdate;
	}
	/**授权时间(yyyy-MM-dd)	**/
	public void setAuthdate(String authdate) {
		this.authdate = authdate;
	}
	/**用户名	**/
	public String getUsername() {
		return this.username;
	}
	/**用户名	**/
	public void setUsername(String username) {
		this.username = username;
	}
	/**用户密码	**/
	public String getUserpassword() {
		return this.userpassword;
	}
	/**用户密码	**/
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	/**网络类型	**/
	public String getNettype() {
		return this.nettype;
	}
	/**网络类型	**/
	public void setNettype(String nettype) {
		this.nettype = nettype;
	}
	/**交易名称	**/
	public String getTransname() {
		return this.transname;
	}
	/**交易名称	**/
	public void setTransname(String transname) {
		this.transname = transname;
	}
	/**产品ID	**/
	public String getProductid() {
		return this.productid;
	}
	/**产品ID	**/
	public void setProductid(String productid) {
		this.productid = productid;
	}
	/**API版本	**/
	public String getApiver() {
		return this.apiver;
	}
	/**API版本	**/
	public void setApiver(String apiver) {
		this.apiver = apiver;
	}
	/**产品代码	**/
	public String getMessagecode() {
		return this.messagecode;
	}
	/**产品代码	**/
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	/**证书校验码	**/
	public String getCerCheckCode() {
		return this.cerCheckCode;
	}
	/**证书校验码	**/
	public void setCerCheckCode(String cerCheckCode) {
		this.cerCheckCode = cerCheckCode;
	}
	/**私钥别名	**/
	public String getStorealias() {
		return this.storealias;
	}
	/**私钥别名	**/
	public void setStorealias(String storealias) {
		this.storealias = storealias;
	}
	/**私钥密码	**/
	public String getStorepassword() {
		return this.storepassword;
	}
	/**私钥密码	**/
	public void setStorepassword(String storepassword) {
		this.storepassword = storepassword;
	}
	/**访问平安一账通url	**/
	public String getUrl() {
		return this.url;
	}
	/**访问平安一账通url	**/
	public void setUrl(String url) {
		this.url = url;
	}
}