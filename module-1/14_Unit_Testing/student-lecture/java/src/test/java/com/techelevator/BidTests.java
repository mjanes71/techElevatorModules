package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BidTests {

    private static final String BIDDER_NAME = "TestBidder";
    private static final int BID_AMOUNT = 5;

    private Bid sut;

   @Before //creating a new bidder before every test is run so we don't have to put it in the arrange section
   public void setup(){
       sut = new Bid(BIDDER_NAME, BID_AMOUNT);
   }

    @Test
    public void getBidder_returns_bidder_name(){
        //Arrange - have to create a new bid  to test the getter
       // Bid bid = new Bid(BIDDER_NAME, 1);
        //above line is commented out b/c we made the before method which does this in the setup

        //Act - have to create a string to hold the result of the getter
        String bidder = sut.getBidder();
        //Assert - have to see if the String in act is the same as the getter returns
        Assert.assertEquals(BIDDER_NAME, bidder);
    }

    @Test
    public void getBidAmount_returns_bid_amount(){
        //Arrange
        //Bid bid = new Bid(BIDDER_NAME, BID_AMOUNT);
        //above line is commented out b/c we made the before method which does this in the setup

        //Act
        int bidAmount = sut.getBidAmount();

        //Assert

        Assert.assertEquals(BID_AMOUNT, bidAmount);
    }


}
