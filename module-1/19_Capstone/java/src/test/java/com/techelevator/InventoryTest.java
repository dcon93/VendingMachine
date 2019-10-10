package com.techelevator;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
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
}
