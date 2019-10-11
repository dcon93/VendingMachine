package com.techelevator;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;

public class InventoryTest {
	
	Inventory testInventory;
	
	@Before
	public void setup() {
		this.testInventory = new Inventory();
	}
	
	@Test 
	public void test_if_convert_to_product_method_works() {
		String[] newstring = {"AB23", "Fritos","2.05","Chip"};
		Product c = new Chips("Fritos", 205);
		
		Assert.assertEquals(c,testInventory.convertArraytoProduct(newstring));
	}
	
	@Test
	public void test_if_stockInventory_makes_map () {
		testInventory.stockInventory();
		Product p = testInventory.getProductFromSlot("a1"); // returns product
		Product notThere = testInventory.getProductFromSlot("z9");
		
		Assert.assertNotNull("product in slot A1 is null", p);
		
		Assert.assertNull("product in slot z9 is there", notThere);
	}
	
	@Test
	public void test_product_equals_works() {
		Product c1 = new Chips("Doritos", 302);
		Product c2 = new Chips("Doritos", 302);
		
		Assert.assertEquals(c1, c2);
	}
	
	
	
	
}
