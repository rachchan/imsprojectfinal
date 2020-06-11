package com.qa.services;

import java.sql.SQLException;
import java.util.List;

public interface CrudServices<T> {
	
	int create (T customers) throws SQLException;
	T select(int id);
	List<T> selectAll() throws SQLException;
	boolean delete(int Id) throws SQLException;
	boolean update(T customers) throws SQLException;
}
