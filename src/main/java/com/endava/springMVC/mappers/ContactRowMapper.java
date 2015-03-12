package com.endava.springMVC.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.endava.springMVC.model.Contact;

public class ContactRowMapper implements RowMapper<Contact>{

	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getInt(1));
		contact.setContent(rs.getString(2));
		return contact;
	}
	
}
