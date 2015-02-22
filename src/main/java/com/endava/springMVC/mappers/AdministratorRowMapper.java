package com.endava.springMVC.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.endava.springMVC.model.Administrator;


public class AdministratorRowMapper implements RowMapper<Administrator>{
	//@Override
	public Administrator mapRow(ResultSet rs, int arg1) throws SQLException {
		Administrator admin = new Administrator();
		admin.setId(rs.getInt(1));
		admin.setFirstName(rs.getString(2));
		admin.setLastName(rs.getString(3));
		admin.setEmail(rs.getString(4));
		admin.setUserName(rs.getString(5));
		admin.setPassword(rs.getString(6));
		
		return admin;
	}
}
