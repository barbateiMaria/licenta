package com.endava.springMVC.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.endava.springMVC.model.NavigationBar;

public class NavigationBarRowMapper implements RowMapper<NavigationBar>{

	public NavigationBar mapRow(ResultSet rs, int arg1) throws SQLException {
		NavigationBar navBar = new NavigationBar();
		navBar.setId(rs.getInt(1));
		navBar.setContent(rs.getString(2));
		navBar.setUsed(rs.getBoolean(3));
		return navBar;
	}

}
