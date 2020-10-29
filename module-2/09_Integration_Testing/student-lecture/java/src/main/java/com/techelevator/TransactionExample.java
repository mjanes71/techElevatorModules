package com.techelevator;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionExample {

	private static JdbcTemplate jdbcTemplate;


	public static void main(String[] args) throws SQLException {
		
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource(); //this is not a connection pool, just one connection
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
		dataSource.setAutoCommit(false);//if you don't say anything here, autocommit is defaulted to true

		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update("UPDATE actor SET first_name = 'Megan';");

		jdbcTemplate.update("TRUNCATE actor CASCADE;"); //WIPES OUT ALL RECORDS AND ANYTHING THAT DEPENDS ON THEM IN OTHER TABLES

		displayActorNames(); //display before rollback

		Connection currentConnection = dataSource.getConnection(); //have to get current connection to use rollback method
		currentConnection.rollback(); //tells the open transaction to rollback, closing off this bubble from the data table - would use .commit() if you wanted to commit instead of rollback

		displayActorNames(); //display after rollback
					
		dataSource.destroy();//close the datasource when done
	}

		public static void displayActorNames(){
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT first_name, last_name FROM actor;");

			while (rowSet.next()) {
				String firstName = rowSet.getString("first_name");
				String lastName = rowSet.getString("last_name");
				System.out.println(firstName + " " + lastName);
			}

		}

}
