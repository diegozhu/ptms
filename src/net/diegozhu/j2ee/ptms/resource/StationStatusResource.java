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
import net.diegozhu.j2ee.ptms.vo.ResponseData;
import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.StationStatus;
import net.diegozhu.j2ee.ptms.service.IStationStatusService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:station_status<br>
 * @author diego zhu
 * @version 1.0
 */

@Path("/StationStatus")
@Controller
public class StationStatusResource {

	private static Logger logger = Logger.getLogger(StationStatusResource.class);

	@Autowired
	private IStationStatusService StationStatusService;

	@GET
	public String getAllStationStatus() throws BaseException {
		List<StationStatus> list = StationStatusService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addStationStatus(String request) throws BaseException {
		StationStatus StationStatus = ((new Gson()).fromJson(request, StationStatus.class));
		logger.info("add StationStatus:" + StationStatus);
		ResponseData rp = new ResponseData();
		StationStatus = StationStatusService.add(StationStatus);
		rp.setStatus("ok");
		rp.setData(StationStatus);
		return new Gson().toJson(rp);
	}

	@Path("/{StationStatusId}/")
	@GET
	public String getStationStatus(@PathParam("StationStatusId") Integer StationStatusId) throws BaseException {
		StationStatus StationStatus = StationStatusService.get(StationStatusId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(StationStatus);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateStationStatus(String request) throws BaseException {
		StationStatus StationStatus = ((new Gson()).fromJson(request, StationStatus.class));
		StationStatusService.update(StationStatus);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(StationStatus);
		return new Gson().toJson(rp);
	}

	@Path("/del/{StationStatusId}/")
	@GET
	public String deleteStationStatus(@PathParam("StationStatusId") Integer StationStatusId) throws BaseException {
		StationStatusService.delete(StationStatusId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public IStationStatusService getStationStatusService() {
		return StationStatusService;
	}

	public void setStationStatusService(IStationStatusService StationStatusService) {
		this.StationStatusService = StationStatusService;
	}
}
