package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class Inventory {

	// read vendingmachine.csv

	static File inputFile = new File("vendingmachine.csv");
	static Scanner inputStream = null;
	
	Map<String, Product> inventoryMap = new HashMap<String, Product>();
	Map<String, Integer> quantityMap = new HashMap<String, Integer>();

	public void stockInventory() {
		try {
			inputStream = new Scanner(inputFile);
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(1);
		}

		String[] currentLineArr = new String[4];
		

		while (inputStream.hasNext()) {
			String line = inputStream.nextLine();
			currentLineArr = line.split("[|]");
			
			String mapKey = currentLineArr[0].toUpperCase();
			
			inventoryMap.put(mapKey, convertArraytoProduct(currentLineArr));
			quantityMap.put(mapKey, 5);
		}


		// convertArraytoProduct(currentLineArr);
	}
	
	// dispense product should take a string and return a product
	//get the product from inventory map
	//check quantity in quantity map and decrement it
	
	
	
	public Product getProductFromSlot(String slotID) {
		return inventoryMap.get(slotID.toUpperCase());
	}

	public static Product convertArraytoProduct(String[] currentLineArr) {
		
		BigDecimal price = new BigDecimal(currentLineArr[2]);
		// multiplies big decimal by 100 and turns it into an int
		int priceInPennies = price.multiply(BigDecimal.valueOf(100)).intValue();
		
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
