package com.santander.meetup.room.service;


import java.util.Optional;

import com.santander.meetup.room.model.Room;

public interface RoomService {
	
	Room createRoom(Room room);

	Optional<Room> getRoom(Long roomId);
	
	void removeRoom(Long roomId);
	
	Room saveRoom(Room room);

	void deleteRoom(Long id);

}
