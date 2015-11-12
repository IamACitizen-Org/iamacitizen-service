package com.iamacitezen.datasource.finder.rowmapper;

import java.nio.ByteBuffer;
import java.util.UUID;

import com.datastax.driver.core.Row;
import com.iamacitezen.model.impl.Announcement;
import com.iamacitizen.core.datasource.finder.cassandra.CassandraRowMapper;
import com.iamacitizen.core.model.KeyIdentity;

public class AnnouncementRowMapper implements
		CassandraRowMapper<Announcement, UUID> {

	public Announcement mapRow(Row row) {
		String country = row.getString("country");
		String state = row.getString("state");
		String city = row.getString("city");
		String username = row.getString("username");
		UUID announcement_id = row.getUUID("announcement_id");
		String announcement_type = row.getString("announcement_type");
		String title = row.getString("title");
		String description = row.getString("description");
		String institution_area = row.getString("institution_area");
		String institution_type = row.getString("institution_type");
		String institution = row.getString("institution");
		UUID when_created = row.getUUID("when_created");
		ByteBuffer photo = row.getBytes("photo");

		Announcement announcement = new Announcement();
		announcement.setCountry(country);
		announcement.setState(state);
		announcement.setCity(city);
		announcement.setUsername(username);
		announcement.setKey(new KeyIdentity<UUID>(announcement_id));
		announcement.setAnnouncementType(announcement_type);
		announcement.setTitle(title);
		announcement.setDescription(description);
		announcement.setInstitutionArea(institution_area);
		announcement.setInstitutionType(institution_type);
		announcement.setInstitution(institution);
		announcement.setWhenCreated(when_created);
		
		if (photo != null) {
			byte[] bytes = new byte[photo.remaining()];
			photo.get(bytes);
			announcement.setPhoto(bytes);
		}

		return announcement;
	}

}
