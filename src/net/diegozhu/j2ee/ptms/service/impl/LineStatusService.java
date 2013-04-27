package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.ILineStatusDao;
import net.diegozhu.j2ee.ptms.model.LineStatus;
import net.diegozhu.j2ee.ptms.service.ILineStatusService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LineStatusInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class LineStatusService extends BaseService<LineStatus, Integer> implements ILineStatusService {

	@Autowired
	public void setBaseDao(ILineStatusDao dao) {
		super.setBaseDao(dao);
	}

}
