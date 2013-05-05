package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.ILineDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.Line;

import org.springframework.stereotype.Repository;

/**
 * LineDao.
 * 
 * @author diegozhu.net
 */
@Repository
public class LineDao extends BaseDao<Line, Integer> implements ILineDao {
	public LineDao() {
		this.setEntityName("Line");
	}
}
