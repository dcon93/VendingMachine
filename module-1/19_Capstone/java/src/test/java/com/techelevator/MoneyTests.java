package com.techelevator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import org.junit.After;

public class MoneyTests {

	Money testMoney;

	@Before
	public void setup() {
		this.testMoney = new Money();
	}

	@Test
	public void check_that_Strings_format_properly_on_balance() {
		testMoney.addMoney(5);

		Assert.assertEquals("$5.00", testMoney.getBalanceAsString());
	}

	@Test
	public void check_if_add_money_adds_money_and_multiplies_by_100() {
		int currentBalance = testMoney.addMoney(12);

		Assert.assertEquals(1200, currentBalance);

	}
	
	@Test
	public void check_if_withdraw_money_works() {
		int currentBalance = testMoney.addMoney(15);
		currentBalance = testMoney.withdrawMoney(15);
		
		Assert.assertEquals(0, currentBalance);
		
	}
	
	@Test
	public void check_if_change_returns_correct_amount_of_quarters() {
		String expectedString = "Your change is 8 quarters, 0 dimes, and 0 nickels.";
		String expectedString2 = "Your change is 7 quarters, 1 dimes, and 1 nickels.";
		
		Assert.assertEquals(expectedString, testMoney.returnChangeAsCoins(200));
		Assert.assertEquals(expectedString2, testMoney.returnChangeAsCoins(190));
	}
}
