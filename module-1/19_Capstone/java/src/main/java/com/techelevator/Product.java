package com.techelevator;

import org.w3c.dom.NameList;

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


}
