package com.app.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.client.model.Album;

@Controller
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	OAuth2AuthorizedClientService oAuth2clientService;
	
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	
	@Autowired
	WebClient webClient;

	/*
	 * By doing this approach we need to create Authetiation object and
	 * OAuth2AuthenticationToken and OAuth2AuthorizedClient for each request
	 * So we can use WebClient and pass OAuth2AuthorizedClient by configuring webClient
	 */
	/*@GetMapping("/show")
	public String getListofAlbums(Model map, @AuthenticationPrincipal OidcUser principal){
	
		
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
		 		
		OAuth2AuthorizedClient oAuthClient = oAuth2clientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getPrincipal().getName());
		
		String jwtAuthToken = oAuthClient.getAccessToken().getTokenValue();
		System.out.println(jwtAuthToken);
		
		System.out.println("Principal"+principal);
		OidcIdToken idToken = principal.getIdToken();
		String tokenValue = idToken.getTokenValue();
		System.out.println("Token "+tokenValue);
		
		String url = "http://localhost:2004/albums/show";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + jwtAuthToken);
		
		HttpEntity<List<Album>> entity = new HttpEntity<>(headers);
		ResponseEntity<List<Album>> exchange = restTemplate.exchange(url, HttpMethod.GET, entity,  new ParameterizedTypeReference<List<Album>>() {});
		List<Album> albumList = exchange.getBody();
		
		map.addAttribute("albums",  albumList);
		return "albums";
	}*/

	@GetMapping("/show")
	public String getListofAlbums(Model map, @AuthenticationPrincipal OidcUser principal){
		
		String url = "http://localhost:2004/albums/show";
		List<Album> albums = webClient.get()
				.uri(url)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Album>>(){})
				.block();
		
		map.addAttribute("albums",  albums);
		return "albums";
	}
	@GetMapping("/hi")
	public String sayHi(Model map){
		map.addAttribute("hi",  "Hi");
		map.addAttribute("albums",  new ArrayList());
		return "albums";
	}
}
