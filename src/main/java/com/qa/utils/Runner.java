package com.qa.connecting.utils;

import java.sql.SQLException;

import com.qa.dao.DatabaseConnection;


public class Runner {
	
	public static void main(String[] args) throws SQLException {
		
	
		Ims ims = new Ims();
		ims.start();
	}
		
}
