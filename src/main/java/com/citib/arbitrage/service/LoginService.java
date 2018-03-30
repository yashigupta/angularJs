package com.citib.arbitrage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citib.arbitrage.model.Login;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@Service
public class LoginService {

	private static Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	MongoDbService mongoService;

	public MongoDbService getMongoService() {
		return mongoService;
	}

	public void setMongoService(MongoDbService mongoService) {
		this.mongoService = mongoService;
	}

	public boolean validateUser(Login cus) {

		logger.info("Validating the user.");

		boolean flag = false;

		DBCollection coll = mongoService.getDb().getCollection("Login");

		BasicDBObject field = new BasicDBObject();
		field.put("Password", 1);
		DBCursor dbc = coll.find(new BasicDBObject("_id", cus.getusername()));

		if (dbc.hasNext()) {
			BasicDBObject obj = (BasicDBObject) dbc.next();
			String str = obj.getString("Password");
			flag = str.equals(cus.getpassword());
		} else {
			flag = false;
		}

		logger.info("Returning from the validate user method.");
		return flag;
	}

}