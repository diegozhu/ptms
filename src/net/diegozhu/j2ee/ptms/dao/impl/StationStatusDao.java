package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IStationStatusDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.StationStatus;
import org.springframework.stereotype.Repository;

/**
 * StationStatusDao.
 * @author diegozhu.net
 */
@Repository
public class StationStatusDao extends BaseDao<StationStatus, Integer> implements IStationStatusDao {

}
