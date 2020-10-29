package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	public void create(City newCity); // create
	public City findCityById(long id); //read
	public List<City> findCityByCountryCode(String countryCode); //read
	public List<City> findCityByDistrict(String district); //read
	public void update(City city); // update
	public void delete(long id); // delete
}
