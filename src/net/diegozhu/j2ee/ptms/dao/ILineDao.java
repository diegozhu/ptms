package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.Line;
import org.springframework.stereotype.Repository;

/**
 * LineDao.
 * @see net.diegozhu.j2ee.ptms.dao.Line
 * @author diegozhu.net
 */
@Repository
public interface ILineDao extends IBaseDao<Line, Integer> {
}
