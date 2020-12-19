package com.resource.server.photos;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.server.photos.model.PhotosResponse;

@RestController
@RequestMapping("/photos")
public class PhotosController {

	@GetMapping("/show")
	public List<PhotosResponse> getAllPhotos(){
		PhotosResponse photosResponse1 = new PhotosResponse();
		photosResponse1.setAlbumId("A001");
		photosResponse1.setPhotoId("PH001");
		photosResponse1.setPhotoTitle("First");
		
		return Arrays.asList(photosResponse1);
	}
}
