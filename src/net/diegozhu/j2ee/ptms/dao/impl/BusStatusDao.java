package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IBusStatusDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.BusStatus;
import org.springframework.stereotype.Repository;

/**
 * BusStatusDao.
 * @author diegozhu.net
 */
@Repository
public class BusStatusDao extends BaseDao<BusStatus, Integer> implements IBusStatusDao {

}
