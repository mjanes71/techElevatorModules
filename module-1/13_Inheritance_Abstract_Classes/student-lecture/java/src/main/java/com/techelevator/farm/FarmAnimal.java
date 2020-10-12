package com.techelevator.farm;

public abstract class FarmAnimal implements Singable { //abstract keeps this class from making objects (it's only meant to serve as a superclass for other subclasses)
	private String name;
	private String sound;
	private boolean asleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {
		return name;
	}
	public final String getSound( ) { //make a method final to keep subclasses from overriding it (do this here because its sound but also works with the sleep method)
		if (asleep){
			return "zzzzz";
		}else {
			return sound;
		}
	}

	public boolean isAsleep(){
		return asleep;
	}

	public void setAsleep(boolean asleep){
		this.asleep = asleep;
	}

	//public abstract String eat(); --> now every time i create a farm animal, i have to create an eat method that returns a string

}