package com.techelevator.farm;

public class Goat extends FarmAnimal {

    public Goat(){ // can be empty b/c we are reusing the constructor from the superclass (just trying to pass the superclass constructor enough arguments to create a farm animal)
        super("Goat","bleat");
    }

    @Override
    public String getSound(){
        return "BAA BAA BAA"; //an override of a method in Farm Animal will affect the goat in the song b/c the goat was declared as a farm animal
    }


}
