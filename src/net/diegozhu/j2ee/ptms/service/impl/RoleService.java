package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IRoleDao;
import net.diegozhu.j2ee.ptms.model.Role;
import net.diegozhu.j2ee.ptms.service.IRoleService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RoleInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class RoleService extends BaseService<Role, Integer> implements IRoleService {

	@Autowired
	public void setBaseDao(IRoleDao dao) {
		super.setBaseDao(dao);
	}

}
