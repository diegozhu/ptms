package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IStationDao;
import net.diegozhu.j2ee.ptms.model.Station;
import net.diegozhu.j2ee.ptms.service.IStationService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StationInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class StationService extends BaseService<Station, Integer> implements IStationService {

	@Autowired
	public void setBaseDao(IStationDao dao) {
		super.setBaseDao(dao);
	}

}
