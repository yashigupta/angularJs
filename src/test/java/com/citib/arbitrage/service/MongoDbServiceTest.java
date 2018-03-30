package com.citib.arbitrage.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.mongodb.DB;

public class MongoDbServiceTest {
	
	MongoDbService mongoService;
	
	@Before
	public void setup() {
		
		mongoService = new MongoDbService();
	}

	@Test
	public void test() {
		
		assertTrue(mongoService.getDb() instanceof DB );
	}

}
