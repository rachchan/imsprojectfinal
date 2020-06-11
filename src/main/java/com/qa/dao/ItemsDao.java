package com.qa.dao;

import java.util.List;

import com.qa.dto.Items;


public interface ItemsDao {

	void create (Items items);
	List<Items> selectAll();
	void update(Items items);
	void delete(int ItemID);
}
