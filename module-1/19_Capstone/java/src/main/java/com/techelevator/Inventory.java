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
	
	
	public static void displayInventoryFromFile() {
		

	}
	
	
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
			currentLineArr = line.split("|");
		}

		String slotID = currentLineArr[0];
		String productName = currentLineArr[1];
		String priceStr = currentLineArr[2];
		String productType = currentLineArr[3];
		
		int price = Integer.parseInt(priceStr);

	}  

}
