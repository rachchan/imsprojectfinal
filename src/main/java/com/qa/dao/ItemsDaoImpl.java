package com.qa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.dto.Items;

public class ItemsDaoImpl implements ItemsDao {
	
	private static final String INSERT_ITEMS = "INSERT INTO items " + "(ItemName, Price, QuantityOrdered) VALUES " + "(?,?,?);";
	private static final String SELECT_ALL_ITEMS = "SELECT * FROM items";
	private static final String UPDATE_ITEMS = "UPDATE items SET Price = ? WHERE ItemID = ?";
	private static final String DELETE_ITEMS = "DELETE FROM items WHERE ItemID = ?";
	private DatabaseConnection connection;

	Statement statement = null;
	ResultSet resultSet = null;
	
	public ItemsDaoImpl(DatabaseConnection databaseConnection) {
		this.setDatabaseConnection(databaseConnection);
	}

	@Override
	public void create(Items items) {
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(INSERT_ITEMS);
			preparedStatement.setString(1, items.getItemName());
			preparedStatement.setDouble(2, items.getPrice());
			preparedStatement.setInt(3, items.getQuantityOrdered());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Could not execute Statement");
		}	
	}

	@Override
	public List<Items> selectAll() {
		List<Items> items = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECT_ALL_ITEMS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int itemId = resultSet.getInt("ItemID");
				String itemName = resultSet.getString("ItemName");
				Double price = resultSet.getDouble("Price");
				int quantityOrdered = resultSet.getInt("QuantityOrdered");
				
				items.add(new Items(itemId, itemName, price, quantityOrdered));
				
			}
		} catch (Exception e) {
			System.out.println("Could not execute statement");
		}
		return items;
	}

	@Override
	public void update(Items items) {
	try {
			
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(UPDATE_ITEMS);
			preparedStatement.setDouble(1, items.getPrice());
			preparedStatement.setInt(2, items.getItemID());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Could not execute Statement");
		}
	}

	@Override
	public void delete(int ItemID) {
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(DELETE_ITEMS);
			preparedStatement.setInt(1, ItemID);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
		
			System.out.println("Could not execute statement");
		}
	
		
	}

	public DatabaseConnection getConnection() {
		return connection;
	}

	public void setDatabaseConnection(DatabaseConnection databaseConnection) {
		this.connection = databaseConnection;
	}

	
}
