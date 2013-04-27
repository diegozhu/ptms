package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.StationStatus;
import org.springframework.stereotype.Repository;

/**
 * StationStatusDao.
 * @see net.diegozhu.j2ee.ptms.dao.StationStatus
 * @author diegozhu.net
 */
@Repository
public interface IStationStatusDao extends IBaseDao<StationStatus, Integer> {
}
