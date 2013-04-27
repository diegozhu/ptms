package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IUserDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.User;
import org.springframework.stereotype.Repository;

/**
 * UserDao.
 * @author diegozhu.net
 */
@Repository
public class UserDao extends BaseDao<User, Integer> implements IUserDao {

}
