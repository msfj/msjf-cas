package com.msjf.finance.cas.modules.organ.entity;

public class SysDictEntity extends SysDictKey {
    private String dictName;

    private String dictValue;

    private String refDictKey;

    private Integer sortNo;

    private String isUsed;

    private String dictComment;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getRefDictKey() {
        return refDictKey;
    }

    public void setRefDictKey(String refDictKey) {
        this.refDictKey = refDictKey == null ? null : refDictKey.trim();
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }

    public String getDictComment() {
        return dictComment;
    }

    public void setDictComment(String dictComment) {
        this.dictComment = dictComment == null ? null : dictComment.trim();
    }
}