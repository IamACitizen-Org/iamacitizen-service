package com.iamacitezen.datasource.finder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.iamacitezen.model.impl.Announcement;
import com.iamacitizen.core.exception.SerigyDataSourceException;

public class AnnouncementFinderTest {

	@Test
	public void testFindByKeyWhenThereIsARecord()
			throws SerigyDataSourceException, IOException {
		// scenery
		AnnouncementFinder announcementFinder = new AnnouncementFinder();

		// function call
		List<Announcement> announcements = announcementFinder.findAll();
		Announcement announcement = announcements.get(0);
		FileOutputStream f = new FileOutputStream("/Users/manoel/Desktop/my_image.jpg");
		f.write(announcement.getPhoto());
		f.close();

		// asserts
	}

}
