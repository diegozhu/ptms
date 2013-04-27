package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IEventsDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.Events;
import org.springframework.stereotype.Repository;

/**
 * EventsDao.
 * @author diegozhu.net
 */
@Repository
public class EventsDao extends BaseDao<Events, Integer> implements IEventsDao {

}
