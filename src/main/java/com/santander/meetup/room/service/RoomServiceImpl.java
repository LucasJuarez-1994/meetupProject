package com.santander.meetup.room.service;

import java.time.LocalDateTime;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.santander.meetup.room.model.Room;
import com.santander.meetup.room.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	
	public static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
	
	@Autowired
	private RoomRepository roomRepository;
	
	
	//CREATED ROOM
	@Override
	public Room createRoom(@NonNull Room room) {
		logger.debug(String.format("Start creating Room. Input: [%s]", room));
		
		room.setId(null);
		Room createdRoom = roomRepository.save(room);

		logger.debug(String.format("Finish creating Room. PO created: [%s] ", room));
		return createdRoom;
		
	}

	//GET ROOM
	@Override
	public Optional<Room> getRoom(Long roomId) {
		return roomRepository.findById(roomId);
	}
	
	//DELETED ROOM
	@Override
	public void removeRoom(Long roomId) {
		roomRepository.deleteById(roomId);
	}
	
	//SAVE ROOM
	@Override
	public Room saveRoom(@NonNull Room room) {

		logger.debug(
				String.format("Start generating save draft Room. Input:PO [%s] ; poId[%d] ", room, room.getId()));

		if ((room.getId() != null) && this.roomRepository.existsById(room.getId())) {

			room.setModifiedBy(null);
			room.setModifiedDate(LocalDateTime.now());
		} else {
			room.setId(null);
			room.setCreatedBy(null);
			room.setCreatedDate(LocalDateTime.now());
		}
		
		Room roomResult = this.roomRepository.save(room);
		return roomResult;

	}

	@Override
	public void deleteRoom(Long id) {
		roomRepository.deleteRoomById(id);
		
	}

}
