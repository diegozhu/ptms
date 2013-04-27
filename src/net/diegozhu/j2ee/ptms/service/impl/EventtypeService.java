package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IEventtypeDao;
import net.diegozhu.j2ee.ptms.model.Eventtype;
import net.diegozhu.j2ee.ptms.service.IEventtypeService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EventtypeInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class EventtypeService extends BaseService<Eventtype, Integer> implements IEventtypeService {

	@Autowired
	public void setBaseDao(IEventtypeDao dao) {
		super.setBaseDao(dao);
	}

}
