package com.paf_project.ElectroGrid.Business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.paf_project.ElectroGrid.Calculetions.PowerConsumptionUnitsValue;
import com.paf_project.ElectroGrid.DBcontext.DatabaseConnection;
import com.paf_project.ElectroGrid.DBcontext.IDBContex;
import com.paf_project.ElectroGrid.Model.PowerConsumption;
import com.paf_project.ElectroGrid.Model.UnitValue;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

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
	
	//retrieve all power consumption
	public List<PowerConsumption> getAll(){
			
		List<PowerConsumption> powerConsumptions = new ArrayList<PowerConsumption>();
		
		String sql = "SELECT * FROM powerconsumption";
		
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
					PowerConsumption powerConsumption = new PowerConsumption();
					
					powerConsumption.setId(resultSet.getInt(1));
					powerConsumption.setCustomer_ID(resultSet.getInt(2));
					powerConsumption.setValue(resultSet.getDouble(3));
					powerConsumption.setDate(resultSet.getString(4));
					
					powerConsumptions.add(powerConsumption);
					
				}
				
		} catch (Exception e) {
			
				System.out.println(e);
		}
			
		return powerConsumptions;
	}
	
	// insert power details and calculate current value
	public String addPowerDetails(PowerConsumption powerConsumption) {
		
		PowerConsumptionUnitsValue powerConsumptionUnitsValue = new PowerConsumptionUnitsValue();
		
		String response;
		
		String sql = "insert into powerconsumption value (?,?,?,?)";
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,powerConsumption.getId());
			preparedStatement.setInt(2,powerConsumption.getCustomer_ID());
			preparedStatement.setDouble(3,powerConsumptionUnitsValue.calUnitsValue(powerConsumption.getUnits()));
			preparedStatement.setString(4,java.time.LocalDate.now().toString());
							
			preparedStatement.executeUpdate();
			
			response =  "successfuly inserted\n" 
						+"Custermer ID: "+ powerConsumption.getCustomer_ID()+"\n" 
						+"Current Units Value: "+ powerConsumptionUnitsValue.calUnitsValue(powerConsumption.getUnits())+"\n"
						+"Date: "+ java.time.LocalDate.now().toString()+"\n";
				
		} catch (Exception e) {
			
			response = "error";
			
		}
		
		return response;
	}
	
	//remove power details
	public String deletePowerDetails(int id){
		
		String sql = "DELETE FROM `electrogriddb`.`powerconsumption` WHERE (`id` = ?)";
		
		String response;
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,	id);
							
			preparedStatement.executeUpdate();
			
			response = "Succsessfuly deleted";		
							
		} catch (Exception e) {
			
			response = "error";
			
		}
		
		return response; 
		
	}	
	
	// retrieve unite values and limits  
	public List<UnitValue> getAllUnitValue(){
			
		List<UnitValue> unitValues = new ArrayList<UnitValue>();
		
		String sql = "SELECT * FROM unit_value";
		
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				UnitValue unitValue = new UnitValue();
				
				unitValue.setId(resultSet.getString(1));
				unitValue.setUpper_limit(resultSet.getInt(2));
				unitValue.setLower_limit(resultSet.getInt(3));
				unitValue.setCurrent_price_per_unit(resultSet.getDouble(4));
					
									
				unitValues.add(unitValue);
				
			}
				
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
			
		return unitValues;
		
	}
	
	//edit unite values and limits  
	public String updateUnitValue(UnitValue uv){

		String sql = "UPDATE `electrogriddb`.`unit_value` SET `upper_limit` = ?, `lower_limit` = ?, `current_price_per_unit` = ? WHERE (`id` = ?)";
		
		String response; 
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,uv.getUpper_limit());
			preparedStatement.setInt(2,uv.getLower_limit());
			preparedStatement.setDouble(3,uv.getCurrent_price_per_unit());
			preparedStatement.setString(4,uv.getId());
			
			preparedStatement.executeUpdate();
			
			response = "successfuly update\n" 
						+"ID: "+ uv.getId()+"\n"
						+"Upper Limit: "+ uv.getUpper_limit()+"\n" 
						+"Lower Limit: "+ uv.getLower_limit()+"\n" 
						+"Current Price: "+ uv.getCurrent_price_per_unit()+"\n";
			
		} catch (Exception e) {
			
			response = "error";
		}
		
		
		return response ;
	}
	
	// micro_services user service --> power consumption service
	public List<PowerConsumption> getAllUserPowerConsumption(int id){
				
		List<PowerConsumption> powerConsumptions = new ArrayList<PowerConsumption>();
		
		String sql = "SELECT * FROM powerconsumption WHERE (`customer_ID` = "+id+")";
		
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
					PowerConsumption powerConsumption = new PowerConsumption();
					
					powerConsumption.setId(resultSet.getInt(1));
					powerConsumption.setCustomer_ID(resultSet.getInt(2));
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
