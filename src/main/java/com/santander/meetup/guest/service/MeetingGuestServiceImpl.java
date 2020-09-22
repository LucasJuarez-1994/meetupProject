package com.santander.meetup.guest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.santander.meetup.guest.model.GuestDetail;
import com.santander.meetup.guest.repository.MeetingGuestRepository;
import com.santander.meetup.room.service.RoomServiceImpl;

@Service
public class MeetingGuestServiceImpl implements MeetingGuestService {
	
public static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
	
	@Autowired
	private MeetingGuestRepository meetingGuestRepository;
	
	//SAVE GUEST
	@Override
	public GuestDetail saveMeetingGuest(@NonNull GuestDetail meetingGuest) {

		logger.debug(
				String.format("Start generating save draft MeetingGuest. Input:PO [%s] ; poId[%d] ", meetingGuest, meetingGuest.getId()));
		
		GuestDetail meetingGuestResult = this.meetingGuestRepository.save(meetingGuest);
		return meetingGuestResult;

	}

}
