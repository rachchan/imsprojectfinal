package com.qa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Driver;
import com.qa.connecting.exceptions.SqlStatementNotUnderstoodException;
import com.qa.utils.Ims;



public class DatabaseConnection {
	
	/**
	 * Connect to Database
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	private String user;
	private String password;
	private Connection connection = null;
	
	public DatabaseConnection(String user, String password) {
		this.setUser(user);
		this.setPassword(password);
	}
	
	private void setUser(String user) {
		this.user = user;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * Get a connection to database
	 * @return Connection object
	 */
	public Connection getConnection() {
		
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/imsdb", user, password);
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
	
	
	public void closeConnection() {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error occured when closing the connection");
			}
	}

	
}


