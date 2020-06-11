package com.qa.dto;

public class Orderline {

	int OrderlineID = 0;
	int fk_OrderID;
	int fk_ItemID;
	int QuantityOrdered;

	public Orderline(int OrderlineID, int fk_OrderID, int fk_ItemID, int QuantityOrdered) {
		super();
		this.OrderlineID = OrderlineID;
		this.fk_OrderID = fk_OrderID;
		this.fk_ItemID = fk_ItemID;
		this.QuantityOrdered = QuantityOrdered;
	}

	public int getOrderlineID() {
		return OrderlineID;
	}

	public void setOrderlineID(int orderlineID) {
		OrderlineID = orderlineID;
	}

	public int getFk_OrderID() {
		return fk_OrderID;
	}

	public void setFk_OrderID(int fk_OrderID) {
		this.fk_OrderID = fk_OrderID;
	}

	public int getFk_ItemID() {
		return fk_ItemID;
	}

	public void setFk_ItemID(int fk_ItemID) {
		this.fk_ItemID = fk_ItemID;
	}

	public int getQuantityOrdered() {
		return QuantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		QuantityOrdered = quantityOrdered;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + OrderlineID;
		result = prime * result + QuantityOrdered;
		result = prime * result + fk_ItemID;
		result = prime * result + fk_OrderID;
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
		Orderline other = (Orderline) obj;
		if (OrderlineID != other.OrderlineID)
			return false;
		if (QuantityOrdered != other.QuantityOrdered)
			return false;
		if (fk_ItemID != other.fk_ItemID)
			return false;
		if (fk_OrderID != other.fk_OrderID)
			return false;
		return true;
	}

}
