package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.AusAuthoneKey;
/***
  *AusAuthoneEntity
  *登录认证表
  */
public class AusAuthoneEntity extends AusAuthoneKey {
	/**登录密码	**/
	private String password;
	/**认证累计失败次数	**/
	private Integer failcount;
	/**注册来源 100 0-web 1-app	**/
	private String registersource;
	/**插入日期	**/
	private String insertdate;
	/**插入时间	**/
	private String inserttime;
	/**更新日期（最后认证时间）	**/
	private String updatedate;
	/**更新时间（最后认证时间）	**/
	private String updatetime;
	/**来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签	**/
	private String source;
	/**在线状态(N-不在线 Y-在线)	**/
	private String onlinestatus;
	/**登陆来源(0-web 1-app)	**/
	private String loginsource;
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
	/**登录密码	**/
	public String getPassword() {
		return this.password;
	}
	/**登录密码	**/
	public void setPassword(String password) {
		this.password = password;
	}
	/**认证累计失败次数	**/
	public Integer getFailcount() {
		return this.failcount;
	}
	/**认证累计失败次数	**/
	public void setFailcount(Integer failcount) {
		this.failcount = failcount;
	}
	/**注册来源 100 0-web 1-app	**/
	public String getRegistersource() {
		return this.registersource;
	}
	/**注册来源 100 0-web 1-app	**/
	public void setRegistersource(String registersource) {
		this.registersource = registersource;
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
	/**更新日期（最后认证时间）	**/
	public String getUpdatedate() {
		return this.updatedate;
	}
	/**更新日期（最后认证时间）	**/
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**更新时间（最后认证时间）	**/
	public String getUpdatetime() {
		return this.updatetime;
	}
	/**更新时间（最后认证时间）	**/
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	/**来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签	**/
	public String getSource() {
		return this.source;
	}
	/**来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签	**/
	public void setSource(String source) {
		this.source = source;
	}
	/**在线状态(N-不在线 Y-在线)	**/
	public String getOnlinestatus() {
		return this.onlinestatus;
	}
	/**在线状态(N-不在线 Y-在线)	**/
	public void setOnlinestatus(String onlinestatus) {
		this.onlinestatus = onlinestatus;
	}
	/**登陆来源(0-web 1-app)	**/
	public String getLoginsource() {
		return this.loginsource;
	}
	/**登陆来源(0-web 1-app)	**/
	public void setLoginsource(String loginsource) {
		this.loginsource = loginsource;
	}
}