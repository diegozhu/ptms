package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IBusStatusDao;
import net.diegozhu.j2ee.ptms.model.BusStatus;
import net.diegozhu.j2ee.ptms.service.IBusStatusService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BusStatusInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class BusStatusService extends BaseService<BusStatus, Integer> implements IBusStatusService {

	@Autowired
	public void setBaseDao(IBusStatusDao dao) {
		super.setBaseDao(dao);
	}

}
