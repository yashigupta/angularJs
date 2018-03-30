package com.citib.arbitrage.service;
import com.citib.arbitrage.model.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

//import org.junit.Test;

public class CurrentServiceTest {
	
	
	CurrentService cs;
	ArrayList<CurrentStock> c;
	@Before
	public void setup()
	{
		cs=new CurrentService();
		c=new ArrayList<CurrentStock>();
	}

	@Test                                          
	public void test() throws IOException {                       //test case for arraylist length
		c=cs.getCurrent();
		assertTrue(c.size()>0);
	}

}
