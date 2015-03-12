package com.endava.springMVC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.endava.springMVC.mappers.NavigationBarRowMapper;
import com.endava.springMVC.model.NavigationBar;
@Repository
public class NavBarDao {

	@Autowired
	DataSource dataSource;

	public List<NavigationBar> getAllNavBarElements() {
		String sql = "SELECT * from navBar";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<NavigationBar> navBarElements = jdbcTemplate.query(sql,
				new NavigationBarRowMapper());
		return navBarElements;
	}

	public List<NavigationBar> getChosenNavBarElements() {
		String sql = "SELECT * from navBar where used = 1";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<NavigationBar> navBarElements = jdbcTemplate.query(sql,
				new NavigationBarRowMapper());
		return navBarElements;
	}

	public void setUsedNavBarElements(String navBarElementFromRequest) {
		List<NavigationBar> list = getAllNavBarElements();
		for (NavigationBar navBarElem : list) {
			if (navBarElem.equals(navBarElementFromRequest)) {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				String sql = "update navBar set used = ? where content = ?";
				jdbcTemplate.update(sql, new Object[] {1,
						navBarElementFromRequest});
			}
		}
	}
}
