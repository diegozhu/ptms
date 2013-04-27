package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.ILineStationDao;
import net.diegozhu.j2ee.ptms.model.LineStation;
import net.diegozhu.j2ee.ptms.service.ILineStationService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LineStationInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class LineStationService extends BaseService<LineStation, Integer> implements ILineStationService {

	@Autowired
	public void setBaseDao(ILineStationDao dao) {
		super.setBaseDao(dao);
	}

}
