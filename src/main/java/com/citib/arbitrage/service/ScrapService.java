package com.citib.arbitrage.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.citib.arbitrage.model.DisplayScrap;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

@Service
public class ScrapService {
	@Autowired
	MongoDbService mongoService;
	
	private static Logger logger = LoggerFactory.getLogger(ScrapService.class);
	
	/* function to retrieve data */
	public ArrayList<DisplayScrap> toretrieve() {

		logger.info("Starting the toRetrieve method");
		DBCursor cursor1 = mongoService.getDb().getCollection("pune_maharashtra").find();
		ArrayList<DisplayScrap> ss = new ArrayList<DisplayScrap>();
		DisplayScrap s;
		//BasicDBObject searchquery = new BasicDBObject("userId", usr);
		cursor1 = mongoService.getDb().getCollection("MEMORANDUM_OF_UNDERSTANDING_ON_MEGA_CONSTRUCTION_PROJECTS").find();
				//.find(searchquery).sort(new BasicDBObject("date", -1)).sort(new BasicDBObject("time", -1));
		while (cursor1.hasNext()) {
			s = new DisplayScrap();
			BasicDBObject obj = (BasicDBObject) cursor1.next();
			s.setTitle(obj.getString("title"));
			s.setDescription(obj.getString("description"));
			s.setLink(obj.getString("link"));
			ss.add(s);
			System.out.println(s.getTitle());
		}
		System.out.println("I am here");
		//System.out.println(ss);
		/*for(DisplayScrap obj :ss)
		{
			System.out.println(obj.getLink());
		}*/
		cursor1.close();
		logger.info("Closing the toRetrieve method");
		return ss;
	}
}
