package com.playapp.surity.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Surityconfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/users/status").hasAuthority("SCOPE_profile")
		.anyRequest().authenticated()
		.and()
		.oauth2ResourceServer()
		.jwt();
		
	}
}
