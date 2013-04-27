package net.diegozhu.j2ee.ptms.service.impl;

import net.diegozhu.j2ee.ptms.dao.IUserDao;
import net.diegozhu.j2ee.ptms.model.User;
import net.diegozhu.j2ee.ptms.service.IUserService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserInterface.
 * 
 * @author diegozhu.net
 */
@Service
public class UserService extends BaseService<User, Integer> implements IUserService {

	@Autowired
	public void setBaseDao(IUserDao dao) {
		super.setBaseDao(dao);
	}

}
