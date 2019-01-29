package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.dao.entity.OrganAppendEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.key.OrganAppendKey;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
import com.msjf.finance.cas.common.dao.persistence.OrganAppendDao;
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
 *    添加拟设立-第四步-其它信息
 *  <pre/>
 * @author kevin
 * @create 2019-01-28 17:00
 */
@Service
public class OrganPlanPlanBuildApplyFourthlyImpl extends BaseService {

    private static final Logger logger = LogManager.getLogger(OrganPlanPlanBuildApplyFourthlyImpl.class);

    /**
     * 发起人客户代码
     */
    private String customerno;

    /**
     * 企业客户代码
     */
    private String orgcustomerno;

    /**
     * 公共-主要负责人从业经历介绍
     **/
    private String mainworkexp;
    /**
     * 公共-其他主要负责人介绍
     **/
    private String othersintro;
    /**
     * 公共-股东背景介绍
     **/
    private String partnerintro;
    /**
     * 从业人数数量
     **/
    private String mployedPeopleNumbere;
    /**
     * 投资所关注行业市场类型（企业自有资金-所投项目所属行业  dict20025）
     **/
    private String industryMarketType;

    /**
     * 关注的项目阶段
     **/
    private String focusProjectPhase;

    /**
     * 投资获得收益方式（其他企业-盈利模式）
     **/
    private String returnInvestment;
    /**
     * 附件(多个附件相对地址用逗号分割)
     **/
    private String adjunct;
    /**
     * 备注
     **/
    private String remarks;


    /**
     * 添加拟设立-第四步-其它信息
     *
     * @param mapParam 入参
     * @param rs       返回结果
     */
    @Transactional(rollbackFor = Exception.class, timeout = 30000)
    @Override
    public void addApplyFourthly(HashMap<String, Object> mapParam, Response rs) {
        rs.fail("cas", "操作失败");
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
        mainworkexp = StringUtil.valueOf(mapParam.get("mainworkexp"));
        othersintro = StringUtil.valueOf(mapParam.get("othersintro"));
        partnerintro = StringUtil.valueOf(mapParam.get("partnerintro"));
        mployedPeopleNumbere = StringUtil.valueOf(mapParam.get("mployedPeopleNumbere"));
        industryMarketType = StringUtil.valueOf(mapParam.get("industryMarketType"));
        focusProjectPhase = StringUtil.valueOf(mapParam.get("focusProjectPhase"));
        returnInvestment = StringUtil.valueOf(mapParam.get("returnInvestment"));
        adjunct = StringUtil.valueOf(mapParam.get("adjunct"));
        remarks = StringUtil.valueOf(mapParam.get("remarks"));
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

        //根据企业客户代码检查企业基本信息是否存在
        OrganInfoDao organInfoDao = SpringContextUtil.getBean("organInfoDao");
        OrganInfoKey organInfoKey = new OrganInfoKey();
        organInfoKey.setKey(orgcustomerno);
        OrganInfoEntity organInfoEntity = organInfoDao.getEntityKey(organInfoKey);
        //1-检查发起人账户信息不存在
        if (!CheckCustomerInfo(customerno, rs)) {
            return false;
        }
        //2-检查企业基本信息是否存在
        if (CheckUtil.isNull(organInfoEntity)) {
            rs.fail(serviceName, "企业基本信息不存在");
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
        //更新企业其他信息
        if (!updateOrganAppend(rs)) {
            return false;
        }
        rs.success("更新成功");
        return super.clear(mapParam, rs);
    }

    /**
     * 更新企业其他信息
     *
     * @param rs 结果集
     * @return false 失败  true 成功
     */
    private boolean updateOrganAppend(Response rs) {
        //更新企业其他信息
        OrganAppendEntity organAppendEntity = new OrganAppendEntity();
        organAppendEntity.setCustomerno(customerno);
        organAppendEntity.setVersion(Integer.parseInt(MacroDefine.YES));
        organAppendEntity.setMainworkexp(mainworkexp);
        organAppendEntity.setOthersintro(othersintro);
        organAppendEntity.setPartnerintro(partnerintro);
        organAppendEntity.setMployedPeopleNumbere(mployedPeopleNumbere);
        organAppendEntity.setIndustryMarketType(industryMarketType);
        organAppendEntity.setFocusProjectPhase(focusProjectPhase);
        organAppendEntity.setReturnInvestment(returnInvestment);
        organAppendEntity.setAdjunct(adjunct);
        organAppendEntity.setRemarks(remarks);

        //根据企业代码查询企业其他信息是否存在
        OrganAppendDao organAppendDao = SpringContextUtil.getBean("organAppendDao");
        OrganAppendKey organAppendKey = new OrganAppendKey();
        organAppendKey.setKey(organAppendEntity.getCustomerno());
        OrganAppendEntity organAppendKeyEntity = organAppendDao.getEntityKey(organAppendKey);
        //首次设立申请 新增记录
        try {
            Integer row;
            if (CheckUtil.isNull(organAppendKeyEntity)) {
                row = organAppendDao.insEntity(organAppendEntity);
            } else {
                //设立申请保存后可以修改
                row = organAppendDao.updAllowEmptyEntity(organAppendEntity);
            }
            if (row != 1) {
                throw new RuntimeException("organ_append更新失败");
            }
            return true;
        } catch (RuntimeException e) {
            rs.fail(serviceName, "organ_append更新失败");
            logger.error(serviceName, "organ_append更新失败", e);
            throw new RuntimeException("organ_append更新失败", e);
        }
    }
}
