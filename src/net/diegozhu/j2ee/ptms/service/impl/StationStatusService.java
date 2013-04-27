package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IStationStatusDao;
import net.diegozhu.j2ee.ptms.model.StationStatus;
import net.diegozhu.j2ee.ptms.service.IStationStatusService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StationStatusInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class StationStatusService extends BaseService<StationStatus, Integer> implements IStationStatusService {

	@Autowired
	public void setBaseDao(IStationStatusDao dao) {
		super.setBaseDao(dao);
	}

}
