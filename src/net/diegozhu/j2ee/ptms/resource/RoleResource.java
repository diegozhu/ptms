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
import net.diegozhu.j2ee.ptms.model.Role;
import net.diegozhu.j2ee.ptms.service.IRoleService;
import net.diegozhu.j2ee.ptms.vo.ResponseData;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:role<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/Role")
@Controller
public class RoleResource {

	private static Logger logger = Logger.getLogger(RoleResource.class);

	@Autowired
	private IRoleService RoleService;

	@GET
	public String getAllRole() throws BaseException {
		List<Role> list = RoleService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addRole(String request) throws BaseException {
		Role Role = ((new Gson()).fromJson(request, Role.class));
		logger.info("add Role:" + Role);
		ResponseData rp = new ResponseData();
		Role = RoleService.add(Role);
		rp.setStatus("ok");
		rp.setData(Role);
		return new Gson().toJson(rp);
	}

	@Path("/{RoleId}/")
	@GET
	public String getRole(@PathParam("RoleId") Integer RoleId) throws BaseException {
		Role Role = RoleService.get(RoleId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Role);
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateRole(String request) throws BaseException {
		Role Role = ((new Gson()).fromJson(request, Role.class));
		RoleService.update(Role);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(Role);
		return new Gson().toJson(rp);
	}

	@Path("/del/{RoleId}/")
	@GET
	public String deleteRole(@PathParam("RoleId") Integer RoleId) throws BaseException {
		RoleService.delete(RoleId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	public IRoleService getRoleService() {
		return RoleService;
	}

	public void setRoleService(IRoleService RoleService) {
		this.RoleService = RoleService;
	}
}
