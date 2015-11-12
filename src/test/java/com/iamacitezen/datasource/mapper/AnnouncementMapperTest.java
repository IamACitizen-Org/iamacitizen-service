package com.iamacitezen.datasource.mapper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import org.testng.annotations.Test;

import com.iamacitezen.model.impl.Announcement;
import com.iamacitizen.core.model.KeyIdentity;

public class AnnouncementMapperTest {

	/*
	 * 
	 * CREATE TABLE announcement ( announcement_id uuid PRIMARY KEY, country
	 * text, state text, city text, username text, announcement_type text, title
	 * text, description text, institution_area text, institution_type text,
	 * institution text, when_created timeuuid, photo blob );
	 */

	@Test
	public void testUpdate() throws IOException {
		// scenery

		File file = new File(
				"/Users/manoel/Desktop/166622_107695839305481_2793838_n.jpg");
		
//		//Read the file to a BufferedImage  
//		BufferedImage image = ImageIO.read(file); 
//
//		//Create a file for the output  
//		File output = new File("/Users/manoel/Desktop/166622_107695839305481_2793838_n.bmp");  
//		  
//		//Write the image to the destination as a BMP  
//		ImageIO.write(image, "bmp", output); 
//		
//		file = new File("/Users/manoel/Desktop/166622_107695839305481_2793838_n.bmp");
		
		FileInputStream fis = new FileInputStream(file);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		for (int readNum; (readNum = fis.read(buf)) != -1;) {
			bos.write(buf, 0, readNum);
		}

		byte[] bytes = bos.toByteArray();
		bos.close();
		fis.close();

		Announcement announcement = new Announcement();
		announcement.setAnnouncementType("oficial");
		announcement.setCity("Aracaju");
		announcement.setCountry("Brasil");
		announcement.setState("SE");
		announcement.setDescription("Ministério Público não fax o seu lapel");
		announcement.setInstitution("Camara Deputados SE");
		announcement.setInstitutionArea("Política");
		announcement.setInstitutionType("Pública");
		announcement.setKey(new KeyIdentity<UUID>(UUID
				.fromString("7db1a490-5878-11e2-bcfd-0800200c9a66")));
		
		announcement.setPhoto(bytes);
		announcement
				.setTitle("Currupção na Camara dos Deputados Estaduais de Sergipe");
		announcement.setUsername("manoel");

		// function call
		AnnouncementMapper mapper = new AnnouncementMapper();
		mapper.insert(announcement);

	}

}
