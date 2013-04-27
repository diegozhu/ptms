package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.Eventtype;
import org.springframework.stereotype.Repository;

/**
 * EventtypeDao.
 * @see net.diegozhu.j2ee.ptms.dao.Eventtype
 * @author diegozhu.net
 */
@Repository
public interface IEventtypeDao extends IBaseDao<Eventtype, Integer> {
}
