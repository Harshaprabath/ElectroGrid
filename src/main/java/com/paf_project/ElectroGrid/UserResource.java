package com.paf_project.ElectroGrid;

import com.paf_project.ElectroGrid.Model.User;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("user")
public class UserResource {
	  
		@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public User getUser() {
		  		  
		  User user = new User();
		  user.setUserId("1");
		  user.setName("Amal");
		  user.setNic("123");
		  user.setAddress("Malabe");
		  user.setPhone(1234);
		  user.setEmail("amal@gmail.com");
		  user.setPassword("123");
		  return user;
	        
	    }
	
}
