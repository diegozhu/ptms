package net.diegozhu.j2ee.ptms.dao;

import java.util.List;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.Bus;

import org.springframework.stereotype.Repository;

/**
 * BusDao.
 * 
 * @see net.diegozhu.j2ee.ptms.dao.Bus
 * @author diegozhu.net
 */
@Repository
public interface IBusDao extends IBaseDao<Bus, Integer> {

	List<Bus> getFreeBuses() throws BaseException;
}
