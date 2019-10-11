package com.techelevator;
import java.util.Scanner;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION }; 
	
	private Menu menu;
	private VendingMachine vendingMachine;
	private Scanner inputScanner;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.vendingMachine = new VendingMachine();
		this.inputScanner = new Scanner(System.in);
	}
	
	public void runPurchaseMenu() {
		while(true) {
			System.out.println("Current Balance: " + vendingMachine.getMoney().getBalanceAsString());
			
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			
			if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				//print message asking for money and then print the amount
				
				System.out.println("Insert Dollars >>>");
				String fedMoney = inputScanner.nextLine();
				int moneyDeposited = Integer.parseInt(fedMoney);
				
				vendingMachine.getMoney().addMoneyInDollars(moneyDeposited);
				
				//once you have the amount you just call your vending machine and add money
				
				
			}else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				//prompt them to get the slot
				
				System.out.println("Enter Product Key >>>");
				
				String itemSelected = inputScanner.nextLine();
				
				if(vendingMachine.getInventory().inventoryMap.containsKey(itemSelected)) {
					System.out.println("Vended a " + vendingMachine.vend(itemSelected).getName());
					
				} else {
					System.out.println("Couldn't find item at " + itemSelected);
				}
				
				
				
				//need to use the inventory to see if it is valid and if there is any to dispense
				//need to call your vend method and if it returns a product then it worked and if didnt you didn't have enough money
				
			}else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				//make change
				System.out.println(vendingMachine.returnChange());
				
				//finish transaction
				return;
			}
		}
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			vendingMachine.getInventory().printInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				runPurchaseMenu();
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		
		
		
		
	}
}
