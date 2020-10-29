package com.techelevator;

import com.techelevator.hotels.models.Hotel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {

    private static final String API_URL = "http://localhost:3000/hotels";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        //delete and catch exceptions
        try {
            restTemplate.delete(API_URL + "/7");
        }catch (ResourceAccessException e){
            System.out.println("Could not connect to the server. Reconnect and try again.");
        } catch (RestClientResponseException exception){
            System.out.println("Connected to server but was unable to complete your request.");
        }

        //update aka put
        Hotel hotelToUpdate = restTemplate.getForObject(API_URL + "/3", Hotel.class); //get the object we want to update
        hotelToUpdate.setName("The Literal Best Hotel On Earth");
        HttpHeaders headers = new HttpHeaders(); //have to create headers to send along with the body
        headers.setContentType(MediaType.APPLICATION_JSON); // set content type header to json
        HttpEntity<Hotel> entity = new HttpEntity<>(hotelToUpdate, headers); //package the body and the headers in one entity
        restTemplate.put(API_URL + "/3", entity); //use rest template to put the entity at the API URL

        //create new resource aka post
        Hotel newHotel = new Hotel(); //create a new hotel and set it's properties
        newHotel.setName("Megan's Shack");
        newHotel.setRoomsAvailable(666);
        newHotel.setStars(3);
        newHotel.setCoverImage("spooky.png");
        //reusing headers created above
        entity = new HttpEntity<>(newHotel, headers); //create new entity to package headers and new hotel object
        newHotel = restTemplate.postForObject(API_URL, entity, Hotel.class); //returns a new hotel so we can store it
        System.out.println(newHotel);


    }
}
