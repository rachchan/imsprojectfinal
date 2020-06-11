package com.qa.services;

import java.sql.SQLException;


import org.apache.log4j.Logger;

import com.qa.dao.*;
import com.qa.dto.*;

public class CustomerServices {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerServices.class);
	private CustomerDao customerDao;
	
	public CustomerServices(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public void createCustomer(Customers customer) {
		try {
			customerDao.create(customer);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}
	
	public void selectCustomers() {
		try {
			customerDao.selectAll();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		
	}
	
	public void deleteCustomers(int id) {
		try {
			customerDao.delete(id);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	
	public void updateCustomer(Customers customers) {
		try {
			customerDao.update(customers);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}


}
	

