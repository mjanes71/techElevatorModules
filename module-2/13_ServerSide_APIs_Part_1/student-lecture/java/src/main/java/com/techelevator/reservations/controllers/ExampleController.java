package com.techelevator.reservations.controllers;

import com.techelevator.reservations.models.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/greeting")
public class ExampleController {

    @RequestMapping (method = RequestMethod.GET) //this annotation used to tell the server that this method takes requests when the path greeting is requested
    public String sayHello(){
        return "Hello from the Spring Framework.";
    }

    @RequestMapping (method = RequestMethod.DELETE)
    public String questionIntentions(){
        return "Why do you want me gone?";
    }

    @RequestMapping (path = "/address", method = RequestMethod.GET)
    public Address getAnAddress(){
        Address address = new Address ("1101 Hamilton Ave","Oakhurst Complex","Hamilton", "Ohio", "45041");
        return address;
    }


}
