/*
 * ptms
 * Copyright (c) 2013 diegozhu All Rights Reserved.
 */
package net.diegozhu.j2ee.ptms.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.Eventtype;
import net.diegozhu.j2ee.ptms.service.IEventtypeService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:eventtype<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/eventtype")
@Controller
public class EventtypeResource {

	private static Logger logger = Logger.getLogger(EventtypeResource.class);

	@Autowired
	private IEventtypeService EventtypeService;

	@GET
	public String getAllEventtype() throws BaseException {
		List<Eventtype> list = EventtypeService.loadAll();
		return new Gson().toJson(list);
	}

	@POST
	public String addEventtype(String request) throws BaseException {
		Eventtype Eventtype = ((new Gson()).fromJson(request, Eventtype.class));
		Eventtype = EventtypeService.add(Eventtype);
		logger.info("add Eventtype:" + Eventtype);
		return new Gson().toJson(Eventtype);
	}

	@Path("/{EventtypeId}/")
	@GET
	public String getEventtype(@PathParam("EventtypeId") Integer EventtypeId) throws BaseException {
		return new Gson().toJson(EventtypeService.get(EventtypeId));
	}

	@Path("/{EventtypeId}/")
	@PUT
	public String updateEventtype(String request) throws BaseException {
		Eventtype Eventtype = ((new Gson()).fromJson(request, Eventtype.class));
		EventtypeService.update(Eventtype);
		return "{ \"status\" : \"OK\" }";
	}

	@Path("/{EventtypeId}/")
	@DELETE
	public String deleteEventtype(@PathParam("EventtypeId") Integer EventtypeId) throws BaseException {
		EventtypeService.delete(EventtypeId);
		return "{ \"status\" : \"OK\" }";
	}

	public IEventtypeService getEventtypeService() {
		return EventtypeService;
	}

	public void setEventtypeService(IEventtypeService EventtypeService) {
		this.EventtypeService = EventtypeService;
	}
}
