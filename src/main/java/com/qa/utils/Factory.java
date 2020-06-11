package com.qa.utils;



import com.qa.dao.DatabaseConnection;

public class Factory {

	DatabaseConnection DB = null;
	static Factory factory = null;
	
	private Factory() {
		
	}
	
	public static Factory getFactory() {
		if (factory == null) {
			factory = new Factory();
		}
		return factory;
	}
	
	public DatabaseConnection getDB() {
		if (DB == null) {

			System.out.println("Database Username: ");
			String user = Input.getInput();
			System.out.println("Database Password: ");
			String password = Input.getInput();
			
			DB = new DatabaseConnection(user, password);
		} 
		return DB;
	}

	
	
}
