package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.BusLine;
import org.springframework.stereotype.Repository;

/**
 * BusLineDao.
 * @see net.diegozhu.j2ee.ptms.dao.BusLine
 * @author diegozhu.net
 */
@Repository
public interface IBusLineDao extends IBaseDao<BusLine, Integer> {
}
