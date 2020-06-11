package com.qa.controllers;


import com.qa.connecting.utils.Action;
import com.qa.connecting.utils.Input;
import com.qa.dto.*;
import com.qa.services.*;

public class CustomerController {

	private CustomerServices customerService;
	private Input input;

	public CustomerController(Input input, CustomerServices customerService) {
		this.customerService = customerService;
		this.input = input;
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
		String firstName = input.getInput();

		System.out.println("Customer Last Name");
		String lastName = input.getInput();

		System.out.println("Customer Address");
		String address = input.getInput();
		
		Customers customer = new Customers(lastName, firstName, address);
		customerService.createCustomer(customer);

	}

	protected void read() {
		customerService.selectCustomers();
		
	}

	protected void update() {
		System.out.println("Customer first name: ");
		String firstName = input.getInput();
		
		System.out.println("Customer last name: ");
		String lastName = input.getInput();

		System.out.println("Customer new address: ");
		String address = input.getInput();
		
		Customers customer = new Customers(lastName, firstName, address);
		customerService.updateCustomer(customer);
		System.out.println("Customer first name: " + firstName + ", New address: "+ address);
	}

	protected void delete() {
		System.out.println("Specify the customer you want to delete: ");
		
		System.out.println("Customer first name: ");
		String firstName = input.getInput();
		
		System.out.println("Customer last name: ");
		String lastName = input.getInput();

		System.out.println("Customer new address: ");
		String address = input.getInput();
		
		System.out.println("Customer ID: ");
		int id = input.getInt();
		
		Customers customer = new Customers(id, lastName, firstName, address);
		customerService.deleteCustomers(id);
		System.out.println(firstName + " has been deleted");
		
	}
}

