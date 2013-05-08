package net.diegozhu.j2ee.ptms.dao.impl;

import java.util.List;

import net.diegozhu.j2ee.ptms.dao.IEventsDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.Events;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * EventsDao.
 * 
 * @author diegozhu.net
 */
@Repository
public class EventsDao extends BaseDao<Events, Integer> implements IEventsDao {
	public EventsDao() {
		super.setEntityName("Events");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Events> getByCatogray(String catogray) throws BaseException {
		String hql = "FROM Events WHERE " + catogray + "id != 1 and deleted != 1";

		Query query = this.getSession().createQuery(hql);
		return query.list();
	}
}
