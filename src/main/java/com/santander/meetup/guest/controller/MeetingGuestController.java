package com.santander.meetup.guest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santander.meetup.guest.model.GuestDetail;
import com.santander.meetup.guest.service.MeetingGuestService;

@EnableResourceServer
@RestController
public class MeetingGuestController {
	
	public static final Logger logger = LoggerFactory.getLogger(MeetingGuestController.class);
	
	@Autowired
	private MeetingGuestService meetingGuestService;
	
	@PostMapping("/guest")
	  public ResponseEntity<?> postMeetingGuest(@Valid @RequestBody GuestDetail meetingGuest) {
	    
		GuestDetail saveMeetingGuest = meetingGuestService.saveMeetingGuest(meetingGuest);
		return new ResponseEntity<>(saveMeetingGuest, HttpStatus.OK);
	}
	    

}
