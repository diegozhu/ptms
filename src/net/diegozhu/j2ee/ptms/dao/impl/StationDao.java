package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IStationDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.Station;

import org.springframework.stereotype.Repository;

/**
 * StationDao.
 * 
 * @author diegozhu.net
 */
@Repository
public class StationDao extends BaseDao<Station, Integer> implements IStationDao {
	public StationDao() {
		this.setEntityName("Station");
	}
}
