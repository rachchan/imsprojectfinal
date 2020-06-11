package com.qa.connecting.utils;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Input {

	private Scanner scanner = new Scanner(System.in);
	public static final Logger LOGGER = Logger.getLogger(Ims.class);
	
	public String getInput() {
		return scanner.nextLine();
	}
	
	public double getDouble() {
		double value;
		while (true) {
			try {
				value = Double.parseDouble(scanner.nextLine());
				return value;
			} catch (NumberFormatException b) {
				LOGGER.error(b);
			}
		}
	}
	
	
	public int getInt() {
		int value;
		
		while (true) {
			try {
				value = Integer.parseInt(scanner.nextLine());
				return value;
			} catch (NumberFormatException b) {
				LOGGER.error(b);
			}

		}
	}
}
