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
import net.diegozhu.j2ee.ptms.model.Eventtype;
import net.diegozhu.j2ee.ptms.service.IEventtypeService;
import net.diegozhu.j2ee.ptms.vo.ResponseData;

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

@Path("/Eventtype")
@Controller
public class EventtypeResource {

	private static Logger logger = Logger.getLogger(EventtypeResource.class);

	@Autowired
	private IEventtypeService EventtypeService;

	@GET
	public String getAllEventtype() throws BaseException {
		List<Eventtype> list = EventtypeService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addEventtype(String request) throws BaseException {
		Eventtype Eventtype = ((new Gson()).fromJson(request, Eventtype.class));
		logger.info("add Eventtype:" + Eventtype);
		ResponseData rp = new ResponseData();
		Eventtype.setId(null);
		Eventtype = EventtypeService.add(Eventtype);
		rp.setStatus("ok");
		rp.setData(Eventtype);
		return new Gson().toJson(rp);
	}

	@Path("/{EventtypeId}/")
	@GET
	public String getEventtype(@PathParam("EventtypeId") Integer EventtypeId) throws BaseException {
		Eventtype Eventtype = EventtypeService.get(EventtypeId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Eventtype);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateEventtype(String request) throws BaseException {
		Eventtype Eventtype = ((new Gson()).fromJson(request, Eventtype.class));
		EventtypeService.update(Eventtype);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Eventtype);
		return new Gson().toJson(rp);
	}

	@Path("/del/{EventtypeId}/")
	@GET
	public String deleteEventtype(@PathParam("EventtypeId") Integer EventtypeId) throws BaseException {
		EventtypeService.delete(EventtypeId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public IEventtypeService getEventtypeService() {
		return EventtypeService;
	}

	public void setEventtypeService(IEventtypeService EventtypeService) {
		this.EventtypeService = EventtypeService;
	}
}
