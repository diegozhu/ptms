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
import net.diegozhu.j2ee.ptms.model.BusStatus;
import net.diegozhu.j2ee.ptms.service.IBusStatusService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:bus_status<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/busStatus")
@Controller
public class BusStatusResource {

	private static Logger logger = Logger.getLogger(BusStatusResource.class);

	@Autowired
	private IBusStatusService BusStatusService;

	@GET
	public String getAllBusStatus() throws BaseException {
		List<BusStatus> list = BusStatusService.loadAll();
		return new Gson().toJson(list);
	}

	@POST
	public String addBusStatus(String request) throws BaseException {
		BusStatus BusStatus = ((new Gson()).fromJson(request, BusStatus.class));
		BusStatus = BusStatusService.add(BusStatus);
		logger.info("add BusStatus:" + BusStatus);
		return new Gson().toJson(BusStatus);
	}

	@Path("/{BusStatusId}/")
	@GET
	public String getBusStatus(@PathParam("BusStatusId") Integer BusStatusId) throws BaseException {
		return new Gson().toJson(BusStatusService.get(BusStatusId));
	}

	@Path("/{BusStatusId}/")
	@PUT
	public String updateBusStatus(String request) throws BaseException {
		BusStatus BusStatus = ((new Gson()).fromJson(request, BusStatus.class));
		BusStatusService.update(BusStatus);
		return "{ \"status\" : \"OK\" }";
	}

	@Path("/{BusStatusId}/")
	@DELETE
	public String deleteBusStatus(@PathParam("BusStatusId") Integer BusStatusId) throws BaseException {
		BusStatusService.delete(BusStatusId);
		return "{ \"status\" : \"OK\" }";
	}

	public IBusStatusService getBusStatusService() {
		return BusStatusService;
	}

	public void setBusStatusService(IBusStatusService BusStatusService) {
		this.BusStatusService = BusStatusService;
	}
}
