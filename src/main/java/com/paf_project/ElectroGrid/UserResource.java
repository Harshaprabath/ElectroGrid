package com.paf_project.ElectroGrid;

import java.util.List;

import com.paf_project.ElectroGrid.Business.UserService;
import com.paf_project.ElectroGrid.ViewModel.ResponseViewModel;
import com.paf_project.ElectroGrid.Model.User;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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
	@Path("getUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userId") int userId)
	{		  		  
	 	  return Uservice.getUser(userId);     																																																									  
    }
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("addUser")
	public ResponseViewModel addUser(User user)
	{		
		 return Uservice.addUser(user);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("updateUser")
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
		
	
	@DELETE
	@Path("deleteUser/{userId}")
	public ResponseViewModel deleteUser(@PathParam("userId")int userId)
	{		
		return Uservice.deleteUser(userId);			
	}
	
	
	 @GET
	 @Path("userpowerconsumption/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<String> getAllUserPowerConsumption(@PathParam("id")int userid)
	 {
		return Uservice.getAllUserPowerConsumption(userid);		 
     }
	
}
