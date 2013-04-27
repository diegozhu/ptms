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
import net.diegozhu.j2ee.ptms.model.Station;
import net.diegozhu.j2ee.ptms.service.IStationService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:station<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/station")
@Controller
public class StationResource {

	private static Logger logger = Logger.getLogger(StationResource.class);

	@Autowired
	private IStationService StationService;

	@GET
	public String getAllStation() throws BaseException {
		List<Station> list = StationService.loadAll();
		return new Gson().toJson(list);
	}

	@POST
	public String addStation(String request) throws BaseException {
		Station Station = ((new Gson()).fromJson(request, Station.class));
		Station = StationService.add(Station);
		logger.info("add Station:" + Station);
		return new Gson().toJson(Station);
	}

	@Path("/{StationId}/")
	@GET
	public String getStation(@PathParam("StationId") Integer StationId) throws BaseException {
		return new Gson().toJson(StationService.get(StationId));
	}

	@Path("/{StationId}/")
	@PUT
	public String updateStation(String request) throws BaseException {
		Station Station = ((new Gson()).fromJson(request, Station.class));
		StationService.update(Station);
		return "{ \"status\" : \"OK\" }";
	}

	@Path("/{StationId}/")
	@DELETE
	public String deleteStation(@PathParam("StationId") Integer StationId) throws BaseException {
		StationService.delete(StationId);
		return "{ \"status\" : \"OK\" }";
	}

	public IStationService getStationService() {
		return StationService;
	}

	public void setStationService(IStationService StationService) {
		this.StationService = StationService;
	}
}
