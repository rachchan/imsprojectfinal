package com.qa.controllers;


import com.qa.dto.Customers;
import com.qa.services.CustomerServices;
import com.qa.utils.Action;
import com.qa.utils.Input;

public class CustomerController {

	private CustomerServices customerService;

	public CustomerController(CustomerServices customerService) {
		this.customerService = customerService;
	}

	public void run(Action action) {
		switch (action) {
		case CREATE:
			create();
			break;
		case READ:
			read();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		default:
			break;
		}
	}

	protected void create() {
		System.out.println("Please enter the following information: ");

		System.out.println("Customer First Name");
		String firstName = Input.getInput();

		System.out.println("Customer Last Name");
		String lastName = Input.getInput();

		System.out.println("Customer Address");
		String address = Input.getInput();
		
		Customers customer = new Customers(lastName, firstName, address);
		customerService.createCustomer(customer);
		System.out.println("Customer created: " + firstName + ", " + lastName + ", " + address);
	}

	protected void read() {
		customerService.selectCustomers();
	}

	protected void update() {
	
		
		System.out.println("Customer ID: ");
		int customerID = Input.getInt();

		System.out.println("New Address: ");
		String address = Input.getInput();
		
		Customers customer = new Customers(customerID, address);
		customerService.updateCustomer(customer);
		System.out.println("Customer ID " + customerID + "New address: "+ address);
	}

	protected void delete() {
		System.out.println("Specify the customer you want to delete: ");
		
		
		System.out.println("Customer ID: ");
		int CustomerID = Input.getInt();
		
		Customers customer = new Customers(CustomerID);
		customerService.deleteCustomers(CustomerID);
		System.out.println(customer.getCustomerID() + " has been deleted");
		
	}
}

