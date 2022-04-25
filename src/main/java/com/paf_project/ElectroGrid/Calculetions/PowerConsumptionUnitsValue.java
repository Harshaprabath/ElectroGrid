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
	
	
	public PowerConsumptionUnitsValue() {
		super();
		
		this.dbContext  = new DatabaseConnection();
		this.connection = dbContext.getDatabaseConnection();
		
	}
	
	//get limits and per units value
    public ArrayList<Double> getLimitsValue() {
    	
    	ArrayList<Double> calDetails = new ArrayList<Double>();
		
    	//quarry
    	String sql = "SELECT * FROM unit_value";
		
    	try {
			
		    statement = connection.createStatement();
		    resultSet = statement.executeQuery(sql);
		    
			while (resultSet.next()) {
				
				//upper limit
				calDetails.add((double) resultSet.getInt(2));
				
				//lower limit
				calDetails.add((double)resultSet.getInt(3));
				
				//current unit price
				calDetails.add(resultSet.getDouble(4));
					
			}
				
		} catch (Exception e) {
			
				System.out.println(e);
		}
			
		return calDetails;
		
	}
    
    //calculate current price
	public double calUnitsValue(int units) {
		
		ArrayList<Double> unitsDetails = getLimitsValue();
		
		double remender = units - unitsDetails.get(0);
		double unitsValue ;
		
		if(remender > 0) {
			
			unitsValue = (unitsDetails.get(0)* unitsDetails.get(2)) + (remender *unitsDetails.get(5));
			
		}else {
			
			unitsValue = (unitsDetails.get(0)* unitsDetails.get(2));
		}
		
		return unitsValue;
	}

}
