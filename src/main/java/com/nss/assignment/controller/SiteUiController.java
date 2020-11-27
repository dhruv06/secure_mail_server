package com.nss.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteUiController extends AbstractUiController {

	// WEBSITE PAGES
	@RequestMapping(value = "")
	public ModelAndView index() {
		return mav("login.html");
	}
	@RequestMapping(value = "/site/features")
	public ModelAndView features() {
		return mav("features.html");
	}
	@RequestMapping(value = "/site/Register")
	public ModelAndView Register() {
		return mav("generateKeys.html");
	}
	@RequestMapping(value = "/site/Compose")
	public ModelAndView Compose() {
		return mav("compose.html");
	}
	@RequestMapping(value = "/site/Inbox")
	public ModelAndView inbox() {
		return mav("inbox.html");
	}
}
