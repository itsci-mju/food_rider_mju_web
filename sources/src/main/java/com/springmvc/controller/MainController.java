package com.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MainController {
	@RequestMapping(value = "/loadmains", method = RequestMethod.GET)
	public String loadmainsPage() {
		return "index";
	}
}
