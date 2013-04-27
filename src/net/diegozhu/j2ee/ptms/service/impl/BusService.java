package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IBusDao;
import net.diegozhu.j2ee.ptms.model.Bus;
import net.diegozhu.j2ee.ptms.service.IBusService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BusInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class BusService extends BaseService<Bus, Integer> implements IBusService {

	@Autowired
	public void setBaseDao(IBusDao dao) {
		super.setBaseDao(dao);
	}

}
