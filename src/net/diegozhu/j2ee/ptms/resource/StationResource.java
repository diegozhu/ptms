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
import net.diegozhu.j2ee.ptms.model.Station;
import net.diegozhu.j2ee.ptms.model.StationStatus;
import net.diegozhu.j2ee.ptms.service.IStationService;
import net.diegozhu.j2ee.ptms.service.IStationStatusService;
import net.diegozhu.j2ee.ptms.vo.ResponseData;

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

@Path("/Station")
@Controller
public class StationResource {

	private static Logger logger = Logger.getLogger(StationResource.class);

	@Autowired
	private IStationService StationService;

	@Autowired
	private IStationStatusService stationStatusService;

	@GET
	public String getAllStation() throws BaseException {
		List<Station> list = StationService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@GET
	@Path("{StationId}/status/")
	public String getAllStatus(@PathParam("StationId") String StationId) throws BaseException {
		List<StationStatus> list = stationStatusService.getByField("stationid", StationId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	@Path("{StationId}/status/")
	public String addStatus(@PathParam("StationId") String StationId, String request) throws BaseException {
		StationStatus StationStatus = ((new Gson()).fromJson(request, StationStatus.class));
		logger.info("add StationStatus:" + StationStatus);
		StationStatus.setId(null);
		ResponseData rp = new ResponseData();
		StationStatus = stationStatusService.add(StationStatus);
		rp.setStatus("ok");
		rp.setData(StationStatus);
		return new Gson().toJson(rp);
	}

	@GET
	@Path("{StationId}/status/last/")
	public String getLastestStatus(@PathParam("StationId") String StationId) throws BaseException {
		List<StationStatus> list = stationStatusService.getByField("stationid", StationId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		if (null != list && list.size() > 0) {
			rp.setData(list.get(list.size() - 1));
		}
		return new Gson().toJson(rp);
	}

	@POST
	public String addStation(String request) throws BaseException {
		Station Station = ((new Gson()).fromJson(request, Station.class));
		logger.info("add Station:" + Station);
		Station.setId(null);
		ResponseData rp = new ResponseData();
		Station = StationService.add(Station);
		rp.setStatus("ok");
		rp.setData(Station);
		return new Gson().toJson(rp);
	}

	@Path("/{StationId}/")
	@GET
	public String getStation(@PathParam("StationId") Integer StationId) throws BaseException {
		Station Station = StationService.get(StationId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Station);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateStation(String request) throws BaseException {
		Station Station = ((new Gson()).fromJson(request, Station.class));
		StationService.update(Station);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Station);
		return new Gson().toJson(rp);
	}

	@Path("/del/{StationId}/")
	@GET
	public String deleteStation(@PathParam("StationId") Integer StationId) throws BaseException {
		StationService.delete(StationId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public IStationService getStationService() {
		return StationService;
	}

	public void setStationService(IStationService StationService) {
		this.StationService = StationService;
	}
}
