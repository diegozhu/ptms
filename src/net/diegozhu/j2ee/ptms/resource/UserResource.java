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
import net.diegozhu.j2ee.ptms.model.Events;
import net.diegozhu.j2ee.ptms.model.User;
import net.diegozhu.j2ee.ptms.service.IEventsService;
import net.diegozhu.j2ee.ptms.service.IUserService;
import net.diegozhu.j2ee.ptms.vo.ResponseData;

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

@Path("/User")
@Controller
public class UserResource {

	private static Logger logger = Logger.getLogger(UserResource.class);

	@Autowired
	private IUserService UserService;
	@Autowired
	private IEventsService eventsService;

	public IEventsService getEventsService() {
		return eventsService;
	}

	public void setEventsService(IEventsService eventsService) {
		this.eventsService = eventsService;
	}

	@GET
	public String getAllUser() throws BaseException {
		List<User> list = UserService.loadAll();
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	@POST
	public String addUser(String request) throws BaseException {
		User User = ((new Gson()).fromJson(request, User.class));
		ResponseData rp = new ResponseData();
		String name = User.getName();
		if (name == null || name == "") {
			rp.setStatus("error");
			rp.setCode(300);
			return new Gson().toJson(rp);
		}
		if (name.length() > 45) {
			rp.setStatus("error");
			rp.setCode(301);
			return new Gson().toJson(rp);
		}

		if (name.length() < 2) {
			rp.setStatus("error");
			rp.setCode(302);
			return new Gson().toJson(rp);
		}
		User.setId(null);
		logger.info("add User:" + User);

		User = UserService.add(User);
		rp.setStatus("ok");
		rp.setData(User);
		return new Gson().toJson(rp);
	}

	@Path("/{UserId}/")
	@GET
	public String getUser(@PathParam("UserId") Integer UserId) throws BaseException {
		User User = UserService.get(UserId);
		ResponseData rp = new ResponseData();
		if (User == null) {
			rp.setStatus("error");
			rp.setCode(303);
		} else {
			rp.setStatus("ok");
			rp.setData(User);
		}
		return new Gson().toJson(rp);
	}

	@PUT
	public String updateUser(String request) throws BaseException {
		User User = ((new Gson()).fromJson(request, User.class));
		UserService.update(User);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(User);
		return new Gson().toJson(rp);
	}

	@Path("/del/{UserId}/")
	@GET
	public String deleteUser(@PathParam("UserId") Integer UserId) throws BaseException {
		UserService.delete(UserId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		return new Gson().toJson(rp);
	}

	@Path("{userId}/events/")
	@GET
	public String getEvents(@PathParam("userId") String UserId) throws BaseException {
		List<Events> list = eventsService.getByField("userid", UserId);
		ResponseData rp = new ResponseData();
		rp.setStatus("ok");
		rp.setData(list);
		return new Gson().toJson(rp);
	}

	public IUserService getUserService() {
		return UserService;
	}

	public void setUserService(IUserService UserService) {
		this.UserService = UserService;
	}
}
