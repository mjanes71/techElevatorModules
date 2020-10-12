package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuctionTests {

    @Before


    @Test
    public void higher_bid_wins_regardless_of_order_placed(){
        //Arrange
        Auction sut = new Auction("ThingforSale");
        sut.placeBid(new Bid("Person 1", 100));
        sut.placeBid(new Bid("Person 2", 50));

        //Act
        Bid winningBid = sut.getHighBid();

        //Assert
        Assert.assertEquals("Person 1", winningBid.getBidder());
    }

}
