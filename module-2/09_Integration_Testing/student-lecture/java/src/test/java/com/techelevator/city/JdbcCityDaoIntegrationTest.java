package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


public class JdbcCityDaoIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JdbcCityDao sut;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass //only gets run once before all tests in this class
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass //only gets run once after all tests in this class
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before //runs before every test
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update("TRUNCATE country CASCADE"); //remove existing data

		String sqlInsertCountry = "INSERT INTO country " +
			"(code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold," +
				" localname, governmentform, headofstate, capital, code2)" +
			"VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL," +
				"'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', NULL, 'AF')";

		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		
		sut = new JdbcCityDao(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After //runs after every test
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback(); //rollback occurs every test (each test is its own transaction)
	}

	@Test //tests create and retrieve by id methods from jdbcCityDAO
	public void new_city_can_be_created_and_retrieved(){
		//ARRANGE
		City testCity = new City(); //just creates a city object
		testCity.setName("Testville");
		testCity.setDistrict("Testdistrict");
		testCity.setPopulation(1);
		testCity.setCountryCode(TEST_COUNTRY);

		//ACT
		sut.create(testCity); //now we use the jdbcCityDAO methods that we want to test (testing the method to create)
		City retrievedCity = sut.findCityById(testCity.getId());

		//ASSERT
		Assert.assertEquals(testCity.getName(), retrievedCity.getName());
		Assert.assertEquals(testCity.getCountryCode(), retrievedCity.getCountryCode());
		Assert.assertEquals(testCity.getDistrict(), retrievedCity.getDistrict());
		Assert.assertEquals(testCity.getPopulation(), retrievedCity.getPopulation());
	}

	private City createTestCity(){
		City testCity = new City();
		testCity.setName("Testville");
		testCity.setDistrict("Testdistrict");
		testCity.setPopulation(1);
		testCity.setCountryCode(TEST_COUNTRY);
		return testCity;
	}

	 @Test
	public void all_city_info_is_updated_correctly (){ //tests update method and create method and retrieve method
		//Arrange
		 City testCity = createTestCity(); //create city object
		 sut.create(testCity); //use jdbc create method to create the test city in the database

		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); //use jdbc template to add a new country to test country code update
		 String sqlInsertCountry = "INSERT INTO country " +
				 "(code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold," +
				 " localname, governmentform, headofstate, capital, code2)" +
				 "VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL," +
				 "'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', NULL, 'AF')";
		 jdbcTemplate.update(sqlInsertCountry, "ABC");

		 //Act
		 testCity.setName("New Name"); //change testcity object info after it's been added to database
		 testCity.setDistrict("New District");
		 testCity.setPopulation(123);
		 testCity.setCountryCode("ABC");
		 sut.update(testCity); //update database with new info

		 //Assert
		 City retrievedCity = sut.findCityById(testCity.getId()); //retrieve new city created from testcity info in database
		 assertCitiesAreEqual(testCity, retrievedCity); //check test city object equals retrieved city

	 }

	 private void assertCitiesAreEqual(City expected, City actual){
		 Assert.assertEquals(expected.getName(), actual.getName());
		 Assert.assertEquals(expected.getCountryCode(), actual.getCountryCode());
		 Assert.assertEquals(expected.getDistrict(), actual.getDistrict());
		 Assert.assertEquals(expected.getPopulation(), actual.getPopulation());
	 }

	 @Test
	public void city_is_deleted(){ //uses create city and find id methods to test delete city
		//Arrange
		 City testCity = createTestCity();
		 sut.create(testCity);

		 //Act

		 sut.delete(testCity.getId());

		 //Assert
		 City retrievedCity = sut.findCityById(testCity.getId()); //create new city by using findCityById method and passing it the testCity id we created)
		 Assert.assertNull(retrievedCity); //should be null because that city id should have been deleted
	 }

	@Test
	public void all_cities_for_countrycode_are_retrieved(){ //testing find city by countrycode method
		//Arrange
		for (int i = 0; i < 100; i ++){ //create 100 cities with the same countrycode but with diff names and populations
			City testCity = createTestCity();
			testCity.setName("Test City " + i);
			testCity.setPopulation(i);
			sut.create(testCity);
		}

		//Act
		List<City> results = sut.findCityByCountryCode(TEST_COUNTRY); //create a city list using the method under test

		//Assert
		Assert.assertEquals(100, results.size());
		for (int i = 0; i < 100; i++){
			City testCity = results.get(i); //iterate through the created list
			Assert.assertEquals("Test City " + i, testCity.getName()); //do the names match?
			Assert.assertEquals(i, testCity.getPopulation());//do the populations match?
		}
	}

	@Test
	public void all_cities_for_district_are_found() {
		//Arrange
		List<City> citiesInDistrict = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			City testCity = createTestCity();
			testCity.setName("Test City " + i);
			testCity.setDistrict("Target District");
			citiesInDistrict.add(testCity);
			sut.create(testCity);
		}
		sut.create(createTestCity()); // create one extra city so that we know we are ONLY getting back 50 cities with the same district (not 51)

		//Act

		List<City> results = sut.findCityByDistrict("Target District");

		//Assert
		Assert.assertEquals(50, results.size());

		for (City expected : citiesInDistrict) { //probably never do this
			boolean cityFound = false;
			for (City actual : results) {
				if (expected.getName().equals(actual.getName())) {
					cityFound = true;
					break;
				}
			}
			Assert.assertTrue(cityFound);
		}
	}

	@Test(expected = RuntimeException.class)
	public void updating_nonexistent_city_throws_exception(){
		//Arrange
		City testCity = createTestCity();
		//Act
		sut.update(testCity);
		//Assert
		//RuntimeException is expected above.
	}
}
