package com.techelevator;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

import org.junit.After;

public class VendingMachineTests {
	
	VendingMachine testVendingMachine;
	
	@Before
	public void setup() {
		this.testVendingMachine = new VendingMachine();
	}
	
	
	@Test 
	public void check_if_insertmoney_returns_true_when_divisible_by_100() {
	
		Assert.assertTrue(testVendingMachine.insertMoney(500));
		Assert.assertFalse(testVendingMachine.insertMoney(393));
	}
	
	@Test
	public void check_that_vend_method_returns_null_when_given_wrong_slotID() {
		
		
		Assert.assertNull(testVendingMachine.vend("54"));
		Assert.assertNotNull(testVendingMachine.getInventory().getProductFromSlot("A1"));
	}
	
	@Test
	public void check_that_vend_method_returns_not_null_when_quantity_is_created() {
		testVendingMachine.getInventory().getProductQuantityFromSlot("A1");
		

		
		Assert.assertNotNull(testVendingMachine.getInventory().getProductQuantityFromSlot("A1"));
	}
	
	//want to create a test that method vend returns null if the quantity is 0
	
}
