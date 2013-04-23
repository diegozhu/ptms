package net.diegozhu.j2ee.ptms.resource;

import java.util.List;  
  
 
import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;  
  
import net.diegozhu.j2ee.ptms.service.IUserService;
import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.model.User;
import org.apache.log4j.Logger;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
  
import com.google.gson.Gson;  
import com.sun.jersey.spi.resource.Singleton;  
  
@Path("/user")
@Singleton
@Controller

public class UserResource {  
  
    private static Logger logger = Logger.getLogger(UserResource.class);  
    
    @Autowired  
    private IUserService userService;  
    
    @Path("/get")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser() {  
        List<User> list = null;  
        String str = null;  
        try {  
            list = userService.loadAll(); 
            if(null != list){
            	str = new Gson().toJson(list); 
            }             
        } catch (Exception e) {  
            logger.error("get exception : ", e);  
        }  
        return str;  
    }

    @Path("/post")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String putUser() { 
    	
    	String result ="";
        User user = new User();
        user.setName("asdfa");
        try {
	        userService.add(user);
	        result = "asdfasf";
        } catch (BaseException e) {
	        e.printStackTrace();
        }
        return result;  
    }
    
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}  
}  
