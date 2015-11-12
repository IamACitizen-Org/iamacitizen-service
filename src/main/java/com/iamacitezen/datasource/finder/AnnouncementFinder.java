package com.iamacitezen.datasource.finder;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Row;
import com.google.common.base.Preconditions;
import com.iamacitezen.datasource.finder.rowmapper.AnnouncementRowMapper;
import com.iamacitezen.model.impl.Announcement;
import com.iamacitizen.core.datasource.finder.cassandra.CassandraFinder;

public class AnnouncementFinder extends CassandraFinder<Announcement, UUID> {

	private AnnouncementRowMapper rowMapper;

	public AnnouncementFinder() {
		rowMapper = new AnnouncementRowMapper();
	}

	public Announcement mapRow(Row row) {
		return rowMapper.mapRow(row);
	}

	@Override
	protected String getfindSQL() {
		return "SELECT * FROM iamacitizen.announcement WHERE announcement_id = ?;";
	}

	@Override
	protected String getfindAllSQL() {
		return "SELECT * FROM iamacitizen.announcement;";
	}

	@Override
	protected String getfindByFilterSQL(Announcement filter) {
		Preconditions.checkNotNull(filter);
		Preconditions.checkNotNull(filter.getCountry());

		StringBuilder CQL = new StringBuilder("SELECT * FROM iamacitizen.announcement WHERE country = ? ");
		
		if (filter.getState() != null) {
			CQL.append(" AND state = ? ");
		}
		
		if (filter.getCity() != null) {
			CQL.append(" AND city = ? ");
		}

		return CQL.toString();
	}

	@Override
	protected void setFindParameters(BoundStatement bs, UUID key) {
		bs.bind(key);
	}

	@Override
	protected void setFindByFilterParameters(BoundStatement bs,
			Announcement filter) {
		Preconditions.checkNotNull(filter);
		Preconditions.checkNotNull(filter.getCountry());
		
		bs.bind(filter.getCountry());
		
		if (filter.getState() != null) {
			bs.bind(filter.getState());
		}
		
		if (filter.getCity() != null) {
			bs.bind(filter.getCity());
		}
	}

}
