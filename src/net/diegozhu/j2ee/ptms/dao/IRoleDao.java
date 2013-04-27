package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.Role;
import org.springframework.stereotype.Repository;

/**
 * RoleDao.
 * @see net.diegozhu.j2ee.ptms.dao.Role
 * @author diegozhu.net
 */
@Repository
public interface IRoleDao extends IBaseDao<Role, Integer> {
}
