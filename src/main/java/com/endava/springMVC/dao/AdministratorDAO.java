package com.endava.springMVC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.endava.springMVC.mappers.AdministratorRowMapper;
import com.endava.springMVC.model.Administrator;

@Repository
public class AdministratorDAO {
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private static final String TABLE_NAME = "administrators";

	public List<Administrator> getAll() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Administrator> all = jdbcTemplate.query("select * from "
				+ TABLE_NAME, new AdministratorRowMapper());
		return all;
	}

	/*
	 * public void findUserById(int userId) { JdbcTemplate jdbcTemplate = new
	 * JdbcTemplate(dataSource); String sql =
	 * "select * from users where id = ?"; User all =
	 * (User)jdbcTemplate.queryForObject(sql, new Object[] { userId}, new
	 * UserRowMapper()); if(all != null) {
	 * System.out.println("I have found the user"); } else {
	 * System.out.println("The user is nowhere to find in the DB !!!"); return;
	 * }
	 * 
	 * }
	 */

	public Administrator login(String userName, String password) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "Select * from " + TABLE_NAME
				+ " where username = ? and password = ?";

		try {
			Administrator all = (Administrator) jdbcTemplate.queryForObject(
					sql, new Object[] { userName, password },
					new AdministratorRowMapper());
			return all;
		} catch (Exception e) {
			System.out.println("Unsuccessful user authentification. "
					+ e.getMessage());
			return null;
		}
	}

	public void signUp(String firstName, String lastName, String userName,
			String email, String password) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into administrators(firstname, lastname, username, email, password) values(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { firstName, lastName, userName,
				email, password });

	}
	
	/*public static void main(String[] args) {
		 AdministratorDAO adminDao = new AdministratorDAO();
		 adminDao.signUp("daa", "dasda","dad", "dada", "1234");
	      
	}*/
}
