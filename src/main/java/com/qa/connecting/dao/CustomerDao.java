package com.qa.connecting.dao;

import com.qa.connecting.model.Customer;

public class CustomerDao {

	private DatabaseConnection databaseConnection;

	public CustomerDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertCustomer(Customer customer) {
		String sql = "insert into customer(name, email, address) values ('" + customer.getName() + "', '"
				+ customer.getEmail() + "', '" + customer.getAddress() + "');";

		databaseConnection.sendUpdate(sql);
	}

}
