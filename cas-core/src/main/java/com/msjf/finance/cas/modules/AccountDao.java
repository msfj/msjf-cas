package com.msjf.finance.cas.modules;

import com.msjf.finance.cas.common.dao.MyBatisDao;

import java.util.HashMap;
import java.util.List;
@MyBatisDao
public interface AccountDao {

    List selectOrganInfoByMobile(HashMap map);

    List selectLoginInfo(HashMap map);

    List selectEmployeeInfo(HashMap map);
}
