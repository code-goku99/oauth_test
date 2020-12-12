package com.playapp.surity.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import com.playapp.surity.convrtr.KeycloakRoleConverter;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class Surityconfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
		jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter() );
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/users/status")
		//.hasAuthority("SCOPE_profile")
		//.hasRole("developer")
		.hasAnyRole("developer","usr")
		.anyRequest().authenticated()
		.and()
		.oauth2ResourceServer()
		.jwt()
		.jwtAuthenticationConverter(jwtConverter);
		
	}
}
