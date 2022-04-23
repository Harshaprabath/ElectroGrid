package com.paf_project.ElectroGrid.DBcontext;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection implements IDBContex{
	
	private Connection dbContextConnection;
	private final String dbContextDriverName;
	private String dbContextConnectionString;
	private String dbContextUser;
	private String dbContextPassword;
	
	public DatabaseConnection() {
		this.dbContextDriverName = "com.mysql.jdbc.Driver";
		this.dbContextConnectionString = "jdbc:mysql://localhost:3306/electrogriddb";
		this.dbContextUser = "root";
		this.dbContextPassword = "12345";

		}
	
	@Override
	public Connection getDatabaseConnection() {
		try {
			Class.forName(dbContextDriverName);
			dbContextConnection = DriverManager.getConnection(dbContextConnectionString, dbContextUser, dbContextPassword);

			System.out.println("Database Connection Established");

			} catch (Exception e) {
			System.out.println("dbConnectionError: " + e.getMessage());
			}
			return dbContextConnection;
			
	}
		
}
