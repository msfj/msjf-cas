package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.BranchKey;
/***
  *BranchEntity
  *分支表
  */
public class BranchEntity extends BranchKey {
	/**组织名称	**/
	private String branchname;
	/**上级组织编号	**/
	private String parentid;
	/**组织类型 0- 机构 1-部门	**/
	private String branchtype;
	/**所在省 dict101021	**/
	private String province;
	/**所在市 dict101022	**/
	private String city;
	/**所在区/县 dict101023	**/
	private String county;
	/**街道	**/
	private String stertreet;
	/**显示顺序	**/
	private Integer showorder;
	/**当前序号	**/
	private Integer curnumber;
	public void init() {
	}
	/**组织编号	**/
	public String getBranchid() {
		return this.branchid;
	}
	/**组织编号	**/
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	/**组织名称	**/
	public String getBranchname() {
		return this.branchname;
	}
	/**组织名称	**/
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	/**上级组织编号	**/
	public String getParentid() {
		return this.parentid;
	}
	/**上级组织编号	**/
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**组织类型 0- 机构 1-部门	**/
	public String getBranchtype() {
		return this.branchtype;
	}
	/**组织类型 0- 机构 1-部门	**/
	public void setBranchtype(String branchtype) {
		this.branchtype = branchtype;
	}
	/**所在省 dict101021	**/
	public String getProvince() {
		return this.province;
	}
	/**所在省 dict101021	**/
	public void setProvince(String province) {
		this.province = province;
	}
	/**所在市 dict101022	**/
	public String getCity() {
		return this.city;
	}
	/**所在市 dict101022	**/
	public void setCity(String city) {
		this.city = city;
	}
	/**所在区/县 dict101023	**/
	public String getCounty() {
		return this.county;
	}
	/**所在区/县 dict101023	**/
	public void setCounty(String county) {
		this.county = county;
	}
	/**街道	**/
	public String getStertreet() {
		return this.stertreet;
	}
	/**街道	**/
	public void setStertreet(String stertreet) {
		this.stertreet = stertreet;
	}
	/**显示顺序	**/
	public Integer getShoworder() {
		return this.showorder;
	}
	/**显示顺序	**/
	public void setShoworder(Integer showorder) {
		this.showorder = showorder;
	}
	/**当前序号	**/
	public Integer getCurnumber() {
		return this.curnumber;
	}
	/**当前序号	**/
	public void setCurnumber(Integer curnumber) {
		this.curnumber = curnumber;
	}
}