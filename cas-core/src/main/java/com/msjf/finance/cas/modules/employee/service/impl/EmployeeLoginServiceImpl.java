package com.msjf.finance.cas.modules.employee.service.impl;

import com.msjf.finance.cas.facade.employee.domain.EmployeeInfoDomain;
import com.msjf.finance.cas.modules.Account.Account;
import com.msjf.finance.cas.modules.ausAuthone.dao.AusAuthoneDao;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneEntity;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneKey;
import com.msjf.finance.cas.modules.employee.dao.EmployeeMapper;
import com.msjf.finance.cas.modules.employee.emun.EmployeeLoginEnum;
import com.msjf.finance.cas.modules.employee.entity.EmployeeEntity;
import com.msjf.finance.cas.modules.employee.service.EmployeeLoginService;
import com.msjf.finance.cas.modules.login.emun.LoginEnum;
import com.msjf.finance.cas.modules.util.CommonUtil;
import com.msjf.finance.cas.modules.util.DateUtil;
import com.msjf.finance.cas.modules.util.MacroDefine;
import com.msjf.finance.cas.modules.util.StringUtil;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("employeeLoginService")
@Scope("prototype")
public class EmployeeLoginServiceImpl extends Account implements EmployeeLoginService {
    /** 登录账号*/
    private String loginname;

    /** 密码*/
    private String password;

    /** 登录来源  0-web 1-app*/
    private String loginsource;

    /** 客户代码*/
    private String customerno;

    @Resource
    AusAuthoneDao ausAuthoneDao;
    @Resource
    EmployeeMapper employeeMapper;
    @Override
    public Response<EmployeeInfoDomain> employeeLogin(HashMap<String, Object> mapParam) {
        Response<EmployeeInfoDomain> rs=new Response();
        getParam(mapParam);
        if (StringUtils.isEmpty(loginname)) {
            return rs.fail(EmployeeLoginEnum.LOGIN_NAME_NULL);
        }
        if (StringUtils.isEmpty(password)) {
            return rs.fail(EmployeeLoginEnum.PWD_NULL);
        }
        if (StringUtils.isEmpty(loginsource)) {
            return rs.fail(EmployeeLoginEnum.LOGIN_SOURCE_NULL);
        }
        if (!CommonUtil.isLegalOfDictValue("100", "登录来源", loginsource, rs)) {
            return rs.fail(EmployeeLoginEnum.LOGIN_SOURCE_ERROR);
        }
        //用户名存在性检查
        EmployeeEntity EmployeeEntity = new EmployeeEntity();
        EmployeeEntity.setLoginname(loginname);
        List<EmployeeEntity> ls = employeeMapper.selectByEntity(EmployeeEntity);
        if (ObjectUtils.isEmpty(ls)) {
            return rs.fail(EmployeeLoginEnum.MSG_USER_NULL);
        }
        if (MacroDefine.CUST_STATUS.LOCK.getValue().equals(ls.get(0).getStatus())) {
            return rs.fail(LoginEnum.MSG_USER_LOCK);
        }
        if (MacroDefine.CUST_STATUS.FROZEN.getValue().equals(ls.get(0).getStatus())) {
            return rs.fail(LoginEnum.MSG_USER_FROZEN);
        }
        if (MacroDefine.CUST_STATUS.CANCEL.getValue().equals(ls.get(0).getStatus())) {
            return rs.fail(LoginEnum.MSG_USER_CANCEL);
        }
        //验证码正确性检查
        String certificateno = ls.get(0).getCertificateno();
        customerno = ls.get(0).getCustomerno();
        //密码检查
        AusAuthoneKey ausAuthoneKey = new AusAuthoneKey();
        ausAuthoneKey.setCustomerno(customerno);
        AusAuthoneEntity ausAuthoneEntity = ausAuthoneDao.getAusAuthoneByKeyLock(ausAuthoneKey);
        if (ObjectUtils.isEmpty(ausAuthoneEntity)) {
            return rs.fail(EmployeeLoginEnum.MSG_USER_NULL);
        }
        String enPassword = CommonUtil.HmacSHA1Encrypt(password,customerno);
        if (StringUtils.isEmpty(enPassword)) {
            return rs.fail(LoginEnum.PWD_ENCRYPT_ERROR);
        }
        if (!enPassword.equals(ausAuthoneEntity.getPassword())) {
            //检查错误次数 错误达到上限锁定 并返回前端信息
            checkFailcount(ausAuthoneEntity.getFailcount(), rs);
            return rs;
        }
        updAuthone(rs);
        EmployeeInfoDomain employeeInfoDomain=new EmployeeInfoDomain();
        employeeInfoDomain.setLoginname(loginname);
        employeeInfoDomain.setCertificateno(certificateno);
//        HashMap<String, Object> rsmap = new HashMap<String, Object>();
//        rsmap.put("customerno", customerno);
//        rsmap.put("name", loginname);
//        rsmap.put("kosgParams", CommonUtil.getKosgParams(customerno));
        return rs.success(EmployeeLoginEnum.LOGIN_SUCCESS,employeeInfoDomain);
    }

