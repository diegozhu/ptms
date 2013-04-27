package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.LineStation;
import org.springframework.stereotype.Repository;

/**
 * LineStationDao.
 * @see net.diegozhu.j2ee.ptms.dao.LineStation
 * @author diegozhu.net
 */
@Repository
public interface ILineStationDao extends IBaseDao<LineStation, Integer> {
}
