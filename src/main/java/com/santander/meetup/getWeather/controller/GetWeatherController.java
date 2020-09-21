package com.santander.meetup.getWeather.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@RestController
public class GetWeatherController {
	
	public static final Logger logger = LoggerFactory.getLogger(GetWeatherController.class);
	
	@GetMapping("/data/2.5/weather")
	  public ResponseEntity<?> getWeather(
			  @PathVariable("id") Long id, 
			  @PathVariable("appId") String appId, 
			  HttpServletRequest request) {
		
		
		
		return null;

	  }

}
