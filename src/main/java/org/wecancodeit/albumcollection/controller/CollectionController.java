package org.wecancodeit.albumcollection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CollectionController {
	@GetMapping("/")
	public String getHome() {
		return "../static/index";
	}
}
