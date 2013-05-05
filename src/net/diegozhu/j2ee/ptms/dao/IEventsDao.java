package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.Events;

import org.springframework.stereotype.Repository;

/**
 * EventsDao.
 * 
 * @see net.diegozhu.j2ee.ptms.dao.Events
 * @author diegozhu.net
 */
@Repository
public interface IEventsDao extends IBaseDao<Events, Integer> {

}
