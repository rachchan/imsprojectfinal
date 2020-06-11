package com.qa.connecting.utils;


import org.apache.log4j.Logger;
import com.qa.controllers.CustomerController;
import com.qa.dao.CustomerDaoImpl;
import com.qa.dao.DatabaseConnection;
import com.qa.dto.Models;
import com.qa.services.CustomerServices;


public class Ims {

	private Input input;
	public static final Logger LOGGER = Logger.getLogger(Ims.class);
	
	public Ims(Input input, DatabaseConnection databaseConnection) {
		this.input = input;
	}

	public void start() {
		
		System.out.println("Would you like to create, read, update or delete?");
		System.out.println("To exit, type [exit]");
 
			Action selectedAction;

			while (true) {
				try {
					String actionInput = input.getInput();
					selectedAction = Action.valueOf(actionInput.toUpperCase());
					System.out.println(selectedAction);
					break;
				} catch (IllegalArgumentException e) {
					LOGGER.warn("Not an option, try again");
				}
			}

			Models models;
			while (true) {
				try {
					String modelSelection = "Choose customers, orders or items: ";
					for (Models modelSelect : Models.values()) {
						modelSelection += modelSelect.toString().toLowerCase() + ", ";
					}
					System.out.println(modelSelection);
					String modelInput = input.getInput();
					models = Models.valueOf(modelInput.toUpperCase());
					System.out.println(models);
					break;
				} catch (IllegalArgumentException e) {
					LOGGER.warn("Model not recognised, try again");
				}
			}

			switch (models) {
			case CUSTOMERS:
				CustomerController controller = new CustomerController(input, new CustomerServices(new CustomerDaoImpl()));
				controller.run(selectedAction);
				break;
			case ORDERS:
			
				break;
			case ITEMS:
				
				break;
			default:
				break;
			}

			DatabaseConnection.closeConnection();
		}

}
