package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.ILineStatusDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.LineStatus;
import org.springframework.stereotype.Repository;

/**
 * LineStatusDao.
 * @author diegozhu.net
 */
@Repository
public class LineStatusDao extends BaseDao<LineStatus, Integer> implements ILineStatusDao {

}
