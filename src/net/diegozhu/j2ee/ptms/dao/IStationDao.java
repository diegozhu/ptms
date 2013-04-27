package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.Station;
import org.springframework.stereotype.Repository;

/**
 * StationDao.
 * @see net.diegozhu.j2ee.ptms.dao.Station
 * @author diegozhu.net
 */
@Repository
public interface IStationDao extends IBaseDao<Station, Integer> {
}
