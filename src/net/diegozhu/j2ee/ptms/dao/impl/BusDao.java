package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IBusDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.Bus;

import org.springframework.stereotype.Repository;

/**
 * BusDao.
 * 
 * @author diegozhu.net
 */
@Repository
public class BusDao extends BaseDao<Bus, Integer> implements IBusDao {

	public BusDao() {
		this.setEntityName("Bus");
	}

}
