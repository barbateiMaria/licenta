package com.endava.springMVC.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.endava.springMVC.model.Event;

public class EventRowMapper implements RowMapper<Event> {

	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
		Event ev = new Event();
		ev.setEventId(rs.getInt(1));
		ev.setName(rs.getString(2));
		ev.setDescription(rs.getString(3));
		
		return ev;
	}

}
