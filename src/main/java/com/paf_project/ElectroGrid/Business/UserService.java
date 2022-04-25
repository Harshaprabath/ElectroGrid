package com.paf_project.ElectroGrid.Business;

import java.util.ArrayList;
import java.util.List;

import com.paf_project.ElectroGrid.DBcontext.DatabaseConnection;
import com.paf_project.ElectroGrid.DBcontext.IDBContex;
import com.paf_project.ElectroGrid.Model.PowerConsumption;
import com.paf_project.ElectroGrid.ViewModel.ResponseViewModel;
import com.paf_project.ElectroGrid.Model.User;

import java.sql.*;

public class UserService 
{
	private Connection con = null;
	private IDBContex dbContext;
	private Statement statement;
	private ResultSet resultset;
	private static PreparedStatement preparedStatement = null;
			
	
	public UserService()
	{		
		super();
		this.dbContext = new DatabaseConnection();
		this.con = dbContext.getDatabaseConnection();
				
	}
		
			
	//GET ALL USER DETAILS
	public List<User> getUsers()
	
	{
		List<User> users = new ArrayList<>();
		String sql = "select * from `electrogriddb`.`user`";
		
		try		
		{
			statement = con.createStatement();
			resultset = statement.executeQuery(sql);
			
			while(resultset.next())
			{
				User user = new User();
				
				user.setUserId(resultset.getInt(1));
				user.setName(resultset.getString(2));
				user.setNic(resultset.getString(3));
				user.setAddress(resultset.getString(4));
				user.setPhone(resultset.getInt(5));
				user.setPassword(resultset.getString(6));
				user.setEmail(resultset.getString(7));
				
				users.add(user);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		return users;
	}	
	
	
	//GET A SINGLE USER DETAIL
	public User getUser(int userId)
	
	{				
		String sql = "select * from user where Id = "+userId+";";		
		User user = new User();	
		
		try
		{
			statement = con.createStatement();
			resultset = statement.executeQuery(sql);
			
			if (resultset.next())
			{
				user.setUserId(resultset.getInt(1));
				user.setName(resultset.getString(2));
				user.setNic(resultset.getString(3));
				user.setAddress(resultset.getString(4));
				user.setPhone(resultset.getInt(5));
				user.setPassword(resultset.getString(6));
				user.setEmail(resultset.getString(7));					
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		return user;		
	}
	
	
	//ADD A NEW USER
	public ResponseViewModel addUser(User user) 
	{
		String sql = "insert into `electrogriddb`.`user` values (?,?,?,?,?,?,?)";		
		ResponseViewModel response = new ResponseViewModel();
		
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getNic());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setInt(5, user.getPhone());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getEmail());			

			preparedStatement.executeUpdate();
			
			response.isSuccess = true;
			response.message = "User successfully added";
			
			
		}
		catch(Exception e)
		{
			response.isSuccess = false;
			response.message = "An error has been occured. Please try again";
		}
		
		return response;
	}
	
	
	
	//UPDATE USER DETAILS
	public void updateUser(User user) 
	{
		String sql = "update `electrogriddb`.`user` set `name` = ?, `nic` = ?, `address` = ?, `phone` = ?, `password` = ?, `email` = ? where (`id` = ?);";
				
		try
		{
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getNic());
			statement.setString(3, user.getAddress());
			statement.setInt(4, user.getPhone());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmail());
			statement.setInt(7, user.getUserId());			

			statement.executeUpdate();			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}



	//DELETE A USER
	public ResponseViewModel deleteUser(int userId) 
	{
		String sql = "DELETE FROM `electrogriddb`.`user` WHERE (`id` = ?)";		
		ResponseViewModel response = new ResponseViewModel();
		
		try
		{
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, userId);
			statement.executeUpdate();	
			
			response.isSuccess= true;
			response.message = "Successfuly deleted";
			
		}
		catch(Exception e)
		{
			response.isSuccess= false;
			response.message = "An error has been occured. Please try again";		
		}
		
		return response;
	}

		
	
	//MICROSERVICE USER SERVICE --> POWER CONSUMPTION SERVICE
	public ArrayList<String> getAllUserPowerConsumption(int userId) {
		
		ArrayList<String> response = new ArrayList<String>() ;
		
		//POWER CONSUMPTION SERVICE USE 
		PowerconsumptioneService powerconsumptioneService = new PowerconsumptioneService();
		
		List<PowerConsumption> powerConsumptions = powerconsumptioneService.getAllUserPowerConsumption(userId);
		
		if(powerConsumptions != null) {
			
			for (int counter = 0; counter < powerConsumptions.size(); counter++)
			{
			           response.add("Customer Name: "+getUserName(userId)+" " 
			        		   	  +"Customer ID: "+ powerConsumptions.get(counter).getCustomer_ID()+" "
					              +"Value: "+ powerConsumptions.get(counter).getValue()+" " 
					              +"Date: "+ powerConsumptions.get(counter).getDate()+" "); 
			}
		}
		
		else 
		{			
			response.add("Customer Name: "+getUserName(userId)+" " + "No such a record ");
		}
				
		return response;		
	}
	
	
	public String getUserName(int userId) 
	{		
		String response = null ;		
		String sql = " SELECT * FROM `electrogriddb`.`user` WHERE (`id` = "+userId+");";
		
		try
		{
			Statement statement = con.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			
			while(resultset.next())
			{
				response = resultset.getString(2);				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		return response;
	}
		
}


