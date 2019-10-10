package com.techelevator;

public abstract class Product {
	private String name;
	private String type;
	private int price;
	private String sound;

	
	public Product(String name, String type, int price, String sound) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.sound = sound;
	}

	
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getSound() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}


}
