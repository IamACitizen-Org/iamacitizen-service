package com.iamacitezen.model.impl.rowkey;

public class AnnouncementRowKey {
	
	private String country;
	private String estate;
	private String city;
	private String username;
	
	public AnnouncementRowKey(String country, String estate, String city,
			String username) {
		super();
		this.country = country;
		this.estate = estate;
		this.city = city;
		this.username = username;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}