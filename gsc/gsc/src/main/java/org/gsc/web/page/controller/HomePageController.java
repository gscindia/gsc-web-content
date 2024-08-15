package org.gsc.web.page.controller;

import org.gsc.constant.GscConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomePageController {
	@GetMapping(GscConstants.HOMEPAGE_PATH)	
	public String homePage() {
		return "index";     
	}
	
}
