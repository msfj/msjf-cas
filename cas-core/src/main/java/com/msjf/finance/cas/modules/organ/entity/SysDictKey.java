package com.msjf.finance.cas.modules.organ.entity;

public class SysDictKey {
    //字典ＩＤ
    protected String dictId;
    //字典ＫＥＹ
    protected String dictKey;

    public String getDictId() {
        return this.dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictKey() {
        return this.dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public void setKey(String dictId, String dictKey) {
        this.dictId = dictId;
        this.dictKey = dictKey;
    }
}