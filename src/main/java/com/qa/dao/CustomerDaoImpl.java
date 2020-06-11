package com.qa.dao;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.qa.dto.Customers;

import java.sql.Statement;
import java.sql.PreparedStatement;




public class CustomerDaoImpl implements CustomerDao { 
	

	private static final String INSERT_CUSTOMERS = "INSERT INTO customers " + "(LastName, FirstName, Address) VALUES " + "(?,?,?);";
	private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customers";
	private static final String UPDATE_CUSTOMER = "UPDATE customers SET Address = ? WHERE CustomerID = ?";
	private static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE CustomerID = ?";
	private DatabaseConnection connection;

	Statement statement = null;
	ResultSet resultSet = null;
	
	public CustomerDaoImpl(DatabaseConnection databaseConnection) {
		this.setDatabaseConnection(databaseConnection);
	}
	
	
	@Override
	public void create(Customers customers)  {
		try {
			
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(INSERT_CUSTOMERS);
			preparedStatement.setString(1, customers.getLastName());
			preparedStatement.setString(2, customers.getFirstName());
			preparedStatement.setString(3, customers.getAddress());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Could not execute Statement");
		}		
	}
				
	
	@Override
	public void update(Customers customers) {
		
		try {
			
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(UPDATE_CUSTOMER);
			preparedStatement.setString(1, customers.getAddress());
			preparedStatement.setInt(2, customers.getCustomerID());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Could not execute Statement");
		}
	
	}
	


	@Override
	public List<Customers> selectAll() {
		List<Customers> customers = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECT_ALL_CUSTOMERS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int CustomerID = resultSet.getInt("CustomerID");
				String lastName = resultSet.getString("LastName");
				String firstName = resultSet.getString("FirstName");
				String address = resultSet.getString("Address");
				
				customers.add(new Customers(CustomerID, lastName, firstName, address));
				
			}
		} catch (Exception e) {
			System.out.println("Could not execute statement");
		}
		return customers;
	}


	@Override
	public void delete(int CustomerID)  {
	
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(DELETE_CUSTOMER);
			preparedStatement.setInt(1, CustomerID);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
		
			System.out.println("Could not execute statement");
		}
	
	}


	public DatabaseConnection getDatabaseConnection() {
		return connection;
	}


	public void setDatabaseConnection(DatabaseConnection databaseConnection) {
		this.connection = databaseConnection;
	}
}


	





