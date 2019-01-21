package com.msjf.finance.cas.modules.organ.entity;

/***
 *SysDictEntity
 *系统字典表
 */
public class SysDictEntity extends SysDictKey {
    private String dictName;
    //字典值
    private String dictValue;
    //关联省市区
    private String refDictKey;
    private Integer sortNo;
    private String isUsed;
    private String dictComment;

    public void init() {
    }

    @Override
    public String getDictId() {
        return this.dictId;
    }

    @Override
    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return this.dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    @Override
    public String getDictKey() {
        return this.dictKey;
    }

    @Override
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return this.dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getRefDictKey() {
        return this.refDictKey;
    }

    public void setRefDictKey(String refDictKey) {
        this.refDictKey = refDictKey;
    }

    public Integer getSortNo() {
        return this.sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getIsUsed() {
        return this.isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getDictComment() {
        return this.dictComment;
    }

    public void setDictComment(String dictComment) {
        this.dictComment = dictComment;
    }
}