package com.iamacitezen.service.impl;

import java.util.List;
import java.util.UUID;

import com.iamacitezen.datasource.finder.AnnouncementFinder;
import com.iamacitezen.datasource.mapper.AnnouncementMapper;
import com.iamacitezen.model.impl.Announcement;
import com.iamacitezen.service.api.IAnnouncementService;
import com.iamacitizen.core.exception.SerigyBusinessException;
import com.iamacitizen.core.exception.SerigyDataSourceException;

public class AnnouncementService implements IAnnouncementService {
	
	private AnnouncementFinder finder = new AnnouncementFinder();
	private AnnouncementMapper mapper = new AnnouncementMapper();

	public Announcement insert(Announcement domainObject)
			throws SerigyBusinessException, SerigyDataSourceException {
		mapper.insert(domainObject);
		return domainObject;
	}

	public int update(Announcement domainObject)
			throws SerigyBusinessException, SerigyDataSourceException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Announcement domainObject)
			throws SerigyBusinessException, SerigyDataSourceException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Announcement find(UUID key) throws SerigyBusinessException,
			SerigyDataSourceException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Announcement> findAll() throws SerigyBusinessException,
			SerigyDataSourceException {
		return finder.findAll();
	}

	public List<Announcement> findByFilter(Announcement filter)
			throws SerigyBusinessException, SerigyDataSourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
