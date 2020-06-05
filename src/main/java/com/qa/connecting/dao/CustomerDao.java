package com.qa.connecting.dao;

import com.qa.connecting.model.Customers;

public class CustomerDao {

	private DatabaseConnection databaseConnection;

	public CustomerDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertCustomers(Customers customers) {
		String sql = "insert into customer(last name, firstname, address) values ('" + customers.getLastName() + "', '"
				+ customers.getFirstName() + "', '" + customers.getAddress() + "');";

		databaseConnection.sendUpdate(sql);
	}

}
