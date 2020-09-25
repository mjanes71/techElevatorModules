package com.techelevator;


import com.techelevator.playingcards.Card;

public class Lecture {

    public static void main(String[] args) {

        Card myCard = new Card(); // just created a new Card object from Card class
        myCard.setSuit("Hearts"); //call public setter method
        myCard.setRank("Ace");

        System.out.println(myCard.getSuit()); //call public getter method
        System.out.println(myCard.getRank());

        myCard.setFaceUp(true);

        Card yourCard = new Card(); //create another card object, same class
        yourCard.setFaceUp(true);
        yourCard.setSuit("Spades");
        yourCard.setRank("Jack");

        if(myCard.isFaceUp()){
            System.out.println("My Card is face up");
        } else {
            System.out.println("My Card is face down");
        }

        System.out.println(myCard.getName());
        System.out.println(yourCard.getName());

        myCard.flip();

        System.out.println(myCard.isFaceUp());

        System.out.println("My card has a value of " + myCard.getValue());

        System.out.println(yourCard.getValue());

        System.out.println(myCard.isHigherThan(yourCard));

        Card anotherCard = new Card ("Spades"); // can declare suit here b/c of the second constructor

        System.out.println(myCard); //everything that system.out.println puts out is a string, so it knows to look for the toString method



    }
}
