package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.dao.entity.OrganFlowEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.key.CustKey;
import com.msjf.finance.cas.common.dao.key.OrganFlowKey;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
import com.msjf.finance.cas.common.dao.persistence.CustDao;
import com.msjf.finance.cas.common.dao.persistence.OrganFlowDao;
import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.MacroDefine;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.cas.modules.util.SpringContextUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    删除未提交确认设立的企业设立信息
 *  <pre/>
 * @author 95494
 * @create 2019-02-02 12:10
 */
@Service
public class SetDeleteOrgan extends BaseService {
    private static final Logger logger = LogManager.getLogger(SetDeleteOrgan.class);

    /**
     * 发起人客户代码
     */
    private String customerno;

    /**
     * 企业客户代码
     */
    private String orgcustomerno;


    /**
     * 删除未提交确认设立的企业设立信息
     *
     * @param mapParam 入参
     * @param rs       返回结果
     */
    @Transactional(rollbackFor=Exception.class,timeout = 300)
    @Override
    public void setDeleteOrgan(HashMap<String, Object> mapParam, Response rs) {
        rs.fail(serviceName, "删除失败");
        getParam(mapParam);
        doSingleService(mapParam, rs);
    }

    /**
     * 获取入参
     *
     * @param mapParam 入参
     */
    private void getParam(HashMap<String, Object> mapParam) {
        customerno = StringUtil.valueOf(mapParam.get("customerno"));
        orgcustomerno = StringUtil.valueOf(mapParam.get("orgcustomerno"));
    }

    /**
     * 入参检查
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean preCheck(HashMap<String, Object> mapParam, Response rs) {
        if (CheckUtil.checkNull(customerno, serviceName, "发起人客户代码", rs)) {
            return false;
        }
        if (CheckUtil.checkNull(orgcustomerno, serviceName, "企业代码", rs)) {
            return false;
        }
        return super.preCheck(mapParam, rs);
    }

    /**
     * 业务参数检查
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean check(HashMap<String, Object> mapParam, Response rs) {
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        //1-根据企业客户代码查找企业信息是否存在
        OrganInfoKey organInfoKey = new OrganInfoKey();
        organInfoKey.setKey(orgcustomerno);
        OrganInfoEntity organInfoEntity = organInfoDao.getEntityKey(organInfoKey);
        if (CheckUtil.isNull(organInfoEntity)) {
            rs.fail(serviceName, "企业客户信息不存在");
            return false;
        }
        //2-检查企业流程进度是否为未提交状态
        OrganFlowDao organFlowDao = SpringContextUtil.getBean("organFlowDao");
        OrganFlowKey organFlowKey = new OrganFlowKey();
        organFlowKey.setOrgcustomerno(orgcustomerno);
        OrganFlowEntity organFlowEntity = organFlowDao.getEntityKey(organFlowKey);
        if (CheckUtil.isNull(organFlowEntity)) {
            rs.fail(serviceName, "未查询到企业流程信息");
            return false;
        }
        //企业拟申请企业设立且状态未初始状态时允许删除
        if (!MacroDefine.FLOW_TYPE.FLOW_TYPE_0.getValue().equals(organFlowEntity.getType()) && !MacroDefine
                .AUDIT_STATUS.AUDIT_STATUS_INIT.equals(organFlowEntity.getStatus())) {
            rs.fail(serviceName, "当前状态不允许删除");
            return false;
        }
        return super.check(mapParam, rs);
    }

    /**
     * 业务处理
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean clear(HashMap<String, Object> mapParam, Response rs) {
        //删除企业企业基本信息
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        OrganInfoKey organInfoKey = new OrganInfoKey();
        organInfoKey.setKey(orgcustomerno);
        organInfoDao.delEntityKey(organInfoKey);

        //删除企业客户信息表
        CustDao custDao = SpringContextUtil.getBean("custDao");
        CustKey custKey = new CustKey();
        custKey.setKey(orgcustomerno);
        custDao.delEntityKey(custKey);

        //删除企业业务流程信息表
        OrganFlowDao organFlowDao = SpringContextUtil.getBean("custDao");
        OrganFlowKey organFlowKey = new OrganFlowKey();
        organFlowKey.setOrgcustomerno(orgcustomerno);
        organFlowDao.delEntityKey(organFlowKey);

        rs.success("删除成功");
        return super.clear(mapParam, rs);
    }
}
