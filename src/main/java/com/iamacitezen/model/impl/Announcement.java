package com.iamacitezen.model.impl;

import java.util.UUID;

import com.iamacitezen.model.api.IAnnouncement;
import com.iamacitizen.core.model.DomainObject;

public class Announcement extends DomainObject<UUID> implements IAnnouncement {

	private String country;
	private String state;
	private String city;
	private String username;
	private String announcementType;
	private String title;
	private String description;
	private String institutionArea;
	private String institutionType;
	private String institution;
	private UUID whenCreated;
	private byte[] photo;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getAnnouncementType() {
		return announcementType;
	}

	public void setAnnouncementType(String announcementType) {
		this.announcementType = announcementType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstitutionArea() {
		return institutionArea;
	}

	public void setInstitutionArea(String institutionArea) {
		this.institutionArea = institutionArea;
	}

	public String getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public UUID getWhenCreated() {
		return whenCreated;
	}

	public void setWhenCreated(UUID whenCreated) {
		this.whenCreated = whenCreated;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
