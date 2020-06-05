package com.qa.connecting.model;

public class Customers {
	
	private String LastName;
	private String FirstName;
	private String Address;
	
	public Customers(String LastName, String FirstName, String Address) {
		super();
		this.LastName = LastName;
		this.FirstName = FirstName;
		this.Address = Address;
	}

	public String getLastName() {
		return LastName;
	}

	public void setName(String LastName) {
		this.LastName = LastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

}
