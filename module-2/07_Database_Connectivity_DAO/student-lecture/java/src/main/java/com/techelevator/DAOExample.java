package com.techelevator;
import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JdbcCityDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ArrayList;
import java.util.List;

public class DAOExample {

    public static void main(String[] args) {

        BasicDataSource worldDataSource = new BasicDataSource();
        worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world"); //connection string (connects your object to a database)
        worldDataSource.setUsername("postgres");
        worldDataSource.setPassword("postgres1");


        CityDAO cityDAO = new JdbcCityDAO(worldDataSource);

//        City myCity = cityDAO.findCityById(139); //calls findCityByID method from jdbcCityDAO
//        System.out.println(myCity.getName());

        List<City> usaCities = cityDAO.findCityByCountryCode("USA"); // calls findCityByCountryCode method from jdbcCityDAO
        for (City c : usaCities){
            System.out.println(c.getName() + ", " + c.getDistrict());
        }

        List<City> ohioCities = cityDAO.findCityByDistrict("Ohio");
        for(City c : ohioCities){
            System.out.println(c.getName() + ", " + c.getDistrict());

        }


    }
}
