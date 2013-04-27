package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IBusLineDao;
import net.diegozhu.j2ee.ptms.model.BusLine;
import net.diegozhu.j2ee.ptms.service.IBusLineService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author diegozhu.net
 */
@Service
public class BusLineService extends BaseService<BusLine, Integer> implements IBusLineService {

	@Autowired
	public void setBaseDao(IBusLineDao dao) {
		super.setBaseDao(dao);
	}

}
