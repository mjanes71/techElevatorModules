package com.techelevator.reservations.models;

import com.techelevator.reservations.dao.HotelDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.*;

public class Reservation {


    @Autowired
    private HotelDAO hotelDAO;

    private int id;
    @Min(value = 1, message = "The hotel id field is required you goose.")
    private int hotelID;
    @NotBlank(message = "Make sure you provide a name for the reservation you goose.")
    private String fullName;
    @NotBlank (message = "Make sure you provide a check-in date you goose.")
    private String checkinDate;
    @NotBlank (message = "Make sure you provide a check-out date you goose.")
    private String checkoutDate;
    @Min (value = 1, message = "There must be at least one guest to make a reservation.")
    @Max(value = 5, message = "This hotel only has rooms that can accommodate up to 5 people.")
    private int guests;

    @AssertTrue
    private boolean hotelIdIsValid(){
        for(Hotel hotel : hotelDAO.list()){
            if (hotel.getId() == hotelID){
                return true;
            }
        }
        return false;
    }

    public Reservation() {

    }

    public Reservation(int id, int hotelID, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelID = hotelID;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelID
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
