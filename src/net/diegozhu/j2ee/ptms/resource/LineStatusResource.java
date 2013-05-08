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
import net.diegozhu.j2ee.ptms.model.LineStatus;
import net.diegozhu.j2ee.ptms.service.ILineStatusService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:line_status<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/LineStatus")
@Controller
public class LineStatusResource {

	private static Logger logger = Logger.getLogger(LineStatusResource.class);

	@Autowired
	private ILineStatusService LineStatusService;

	@GET
	public String getAllLineStatus() throws BaseException {
		List<LineStatus> list = LineStatusService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addLineStatus(String request) throws BaseException {
		LineStatus LineStatus = ((new Gson()).fromJson(request, LineStatus.class));
		logger.info("add LineStatus:" + LineStatus);
		LineStatus.setId(null);
		ResponseData rp = new ResponseData();
		LineStatus = LineStatusService.add(LineStatus);
		rp.setStatus("ok");
		rp.setData(LineStatus);
		return new Gson().toJson(rp);
	}

	@Path("/{LineStatusId}/")
	@GET
	public String getLineStatus(@PathParam("LineStatusId") Integer LineStatusId) throws BaseException {
		LineStatus LineStatus = LineStatusService.get(LineStatusId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(LineStatus);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateLineStatus(String request) throws BaseException {
		LineStatus LineStatus = ((new Gson()).fromJson(request, LineStatus.class));
		LineStatusService.update(LineStatus);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(LineStatus);
		return new Gson().toJson(rp);
	}

	@Path("/del/{LineStatusId}/")
	@GET
	public String deleteLineStatus(@PathParam("LineStatusId") Integer LineStatusId) throws BaseException {
		LineStatusService.delete(LineStatusId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public ILineStatusService getLineStatusService() {
		return LineStatusService;
	}

	public void setLineStatusService(ILineStatusService LineStatusService) {
		this.LineStatusService = LineStatusService;
	}
}
