package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.LineStatus;
import org.springframework.stereotype.Repository;

/**
 * LineStatusDao.
 * @see net.diegozhu.j2ee.ptms.dao.LineStatus
 * @author diegozhu.net
 */
@Repository
public interface ILineStatusDao extends IBaseDao<LineStatus, Integer> {
}
