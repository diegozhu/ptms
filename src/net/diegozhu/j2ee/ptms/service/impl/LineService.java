package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.ILineDao;
import net.diegozhu.j2ee.ptms.model.Line;
import net.diegozhu.j2ee.ptms.service.ILineService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LineInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class LineService extends BaseService<Line, Integer> implements ILineService {

	@Autowired
	public void setBaseDao(ILineDao dao) {
		super.setBaseDao(dao);
	}

}
