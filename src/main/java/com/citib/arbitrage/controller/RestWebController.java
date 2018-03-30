package com.citib.arbitrage.controller;

//Receives and processes the HTTP requests from controller.js
import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citib.arbitrage.model.CurrentStock;
import com.citib.arbitrage.model.Login;
import com.citib.arbitrage.model.DisplayScrap;
import com.citib.arbitrage.service.CurrentService;
import com.citib.arbitrage.service.LoginService;
import com.citib.arbitrage.service.ScrapService;

@RestController
public class RestWebController {

	@Autowired
	private LoginService service;

	@Autowired
	private CurrentService currservice;

	@Autowired
	private ScrapService savservice;

	private static Logger logger = LoggerFactory.getLogger(RestWebController.class);

	@RequestMapping(value = "/getalllg", method = RequestMethod.GET)
	public ArrayList<CurrentStock> getResource() throws IOException {
		// This function will get the current data from CurrentService and return it to
		// controller.js
		ArrayList<CurrentStock> ar = currservice.getCurrent();
		logger.info("getResource method call successfull");
		return ar;
	}

	@RequestMapping(value = "/postuser", method = RequestMethod.POST)
	public String postlg(@RequestBody Login lg) {
		System.out.println("In request mapping");
		// This function will check login credentials and send status to controller.js
		if (service.validateUser(lg)) {

			logger.info("postlg method returned successful");

			return "Successful!";
		} else {

			logger.info("postlg method return failed");
			return "Failed";
		}
	}

	/*
	 * @RequestMapping(value = "/saveData", method = RequestMethod.POST) public
	 * String saveData(@RequestBody DisplayScrap ss) { // This function receives
	 * data from UI to be saved in the database
	 * logger.info("calling saveService .toSave Method."); // savservice.tosave(ss);
	 * logger.info("saveService .toSave Method returned successfully."); return
	 * "successful"; }
	 */

	@RequestMapping(value = "/getSaved", method = RequestMethod.POST)
	public ArrayList<DisplayScrap> retrieve() throws IOException {
		// This function will get the saved data and return it to controller.js
		logger.info("calling saveService .toretrieve Method.");
		ArrayList<DisplayScrap> ar = savservice.toretrieve();
		logger.info("calling saveService .toretrieve Method returned successfully..");
		return ar;
	}
}