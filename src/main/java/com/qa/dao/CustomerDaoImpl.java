package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.qa.dto.Customers;




public class CustomerDaoImpl implements CustomerDao { 
	

	private static final String INSERT_CUSTOMERS = "INSERT INTO customers " + "(name) VALUES " + "(?);";
	private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customers";
	private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customers";
	private static final String UPDATE_CUSTOMER = "UPDATE customers SET FirstName = ? WHERE CustomerID = ?";
	private static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE CustomerID = ?";
	

	@Override
	public int create(Customers customers) throws SQLException {
		int rowInserted = 0;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, customers.getLastName());
			preparedStatement.setString(2, customers.getFirstName());
			preparedStatement.setString(3, customers.getAddress());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				rowInserted = resultSet.getInt(1);
				rowInserted = resultSet.getInt(2);
				rowInserted = resultSet.getInt(3);
			}
		} catch (Exception e) {
			System.out.println("Could not execute Statement");
		}
		return rowInserted;		
		}
				
	
	@Override
	public boolean update(Customers customers) throws SQLException {
		boolean rowUpdated = false;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
			preparedStatement.setString(1, customers.getLastName());
			preparedStatement.setInt(2, customers.getCustomerID());
			
			rowUpdated = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Could not execute Statement");
		}
		return rowUpdated;
	}
	

	@Override
	public Customers select(int id) {
		Customers customers = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String lastName = resultSet.getString("LastName");
				String firstName = resultSet.getString("FirstName");
				String address = resultSet.getString("Address");
				int customerId = resultSet.getInt("CustomerID");
				customers = new Customers(customerId, lastName, firstName, address);
			}
		} catch (Exception e) {
			System.out.println("Could not execute statement");
		} return customers;
	}


	@Override
	public List<Customers> selectAll() throws SQLException {
		List<Customers> customers = new ArrayList<>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("CustomerID");
				String firstName = resultSet.getString("FirstName");
				String lastName = resultSet.getString("LastName");
				String address = resultSet.getString("Address");
				customers.add(new Customers(id, lastName, firstName, address));
			}
		} catch (Exception e) {
			System.out.println("Could not execute statement");
		}
		return customers;
	}


	@Override
	public boolean delete(int id) throws SQLException {
		boolean rowDeleted = false;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Could not execute statement");
		}
		return rowDeleted;
	}
}


	





