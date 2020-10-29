package com.techelevator.auctions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.exception.AuctionNotFoundException;
import com.techelevator.auctions.model.Auction;

import javax.validation.Valid;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController(AuctionDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "", name = "title_like") String searchTerm,
                              @RequestParam(defaultValue = "0", name = "currentBid_lte") double maxPrice) {

        if( !searchTerm.equals("") ) {
            return dao.searchByTitle(searchTerm);
        }
        if(maxPrice > 0) {
            return dao.searchByPrice(maxPrice);
        }

        return dao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) throws AuctionNotFoundException {
        return dao.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@Valid @RequestBody Auction auction) {
        return dao.create(auction);
    }

    @PutMapping(path = "/{id}")
    public Auction update(@Valid @RequestBody Auction auctionToUpdate, @PathVariable int id) throws AuctionNotFoundException{
        return dao.update(auctionToUpdate, id);
    }

    @DeleteMapping (path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) throws AuctionNotFoundException{
        dao.delete(id);
    }




}