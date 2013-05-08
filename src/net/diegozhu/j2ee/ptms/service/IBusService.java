package net.diegozhu.j2ee.ptms.service;

import java.util.List;

import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.Bus;
import net.diegozhu.j2ee.ptms.service.base.IBaseService;

/**
 * BusInterface.
 * 
 * @author diegozhu.net
 */
public interface IBusService extends IBaseService<Bus, Integer> {

	public List<Bus> getFreeBuses() throws BaseException;
}
