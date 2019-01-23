package com.msjf.finance.cas.modules.Account;


import com.msjf.finance.cas.common.entity.SysDictEntity;
import com.msjf.finance.cas.common.entity.SysDictKey;
import com.msjf.finance.msjf.core.dao.MyBatisDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MyBatisDao
public interface AccountDao {

    List selectOrganInfoByMobile(HashMap map);

    List selectLoginInfo(HashMap map);

    List selectEmployeeInfo(HashMap map);

    List selectPersonInfoByMob(HashMap map);

    Map selectCompanyPersonInfo(HashMap map);

    List<SysDictEntity> selectSysdictlistByKey(List<SysDictKey> sysDictKeyList);

}
