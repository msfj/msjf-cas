package com.msjf.finance.cas.facade.person;
import com.msjf.finance.cas.facade.person.domain.PersonInfoDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.List;

/**
 * Created by oumingwei on 2019/01/08.
 */
public interface PersonInfoFacade {

    /**
     * 查询个人信息
     * @return
     */
    Response<List<PersonInfoDomain>> queryUserInfoList();
}
