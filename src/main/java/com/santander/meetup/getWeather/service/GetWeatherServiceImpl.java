package com.santander.meetup.getWeather.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class GetWeatherServiceImpl {
	
	public void RestOpenWeatherMap() {
		RestTemplate template = new RestTemplate();
		
		//http://api.openweathermap.org/data/2.5/weather?id=6559994&appid=2890ed3e5c53808072d9d30a676b4900
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("api.openweathermap.org")
				.path("/data/2.5/weather")
				.queryParam("id", "6559994", "appid", "2890ed3e5c53808072d9d30a676b4900")
				.build();
		
	}
 
}
