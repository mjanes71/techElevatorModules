package com.techelevator.playingcards;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private static final String DEFAULT_SUIT = "Spades";
    private static final String DEFAULT_RANK = "Ace";

    private static int createdCount; //static variables refer to the class, not the object

    private String suit;
    private String rank;
    private boolean faceUp = false; //defaults card to be face down

    private Map<String, Integer> rankValues = setupRankValues();

    private Map<String, Integer> setupRankValues(){
        Map<String, Integer> result = new HashMap<>();
        result.put("Ace" , 1);
        result.put("Two" , 2);
        result.put("Three" , 3);
        result.put("Four" , 4);
        result.put("Five" , 5);
        result.put("Six" , 6);
        result.put("Seven" , 7);
        result.put("Eight" , 8);
        result.put("Nine" , 9);
        result.put("Ten" , 10);
        result.put("Jack" , 11);
        result.put("Queen" , 12);
        result.put("King" , 13);
        return result;
    }

    public Card(){ // This is a constructor (no return, no void, named after class)
        setSuit(DEFAULT_SUIT);
        setRank(DEFAULT_RANK);
        //can also rewrite this this("Hearts", "Ace") --> It calls the third constructor down
    }

    public Card(String suit){ // if you have multiple methods with the same name, they have to have different types in params
        setSuit(suit); //can only use one constructor at a time
        setRank(DEFAULT_RANK);
        //Could also write this this(suit, "Ace") b/c it calls on the construction in the constructor below

    }

    public Card(String suit, String rank){
        setSuit(suit);
        setRank(rank);
        createdCount++; //used to pass a new value to the static variable when a new card is created
    }

    public static int getCreatedCount() {
        return createdCount;
    }

    public String getSuit(){ //getter (public method) for suit
        return suit;
    }

    public void setSuit(String suit){ // setter for suit
        this.suit = suit;
    }

    public String getRank(){ // getter for rank
        return rank;
    }

    public void setRank(String rank){ //setter for rank
        this.rank = rank;
    }

    public boolean isFaceUp(){ //use "is" instead of "get" for boolean properties/instance variables
        return faceUp;
    }

    public void setFaceUp(boolean faceUp){
        this.faceUp = faceUp;
    }

    public String getName(){
        return getRank() + " of " + getSuit();
    }

    public void flip(){
        if(isFaceUp()){
            setFaceUp(false);
        }else {
            setFaceUp(true);
        }
        //setFaceUp(!isFaceUp()); --> another way to do this
    }

    public int getValue(){
        return rankValues.get(getRank());
    }

    public boolean isHigherThan(Card otherCard){
        return getValue() > otherCard.getValue();
    }

    public boolean isHigherThan(String rank){
        return this.getValue() > rankValues.get(rank);
    }
    public String toString(){ // very very very common method written into classes
        if(isFaceUp()) {
            return getName();
        }else{
            return "Face Down Card";
        }
    }

    public boolean equals(Object otherObject){ //another super common method written into classes
        boolean result = false;
        if(otherObject instanceof Card) { // make sure other object is a Card
            Card otherCard = (Card) otherObject; //these two objects are equal if...
            result = otherCard.getName().equals(this.getName());//their names are the same
        }
        return result;
    }
// you can make variables "final" --> final int a = 0; so that you can't change their value without throwing a red flag
//if a variable is both static AND final, it's considered a "constant" (see syntax at top of this code)






}
