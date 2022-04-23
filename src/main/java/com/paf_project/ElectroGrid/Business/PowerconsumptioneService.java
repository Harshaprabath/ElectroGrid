package com.paf_project.ElectroGrid.Business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.paf_project.ElectroGrid.DBcontext.DatabaseConnection;
import com.paf_project.ElectroGrid.DBcontext.IDBContex;
import com.paf_project.ElectroGrid.Model.PowerConsumption;

public class PowerconsumptioneService {
	
	private Connection connection = null;
	private IDBContex dbContext;
	private Statement statement;
	private ResultSet resultSet;
	private static PreparedStatement preparedStatement = null;
	
	public PowerconsumptioneService() {
		super();
		this.dbContext = new DatabaseConnection();
		this.connection = dbContext.getDatabaseConnection();
		
	}
	
	//get all users from the database
		public List<PowerConsumption> getAll(){
			
			List<PowerConsumption> powerConsumptions = new ArrayList<PowerConsumption>();
			String sql = "SELECT * FROM powerconsumption";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					PowerConsumption powerConsumption = new PowerConsumption();
					powerConsumption.setId(resultSet.getString(1));
					powerConsumption.setCustomer_ID(resultSet.getString(2));
					powerConsumption.setValue(resultSet.getDouble(3));
					powerConsumption.setDate(resultSet.getString(4));
					
									
					powerConsumptions.add(powerConsumption);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return powerConsumptions;
		}
	
}
