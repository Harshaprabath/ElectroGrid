package com.paf_project.ElectroGrid;


import java.util.Arrays;
import java.util.List;

import com.paf_project.ElectroGrid.Model.User;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("user")
public class UserResource {
	  
		@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List <User> getUser() 
		{		  		  
		  User user = new User();
		  user.setUserId("1");
		  user.setName("Amal");
		  user.setNic("123");
		  user.setAddress("Malabe");
		  user.setPhone(1234);
		  user.setEmail("amal@gmail.com");
		  user.setPassword("123");
		  
		  User user1 = new User();
		  user1.setUserId("2");
		  user1.setName("Kamal");
		  user1.setNic("321");
		  user1.setAddress("Kaduwela");
		  user1.setPhone(4321);
		  user1.setEmail("kamal@gmail.com");
		  user1.setPassword("321");
		  
		  
		  List <User> users = Arrays.asList(user,user1);
		  
		  return users;       
	    }
	
}
