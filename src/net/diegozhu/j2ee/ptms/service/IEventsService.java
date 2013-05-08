package net.diegozhu.j2ee.ptms.service;

import java.util.List;

import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.Events;
import net.diegozhu.j2ee.ptms.service.base.IBaseService;

/**
 * EventsInterface.
 * 
 * @author diegozhu.net
 */
public interface IEventsService extends IBaseService<Events, Integer> {

	List<Events> getByCatogray(String catogray) throws BaseException;

}
