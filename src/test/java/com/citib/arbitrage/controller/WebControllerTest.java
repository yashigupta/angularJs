package com.citib.arbitrage.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class WebControllerTest {

@InjectMocks                                               //why is injectmock annotation used
	private WebController indexController;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

	}

	@Test
	public void test() throws Exception {
		MockHttpServletRequestBuilder request = get("/")
				.contentType(MediaType.APPLICATION_JSON);
			MockHttpServletResponse response = mockMvc.perform(request)
				.andReturn()
				.getResponse();
			assertEquals(response.getStatus(),200);
	}

}
