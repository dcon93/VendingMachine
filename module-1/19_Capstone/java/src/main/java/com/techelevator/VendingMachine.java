package com.techelevator;

public class VendingMachine {
	
	private Inventory inventory;
	private Money money;
	
	public VendingMachine() {
		inventory = new Inventory();
		inventory.stockInventory();
		
		money = new Money();
	}

	public Product vend(String slotID) {
		
		if(inventory.getProductFromSlot(slotID) == null || inventory.getProductQuantityFromSlot(slotID) == 0) {
			return null;
		}
		
		int amountToWithdraw = inventory.getProductFromSlot(slotID).getPrice() * 100;
		int currentBalance = money.getBalanceInPennies();
		
		if(currentBalance >= amountToWithdraw) {	
			
			Product p = inventory.dispenseProduct(slotID);
			currentBalance = currentBalance - amountToWithdraw;
			return p;
			
		}
		
		return null; // bc not enough money
		
	}
	
	public String returnChange() {
		return money.returnChangeAsCoins();	
	}

	
	
	
	public boolean insertMoney (int insertAmount) {
		// insertAmount == 100 || insertAmount == 200 || insertAmount == 500 || insertAmount == 1000
		if (insertAmount % 100 == 0) {
			this.money.addMoney(insertAmount);
			return true;
		} 
			return false;
					//"Amount not accepted. Please only feed whole dollar amounts into the vending machine.";
	}
	
	public Inventory getInventory() {
		return inventory;
	}


	public Money getMoney() {
		return money;
	}
	
	
}
