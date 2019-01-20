package com.msjf.finance.cas.modules.Account;


import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.HashMap;
import java.util.List;
@MyBatisDao
public interface AccountDao {

    List selectOrganInfoByMobile(HashMap map);

    List selectLoginInfo(HashMap map);

    List selectEmployeeInfo(HashMap map);

    List selectPersonInfoByMob(HashMap map);

}
