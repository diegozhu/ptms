package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IEventtypeDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.Eventtype;

import org.springframework.stereotype.Repository;

/**
 * EventtypeDao.
 * 
 * @author diegozhu.net
 */
@Repository
public class EventtypeDao extends BaseDao<Eventtype, Integer> implements IEventtypeDao {
	public EventtypeDao() {
		this.setEntityName("Eventtype");
	}
}
