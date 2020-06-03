package com.qa.connecting.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.qa.connecting.exceptions.ConnectionNotMadeException;

public class RemoteDatabaseConnection extends DatabaseConnection {


	public RemoteDatabaseConnection(String user, String password) {
		super(user, password);
	}
	
	public void openConnection() {
		try {
			setConnection(DriverManager.getConnection("jdbc:mysql://35.246.104.154:3306/gamedb?serverTimezone=BST", getUsername(), getPassword()));;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConnectionNotMadeException("Remote database is not accessible: " + e.getMessage());

		}		
	}

}
