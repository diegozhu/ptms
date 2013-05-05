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
import net.diegozhu.j2ee.ptms.model.BusLine;
import net.diegozhu.j2ee.ptms.service.IBusLineService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:bus_line<br>
 * @author diego zhu
 * @version 1.0
 */

@Path("/BusLine")
@Controller
public class BusLineResource {

	private static Logger logger = Logger.getLogger(BusLineResource.class);

	@Autowired
	private IBusLineService BusLineService;

	@GET
	public String getAllBusLine() throws BaseException {
		List<BusLine> list = BusLineService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addBusLine(String request) throws BaseException {
		BusLine BusLine = ((new Gson()).fromJson(request, BusLine.class));
		logger.info("add BusLine:" + BusLine);
		ResponseData rp = new ResponseData();
		BusLine = BusLineService.add(BusLine);
		rp.setStatus("ok");
		rp.setData(BusLine);
		return new Gson().toJson(rp);
	}

	@Path("/{BusLineId}/")
	@GET
	public String getBusLine(@PathParam("BusLineId") Integer BusLineId) throws BaseException {
		BusLine BusLine = BusLineService.get(BusLineId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(BusLine);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateBusLine(String request) throws BaseException {
		BusLine BusLine = ((new Gson()).fromJson(request, BusLine.class));
		BusLineService.update(BusLine);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(BusLine);
		return new Gson().toJson(rp);
	}

	@Path("/del/{BusLineId}/")
	@GET
	public String deleteBusLine(@PathParam("BusLineId") Integer BusLineId) throws BaseException {
		BusLineService.delete(BusLineId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public IBusLineService getBusLineService() {
		return BusLineService;
	}

	public void setBusLineService(IBusLineService BusLineService) {
		this.BusLineService = BusLineService;
	}
}
