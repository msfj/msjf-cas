package com.msjf.finance.cas.modules.organ.service.impl;

import com.msjf.finance.cas.common.dao.entity.CustEntity;
import com.msjf.finance.cas.common.dao.entity.OrganFlowEntity;
import com.msjf.finance.cas.common.dao.entity.OrganInfoEntity;
import com.msjf.finance.cas.common.dao.key.OrganInfoKey;
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
    private String customerNo;

    /**
     * 企业客户代码
     */
    private String orgCustomerNo;

    /**
     * 实际地址(省) dict101021
     **/
    private String realProvince;
    /**
     * 实际地址(市) dict101022
     **/
    private String realCity;
    /**
     * 实际地址(区/县) dict101023
     **/
    private String realCounty;
    /**
     * 实际地址(街道)
     **/
    private String realTreet;

    /**
     * 企业名称
     */
    private String memberName;

    /**
     * 企业类型 字典104 0-有限公司 1-合伙企业
     */
    private String organType;

    /**
     * 企业分类 字典105 0-基金管理人企业 1-基金项目产品企业 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业
     */
    private String organClass;

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
        customerNo = StringUtil.valueOf(mapParam.get("customerno"));
        orgCustomerNo = StringUtil.valueOf(mapParam.get("orgcustomerno"));
        realProvince = StringUtil.valueOf(mapParam.get("realprovince"));
        realCity = StringUtil.valueOf(mapParam.get("realcity"));
        realCounty = StringUtil.valueOf(mapParam.get("realcounty"));
        realTreet = StringUtil.valueOf(mapParam.get("realtreet"));
        memberName = StringUtil.valueOf(mapParam.get("membername"));
        organType = StringUtil.valueOf(mapParam.get("organtype"));
        organClass = StringUtil.valueOf(mapParam.get("organclass"));
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
        if (CheckUtil.isNull(customerNo)) {
            rs.fail("cas", "发起人客户代码不能为空");
            return false;
        }
        if (CheckUtil.isNull(memberName)) {
            rs.fail("cas", "企业名称不能为空");
            return false;
        }
        if (CheckUtil.isNull(organType)) {
            rs.fail("cas", "企业类型不能为空");
            return false;
        }
        if (CheckUtil.isNull(organClass)) {
            rs.fail("cas", "企业分类不能为空");
            return false;
        }
        return super.preCheck(mapParam, rs);
    }

    @Override
    public boolean check(HashMap<String, Object> mapParam, Response rs) {
        //1-检查发起人账户信息不存在
        CustEntity custEntity = new CustEntity();
        custEntity.setCustomerno(customerNo);
        List<CustEntity> customerEntityList = custDao.getListEntity(custEntity);
        if (CheckUtil.isNull(customerEntityList)) {
            rs.fail("cas", "发起人账户信息不存在");
            return false;
        }

        //2-企业名称唯一性检查
        if (!checkOrganName(memberName, rs)) {
            return false;
        }
        //3-检查是否传机构代码，有传则代表是修改,没有则代码是新增(新增是生成企业ID)
        if (CheckUtil.isNull(orgCustomerNo)) {
            //生成企业ID
            orgCustomerNo = String.valueOf(IDUtils.genItemId());
        } else {
            isUpdate = Boolean.TRUE;
        }
        //4-如果为修改则检查企业信息是否存在
        if (isUpdate) {
            OrganInfoKey organInfoKey = new OrganInfoKey();
            organInfoKey.setKey(orgCustomerNo);
            OrganInfoEntity organInfoEntity = organInfoDao.getEntityKey(organInfoKey);
            if (CheckUtil.isNull(organInfoEntity)) {
                rs.fail("cas", "企业基本信息不存在");
                return false;
            }
        }
        return super.check(mapParam, rs);
    }

    @Override
    public boolean clear(HashMap<String, Object> mapParam, Response rs) {
        //1-写企业基本信息表
        addOrganInfo(rs);
        //2-写客户信息表
        addCifCustomer(rs);
        //3-写企业业务流程信息表
        addFlow(rs);
        //4-返回新增信息
        HashMap<String, Object> map = new HashMap(4);
        map.put("orgCustomerNo", orgCustomerNo);
        map.put("organType", organType);
        map.put("organClass", organClass);
        map.put("memberName", memberName);
        rs.success("cas", "操作成功", map);
        return super.clear(mapParam, rs);
    }

    /**
     * 写企业基本信息表
     *
     * @param rs 结果集
     */
    private void addOrganInfo(Response rs) {
        try {
            OrganInfoEntity organInfoEntity = new OrganInfoEntity();
            organInfoEntity.setVersion(INIT_VERSION);
            organInfoEntity.setCustomerno(orgCustomerNo);
            organInfoEntity.setStartcustomerno(customerNo);
            organInfoEntity.setRealprovince(realProvince);
            organInfoEntity.setRealcity(realCity);
            organInfoEntity.setRealcounty(realCounty);
            organInfoEntity.setRealtreet(realTreet);
            organInfoEntity.setMembername(memberName);
            organInfoEntity.setOrgantype(organType);
            organInfoEntity.setOrganclass(organClass);
            //字典 106 0-企业设立中 1-企业已注册 2-企业已注销
            organInfoEntity.setOrganstatus(MacroDefine.ORGAN_STATUS.ORGAN_STATUS_0.getValue());
            organInfoEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            organInfoEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
            organInfoEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            organInfoEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));

            Integer row = isUpdate ? organInfoDao.updEntity(organInfoEntity) : organInfoDao.insEntity(organInfoEntity);
            if (row != 1) {
                throw new RuntimeException("organ_info操作失败");
            }
        } catch (Exception e) {
            rs.fail("cas", "organ_info表写失败");
            logger.error("cas", "organ_info表写失败", e);
            throw new RuntimeException("organ_info表写失败", e);
        }
    }

    /**
     * 写客户信息表
     *
     * @param rs 结果集
     */
    private void addCifCustomer(Response rs) {
        try {
            CustEntity custEntity = new CustEntity();
            custEntity.setCustomerno(orgCustomerNo);
            //用户类型 字典102 0-个人 1-企业
            custEntity.setMembertype(MacroDefine.MEMBER_TYPE.MEMBER_TYPE_1.getValue());
            custEntity.setStatus(MacroDefine.CUST_STATUS.NORMAL.getValue());
            custEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            custEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
            custEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            custEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));

            Integer row = isUpdate ? custDao.updEntity(custEntity) : custDao.insEntity(custEntity);
            if (row != 1) {
                throw new RuntimeException("cif_cust操作失败");
            }
        } catch (Exception e) {
            rs.fail("cas", "cif_cust表写失败");
            logger.error("cas", "cif_cust表写失败", e);
            throw new RuntimeException("cif_cust表写失败", e);
        }
    }

    /**
     * 写企业业务流程信息表
     */
    private void addFlow(Response rs) {
        try {
            OrganFlowEntity cifOrganFlowEntity = new OrganFlowEntity();
            cifOrganFlowEntity.setOrgcustomerno(orgCustomerNo);
            cifOrganFlowEntity.setCustomerno(customerNo);
            //流程类型 字典118 0-企业预核名 1-企业设立 2-企业变更 3-企业注销 4-企业迁入
            cifOrganFlowEntity.setType(MacroDefine.FLOW_TYPE.FLOW_TYPE_0.getValue());
            cifOrganFlowEntity.setStatus(MacroDefine.AUDIT_STATUS.AUDIT_STATUS_INIT.getValue());
            //是否申请退回 0否 1是
            cifOrganFlowEntity.setIsreturn(MacroDefine.IS_RETURN.IS_RETURN_0.getValue());
            cifOrganFlowEntity.setInsertdate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            cifOrganFlowEntity.setInserttime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));
            cifOrganFlowEntity.setUpdatedate(DateUtils.getUserDate(DateUtils.DATE_FMT_DATE));
            cifOrganFlowEntity.setUpdatetime(DateUtils.getUserDate(DateUtils.DATE_FMT_TIME));

            Integer row = isUpdate ? organFlowDao.updEntity(cifOrganFlowEntity) : organFlowDao.insEntity
                    (cifOrganFlowEntity);
            if (row != 1) {
                throw new RuntimeException("cif_cust操作失败");
            }
        } catch (Exception e) {
            rs.fail("cas", "cif_organ_flow表写失败");
            logger.error("cas", "cif_organ_flow表写失败", e);
            throw new RuntimeException("cif_organ_flow表写失败", e);
        }
    }


}
