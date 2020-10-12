package com.techelevator.farm;

public final class Cat extends FarmAnimal { //when you add final to a class, it keeps subclasses from being created from that class

    public Cat(){
        super("Cat", "Meow");
    }
}
