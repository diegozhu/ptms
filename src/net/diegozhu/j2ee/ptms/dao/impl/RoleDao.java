package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IRoleDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.Role;

import org.springframework.stereotype.Repository;

/**
 * RoleDao.
 * 
 * @author diegozhu.net
 */
@Repository
public class RoleDao extends BaseDao<Role, Integer> implements IRoleDao {
	public RoleDao() {
		this.setEntityName("Role");
	}
}
