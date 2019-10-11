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
	
	// check quantity of quantitymap after calling stockInventory()
	
	@Test
	public void stockInventory_should_set_quantityMap_values_to_5() {
		testInventory.stockInventory();
		
		int quantity = testInventory.getProductQuantityFromSlot("b2");
		
		Assert.assertEquals(quantity, 5);
	}
	
	// return product after dispensing and check that quantity has decreased by 1
	
	@Test
	public void dispenseProduct_returns_product_and_decrements_quantity() {
		testInventory.stockInventory();
		
		Product expected = testInventory.dispenseProduct("C4");
		
		Product actual = new Drink("Heavy", 150);
		
		int quantity = testInventory.getProductQuantityFromSlot("C4");
		
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(quantity, 4);
		
	}
	// returns null when quantity is 0
	@Test
	public void dispenseProduct_returns_null_when_quantityMap_value_is_0 () {
		testInventory.stockInventory();
		
		testInventory.dispenseProduct("d3");
		testInventory.dispenseProduct("d3");
		testInventory.dispenseProduct("d3");
		testInventory.dispenseProduct("d3");
		testInventory.dispenseProduct("d3");
		
		Product p = testInventory.dispenseProduct("d3");
		Assert.assertEquals(p, null);	
		
	}
	
	
	
	
}
