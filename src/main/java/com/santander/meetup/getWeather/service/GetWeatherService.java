package com.santander.meetup.getWeather.service;

import java.util.Optional;

import com.santander.meetup.getWeather.model.GetWeatherResponse;

public interface GetWeatherService {
	
	Optional<GetWeatherResponse> getWeather(Long id);

}
