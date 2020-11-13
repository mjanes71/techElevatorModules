package com.techelevator.cart;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class CartJdbcDao implements CartDao {

	private JdbcTemplate jdbcTemplate;

	public CartJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void save(Cart newCart) {
		String sql = "INSERT INTO carts (username, cookie_value, created) VALUES (?, ?, ?);";
		jdbcTemplate.update(sql, newCart.getUsername(), newCart.getCookieValue(), newCart.getCreated());

	}

	@Override
	public List<Cart> getAllCarts() {
		List<Cart> listOfCarts = new ArrayList<>();
		String sql = "SELECT id, username, cookie_value, created FROM carts;";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		while (rowSet.next()){
			Cart myCart = mapRowToCart(rowSet);
			listOfCarts.add(myCart);
		}

		return listOfCarts;
	}

	private Cart mapRowToCart(SqlRowSet results) {
		Cart cartRow = new Cart();
		cartRow.setId(results.getLong("id"));
		cartRow.setUsername(results.getString("username"));
		cartRow.setCookieValue(results.getString("cookie_value"));
		cartRow.setCreated(results.getDate("created").toLocalDate());
		return cartRow;
	}

}
