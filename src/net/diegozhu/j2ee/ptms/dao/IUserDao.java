package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.User;
import org.springframework.stereotype.Repository;

/**
 * UserDao.
 * @see net.diegozhu.j2ee.ptms.dao.User
 * @author diegozhu.net
 */
@Repository
public interface IUserDao extends IBaseDao<User, Integer> {
}
