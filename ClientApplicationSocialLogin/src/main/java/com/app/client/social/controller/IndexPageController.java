package com.app.client.social.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

	@GetMapping("/")
	public String indexDisplay(Model model) {
		return "index";
	}
}
