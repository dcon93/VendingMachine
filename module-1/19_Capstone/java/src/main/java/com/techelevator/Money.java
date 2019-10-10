package com.techelevator;

public class Money {
	private double balance = 0;
	final static int NICKLE = 5;
	final static int DIME = 10;
	final static int QUARTER = 25;
	final static int DOLLAR = 100;
	final static int FIVE_DOLLAR = 5;
	final static int TEN_DOLLAR = 1000;
	final static int TWENTY_DOLLAR = 2000;
	
	
	private static double insertMoney() {
		return 0;
	}
	
	
		public static void changeOut(int change){
		    int quarters = 0;
		    int dimes = 0;
		    int nickels = 0;
		    while (change >= 25){
		        quarters = quarters + 1;
		        change = change - 25;
		    }
		    while (change >= 10){
		        dimes = dimes + 1;
		        change = change - 10;
		    }
		    while (change >= 5){
		        nickels = nickels + 1;
		        change = change - 5; 
		        }
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
