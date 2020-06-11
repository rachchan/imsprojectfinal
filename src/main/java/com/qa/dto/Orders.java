package com.qa.dto;

import java.sql.Date;

public class Orders {

	private int OrderID = 0;
	private int fk_CustomerID = 0;
	private Date DatePlaced;
	private double OrderTotal;
	
	public Orders() {
		this.OrderID = 0;
		this.fk_CustomerID = 0;
		this.DatePlaced = null;
		this.OrderTotal = 0.0;
	}

	public Orders(int OrderID, int CustomerID, Date DatePlaced, double OrderTotal) {
		this.OrderID = OrderID;
		this.setCustomerID(CustomerID);
		this.DatePlaced = DatePlaced;
		this.OrderTotal = OrderTotal;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	
	public int getCustomerID() {
		return fk_CustomerID;
	}

	public void setCustomerID(int CustomerID) {
		this.fk_CustomerID = CustomerID;
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
		result = prime * result + OrderID;
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
		if (OrderID != other.OrderID)
			return false;
		if (Double.doubleToLongBits(OrderTotal) != Double.doubleToLongBits(other.OrderTotal))
			return false;
		return true;
	}


}
