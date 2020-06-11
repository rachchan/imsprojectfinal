package com.qa.dto;

public class Items {

	private Integer ItemID = 0;
	private String ItemName;
	private double Price;
	private int QuantityOrdered;
	
	public Items() {
		this.ItemID = 0;
		this.ItemName = null;
		this.Price = 0.0;
		this.QuantityOrdered = 0;
	}
	
	public Items(String ItemName) {
		this.ItemName = ItemName;
	}
	
	public Items(double Price, int ItemID) {
		this.Price = Price;
		this.ItemID = ItemID;
	}
	
	public Items(String ItemName, double Price, int QuantityOrdered) {
		this.ItemName = ItemName;
		this.Price = Price;
		this.QuantityOrdered = QuantityOrdered;
	}

	public Items(int ItemID, String ItemName, double Price, int QuantityOrdered) { 
		this.ItemID = ItemID;
		this.ItemName = ItemName;
		this.Price = Price;
		this.QuantityOrdered = QuantityOrdered;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getQuantityOrdered() {
		return QuantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		QuantityOrdered = quantityOrdered;
	}

	public int getItemID() {
		return ItemID;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ItemID;
		result = prime * result + ((ItemName == null) ? 0 : ItemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + QuantityOrdered;
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
		Items other = (Items) obj;
		if (ItemID != other.ItemID)
			return false;
		if (ItemName == null) {
			if (other.ItemName != null)
				return false;
		} else if (!ItemName.equals(other.ItemName))
			return false;
		if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
			return false;
		if (QuantityOrdered != other.QuantityOrdered)
			return false;
		return true;
	}

}
