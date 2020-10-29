package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.Scanner;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource(); //object that represents your database
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore"); //connection string (connects your object to a database)
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1"); //Don't make this a habit--use an environment variable or external config file.

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dvdstoreDataSource); //this is how we access Spring framework/the jdbc

		String query = "SELECT first_name, last_name FROM actor WHERE last_name LIKE 'C%';"; //2 semicolons, one to end query and one to end java code line

		SqlRowSet results =  jdbcTemplate.queryForRowSet(query); //this says "hey jdbc template, go run that query on line 23" returns SQL row set -- container/collection that holds the results of the query, created by jdbc

		while (results.next()){
			System.out.println(results.getString("first_name") + " " + results.getString("last_name")); //make sure you selected the fields you want in your query
		}

		System.out.println("-----------------------------------------------------------------------");


		// parameterized query

		String paramQuery = "SELECT first_name, last_name FROM actor WHERE last_name LIKE ?;"; //replace the LIKE with a question mark

		results =  jdbcTemplate.queryForRowSet(paramQuery,"D%"); //pass this a second argument to replace the ? in the query, can change one letter to change the whole return from the while loop

		while (results.next()){
			System.out.println(results.getString("first_name") + " " + results.getString("last_name")); //make sure you selected the fields you want in your query
		}

		System.out.println("-----------------------------------------------------------------------");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter a letter: ");
		String letter = userInput.nextLine().substring(0,1).toUpperCase();

		String paramQuery2 = "SELECT first_name, last_name FROM actor WHERE last_name LIKE ?;"; //replace the LIKE with a question mark

		results =  jdbcTemplate.queryForRowSet(paramQuery2,letter + "%"); //pass this a second argument to replace the ? in the query

		while (results.next()){
			System.out.println(results.getString("first_name") + " " + results.getString("last_name")); //make sure you selected the fields you want in your query
		}

		System.out.println("-----------------------------------------------------------------------");

		//multiple parameters

		String paramQuery3 = "SELECT first_name, last_name FROM actor WHERE last_name LIKE ? AND first_name LIKE ?;"; //replace the LIKE with a question mark

		results =  jdbcTemplate.queryForRowSet(paramQuery3,"D%","E%" ); //pass this a second argument to replace the ? in the query

		while (results.next()){
			System.out.println(results.getString("first_name") + " " + results.getString("last_name")); //make sure you selected the fields you want in your query
		}

		//changing data in the table

		System.out.println("-----------------------------------------------------------------------");

		String updateQuery = "INSERT INTO actor (first_name, last_name) VALUES ('ELLA', 'FOX');";

		jdbcTemplate.update(updateQuery);

		jdbcTemplate.update("DELETE FROM actor WHERE first_name = 'Ella' AND last_name = 'Fox';");


	}
}
