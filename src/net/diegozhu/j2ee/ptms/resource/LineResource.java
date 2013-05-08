/*
 * ptms
 * Copyright (c) 2013 diegozhu All Rights Reserved.
 */
package net.diegozhu.j2ee.ptms.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.Bus;
import net.diegozhu.j2ee.ptms.model.Line;
import net.diegozhu.j2ee.ptms.model.LineStation;
import net.diegozhu.j2ee.ptms.model.Station;
import net.diegozhu.j2ee.ptms.service.IBusService;
import net.diegozhu.j2ee.ptms.service.ILineService;
import net.diegozhu.j2ee.ptms.service.ILineStationService;
import net.diegozhu.j2ee.ptms.service.IStationService;
import net.diegozhu.j2ee.ptms.vo.ResponseData;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:line<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/Line")
@Controller
public class LineResource {

	private static Logger logger = Logger.getLogger(LineResource.class);

	@Autowired
	private ILineService LineService;
	@Autowired
	private ILineStationService lineStationService;

	@Autowired
	private IStationService stationService;

	@Autowired
	private IBusService busService;

	public IBusService getBusService() {
		return busService;
	}

	public void setBusService(IBusService busService) {
		this.busService = busService;
	}

	@GET
	public String getAllLine() throws BaseException {
		List<Line> list = LineService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addLine(String request) throws BaseException {
		Line Line = ((new Gson()).fromJson(request, Line.class));
		logger.info("add Line:" + Line);
		Line.setId(null);
		ResponseData rp = new ResponseData();
		Line = LineService.add(Line);
		rp.setStatus("ok");
		rp.setData(Line);
		return new Gson().toJson(rp);
	}

	@Path("/{LineId}/")
	@GET
	public String getLine(@PathParam("LineId") Integer LineId) throws BaseException {
		Line Line = LineService.get(LineId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Line);
		return new Gson().toJson(rp);
	}

	@Path("/{LineId}/bus")
	@GET
	public String getBuses(@PathParam("LineId") String LineId) throws BaseException {
		List<Bus> list = busService.getByField("lineid", LineId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@Path("{lineId}/station/add/{stationid}")
	@GET
	public String addStation(@PathParam("lineId") Integer LineId, @PathParam("stationid") Integer stationid) throws BaseException {

		LineStation lineStation = new LineStation();

		lineStation.setLine(LineService.get(LineId));
		lineStation.setStation(stationService.get(stationid));
		lineStation.setName(" ");
		lineStation.setCreatetime((new Date()).toString());
		lineStation.setDescription(" ");

		lineStationService.add(lineStation);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(" ");
		return new Gson().toJson(rp);
	}

	@Path("{lineId}/station/del/{stationid}")
	@GET
	public String delStation(@PathParam("lineId") String LineId, @PathParam("stationid") String stationid) throws BaseException {

		Map<String, String> queryFilter = new HashMap<String, String>();

		queryFilter.put("LineId", LineId);
		queryFilter.put("stationid", stationid);

		LineStation lineStation = lineStationService.getByFields(queryFilter).get(0);

		lineStationService.delete(lineStation);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(" ");
		return new Gson().toJson(rp);
	}

	@Path("{lineId}/bus/add/{busid}")
	@GET
	public String addBus(@PathParam("lineId") Integer LineId, @PathParam("busid") Integer busid) throws BaseException {

		Bus bus = busService.get(busid);
		Line line = LineService.get(LineId);
		bus.setLine(line);

		busService.update(bus);

		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(" ");
		return new Gson().toJson(rp);
	}

	@Path("{lineId}/bus/del/{busid}")
	@GET
	public String delBus(@PathParam("lineId") Integer LineId, @PathParam("busid") Integer busid) throws BaseException {

		Bus bus = busService.get(busid);

		bus.setLine(null);

		busService.update(bus);

		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(" ");
		return new Gson().toJson(rp);
	}

	@Path("/{LineId}/station")
	@GET
	public String getStations(@PathParam("LineId") String LineId) throws BaseException {
		List<LineStation> list = lineStationService.getByField("LineId", LineId);
		List<Station> stations = new ArrayList<Station>();
		for (LineStation lineStation : list) {
			stations.add(lineStation.getStation());
		}
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(stations);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateLine(String request) throws BaseException {
		Line Line = ((new Gson()).fromJson(request, Line.class));
		LineService.update(Line);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Line);
		return new Gson().toJson(rp);
	}

	@Path("/del/{LineId}/")
	@GET
	public String deleteLine(@PathParam("LineId") Integer LineId) throws BaseException {
		LineService.delete(LineId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public ILineService getLineService() {
		return LineService;
	}

	public void setLineService(ILineService LineService) {
		this.LineService = LineService;
	}
}
