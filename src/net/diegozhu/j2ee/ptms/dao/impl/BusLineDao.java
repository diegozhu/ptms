package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IBusLineDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.BusLine;
import org.springframework.stereotype.Repository;

/**
 * BusLineDao.
 * @author diegozhu.net
 */
@Repository
public class BusLineDao extends BaseDao<BusLine, Integer> implements IBusLineDao {

}
