package net.diegozhu.j2ee.ptms.dao.impl;

import java.util.List;

import net.diegozhu.j2ee.ptms.dao.IBusDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.Bus;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * BusDao.
 * 
 * @author diegozhu.net
 */
@SuppressWarnings("unchecked")
@Repository
public class BusDao extends BaseDao<Bus, Integer> implements IBusDao {

	public BusDao() {
		this.setEntityName("Bus");
	}

	@Override
	public List<Bus> getFreeBuses() throws BaseException {
		String hql = "FROM Bus WHERE deleted != 1 AND lineid = null";

		Query query = this.getSession().createQuery(hql);

		return query.list();
	}

}
