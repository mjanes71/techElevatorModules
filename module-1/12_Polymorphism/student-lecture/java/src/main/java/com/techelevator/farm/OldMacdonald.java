package com.techelevator.farm;

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

		for(Sellable item : merchandise){
			System.out.println("And that " + item.getName() + " can be yours for just "
					+ item.getPrice() + " dollars!");
		}

		FarmAnimal critter = new Chicken();
		System.out.println(critter.getSound());
		//critter.layEgg would cause a compiler error b/c you defined Chicken as a Farm Animal, not a Chicken. So the chicken methods aren't available, only the farm animal methods

		System.out.println(critter instanceof FarmAnimal); //returns boolean (true as is. would also be true if critter instanceof Chicken)
		//don't use instanceof in a big else/if mess b/c its unnecessary with polymorphism
	}
}