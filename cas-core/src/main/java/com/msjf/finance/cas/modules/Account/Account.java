package com.msjf.finance.cas.modules.Account;

import com.msjf.finance.cas.modules.IApp;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

/**
 * Created by lzp on 2018/12/27.
 */
public abstract class Account implements IApp {


    /**
     * 服务名称
     */
    protected final static String serviceName = "cas";
    /**
     * 日志记录类
     */
    protected final Logger logger = LogManager.getLogger(this.getClass());
    /** 日期格式 yyyyMMdd */
    public static final String DATE_FMT_DATE = "yyyyMMdd";

    /** 日期格式 HHmmss */
    public static final String DATE_FMT_TIME = "HHmmss";

    /** 日期格式 yyyyMMddHHmmss */
    public static final String DATE_FMT_DATETIME = "yyyyMMddHHmmss";

    /** 登录来源  0-web 1-app*/
    public static final String WEB="0";
    public static final String APP="1";
    /**
     * 个人手机号码允许重复数量
     */
    public static final Integer init_phone_count_person = 1;

    /**
     * 机构手机号码允许重复数量
     */
    public static final Integer init_phone_count_organ = 50;

    /** 是 */
    public static final String YES = "1";

    /** 否 */
    public static final String NO = "0";


    /** 企业*/
    public static final String company = "1";

    /** 个人 */
    public static final String person = "0";

    /** 步骤1*/
    public static final String step_1 = "1";


    /** 步骤2*/
    public static final String step_2 = "2";

    /** 步骤3*/
    public static final String step_3 = "3";

    /**
     * 短信认证类型 0-服务平台注册 1-管理平台登录 2-修改密码 3-手机换绑 4-业务平台登陆
     */
    public static final String SMS_REGISTER_TYPE = "0";
    public static final String SMS_LOGIN_TYPE = "1";
    public static final String SMS_CHANGE_PWD_TYPE = "2";
    public static final String SMS_CHANGE_MOBILE_TYPE = "3";
    public static final String SMS_SERVICE_LOGIN_TYPE = "4";

    public static final String CERTIFICATETYPE_0="0";

    public static final String STATUS_0="0";

    /** 业务类型 服务平台注册 */
    public static final String BUSINESSCODE_0 = "0";

    /** 业务类型 管理平台用户新增 */
    public static final String BUSINESSCODE_1 = "1";

    /** 业务类型 业务平台用户删除 */
    public static final String BUSINESSCODE_2 = "2";

    /** 业务类型 流程申請退回 */
    public static final String BUSINESSCODE_3 = "3";

    /** 认证状态 *-初始状态 0-认证成功 1-认证失败  */
    public static final String AUTH_STATUS_INIT = "*";

    /** 实名认证 成功   */
    public static final String AUTH_STATUS_SUCCESS = "0";

    /** 实名认证 失败   */
    public static final String AUTH_STATUS_FAILURE = "1";

    /** 申请流水状态-成功   */
    public static final String APPLY_STATUS_SUCCESS = "0";

    /** 申请流水状态-初始   */
    public static final String APPLY_STATUS_INIT = "*";

    /** 申请流水状态-失败   */
    public static final String APPLY_STATUS_FAILURE = "1";

    /** 流程申请状态-未提交   */
    public static final String FLOW_STATUS_INIT = "0";

    /** 流程申请状态-审核中   */
    public static final String FLOW_STATUS_ING = "1";

    /** 流程申请状态-办理完成   */
    public static final String FLOW_STATUS_FIN = "2";

    /** 流程申请状态-审核不通过   */
    public static final String FLOW_STATUS_NO = "3";

    /** 流程申请状态-已暂存  */
    public static final String FLOW_STATUS_TEM = "4";

    /** 当日允许会员登录密码错误次数type*/
    public static final String SYS_PARAM_TYPE_LOGIN_ERROR = "login_error_num";

    /** 当日允许会员登录密码错误次数*/
    public static final String SYS_PARAM_ID_LOGIN_ERROR = "login_allow_error_num";

    /** 验证码失效时间type*/
    public static final String SYS_PARAM_TYPE_FAILURE_TIME = "code_failure_time";

