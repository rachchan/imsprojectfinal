package com.qa.dao;

import com.qa.dto.Items;

public class ItemsDao {
	
	private DatabaseConnection databaseConnection;

	public ItemsDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertItems(Items items) { 
		
		String sql = "INSERT INTO item (ItemName,  ItemPrice) VALUES ('" + items.getItemName() + "'," 
				+ items.getPrice() +")";
		
			databaseConnection.sendUpdate(sql);
	}
}
