package net.diegozhu.j2ee.ptms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.diegozhu.j2ee.ptms.model.User;
import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.service.IUserService;
import net.diegozhu.j2ee.ptms.service.base.impl.BaseService;

@Service
public class UserService extends BaseService<User, Integer> implements IUserService {
	
	
	@Autowired  
    public void setBaseDao(IBaseDao<User, Integer> dao) {  
        super.setBaseDao(dao);  
    }  

}