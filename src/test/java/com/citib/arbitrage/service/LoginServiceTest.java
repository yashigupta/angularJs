package com.citib.arbitrage.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.citib.arbitrage.model.Login;

public class LoginServiceTest {

	Login l;
	
	LoginService ls;//= new LoginService();
	
	
	@Before
	public void setup() {
		l = new Login();
		ls = new LoginService();
		ls.setMongoService(new MongoDbService());
		l.setusername("/Yashi");
		l.setpassword("root111");
	}

	@Test
	public void test() {

		boolean ans = ls.validateUser(l);
		assertTrue(ans);
	}

}
