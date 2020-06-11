package com.qa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
import com.qa.connecting.exceptions.SqlStatementNotUnderstoodException;



public class DatabaseConnection {
	
	/**
	 * Connect to Database
	 * 
	 */
	private static Connection connection;
	
	private static final String URL = "jdbc:mysql://127.0.0.1/imsdb";
	
	private static final String USER = "user";
	
	private static final String PASS = "youshallnotpass";
	
	/**
	 * Get a connection to database
	 * @return Connection object
	 */
	public static Connection getConnection() {
		
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}
	
	public ResultSet sendQuery(String sql) {
		try {
			Statement statement = connection.createStatement();			
			ResultSet resultSet = statement.executeQuery(sql);
			statement.close();
			return resultSet;
		} catch (SQLException e) {
			throw new SqlStatementNotUnderstoodException("Could not query with " + sql);
		}
	}

	public void sendUpdate(String sql) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SqlStatementNotUnderstoodException("Could not query with " + sql);
		}
	}
	
	
	public static void closeConnection() {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error occured when closing the connection");
			}
	}
	
	
}


