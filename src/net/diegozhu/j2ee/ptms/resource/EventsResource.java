/*
 * ptms
 * Copyright (c) 2013 diegozhu All Rights Reserved.
 */
package net.diegozhu.j2ee.ptms.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.Events;
import net.diegozhu.j2ee.ptms.service.IEventsService;
import net.diegozhu.j2ee.ptms.vo.ResponseData;

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

@Path("/Events")
@Controller
public class EventsResource {

	private static Logger logger = Logger.getLogger(EventsResource.class);

	@Autowired
	private IEventsService EventsService;

	@Path("/c/{Catogray}/")
	@GET
	public String getEventsCatogray(@PathParam("Catogray") String Catogray) throws BaseException {
		List<Events> list = EventsService.getByCatogray(Catogray);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@GET
	public String getAllEvents() throws BaseException {
		List<Events> list = EventsService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addEvents(String request) throws BaseException {
		Events Events = ((new Gson()).fromJson(request, Events.class));
		logger.info("add Events:" + Events);
		Events.setId(null);
		ResponseData rp = new ResponseData();
		Events = EventsService.add(Events);
		rp.setStatus("ok");
		rp.setData(Events);
		return new Gson().toJson(rp);
	}

	@Path("/{EventsId}/")
	@GET
	public String getEvents(@PathParam("EventsId") Integer EventsId) throws BaseException {
		Events Events = EventsService.get(EventsId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Events);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateEvents(String request) throws BaseException {
		Events Events = ((new Gson()).fromJson(request, Events.class));
		EventsService.update(Events);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Events);
		return new Gson().toJson(rp);
	}

	@Path("/del/{EventsId}/")
	@GET
	public String deleteEvents(@PathParam("EventsId") Integer EventsId) throws BaseException {
		EventsService.delete(EventsId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public IEventsService getEventsService() {
		return EventsService;
	}

	public void setEventsService(IEventsService EventsService) {
		this.EventsService = EventsService;
	}
}
