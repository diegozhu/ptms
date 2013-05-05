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
import net.diegozhu.j2ee.ptms.model.Line;
import net.diegozhu.j2ee.ptms.service.ILineService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:line<br>
 * @author diego zhu
 * @version 1.0
 */

@Path("/Line")
@Controller
public class LineResource {

	private static Logger logger = Logger.getLogger(LineResource.class);

	@Autowired
	private ILineService LineService;

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
