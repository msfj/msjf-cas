package com.msjf.finance.cas.common.dao.persistence;
import com.msjf.finance.cas.common.dao.entity.OrganTaxEntity;
import com.msjf.finance.cas.common.dao.key.OrganTaxKey;
import com.msjf.finance.cas.common.dao.IBaseDao;
import com.msjf.finance.msjf.core.dao.MyBatisDao;
/**
 * @author 
 */
@MyBatisDao
public interface OrganTaxDao extends IBaseDao<OrganTaxEntity,OrganTaxKey> {
}