    /** 短信验证码失效时间(s)*/
    public static final String SYS_PARAM_ID_FAILURE_TIME_MSGCODE = "msgcode_failure_time";

    /** 邀请码失效时间(h)*/
    public static final String SYS_PARAM_ID_FAILURE_TIME_INVITECODE = "invitecode_failure_time";

    /** 管理平台用户初始密码*/
    public static final String SYS_PARAM_TYPE_INIT_PASSWORD = "init_password";

    /** 管理平台用户初始密码*/
    public static final String SYS_PARAM_ID_INIT_PASSWORD = "manage_init_password";

    /** 管理平台用户初始密码:q111111*/
    public static final String SYS_INIT_PASSWORD = "D19592FA1AF0BDF95710D12A20A413C2";

    /** 税收测算报送状态 0-未报送 */
    public static final String TAX_SUB_0 = "0";

    /** 税收测算报送状态 1-已报送 */
    public static final String TAX_SUB_1 = "1";

    /** 补助状态-开启   */
    public static final String GRANT_STATUS_OPEN = "0";

    /** 补助状态-关闭   */
    public static final String GRANT_STATUS_OFF = "*";

    /** 当前报告期-否   */
    public static final String ISCURRENT_NO = "0";

    /** 当前报告期-是   */
    public static final String ISCURRENT_YSE = "1";

    /** 当前报告期type   */
    public static final String ISCURRENT_TYPE = "105";

    /** 流程类型 企业预核名   */
    public static final String FLOW_TYPE_NAME = "0";

    /** 流程类型 企业设立    */
    public static final String FLOW_TYPE_BUILD = "1";

    /** 流程类型 企业变更   */
    public static final String FLOW_TYPE_MODIFY = "2";

    /** 流程类型 企业注销   */
    public static final String FLOW_TYPE_CANCLE = "3";

    /** 流程类型 企业迁入   */
    public static final String FLOW_TYPE_IN = "4";

    /** 组织类型 机构   */
    public static final String BRANCH_TYPE_JG = "0";

    /** 组织类型 部门    */
    public static final String BRANCH_TYPE_BM = "1";

    /** 机构父id    */
    public static final String BRANCH_PARENTID = "-1";

    /** 企业信息表状态 企业设立中   */
    public static final String INFO_TYPE_BUILD = "0";

    /** 企业信息表状态 企业变更中    */
    public static final String INFO_TYPE_MODIFY = "2";

    /** 企业信息表状态 企业迁入中   */
    public static final String INFO_TYPE_IN = "3";

    /** 企业信息表状态 企业注销中   */
    public static final String INFO_TYPE_CANCLE = "4";

    /** 基金管理人企业  */
    public static final String ORGCLASS_TYPE_0  = "0";

    /** 基金项目产品企业  */
    public static final String ORGCLASS_TYPE_1  = "1";

    /** 个人自有资金投资平台类企业  */
    public static final String ORGCLASS_TYPE_2  = "2";

    /** 企业自有资金投资平台类企业  */
    public static final String ORGCLASS_TYPE_3  = "3";

    /** 融资租赁企业   */
    public static final String ORGCLASS_TYPE_4  = "4";

    /** 其他企业   */
    public static final String ORGCLASS_TYPE_5  = "5";

    /** 员工持股平台类   */
    public static final String ORGCLASS_TYPE_6  = "6";

    /** 企业状态已注册   */
    public static final String ORGSTATUS_1  = "1";

    /**
     * 入参检查
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean preCheck(HashMap<String, Object> mapParam, Response rs) {
        return true;
    }

    /**
     * 缓存数据
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean cache(HashMap<String, Object> mapParam, Response rs) {
        return true;
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
        return true;
    }

    /**
     * 业务处理前操作
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean before(HashMap<String, Object> mapParam, Response rs) {
        return true;
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
        return true;
    }

    /**
     * 业务处理后操作
     *
     * @param mapParam 入参
     * @param rs       结果集
     * @return false 失败 true 成功
     */
    @Override
    public boolean after(HashMap<String, Object> mapParam, Response rs) {
        return true;
    }
}
