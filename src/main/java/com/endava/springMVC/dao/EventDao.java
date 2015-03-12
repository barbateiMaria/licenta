package com.endava.springMVC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.endava.springMVC.mappers.EventRowMapper;
import com.endava.springMVC.model.Event;

public class EventDao {
	
	@Autowired
	DataSource dataSource;
	
	public void addEvent(String name, String description) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "insert into events(name, description) values (?, ?)";
		jdbcTemplate.update(sql, new Object[] {name, description}, new EventRowMapper());
	}
	
	public List<Event> getAll() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "select * from events";
		List<Event> allEvents = jdbcTemplate.query(sql, new EventRowMapper());
		return allEvents;
	}
	
	
}
