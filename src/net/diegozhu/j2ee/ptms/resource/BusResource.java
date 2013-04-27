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
import net.diegozhu.j2ee.ptms.model.Bus;
import net.diegozhu.j2ee.ptms.service.IBusService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:bus<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/bus")
@Controller
public class BusResource {

	private static Logger logger = Logger.getLogger(BusResource.class);

	@Autowired
	private IBusService BusService;

	@GET
	public String getAllBus() throws BaseException {
		List<Bus> list = BusService.loadAll();
		return new Gson().toJson(list);
	}

	@POST
	public String addBus(String request) throws BaseException {
		Bus Bus = ((new Gson()).fromJson(request, Bus.class));
		Bus = BusService.add(Bus);
		logger.info("add Bus:" + Bus);
		return new Gson().toJson(Bus);
	}

	@Path("/{BusId}/")
	@GET
	public String getBus(@PathParam("BusId") Integer BusId) throws BaseException {
		return new Gson().toJson(BusService.get(BusId));
	}

	@Path("/{BusId}/")
	@PUT
	public String updateBus(String request) throws BaseException {
		Bus Bus = ((new Gson()).fromJson(request, Bus.class));
		BusService.update(Bus);
		return "{ \"status\" : \"OK\" }";
	}

	@Path("/{BusId}/")
	@DELETE
	public String deleteBus(@PathParam("BusId") Integer BusId) throws BaseException {
		BusService.delete(BusId);
		return "{ \"status\" : \"OK\" }";
	}

	public IBusService getBusService() {
		return BusService;
	}

	public void setBusService(IBusService BusService) {
		this.BusService = BusService;
	}
}
