package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.entity.OrganFlowEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.persistence.CustDao;
import com.msjf.finance.cas.common.dao.persistence.OrganFlowDao;
import com.msjf.finance.cas.common.dao.persistence.OrganInfoDao;
import com.msjf.finance.cas.common.utils.CheckUtil;
import com.msjf.finance.cas.common.utils.DateUtils;
import com.msjf.finance.cas.common.utils.IDUtils;
import com.msjf.finance.cas.common.utils.MacroDefine;
import com.msjf.finance.cas.common.utils.StringUtil;
import com.msjf.finance.cas.modules.organ.service.BaseService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 * 描述:
 *    服务平台拟设立新增申请第一步(新增+修改)
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 8:37
 */
@Service
public class OrganPlanPlanBuildApplyFirstImpl extends BaseService {


    /**
     * 发起人客户代码
     */
    private String customerno;

    /**
     * 企业客户代码
     */
    private String orgcustomerno;

    /**
     * 注册地址(省) dict101021
     */
    private String registerprovince;

    /**
     * 注册地址(市) dict101022
     */
    private String registercity;

    /**
     * 注册地址(区/县) dict101023
     */
    private String registercounty;

    /**
     * 注册地址(街道)
     */
    private String registertreet;

    /**
     * 企业名称
     */
    private String membername;

    /**
     * 企业类型 字典104 0-有限公司 1-合伙企业
     */
    private String organtype;

    /**
     * 企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业
     */
    private String organclass;

    /**
     * 版本号 由1开始累加  ++
     */
    private static final int INIT_VERSION = 1;

    /**
     * 新增修改标记（默认新增）
     */
    private boolean isUpdate;

    @Resource
    private CustDao custDao;

    @Resource
    private OrganInfoDao organInfoDao;

    @Resource
    private OrganFlowDao organFlowDao;


    /**
     * 添加拟设立
     *
     * @param mapParam 入参
     * @param rs       返回结果
     */
    @Transactional//(timeout = 30)
    @Override
    public void addApplyFirst(HashMap<String, Object> mapParam, Response rs) {
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
        registerprovince = StringUtil.valueOf(mapParam.get("registerprovince"));
        registercity = StringUtil.valueOf(mapParam.get("registercity"));
        registercounty = StringUtil.valueOf(mapParam.get("registercounty"));
        registertreet = StringUtil.valueOf(mapParam.get("registertreet"));
        membername = StringUtil.valueOf(mapParam.get("membername"));
        organtype = StringUtil.valueOf(mapParam.get("organtype"));
        organclass = StringUtil.valueOf(mapParam.get("organclass"));
        isUpdate = Boolean.FALSE;
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
        if (CheckUtil.isNull(customerno)) {
            rs.fail("cas", "发起人客户代码不能为空");
            return false;
        }
        if (CheckUtil.isNull(membername)) {
            rs.fail("cas", "企业名称不能为空");
            return false;
        }
        if (CheckUtil.isNull(organtype)) {
            rs.fail("cas", "企业类型不能为空");
            return false;
        }
        if (CheckUtil.isNull(organclass)) {
            rs.fail("cas", "企业分类不能为空");
            return false;
        }
        return super.preCheck(mapParam, rs);
    }

    @Override
    public boolean check(HashMap<String, Object> mapParam, Response rs) {
        //1-检查发起人账户信息不存在
        CustEntity custEntity = new CustEntity();
        custEntity.setCustomerno(customerno);
        List<CustEntity> customerEntityList = custDao.getListEntity(custEntity);
        if (CheckUtil.isNull(customerEntityList)) {
            rs.fail("cas", "发起人账户信息不存在");
            return false;
        }

        //2-企业名称唯一性检查
        if (!checkOrganName(membername, rs)) {
            return false;
        }
        //3-检查是否传机构代码，有传则代表是修改,没有则代码是新增(新增是生成企业ID)
        if (CheckUtil.isNull(orgcustomerno)) {
            //生成企业ID
            orgcustomerno = String.valueOf(IDUtils.genItemId());
        } else {
            isUpdate = Boolean.TRUE;
        }
        //4-如果为修改则检查企业信息是否存在
        if (isUpdate) {
            if (!CheckOranInfo(orgcustomerno, rs)) {
                return false;
            }
        }
        return super.check(mapParam, rs);
    }


