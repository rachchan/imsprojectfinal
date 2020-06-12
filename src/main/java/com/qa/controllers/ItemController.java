package com.qa.controllers;



import com.qa.dto.Items;
import com.qa.services.ItemServices;
import com.qa.utils.Action;
import com.qa.utils.Input;


public class ItemController {
	private ItemServices itemService;

	public ItemController(ItemServices itemService) {
		this.itemService = itemService;
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

		System.out.println("Item Name");
		String itemName = Input.getInput();

		System.out.println("Item Price");
		double price = Input.getDouble();

		System.out.println("Quantity");
		int quantity = Input.getInt();
		
		Items item = new Items(itemName, price, quantity);
		itemService.createItem(item);
		System.out.println("Item added: " + itemName + ", " + price + ", " + quantity);
	}

	protected void read() {
		itemService.selectItems();
	}

	protected void update() {
	
		System.out.println("New Price: ");
		double price = Input.getDouble();
		
		System.out.println("Item ID: ");
		int itemId = Input.getInt();
		
		Items item = new Items(price, itemId);
		itemService.updateItem(item);
		System.out.println("Item ID " + itemId + "New price: "+ price);
	}

	protected void delete() {
		System.out.println("Specify the customer you want to delete: ");

		System.out.println("Item ID: ");
		int ItemID = Input.getInt();
		
		Items item = new Items(ItemID);
		itemService.deleteItems(ItemID);
		System.out.println(item.getItemID() + " has been deleted");
		
	}
}



