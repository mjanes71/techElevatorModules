package com.techelevator;

public class ReserveAuction extends Auction{

   private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice){
        super(itemForSale); //saying that the passed in itemForSale needs to be stored in itemForSale as detailed in the parent class
        //subclass constructor HAS to call superclass constructor
        this.reservePrice = reservePrice;
    }

    @Override //this is a keyword that we write into the code to tell the compiler that we intend to override the superclass method
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;

        if(offeredBid.getBidAmount() >= reservePrice){
            isCurrentWinningBid  = super.placeBid(offeredBid);
        } //this bit of code adds the idea that "we need to decide if the offered bid is the minimum reserve price."
        //if it is, go ahead and place the bid by using the code from the parent class
        return isCurrentWinningBid;

    }

}