    @Override
    public boolean clear(HashMap<String, Object> mapParam, Response rs) {
        //1-写企业基本信息表
        if (!addOrganInfo(rs)) {
            return false;
        }
        //2-写客户信息表
        if (!addCifCustomer(rs)) {
            return false;
        }
        //3-写企业业务流程信息表
        if (!addFlow(rs)) {
            return false;
        }
        //4-写企业业务流程信息表
        if (!addFlow(rs)) {
            return false;
        }
        //4-返回新增信息
        HashMap<String, Object> map = new HashMap(4);
        map.put("orgcustomerno", orgcustomerno);
        map.put("organtype", organtype);
        map.put("organclass", organclass);
        map.put("membername", membername);
        rs.success("cas", isUpdate ? "更新成功" : "保存成功", map);
        return super.clear(mapParam, rs);
    }

    /**
     * 写企业基本信息表
     *
     * @param rs 结果集
     */
    private boolean addOrganInfo(Response rs) {

        OrganInfoEntity organInfoEntity = new OrganInfoEntity();
        organInfoEntity.setVersion(INIT_VERSION);
        organInfoEntity.setCustomerno(orgcustomerno);
        organInfoEntity.setStartcustomerno(customerno);
        organInfoEntity.setRegisterprovince(registerprovince);
        organInfoEntity.setRegistercity(registercity);
        organInfoEntity.setRegistercounty(registercounty);
        organInfoEntity.setRegistertreet(registertreet);
        organInfoEntity.setMembername(membername);
        organInfoEntity.setOrgantype(organtype);
        organInfoEntity.setOrganclass(organclass);
        //字典 106 0-企业设立中 1-企业已注册 2-企业已注销
        organInfoEntity.setOrganstatus(MacroDefine.ORGAN_STATUS.ORGAN_STATUS_0.getValue());
        organInfoEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
        organInfoEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
        organInfoEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
        organInfoEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));

        return isUpdate ? updateOrganInfoEntity(organInfoEntity, rs) : insertOrganInfoEntity(organInfoEntity, rs);
    }

    /**
     * 写客户信息表
     *
     * @param rs 结果集
     */
    private boolean addCifCustomer(Response rs) {

        CustEntity custEntity = new CustEntity();
        custEntity.setCustomerno(orgcustomerno);
        //用户类型 字典102 0-个人 1-企业
        custEntity.setMembertype(MacroDefine.MEMBER_TYPE.MEMBER_TYPE_1.getValue());
        custEntity.setStatus(MacroDefine.CUST_STATUS.NORMAL.getValue());
        custEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
        custEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
        custEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
        custEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));

        return isUpdate ? updateCustEntity(custEntity, rs) : insertCustEntity(custEntity, rs);
    }

    /**
     * 写企业业务流程信息表
     */
    private boolean addFlow(Response rs) {

        OrganFlowEntity OrganFlowEntity = new OrganFlowEntity();
        OrganFlowEntity.setOrgcustomerno(orgcustomerno);
        OrganFlowEntity.setCustomerno(customerno);
        //流程类型 字典118 0-企业预核名 1-企业设立 2-企业变更 3-企业注销 4-企业迁入
        OrganFlowEntity.setType(MacroDefine.FLOW_TYPE.FLOW_TYPE_0.getValue());
        OrganFlowEntity.setStatus(MacroDefine.AUDIT_STATUS.AUDIT_STATUS_INIT.getValue());
        //是否申请退回 0否 1是
        OrganFlowEntity.setIsreturn(MacroDefine.IS_RETURN.IS_RETURN_0.getValue());
        OrganFlowEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
        OrganFlowEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
        OrganFlowEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
        OrganFlowEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));

        return isUpdate ? updateOrganFlowEntity(OrganFlowEntity, rs) : insertOrganFlowEntity(OrganFlowEntity, rs);

    }


}
