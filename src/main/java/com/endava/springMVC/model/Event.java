package com.endava.springMVC.model;

public class Event {
	private int eventId;
	private String name;
	private String description;

	/*
	 * private String logo; private String location; private int nrParticipants;
	 * private int nrMaxParicipants;
	 */
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", name=" + name
				+ ", description=" + description + "]";
	}

	/*
	 * public String getLogo() { return logo; }
	 * 
	 * public void setLogo(String logo) { this.logo = logo; }
	 * 
	 * public String getLocation() { return location; }
	 * 
	 * public void setLocation(String location) { this.location = location; }
	 * 
	 * public int getNrParticipants() { return nrParticipants; }
	 * 
	 * public void setNrParticipants(int nrParticipants) { this.nrParticipants =
	 * nrParticipants; }
	 * 
	 * public int getNrMaxParicipants() { return nrMaxParicipants; }
	 * 
	 * public void setNrMaxParicipants(int nrMaxParicipants) {
	 * this.nrMaxParicipants = nrMaxParicipants; }
	 */
}