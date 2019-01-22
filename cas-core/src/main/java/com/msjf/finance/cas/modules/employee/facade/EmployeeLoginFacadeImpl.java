package com.msjf.finance.cas.modules.employee.facade;

import com.msjf.finance.cas.facade.employee.EmployeeLoginFacade;
import com.msjf.finance.cas.facade.employee.domain.EmployeeInfoDomain;
import com.msjf.finance.cas.modules.changePwd.emun.ChangePwdEnum;
import com.msjf.finance.cas.modules.employee.emun.EmployeeLoginEnum;
import com.msjf.finance.cas.modules.employee.service.EmployeeLoginService;
import com.msjf.finance.cas.modules.organ.facade.OrganInfoFacadeImpl;
import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service("employeeLoginFacade")
public class EmployeeLoginFacadeImpl implements EmployeeLoginFacade {
    private static final Logger logger = LogManager.getLogger(OrganInfoFacadeImpl.class);
    @Resource
    EmployeeLoginService employeeLoginService;
    @Override
    public Response<EmployeeInfoDomain> employeeLogin(HashMap<String, Object> mapParam) {
        try {
            return employeeLoginService.employeeLogin(mapParam);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new Response<>().fail(EmployeeLoginEnum.MSG_LOGIN_EXCEPTION);
        }
    }
}
