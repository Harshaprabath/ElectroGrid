package com.paf_project.ElectroGrid.Business;

import java.util.ArrayList;
import java.util.List;

import com.paf_project.ElectroGrid.Model.User;

import java.sql.*;

public class UserService 
{
			
	Connection con =  null;
	
	public UserService() 
	{
		String url = "jdbc:mysql://localhost:3306/electrogriddb";
		String username = "root";
		String password = "12345";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
		
				

	
	public List<User> getUsers()
	{
		List<User> users = new ArrayList<>();
		String sql = "select * from `electrogriddb`.`user`";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setNic(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setPhone(rs.getInt(5));
				user.setEmail(rs.getString(6));
				user.setEmail(rs.getString(7));
				
				users.add(user);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		return users;
	}	
	
	public User getUser(int userId)
	{				
		String sql = "select * from user where userId = ?";
		
		User user = new User();		
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next())
			{
				
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setNic(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setPhone(rs.getInt(5));
				user.setEmail(rs.getString(6));
				user.setEmail(rs.getString(7));				
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		return user;		
	}

	public void addUser(User user) 
	{
		String sql = "insert into `electrogriddb`.`user` values (?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, user.getUserId());
			st.setString(2, user.getName());
			st.setString(3, user.getNic());
			st.setString(4, user.getAddress());
			st.setInt(5, user.getPhone());
			st.setString(6, user.getPassword());
			st.setString(7, user.getEmail());
			

			st.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void updateUser(User user) 
	{
		String sql = "update `electrogriddb`.`user` set `name` = ?, `nic` = ?, `address` = ?, `phone` = ?, `password` = ?, `email` = ? where (`id` = ?);";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, user.getName());
			st.setString(2, user.getNic());
			st.setString(3, user.getAddress());
			st.setInt(4, user.getPhone());
			st.setString(5, user.getPassword());
			st.setString(6, user.getEmail());
			st.setInt(7, user.getUserId());
			

			st.executeUpdate();			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}




	public String deleteUser(int userId) 
	{
		String sql = "DELETE FROM `electrogriddb`.`user` WHERE (`id` = ?)";
		String response = null;
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, userId);
			st.executeUpdate();	
			
			response = "Successfuly deleted";
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return response;
	}

	
	/*public String deleteUser(int userIid){
		
		String sql = "delete from `electrogriddb`.`user` where (`id` = ?)";
		String response = null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,	userIid);
							
			preparedStatement.executeUpdate();
			response = "Succsessfuly deleted";		
							
		} catch (Exception e) {
			System.out.println(e);
		}
		return response; 
	}	*/
		
	
}
