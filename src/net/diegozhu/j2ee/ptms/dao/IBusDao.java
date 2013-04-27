package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.Bus;
import org.springframework.stereotype.Repository;

/**
 * BusDao.
 * @see net.diegozhu.j2ee.ptms.dao.Bus
 * @author diegozhu.net
 */
@Repository
public interface IBusDao extends IBaseDao<Bus, Integer> {
}
