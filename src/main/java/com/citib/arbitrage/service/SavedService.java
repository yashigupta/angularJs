package com.citib.arbitrage.service;

//Provide service to access saved stock from database 
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citib.arbitrage.model.SavedStock;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@Service
public class SavedService {

	private static Logger logger = LoggerFactory.getLogger(SavedService.class);

	@Autowired
	MongoDbService mongoService;

	public void tosave(SavedStock s) {

		logger.info("Creating BasicDB object");

		BasicDBObject field = new BasicDBObject();
		field.append("userId", s.getUserId()).append("stockName", s.getStockName()).append("nsePrice", s.getNsePrice())
				.append("bsePrice", s.getBsePrice()).append("profit", s.getProfit()).append("date", s.getDate())
				.append("time", s.getTime());

		logger.info("Basic Db objected created. Inserting the data in db");

		DBCollection coll = mongoService.getDb().getCollection("gsearch");

		coll.insert(field);

		logger.info("Data inserted successfully.");

	}

	/* function to retrieve data */
	public ArrayList<SavedStock> toretrieve(String usr) {

		logger.info("Starting the toRetrieve method");
		DBCursor cursor1 = mongoService.getDb().getCollection("Saved").find();
		ArrayList<SavedStock> ss = new ArrayList<SavedStock>();
		SavedStock s;
		BasicDBObject searchquery = new BasicDBObject("userId", usr);
		cursor1 = mongoService.getDb().getCollection("gsearch").find(searchquery).sort(new BasicDBObject("date", -1)).sort(new BasicDBObject("time", -1));
		while (cursor1.hasNext()) {
			s = new SavedStock();
			BasicDBObject obj = (BasicDBObject) cursor1.next();
			s.setStockName(obj.getString("stockName"));
			s.setBsePrice(obj.getDouble("bsePrice"));
			s.setNsePrice(obj.getDouble("nsePrice"));
			s.setDate(obj.getString("date"));
			s.setTime(obj.getString("time"));
			s.setProfit(obj.getDouble("profit"));
			s.setUserId(obj.getString("userId"));
			ss.add(s);
		}
		cursor1.close();
		logger.info("Closing the toRetrieve method");
		return ss;
	}

}
