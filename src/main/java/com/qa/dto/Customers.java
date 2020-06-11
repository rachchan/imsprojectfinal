package com.qa.dto;

public class Customers {

	private Integer CustomerID = 0;
	private String LastName;
	private String FirstName;
	private String Address;
	
	public Customers() {
		this.CustomerID = 0;
		this.LastName = null;
		this.FirstName = null;
		this.Address = null;
	}
	
	public Customers(Integer CustomerID) {
		this.CustomerID = CustomerID;
	}
	
	public Customers(Integer CustomerID, String Address) {
		this.CustomerID = CustomerID;
		this.Address = Address;
	}
	
	
	public Customers(String LastName, String FirstName) {
		this.LastName = LastName;
		this.FirstName = FirstName;
	}
	public Customers(Integer CustomerID, String LastName, String FirstName) {
		this.CustomerID = 0;
		this.LastName = LastName;
		this.FirstName = FirstName;
	}
	
	public Customers(String LastName, String FirstName, String Address) {
		this.LastName = LastName;
		this.FirstName = FirstName;
		this.Address = Address;
	}

	public Customers(int CustomerID, String LastName, String FirstName, String Address) {
		this.CustomerID = CustomerID;
		this.LastName = LastName;
		this.FirstName = FirstName;
		this.Address = Address;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
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
	
	public String getCustomer() {
		return FirstName + " | " + LastName + " |" + Address;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + CustomerID;
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (CustomerID != other.CustomerID)
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		return true;
	}

}
