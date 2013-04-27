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
import net.diegozhu.j2ee.ptms.model.User;
import net.diegozhu.j2ee.ptms.service.IUserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * <br>
 * table:user<br>
 * 
 * @author diego zhu
 * @version 1.0
 */

@Path("/user")
@Controller
public class UserResource {

	private static Logger logger = Logger.getLogger(UserResource.class);

	@Autowired
	private IUserService UserService;

	@GET
	public String getAllUser() throws BaseException {
		List<User> list = UserService.loadAll();
		return new Gson().toJson(list);
	}

	@POST
	public String addUser(String request) throws BaseException {
		User User = ((new Gson()).fromJson(request, User.class));
		User = UserService.add(User);
		logger.info("add User:" + User);
		return new Gson().toJson(User);
	}

	@Path("/{UserId}/")
	@GET
	public String getUser(@PathParam("UserId") Integer UserId) throws BaseException {
		return new Gson().toJson(UserService.get(UserId));
	}

	@Path("/{UserId}/")
	@PUT
	public String updateUser(String request) throws BaseException {
		User User = ((new Gson()).fromJson(request, User.class));
		UserService.update(User);
		return "{ \"status\" : \"OK\" }";
	}

	@Path("/{UserId}/")
	@DELETE
	public String deleteUser(@PathParam("UserId") Integer UserId) throws BaseException {
		UserService.delete(UserId);
		return "{ \"status\" : \"OK\" }";
	}

	public IUserService getUserService() {
		return UserService;
	}

	public void setUserService(IUserService UserService) {
		this.UserService = UserService;
	}
}
