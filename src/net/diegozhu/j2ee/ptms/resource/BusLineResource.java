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
import net.diegozhu.j2ee.ptms.model.BusLine;
import net.diegozhu.j2ee.ptms.service.IBusLineService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:bus_line<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/busLine")
@Controller
public class BusLineResource {

	private static Logger logger = Logger.getLogger(BusLineResource.class);

	@Autowired
	private IBusLineService BusLineService;

	@GET
	public String getAllBusLine() throws BaseException {
		List<BusLine> list = BusLineService.loadAll();
		return new Gson().toJson(list);
	}

	@POST
	public String addBusLine(String request) throws BaseException {
		BusLine BusLine = ((new Gson()).fromJson(request, BusLine.class));
		BusLine = BusLineService.add(BusLine);
		logger.info("add BusLine:" + BusLine);
		return new Gson().toJson(BusLine);
	}

	@Path("/{BusLineId}/")
	@GET
	public String getBusLine(@PathParam("BusLineId") Integer BusLineId) throws BaseException {
		return new Gson().toJson(BusLineService.get(BusLineId));
	}

	@Path("/{BusLineId}/")
	@PUT
	public String updateBusLine(String request) throws BaseException {
		BusLine BusLine = ((new Gson()).fromJson(request, BusLine.class));
		BusLineService.update(BusLine);
		return "{ \"status\" : \"OK\" }";
	}

	@Path("/{BusLineId}/")
	@DELETE
	public String deleteBusLine(@PathParam("BusLineId") Integer BusLineId) throws BaseException {
		BusLineService.delete(BusLineId);
		return "{ \"status\" : \"OK\" }";
	}

	public IBusLineService getBusLineService() {
		return BusLineService;
	}

	public void setBusLineService(IBusLineService BusLineService) {
		this.BusLineService = BusLineService;
	}
}
