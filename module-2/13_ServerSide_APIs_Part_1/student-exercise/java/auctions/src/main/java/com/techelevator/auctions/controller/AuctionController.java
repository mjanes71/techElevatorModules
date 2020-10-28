package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuctionController {

    private final AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

    @RequestMapping (path = "/auctions", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "", name = "title_like") String titleLike,
                              @RequestParam(defaultValue = "0" , name = "currentBid_lte") double currentBid) {
       if(titleLike.equals("") && currentBid == 0){
           return dao.list();
       }else if (currentBid > 0 && titleLike.length()>=1){
           return dao.searchByTitleAndPrice(titleLike,currentBid);
       }
       else if (titleLike.equals("")) {
           return dao.searchByPrice(currentBid);
       }else {
           return dao.searchByTitle(titleLike);
       }
    }

    @RequestMapping (path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id){
        return dao.get(id);

    }

    @RequestMapping (path = "/auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction newAuction){
        return dao.create(newAuction);
    }


}
