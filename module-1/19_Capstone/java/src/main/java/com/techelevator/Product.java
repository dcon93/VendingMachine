package com.techelevator;

public class Product {
	private String slotID;
	private String productName;
	private double price;
	private String productType;
	private int quantity;


	public Product(String slot, String name, double price, String productType, int quantity) {
		this.slotID = slot;
		this.productName = name;
		this.price = price;
		this.quantity = quantity;
		this.productType = productType;
	}

	

	public String getProductType() {
		return productType;
	}



	public String getSlot() {
		return slotID;
	}

	public String getName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}

	public void decreaseQuantity() {
		quantity--;

	}

	public String isSoldOut() {
		if (quantity == 0) {
			return "This product is sold out. Please make another selection";
		} else {
			return Integer.toString(quantity);
		}
	}

	@Override
	public String toString() {
		String convertToCharacters = String.format("%1$-5s %2$-25s %3$-10s %4$-20s", slotID, productName, price, isSoldOut());

		return convertToCharacters;
	}

}
