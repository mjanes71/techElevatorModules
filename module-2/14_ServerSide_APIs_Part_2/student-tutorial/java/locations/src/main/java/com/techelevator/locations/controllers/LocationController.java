package com.techelevator.locations.controllers;

import com.techelevator.locations.dao.LocationDAO;
import com.techelevator.locations.exception.LocationNotFoundException;
import com.techelevator.locations.models.Location;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private LocationDAO dao; //new keyword is not used b/c of dependency injection, spring boot creates the object and injects it here

    public LocationController(LocationDAO dao) { //example of dependency injection
        this.dao = dao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Location> list() {
        return dao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Location get(@PathVariable int id) throws LocationNotFoundException {
        return dao.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED) //add this annotation to show status message
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Location add(@Valid @RequestBody Location location) { //add @Valid so it checks the validation annotations in the model class
        return dao.create(location);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Location update(@Valid @RequestBody Location location, @PathVariable int id) throws LocationNotFoundException {
        return dao.update(location, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws LocationNotFoundException {
        dao.delete(id);
    }

}
