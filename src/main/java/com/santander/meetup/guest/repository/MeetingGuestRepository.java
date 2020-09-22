package com.santander.meetup.guest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santander.meetup.guest.model.GuestDetail;

	@Repository
	public interface MeetingGuestRepository extends CrudRepository<GuestDetail, Long> {
	

}
