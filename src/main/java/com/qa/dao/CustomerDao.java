package com.qa.dao;

import java.sql.SQLException;
import java.util.List;

import com.qa.dto.Customers;

public interface CustomerDao {
	
	int create (Customers customers) throws SQLException;
	Customers select(int id);
	List<Customers> selectAll() throws SQLException;
	boolean update(Customers customers) throws SQLException;
	boolean delete(int id) throws SQLException;
	
}
