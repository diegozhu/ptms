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
import net.diegozhu.j2ee.ptms.model.Bus;
import net.diegozhu.j2ee.ptms.model.BusStatus;
import net.diegozhu.j2ee.ptms.model.Events;
import net.diegozhu.j2ee.ptms.service.IBusService;
import net.diegozhu.j2ee.ptms.service.IBusStatusService;
import net.diegozhu.j2ee.ptms.service.IEventsService;
import net.diegozhu.j2ee.ptms.vo.ResponseData;

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

@Path("/Bus")
@Controller
public class BusResource {

	private static Logger logger = Logger.getLogger(BusResource.class);

	@Autowired
	private IBusService BusService;
	@Autowired
	private IEventsService EventsService;
	@Autowired
	private IBusStatusService busStatusService;

	public IBusStatusService getBusStatusService() {
		return busStatusService;
	}

	@GET
	public String getAllBus() throws BaseException {
		List<Bus> list = BusService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@Path("/free/")
	@GET
	public String getFreeBus() throws BaseException {
		List<Bus> list = BusService.getFreeBuses();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addBus(String request) throws BaseException {
		Bus Bus = ((new Gson()).fromJson(request, Bus.class));
		logger.info("add Bus:" + Bus);
		Bus.setId(null);
		ResponseData rp = new ResponseData();
		Bus = BusService.add(Bus);
		rp.setStatus("ok");
		rp.setData(Bus);
		return new Gson().toJson(rp);
	}

	@Path("/{BusId}/")
	@GET
	public String getBus(@PathParam("BusId") Integer BusId) throws BaseException {
		Bus Bus = BusService.get(BusId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Bus);
		return new Gson().toJson(rp);
	}

	@Path("/{BusId}/status")
	@GET
	public String getStatus(@PathParam("BusId") String BusId) throws BaseException {
		List<BusStatus> BusStatus = busStatusService.getByField("busid", BusId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(BusStatus);
		return new Gson().toJson(rp);
	}

	@Path("/{BusId}/events")
	@GET
	public String getEvents(@PathParam("BusId") String BusId) throws BaseException {
		List<Events> Events = EventsService.getByField("busid", BusId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Events);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateBus(String request) throws BaseException {
		Bus Bus = ((new Gson()).fromJson(request, Bus.class));
		BusService.update(Bus);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Bus);
		return new Gson().toJson(rp);
	}

	@Path("/del/{BusId}/")
	@GET
	public String deleteBus(@PathParam("BusId") Integer BusId) throws BaseException {
		BusService.delete(BusId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public IBusService getBusService() {
		return BusService;
	}

	public void setBusStatusService(IBusStatusService busStatusService) {
		this.busStatusService = busStatusService;
	}

	public void setBusService(IBusService BusService) {
		this.BusService = BusService;
	}
}
