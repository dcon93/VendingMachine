package com.techelevator;

public class VendingMachine {
	
	private Inventory inventory;
	private Money money;
	private Logger log;
	
	public VendingMachine() {
		inventory = new Inventory();
		inventory.stockInventory();
		log = new Logger();
		money = new Money();
		
		
	}

	public Product vend(String slotID) {
		
		if(inventory.getProductFromSlot(slotID) == null || inventory.getProductQuantityFromSlot(slotID) == 0) {
			return null;
		}
		
		int amountToWithdraw = inventory.getProductFromSlot(slotID).getPrice();
		int currentBalance = money.getBalanceInPennies();
		
		if(currentBalance >= amountToWithdraw) {	
			
			String prebalance = this.money.getBalanceAsString();
			
			Product p = inventory.dispenseProduct(slotID);
			money.withdrawMoneyInCents(amountToWithdraw);
			
			String postbalance = this.money.getBalanceAsString();
			String eventName = p.getName() + " " + slotID;
			this.log.logEvent(eventName, prebalance, postbalance);
			return p;
			
		}
		
		return null; // bc not enough money
		
	}
	
	public String returnChange() {
		
		String prebalance = this.money.getBalanceAsString();
		String change = money.returnChangeAsCoins();
		String postbalance = this.money.getBalanceAsString();
		
		log.logEvent("GIVE CHANGE", prebalance, postbalance);
		
		return change;	
	}

	
	
	
	public boolean insertMoney (int insertAmountInCents) {
		// insertAmount == 100 || insertAmount == 200 || insertAmount == 500 || insertAmount == 1000
		if (insertAmountInCents % 100 == 0) {
			String prebalance = this.money.getBalanceAsString();
			
			this.money.addMoneyInDollars(insertAmountInCents / 100);
			String postbalance = this.money.getBalanceAsString();
			
			this.log.logEvent("FEED MONEY", prebalance, postbalance);
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
