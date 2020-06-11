package com.qa.dao;


import java.util.List;

import com.qa.dto.Customers;



public interface CustomerDao {
	
	void create (Customers customers);
	List<Customers> selectAll();
	void update(Customers customers);
	void delete(int CustomerID);
	
}
