package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    确认设立
 *  <pre/>
 * @author 95494
 * @create 2019-02-02 14:28
 */
@Service
public class SetApplyConfirmImpl extends BaseService {

    /**
     * 发起人客户代码
     */
    private String customerno;

    /**
     * 企业客户代码
     */
    private String orgcustomerno;
    /**
     * 企业名称
     */
    private String membername;

    /**
     * 确认设立
     *
     * @param mapParam 入参
     * @param rs       返回结果
     */
    @Override
    public void setApplyConfirm(HashMap<String, Object> mapParam, Response rs) {
        super.setApplyConfirm(mapParam, rs);
    }
}
