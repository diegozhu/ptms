package net.diegozhu.j2ee.ptms.dao;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.model.BusStatus;

import org.springframework.stereotype.Repository;

/**
 * BusStatusDao.
 * 
 * @see net.diegozhu.j2ee.ptms.dao.BusStatus
 * @author diegozhu.net
 */
@Repository
public interface IBusStatusDao extends IBaseDao<BusStatus, Integer> {

}
