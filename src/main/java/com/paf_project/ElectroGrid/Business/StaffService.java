package com.paf_project.ElectroGrid.Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.paf_project.ElectroGrid.Model.Staff;

public class StaffService 
{
	
		
		Connection con =  null;
		
		public StaffService() 
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
			
					

		
		public List<Staff> getStaffs()
		{
			List<Staff> staffs = new ArrayList<>();
			String sql = "select * from staff";
			try
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					Staff staff = new Staff();
					staff.setID(rs.getInt(1));
					staff.setCustomerName(rs.getString(2));
					staff.setCustomerID(rs.getString(3));
					staff.setStaffName(rs.getString(4));
					staff.setStaffID(rs.getInt(5));
					staff.setAssignWork(rs.getString(6));
					staff.setMobile(rs.getString(7));
					
					staffs.add(staff);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
					
			return staffs;
		}	
		
		public Staff getStaff(int ID)
		{				
			String sql = "select * from staff where ID ="+ID;
			
			Staff staff = new Staff();		
			try
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next())
				{
					
					staff.setID(rs.getInt(1));
					staff.setCustomerName(rs.getString(2));
					staff.setCustomerID(rs.getString(3));
					staff.setStaffName(rs.getString(4));
					staff.setStaffID(rs.getInt(5));
					staff.setAssignWork(rs.getString(6));
					staff.setMobile(rs.getString(7));				
					
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
					
			return staff;		
		}

		public void addStaff(Staff staff) 
		{
			String sql = "insert into staff values (?,?,?,?,?,?,?)";
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, staff.getID());
				st.setString(2, staff.getCustomerName());
				st.setString(3, staff.getCustomerID());
				st.setString(4, staff.getStaffName());
				st.setInt(5, staff.getStaffID());
				st.setString(6, staff.getAssignWork());
				st.setString(7, staff.getMobile());
				

				st.executeUpdate();
				
				
			}
			catch(Exception e)
			{
				System.out.println("error : " + e);
			}
		}
		
		public String updateStaff (Staff staff) 
		{
			String r = null;
			//String sql = "update staff set ID=?, CustomerName=?, CustomerID=?, StaffName=?, StaffID=?, AssignWork=?, Mobile=?" ;
			String sql = "update `electrogriddb`.`staff` set `CutomerName` = ?, `CustomerID` = ?, `StaffName` = ?, `StaffID` = ?, `AssignWork` = ? , `Mobile` = ? where (`id` = ?)";
			try
			{
				
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, staff.getCustomerName());
				st.setString(2, staff.getCustomerID());
				st.setString(3, staff.getStaffName());
				st.setInt(4, staff.getStaffID());
				st.setString(5, staff.getAssignWork());
				st.setString(6, staff.getMobile());
				st.setInt(7, staff.getID());

				st.executeUpdate();
				
				
				r = "Done!";
			}
			catch (Exception e)		
			{
				System.out.println(e);
			}
			return r;
		}

		public String deleteStaff(int id){
			
//			String sql = "DELETE FROM `electrogriddb`.`staff` WHERE id=`1`";
			String sql = "delete from staff where ID=?";
			String response = null;
			try {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setInt(1,	id);
								
				preparedStatement.executeUpdate();
				
				response = "Succsessfuly deleted";		
								
			} catch (Exception e) {
				System.out.println(e);
				response = "Something went wrong";
			}
			return response; 
		}	
		
		
		
	}



