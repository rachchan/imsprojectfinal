package com.qa.dto;

import java.sql.Date;

public class Orders {

	private int id = 0;
	private int CustomerID = 0;
	private Date DatePlaced = null;
	private double OrderTotal = 0.0;
	
	public Orders() {
	}
	
	public Orders(int id) {
		this.setId(id);
	}
	public Orders(int id, int CustomerID, Date DatePlaced, double OrderTotal) {
		this.id = id;
		this.CustomerID = CustomerID;
		this.DatePlaced = DatePlaced;
		this.OrderTotal = OrderTotal;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int CustomerID) {
		this.CustomerID = CustomerID;
	}


	public Date getDatePlaced() {
		return DatePlaced;
	}

	public void setDatePlaced(Date datePlaced) {
		DatePlaced = datePlaced;
	}

	public double getOrderTotal() {
		return OrderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		OrderTotal = orderTotal;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DatePlaced == null) ? 0 : DatePlaced.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(OrderTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Orders other = (Orders) obj;
		if (DatePlaced == null) {
			if (other.DatePlaced != null)
				return false;
		} else if (!DatePlaced.equals(other.DatePlaced))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(OrderTotal) != Double.doubleToLongBits(other.OrderTotal))
			return false;
		return true;
	}



}
