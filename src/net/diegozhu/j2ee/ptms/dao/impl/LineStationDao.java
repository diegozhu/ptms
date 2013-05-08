package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.ILineStationDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.LineStation;

import org.springframework.stereotype.Repository;

/**
 * LineStationDao.
 * 
 * @author diegozhu.net
 */
@Repository
public class LineStationDao extends BaseDao<LineStation, Integer> implements ILineStationDao {
	public LineStationDao() {
		this.setEntityName("LineStation");

	}

}
