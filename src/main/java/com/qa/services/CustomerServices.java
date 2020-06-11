package com.qa.services;

import java.util.ArrayList;
import java.util.List;

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
		customerDao.create(customer);
	}
	

	public void selectCustomers() {
		List<Customers> myCustomerList = new ArrayList();
		myCustomerList = customerDao.selectAll();
		
		for(int x = 0; x < myCustomerList.size(); x++){
			System.out.println(myCustomerList.get(x).getCustomer());
		}
		
	}
	
	public void deleteCustomers(int CustomerID) {
			customerDao.delete(CustomerID);
	}

	
	public void updateCustomer(Customers customers) {
			customerDao.update(customers);
	}
}
	

