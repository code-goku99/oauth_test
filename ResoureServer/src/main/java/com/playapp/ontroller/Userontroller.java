package com.playapp.ontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playapp.response.UserResponse;

@RestController
@RequestMapping("/users")
public class Userontroller {

	@Autowired
	Environment env;
	
	@GetMapping("/status")
	public String status() {
		// To know from which instance the request is comming
		return "Working on port :"+ env.getProperty("local.server.port");
	}
	
	//@Secured(value = { "ROLE_developer" })
	//@PreAuthorize(value = "hasRole('developer')")
	@PreAuthorize(value = "hasAuthority('ROLE_developer') or #id == #jwt.subject ")
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") String id, @AuthenticationPrincipal Jwt jwt) {
		return "User Deleted Sucessfully with id="+id+"and jwt subject ="+jwt.getSubject();
	}
	
	@PostAuthorize(value = "returnObject.userId == #jwt.subject")
	@GetMapping("/detail/{id}")
	public UserResponse getUser(@PathVariable("id") String id, @AuthenticationPrincipal Jwt jwt) {
		return new UserResponse(id,"Test");
	}
}
