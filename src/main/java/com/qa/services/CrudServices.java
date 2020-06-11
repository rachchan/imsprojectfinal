package com.qa.services;


import java.util.List;

public interface CrudServices<T> {
	
	void create (T customers);
	List<T> selectAll();
	void delete(int CustomerID);
	void update(T customers);
}
