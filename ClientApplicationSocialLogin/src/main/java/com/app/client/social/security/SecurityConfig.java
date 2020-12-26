package com.app.client.social.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	ClientRegistrationRepository clientRegistrationRepository;
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.
		authorizeRequests()
		.antMatchers("/")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.oauth2Login()
		.and()
		.logout()
	//	.logoutSuccessUrl("/")
		.logoutSuccessHandler(oidLogoutSuccessHandler())
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.deleteCookies("JSESSIONID");
	}
	
	public OidcClientInitiatedLogoutSuccessHandler oidLogoutSuccessHandler() {
		
		OidcClientInitiatedLogoutSuccessHandler  logoutHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
		logoutHandler.setPostLogoutRedirectUri("http://localhost:20091/");
		return logoutHandler;
		
	}
	
}
