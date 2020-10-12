package com.techelevator;

public class Lecture {

    public static void main(String[] args) {

        Bid myBid = new Bid("Megan", 100);

        Auction firstAuction = new Auction("The Krusty Krab");
        System.out.println(firstAuction.getHighBid().getBidAmount());
        //prints high bid of zero because constructor sets starting high bid to zero

        firstAuction.placeBid(myBid);
        System.out.println("The high bidder on " + firstAuction.getItemForSale() + " is " + firstAuction.getHighBid().getBidder());
        //prints The high bidder on The Krusty Krab is Megan.

        firstAuction.placeBid(new Bid("Plankton", 5000));
        firstAuction.placeBid(new Bid("Ross", 1000));
        //can create new bids inside the place bid method (just not stored in a variable)

        System.out.println("The high bidder on " + firstAuction.getItemForSale() + " is " + firstAuction.getHighBid().getBidder());

        System.out.println("----------------- New Stuff With Inheritance--------------------------------");

        ReserveAuction secondAuction = new ReserveAuction("Old Shoes", 50);

        secondAuction.placeBid(new Bid("Joe", 25)); // because of new bid override, Joe's bid won't be placed
        secondAuction.placeBid(new Bid("Squidward", 51));

        System.out.println("The high bidder on " + secondAuction.getItemForSale() + " is " + secondAuction.getHighBid().getBidder());

        System.out.println("----------------- New Stuff With Second Inheritance--------------------------------");

        BuyoutAuction thirdAuction = new BuyoutAuction("Ford Pinto", 100);

        thirdAuction.placeBid(new Bid("TomCat", 50));
        thirdAuction.placeBid(new Bid("Moneybags", 101));
        thirdAuction.placeBid(new Bid("TooLate", 102)); //can't win because we wrote in that if the auction was already over, you don't get to place your bid



        System.out.println("The high bidder on " + thirdAuction.getItemForSale() + " is " + thirdAuction.getHighBid().getBidder());



    }
}
