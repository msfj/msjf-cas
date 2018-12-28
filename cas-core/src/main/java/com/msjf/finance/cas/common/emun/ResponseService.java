package com.msjf.finance.cas.common.emun;

/**
 * Created by 11509 on 2018/12/29.
 * 公共接口返回码
 */
public interface ResponseService {
    /**
     * 返回码
     * @return
     */
    String getResponseCode();

    /**
     * 返回描述
     * @return
     */
    String getResponseMessage();
}
