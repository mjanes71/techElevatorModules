package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.BitSet;

public class OldMacdonald {
	public static void main(String[] args) {

		Singable[] farmThings = new Singable[] { new Cow(), new Chicken(), new Goat(), new Tractor() }; //implementing the interface instead of a class so we can add tractor, even though its not a farm animal (type used to be FarmAnimal)


		for (Singable thing : farmThings) {
			String name = thing.getName();//determines what name to say and what sound to make based on which subclass is being referenced during the iteration
			String sound = thing.getSound(); // .getName and .getSound apply to Cow and Chicken because they are both farm animals
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}


		Sellable[] merchandise = new Sellable[] { new Cow(), new Chicken(), new Goat(), new Egg()};
		for(Sellable thing : merchandise){
			System.out.println("And that " + thing.getName() + " can be yours for just "
					+ thing.getPrice() + " dollars!");
		}

		FarmAnimal critter = new Chicken();
		System.out.println(critter.getSound());
		//critter.layEgg would cause a compiler error b/c you defined Chicken as a Farm Animal, not a Chicken. So the chicken methods aren't available, only the farm animal methods

		System.out.println(critter instanceof FarmAnimal); //returns boolean (true as is. would also be true if critter instanceof Chicken)
		//don't use instanceof in a big else/if mess b/c its unnecessary with polymorphism


		System.out.println("---------------------------------- Big Decimal Stuff------------------------------");

		BigDecimal first = new BigDecimal("0.1"); // big decimals are immutable like strings so on line 42, first.add doesn't change the value of first, it just does math
		BigDecimal second = new BigDecimal("0.2");
		System.out.println(first.add(second)); // gives you exactly 0.3 with no floating values

		BigDecimal myNumber = BigDecimal.ZERO;
		myNumber = myNumber.add(second);
		myNumber = myNumber.add(second);
		System.out.println(myNumber);

		BigDecimal price = BigDecimal.valueOf(critter.getPrice());//if you just print price right after this, it looks like an int still, but we know its a big decimal b/c now i can add it in the next line to another big decimal (this wouldn't be allowed if it was an int)
		myNumber = myNumber.add(price);
		System.out.println(myNumber);

		if(first.compareTo(second) > 0){ //compareTo returns either a 1, a 0, or a -1 --> imagine how you'd like to compare the values, put that symbol to the right of your statement, and then put zero on the other side
			System.out.println("first is bigger");
		}

	}



}