    private void getParam(HashMap<String, Object> mapParam) {
        loginname = StringUtil.valueOf(mapParam.get("loginname"));
        password = StringUtil.valueOf(mapParam.get("password"));
        loginsource = StringUtil.valueOf(mapParam.get("loginsource"));
    }

    /**
     * 登录失败更新错误次数 错误次数达到上限状态锁定
     *
     * @param failCount 当前认证失败次数
     * @param rs
     */
    private void checkFailcount(int failCount, Response rs) {
        //获取系统参数 错误次数上限
        int sysFailCount = Integer
                .valueOf(CommonUtil.getSysConfigValue(SYS_PARAM_ID_LOGIN_ERROR, SYS_PARAM_TYPE_LOGIN_ERROR));
        //更新错误次数 和 账户状态
        AusAuthoneEntity ausAuthoneEntity = new AusAuthoneEntity();
        ausAuthoneEntity.setCustomerno(customerno);
        ausAuthoneEntity.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
        ausAuthoneEntity.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
        try {
            if (failCount + 1 >= sysFailCount) {
                //错误次数加1 状态更新为锁定
                ausAuthoneEntity.setFailcount(sysFailCount);
                EmployeeEntity c = new EmployeeEntity();
                c.setCustomerno(customerno);
                c.setStatus(MacroDefine.CUST_STATUS.LOCK.getValue());
                c.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
                c.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
                employeeMapper.updateByPrimaryKeySelective(c);
            } else {
                ausAuthoneEntity.setFailcount(failCount + 1);
            }
            ausAuthoneDao.update(ausAuthoneEntity);
        }
        catch (Exception e) {
            logger.error(e);
            throw new RuntimeException("登录错误次数更新失败");
        }
        int failedExistCount=sysFailCount-ausAuthoneEntity.getFailcount();//剩余次数
        if(failedExistCount>0){
            rs.fail();
            rs.setMsg("用户名或密码错误,剩余"+StringUtil.valueOf(failedExistCount)+"次机会");
        }else{
            rs.fail();
            rs.setMsg("用户名或密码错误,账户已锁定");
        }
    }

    /**
     * 登录成功更新登录认证信息
     *
     * @param rs
     */
    private void updAuthone(Response rs) {
        try {
            AusAuthoneEntity ausAuthoneEntity = new AusAuthoneEntity();
            ausAuthoneEntity.setCustomerno(customerno);
            ausAuthoneEntity.setFailcount(0);
            ausAuthoneEntity.setLoginsource(loginsource);
            ausAuthoneEntity.setOnlinestatus("Y");//N-不在线 Y-在线
            ausAuthoneEntity.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
            ausAuthoneEntity.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
            ausAuthoneDao.update(ausAuthoneEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("aus_authone表更新失败");
        }
    }
}
