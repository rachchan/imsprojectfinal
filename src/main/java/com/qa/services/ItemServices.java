package com.qa.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.dao.ItemsDao;
import com.qa.dto.Items;

public class ItemServices {
	public static final Logger LOGGER = Logger.getLogger(ItemServices.class);
	private ItemsDao itemsDao;
	
	public ItemServices(ItemsDao itemsDao) {
		this.itemsDao = itemsDao;
	}
	
	public void createItem(Items item) {
		itemsDao.create(item);
	}
	

	public void selectItems() {
		List<Items> myItemList = new ArrayList();
		myItemList = itemsDao.selectAll();
		
		for(int x = 0; x < myItemList.size(); x++){
			System.out.println(myItemList.get(x).getItem());
		}
		
	}
	
	public void deleteItems(int ItemID) {
			itemsDao.delete(ItemID);
	}

	
	public void updateItem(Items items) {
			itemsDao.update(items);
	}
}
	

