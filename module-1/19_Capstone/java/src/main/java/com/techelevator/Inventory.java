package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Inventory {
	// read vendingmachine.csv

	File inputFile = new File("vendingmachine.csv");

	Scanner inputStream = null;
	{

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
		
		

	}
	/*
	 * File file = new File("vendingmachine.csv"); FileInputStream fileStream = new
	 * FileInputStream(file); // opens connection to file InputStreamReader input =
	 * new InputStreamReader(fileStream); // reads bytes and decodes to characters
	 * in file BufferedReader reader = new BufferedReader(input); String line; {
	 * 
	 * try { while( (line = reader.readLine()) != null) { String[] wordList =
	 * line.split("\\|"); // wordList[0]// //wordList[1] //wordList[2]
	 * 
	 * 
	 * 
	 * } } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

}
