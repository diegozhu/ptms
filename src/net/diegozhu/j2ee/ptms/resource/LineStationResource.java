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
import net.diegozhu.j2ee.ptms.model.LineStation;
import net.diegozhu.j2ee.ptms.service.ILineStationService;
import net.diegozhu.j2ee.ptms.vo.ResponseData;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:line_station<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/LineStation")
@Controller
public class LineStationResource {

	private static Logger logger = Logger.getLogger(LineStationResource.class);

	@Autowired
	private ILineStationService LineStationService;

	@GET
	public String getAllLineStation() throws BaseException {
		List<LineStation> list = LineStationService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addLineStation(String request) throws BaseException {
		LineStation LineStation = ((new Gson()).fromJson(request, LineStation.class));
		logger.info("add LineStation:" + LineStation);
		LineStation.setId(null);
		ResponseData rp = new ResponseData();
		LineStation = LineStationService.add(LineStation);
		rp.setStatus("ok");
		rp.setData(LineStation);
		return new Gson().toJson(rp);
	}

	@Path("/{LineStationId}/")
	@GET
	public String getLineStation(@PathParam("LineStationId") Integer LineStationId) throws BaseException {
		LineStation LineStation = LineStationService.get(LineStationId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(LineStation);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateLineStation(String request) throws BaseException {
		LineStation LineStation = ((new Gson()).fromJson(request, LineStation.class));
		LineStationService.update(LineStation);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(LineStation);
		return new Gson().toJson(rp);
	}

	@Path("/del/{LineStationId}/")
	@GET
	public String deleteLineStation(@PathParam("LineStationId") Integer LineStationId) throws BaseException {
		LineStationService.delete(LineStationId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public ILineStationService getLineStationService() {
		return LineStationService;
	}

	public void setLineStationService(ILineStationService LineStationService) {
		this.LineStationService = LineStationService;
	}
}
