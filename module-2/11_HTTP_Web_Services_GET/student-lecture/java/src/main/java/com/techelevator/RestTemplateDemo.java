package com.techelevator;

import com.techelevator.hotels.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(); //doesn't need a datasource, unlike jdbc template

       ResponseEntity<String> response =  restTemplate.getForEntity("http://localhost:3000/hotels/3", String.class); //this method gets everything back, params are address and how you want it to be formatted (__.class)
        //response entity object stores the response (similar to sqlrowset)
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());


        ResponseEntity<Hotel> response2 =  restTemplate.getForEntity("http://localhost:3000/hotels/3", Hotel.class);
        System.out.println(response2.getStatusCode());
        Hotel myHotel = response2.getBody(); // create a hotel object from the contents of that server resource
        System.out.println(myHotel.getName()); // now i can get really specific info from that json object

        myHotel = restTemplate.getForObject("http://localhost:3000/hotels/2", Hotel.class); // if you just want to create an object from the resource at an address
        System.out.println(myHotel.getName());
        System.out.println(myHotel.getRoomsAvailable());
    }
}
