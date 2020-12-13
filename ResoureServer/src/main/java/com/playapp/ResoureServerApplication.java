package com.playapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ResoureServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResoureServerApplication.class, args);
	}

}
