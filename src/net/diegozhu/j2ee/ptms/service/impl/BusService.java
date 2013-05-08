package net.diegozhu.j2ee.ptms.service.impl;

import java.util.List;

import net.diegozhu.j2ee.ptms.dao.IBusDao;
import net.diegozhu.j2ee.ptms.exception.base.BaseException;
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

	@Override
	public List<Bus> getFreeBuses() throws BaseException {
		return ((IBusDao) baseDao).getFreeBuses();
	}
}
