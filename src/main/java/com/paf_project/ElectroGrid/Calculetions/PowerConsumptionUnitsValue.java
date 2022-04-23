package com.paf_project.ElectroGrid.Calculetions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.paf_project.ElectroGrid.DBcontext.DatabaseConnection;
import com.paf_project.ElectroGrid.DBcontext.IDBContex;
import com.paf_project.ElectroGrid.Model.PowerConsumption;
import com.paf_project.ElectroGrid.Model.UnitValue;

public class PowerConsumptionUnitsValue {
	
	private Connection connection = null;
	private IDBContex dbContext;
	private Statement statement;
	private ResultSet resultSet;
	private static PreparedStatement preparedStatement = null;
	
	public PowerConsumptionUnitsValue() {
		super();
		this.dbContext = new DatabaseConnection();
		this.connection = dbContext.getDatabaseConnection();
		
	}
	
    public ArrayList<Double> getLimitsValue() {
    	
    	ArrayList<Double> calDetails = new ArrayList<Double>();
		String sql = "SELECT * FROM unit_value";
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				
				//upper
				calDetails.add((double) resultSet.getInt(2));
				//lower
				calDetails.add((double)resultSet.getInt(3));
				//current unit price
				calDetails.add(resultSet.getDouble(4));
					
			}
				
		} catch (Exception e) {
				System.out.println(e);
		}
			
		return calDetails;
		
	}
    
	
	public double calUnitsValue(int units) {
		
		ArrayList<Double> calDetails = getLimitsValue();
		double index= units - calDetails.get(0);
		double unitsValue ;
		if(index > 0) {
			unitsValue = (calDetails.get(0)* calDetails.get(2)) + (index *calDetails.get(5));
			
		}else {
			unitsValue = (calDetails.get(0)* calDetails.get(2));
		}
		
		return unitsValue;
	}

}
