package com.qa.utils;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.dao.DatabaseConnection;


public class Runner {
	
	public static final Logger LOGGER = Logger.getLogger(Runner.class);
	

	public static void main(String[] args) throws SQLException {
		Factory fact = Factory.getFactory();
		
		DatabaseConnection databaseConnection = fact.getDB();
		databaseConnection.getConnection();
		
		Ims ims = new Ims(databaseConnection);
		ims.start();
	}
		
}
