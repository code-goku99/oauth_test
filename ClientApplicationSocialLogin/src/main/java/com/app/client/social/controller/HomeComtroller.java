package com.app.client.social.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeComtroller {

	@GetMapping
	public String displayHomePage(Model model, @AuthenticationPrincipal OAuth2User user) {
		if(user != null) {
			model.addAttribute("name",user.getAttribute("name"));
		}
		return "home";
	}
}
