package com.techelevator;

/**
 * Bookstore
 */
public class Bookstore {

    public static void main(String[] args) {

        System.out.println("Welcome to the Tech Elevator Bookstore");
        System.out.println();

        // Step Three: Test the getters and setters
        Book twoCities = new Book();
        twoCities.setTitle("A Tale of Two Cities");;
        twoCities.setAuthor("Charles Dickens");
        twoCities.setPrice(14.99);
        System.out.println(twoCities.bookInfo());

        // Step Five: Test the Book constructor
        Book threeMuskateers = new Book("The Three Muskateers", "Alexandre Dumas", 12.95);

        Book childhoodEnd = new Book("childhood's End", "Arthur C. Clark", 5.99);

        System.out.println(threeMuskateers.bookInfo());
        System.out.println(childhoodEnd.bookInfo());

        // Step Nine: Test the ShoppingCart class
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(twoCities);
        shoppingCart.add(threeMuskateers);
        shoppingCart.add(childhoodEnd);
        System.out.println(shoppingCart.receipt());
    }
}