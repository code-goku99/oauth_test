package com.albums.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albums.model.Album;

@RestController
@RequestMapping("/albums")
public class AlbumController {

	@GetMapping("/show")
	public List<Album> displayAlbums(Model model) {
		
		Album album1 = new Album();
		Album album2 = new Album();
		Album album3 = new Album();
		Album album4 = new Album();
		Album album5 = new Album();
		Album album6 = new Album();
		model.addAttribute("albumList",  Arrays.asList(album1,album2,album3,album4,album5,album6));
		return  Arrays.asList(album1,album2,album3,album4,album5,album6);
	}
}
