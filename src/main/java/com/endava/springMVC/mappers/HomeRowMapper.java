package com.endava.springMVC.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.endava.springMVC.model.Home;

public class HomeRowMapper implements RowMapper<Home>{

	public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
		Home home = new Home();
		home.setId(rs.getInt(1));
		home.setContent(rs.getString(2));
		return home;
	}

}
