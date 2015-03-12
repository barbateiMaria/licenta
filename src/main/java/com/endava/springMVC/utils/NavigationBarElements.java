package com.endava.springMVC.utils;

public enum NavigationBarElements {
	HOME("Home"), REGISTER("Register"), CONTACT("Contact"), SPEAKERS("Speakers"), LOCATION("Location"); 
	 
	private String statusCode;
 
	private NavigationBarElements(String s) {
		statusCode = s;
	}
 
	public String getStatusCode() {
		return statusCode;
	}
  
}
