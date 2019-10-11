package com.techelevator;

public class Money {
	
	public int balance;

	public Money() {
		balance = 0;
	}

	public int addMoneyInDollars(int amountToDepositInDollars) {
		balance = balance + (amountToDepositInDollars * 100);
		return this.balance;
	}

	public int withdrawMoneyInCents(int amountToWithdrawInCents) {
		balance = balance - (amountToWithdrawInCents);
		return this.balance;
	}

	public int getBalanceInPennies() {
		return this.balance;
	}

	public String getBalanceAsString() {
		int currentBalanceAsInt = balance;
		double currentBalanceAsDouble = (currentBalanceAsInt / 100.00);
		String formattedDoubleAsString = "$" + String.format("%.2f", currentBalanceAsDouble);
		return formattedDoubleAsString;

	}

	public String returnChangeAsCoins() {
		int total = this.balance;

		int totalQuartersToReturn = 0;
		int totalDimesToReturn = 0;
		int totalNickelsToReturn = 0;

		int quarter = 25;
		int dime = 10;
		int nickel = 5;

		while (total > 0) {
			if (total >= quarter) {
				totalQuartersToReturn++;
				total -= quarter;
			} else if (total >= dime) {
				totalDimesToReturn++;
				total -= dime;
			} else if (total >= nickel) {
				totalNickelsToReturn++;
				total -= nickel;

			}

		}

		this.balance = 0;

		String returnString = "Your change is " + totalQuartersToReturn + " quarters, " + totalDimesToReturn
				+ " dimes, " + "and " + totalNickelsToReturn + " nickels.";
		return returnString;
	}

}
