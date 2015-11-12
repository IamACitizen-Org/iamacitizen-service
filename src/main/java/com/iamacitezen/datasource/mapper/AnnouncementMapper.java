package com.iamacitezen.datasource.mapper;

import java.nio.ByteBuffer;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.iamacitezen.model.impl.Announcement;
import com.iamacitizen.core.database.cassandra.CassandraDatabase;
import com.iamacitizen.core.datasource.mapper.cassandra.CassandraMapper;

public class AnnouncementMapper extends CassandraMapper<Announcement, UUID> {

	@Override
	protected void setInsertParameters(BoundStatement bs,
			Announcement announcement) {
		bs.setUUID(0, CassandraDatabase.getTimeUUID());
		bs.setString(1, announcement.getCountry());
		bs.setString(2, announcement.getState());
		bs.setString(3, announcement.getCity());
		bs.setString(4, announcement.getUsername());
		bs.setString(5, announcement.getAnnouncementType());
		bs.setString(6, announcement.getTitle());
		bs.setString(7, announcement.getDescription());
		bs.setString(8, announcement.getInstitutionArea());
		bs.setString(9, announcement.getInstitutionType());
		bs.setString(10, announcement.getInstitution());
		bs.setBytes(11,	ByteBuffer.wrap(announcement.getPhoto()));
	}

	@Override
	protected void setUpdateParameters(BoundStatement bs,
			Announcement announcement) {
		bs.setString(0, announcement.getCountry());
		bs.setString(1, announcement.getState());
		bs.setString(2, announcement.getCity());
		bs.setString(3, announcement.getUsername());
		bs.setString(4, announcement.getAnnouncementType());
		bs.setString(5, announcement.getTitle());
		bs.setString(6, announcement.getDescription());
		bs.setString(7, announcement.getInstitutionArea());
		bs.setString(8, announcement.getInstitutionType());
		bs.setString(9, announcement.getInstitution());
		bs.setBytes(10, ByteBuffer.wrap(announcement.getPhoto()));
		bs.setUUID(11, announcement.getKey().getValue());
	}

	@Override
	protected void setDeleteParameters(BoundStatement bs,
			Announcement announcement) {
		bs.bind(announcement.getKey());
	}

	@Override
	protected String getInsertSQL() {
		StringBuilder CQL = new StringBuilder(
				"INSERT INTO iamacitizen.announcement(announcement_id, country, ");
		CQL.append("state, city, username, announcement_type, ");
		CQL.append("title, description, institution_area, ");
		CQL.append("institution_type, institution, photo, when_created) ");
		CQL.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())");

		return CQL.toString();
	}

	@Override
	protected String getUpdateSQL() {
		StringBuilder CQL = new StringBuilder(
				"UPDATE iamacitizen.announcement SET country = ?, ");
		CQL.append("state = ?, city = ?, username = ?, ");
		CQL.append("announcement_type = ?, title = ?, description = ?, ");
		CQL.append("institution_area = ?, institution_type = ?, institution = ?, photo = ?,");
		CQL.append("when_created = now() WHERE announcement_id = ? ");

		return CQL.toString();
	}

	@Override
	protected String getDeleteSQL() {
		return "DELETE FROM iamacitizen.announcement WHERE announcement_id = ? ";
	}

}
