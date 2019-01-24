package com.msjf.finance.cas.common.dao.entity;
import com.msjf.finance.cas.common.dao.key.SysDictKey;
/***
  *SysDictEntity
  *系统字典表
  */
public class SysDictEntity extends SysDictKey {
	private String dictName;
	/**字典值	**/
	private String dictValue;
	/**关联省市区	**/
	private String refDictKey;
	private Integer sortNo;
	private String isUsed;
	private String dictComment;
	public void init() {
	}
	/**字典ＩＤ	**/
	public String getDictId() {
		return this.dictId;
	}
	/**字典ＩＤ	**/
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	/**null	**/
	public String getDictName() {
		return this.dictName;
	}
	/**null	**/
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	/**字典ＫＥＹ	**/
	public String getDictKey() {
		return this.dictKey;
	}
	/**字典ＫＥＹ	**/
	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}
	/**字典值	**/
	public String getDictValue() {
		return this.dictValue;
	}
	/**字典值	**/
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	/**关联省市区	**/
	public String getRefDictKey() {
		return this.refDictKey;
	}
	/**关联省市区	**/
	public void setRefDictKey(String refDictKey) {
		this.refDictKey = refDictKey;
	}
	/**null	**/
	public Integer getSortNo() {
		return this.sortNo;
	}
	/**null	**/
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	/**null	**/
	public String getIsUsed() {
		return this.isUsed;
	}
	/**null	**/
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	/**null	**/
	public String getDictComment() {
		return this.dictComment;
	}
	/**null	**/
	public void setDictComment(String dictComment) {
		this.dictComment = dictComment;
	}
}