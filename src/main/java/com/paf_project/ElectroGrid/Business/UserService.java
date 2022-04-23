package com.paf_project.ElectroGrid.Business;

import java.util.ArrayList;
import java.util.List;

import com.paf_project.ElectroGrid.Model.User;

public class UserService 
{
	
	List<User> users;
	
	public UserService() {
		
		users = new ArrayList<>();
		
		User user = new User();
		  user.setUserId(1);
		  user.setName("Amal");
		  user.setNic("123");
		  user.setAddress("Malabe");
		  user.setPhone(1234);
		  user.setEmail("amal@gmail.com");
		  user.setPassword("123");
		  
		  User user1 = new User();
		  user1.setUserId(2);
		  user1.setName("Kamal");
		  user1.setNic("321");
		  user1.setAddress("Kaduwela");
		  user1.setPhone(4321);
		  user1.setEmail("kamal@gmail.com");
		  user1.setPassword("321");
		  
		  users.add(user);
		  users.add(user1);
		
	}
	
	public List<User> getUsers()
	{
		return users;
	}	
	
	public User getUser(int userId)
	{				
		for (User user : users)
		{
			if (user.getUserId()==userId)
				return user;
		}
		
		return new User();		
	}

	public void addUser(User user) {
		
		users.add(user);
	}

	
	
}
