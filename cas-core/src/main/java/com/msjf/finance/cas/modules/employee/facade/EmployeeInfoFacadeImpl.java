package com.msjf.finance.cas.modules.employee.facade;

import com.msjf.finance.cas.facade.employee.EmployeeInfoFacade;
import com.msjf.finance.cas.facade.employee.domain.EmployeeInfoDomain;
import com.msjf.finance.cas.facade.organ.OrganInfoFacade;
import com.msjf.finance.cas.facade.organ.domain.OrganInfoDomain;
import com.msjf.finance.cas.modules.employee.service.EmployeeInfoService;
import com.msjf.finance.cas.modules.organ.service.OrganInfoService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 11509 on 2018/12/18.
 *
 *  对入参的校验
 */
@Service("employeeInfoFacade")
public class EmployeeInfoFacadeImpl implements EmployeeInfoFacade {
    @Resource
    EmployeeInfoService employeeInfoService;


    @Override
    public Response<List<EmployeeInfoDomain>> queryEmployeeInfoList() {
       // return employeeInfoService.queryEmployeeInfoList();
        try {
            List<EmployeeInfoDomain> employeeInfoList = employeeInfoService.queryEmployeeInfoList();
            return new Response<>().success(employeeInfoList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Response<>().fail();
    }
}
