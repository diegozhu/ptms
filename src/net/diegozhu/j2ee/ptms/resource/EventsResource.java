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
import net.diegozhu.j2ee.ptms.model.Events;
import net.diegozhu.j2ee.ptms.service.IEventsService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:events<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/events")
@Controller
public class EventsResource {

	private static Logger logger = Logger.getLogger(EventsResource.class);

	@Autowired
	private IEventsService EventsService;

	@GET
	public String getAllEvents() throws BaseException {
		List<Events> list = EventsService.loadAll();
		return new Gson().toJson(list);
	}

	@POST
	public String addEvents(String request) throws BaseException {
		Events Events = ((new Gson()).fromJson(request, Events.class));
		Events = EventsService.add(Events);
		logger.info("add Events:" + Events);
		return new Gson().toJson(Events);
	}

	@Path("/{EventsId}/")
	@GET
	public String getEvents(@PathParam("EventsId") Integer EventsId) throws BaseException {
		return new Gson().toJson(EventsService.get(EventsId));
	}

	@Path("/{EventsId}/")
	@PUT
	public String updateEvents(String request) throws BaseException {
		Events Events = ((new Gson()).fromJson(request, Events.class));
		EventsService.update(Events);
		return "{ \"status\" : \"OK\" }";
	}

	@Path("/{EventsId}/")
	@DELETE
	public String deleteEvents(@PathParam("EventsId") Integer EventsId) throws BaseException {
		EventsService.delete(EventsId);
		return "{ \"status\" : \"OK\" }";
	}

	public IEventsService getEventsService() {
		return EventsService;
	}

	public void setEventsService(IEventsService EventsService) {
		this.EventsService = EventsService;
	}
}
