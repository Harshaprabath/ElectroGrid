package com.paf_project.ElectroGrid;


import java.util.Arrays;
import java.util.List;

import com.paf_project.ElectroGrid.Business.UserService;
import com.paf_project.ElectroGrid.Model.User;

import jakarta.validation.constraints.Past;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("user")
public class UserResource {
	  
	
	UserService Uservice = new UserService();
	
	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List <User> getUser()
		{		  		  
		  
		  System.out.println("user called ");		 
		  return Uservice.getUsers();     																																																									  
	    }
	
	@GET
	@Path("getUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id)
	{		  		  
	  		 
	  return Uservice.getUser(id);     																																																									  
    }
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("AddUser")
	public User addUser(User user)
	{		
		 System.out.println(user);
		 Uservice.addUser(user);
		 return user;
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("UpdateUser")
	public User updateUser(User user)
	{		
		 System.out.println(user);
		 if (Uservice.getUser(user.getUserId()).getUserId()==0)
		 {
			 Uservice.addUser(user);
		 }
		 else
		 {
			 Uservice.updateUser(user);
		 }
		 
		 Uservice.updateUser(user);
		 return user;
	}
	
	
}
