package com.santander.meetup.getWeather.model;

import java.io.Serializable;

public class GetWeather implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8212897484996738613L;
	
	private Long id;
	
	private String appId;
	
	//GET AND SET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	

}
