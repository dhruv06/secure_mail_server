package com.nss.assignment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public abstract class AbstractUiController {

	// Gets value of base Url from properties file
	@Value("${app.baseUrl}")
	private String baseUrl;

	protected ModelAndView mav(String page) {
		// Get current user
		// Set info
		ModelAndView mav = new ModelAndView(page);
		mav.addObject("baseUrl", baseUrl);
		return mav;
	}

}
