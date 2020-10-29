package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private final HotelDAO hotelDAO;
    private final ReservationDAO reservationDAO;

    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);
    }

    @RequestMapping (path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> getAllHotels (@RequestParam(defaultValue = "0", name = "star_rating") int stars,
                                    @RequestParam(defaultValue = "true", name = "has_rooms") boolean roomsAvailable) { //request param name is what the query parameter woudl be called
        if (stars == 0){
            return hotelDAO.list();
        }else {
            List<Hotel> filteredList = new ArrayList<>();
            for (Hotel hotel : hotelDAO.list()){
                if (hotel.getStars() == stars){
                    filteredList.add(hotel);
                }
            }
            return filteredList;
        }
    }

    @RequestMapping (path = "/hotels/{id}", method = RequestMethod.GET) //example of path variable
    public Hotel getHotel(@PathVariable int id){ //have to add pathvariable annotation and add variable in the path
        return hotelDAO.get(id);
    }

    @RequestMapping (path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservationsForHotel(@PathVariable int id){
        return reservationDAO.findByHotel(id);
    }

    @RequestMapping (path = "/reservations", method = RequestMethod.POST)
    public Reservation createNewReservation(@RequestBody Reservation newReservation){ //body annotation (used to pull things out of the body of post and put methods
        return reservationDAO.create(newReservation, newReservation.getHotelID());
    }


}
