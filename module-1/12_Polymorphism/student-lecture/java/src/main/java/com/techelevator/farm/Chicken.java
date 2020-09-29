package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() { //calling constructor from parent FarmAnimal
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	@Override
	public int getPrice(){
		return 5;
	}

}