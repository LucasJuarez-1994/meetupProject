package com.santander.meetup.meetingGuest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santander.meetup.meetingGuest.model.Meeting;

	@Repository
	public interface MeetingGuestRepository extends CrudRepository<Meeting, Long> {
	

}
