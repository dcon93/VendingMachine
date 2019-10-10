package com.techelevator;

import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Inventory {

	// read vendingmachine.csv

	static File inputFile = new File("vendingmachine.csv");
	static Scanner inputStream = null;

	public static void stockInventory() {
		try {
			inputStream = new Scanner(inputFile);
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(1);
		}

		String[] currentLineArr = new String[4];

		while (inputStream.hasNext()) {
			String line = inputStream.nextLine();
			currentLineArr = line.split("|");
		}

		String slotID = currentLineArr[0];
		String productName = currentLineArr[1];
		String priceStr = currentLineArr[2];
		String productType = currentLineArr[3];

		convertArraytoProduct(currentLineArr);

	}

	public Product convertArraytoProduct(String[] currentLineArr) {
		
		double price = Double.parseDouble(currentLineArr[2]);
		int priceInPennies = (int)price * 100;
		
		if (currentLineArr[3].equalsIgnoreCase("chip")) {
			Product p = new Chips(currentLineArr[1], priceInPennies);
			
			return p;
		} else if (currentLineArr[3].equalsIgnoreCase("Candy")) {
			Product p = new Candy(currentLineArr[1], priceInPennies);
			
			return p;
		} else if (currentLineArr[3].equalsIgnoreCase("Drink")) {
			Product p = new Drink(currentLineArr[1], priceInPennies);
			
			return p;
		} else if (currentLineArr[3].equalsIgnoreCase("Gum")) {
			Product p = new Gum(currentLineArr[1], priceInPennies);
			
			return p;
		} return null;
	}

}
