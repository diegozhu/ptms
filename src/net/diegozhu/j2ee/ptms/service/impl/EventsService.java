package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IEventsDao;
import net.diegozhu.j2ee.ptms.model.Events;
import net.diegozhu.j2ee.ptms.service.IEventsService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EventsInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class EventsService extends BaseService<Events, Integer> implements IEventsService {

	@Autowired
	public void setBaseDao(IEventsDao dao) {
		super.setBaseDao(dao);
	}

}
