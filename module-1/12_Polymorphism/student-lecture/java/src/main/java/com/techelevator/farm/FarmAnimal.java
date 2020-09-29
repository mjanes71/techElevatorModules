package com.techelevator.farm;

public class FarmAnimal implements Singable, Sellable{ //invokes the contract made by the singable interface (meets the requirements b/c it has a name and sound method)
	private static final int DEFAULT_PRICE = 10;

	private String name;
	private String sound;
	private int price;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		price = DEFAULT_PRICE;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

}