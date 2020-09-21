package com.santander.meetup.room.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santander.meetup.room.model.Room;
import com.santander.meetup.room.model.RoomState;
import com.santander.meetup.room.service.RoomService;

@EnableResourceServer
@RestController
public class RoomController {
	
	public static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@Autowired
	private RoomService roomService;

	
	
	@PostMapping("/room")
	  public ResponseEntity<?> postRoom(@Valid @RequestBody Room room) {
		
		if(room.getId() != null) {
			Optional<Room> roomExist = roomService.getRoom(room.getId());
		
			room.setCreatedDate(roomExist.get().getCreatedDate());
			room.setCreatedBy(roomExist.get().getCreatedBy());
			
			Room saveRoom = roomService.saveRoom(room);
			return new ResponseEntity<>(saveRoom, HttpStatus.OK);
		} else {
	        Room saveRoom = roomService.saveRoom(room);
	        return new ResponseEntity<>(saveRoom, HttpStatus.OK);
	    }
	}
	
	@GetMapping("/room/{id}")
	  public ResponseEntity<?> getRoom(@PathVariable("id") Long id, HttpServletRequest request) {      
		  Optional<Room> room = roomService.getRoom(id);
		  if (room.isPresent()) {
			  return new ResponseEntity<>(room.get(), HttpStatus.OK);
		  }  else return new ResponseEntity<>("Room id:"+id +" not found", HttpStatus.NOT_FOUND);
	    

	  }
	
	@DeleteMapping("/room/{id}")
	  public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id, HttpServletRequest request) {      
		  Optional<Room> room = roomService.getRoom(id);
		  if (room.isPresent() && room.get().getState() == RoomState.OPEN) {
			  roomService.deleteRoom(id);
			  return new ResponseEntity<>(room.get(), HttpStatus.OK);
		  }  else if(room.get().getState() == RoomState.CLOSED) {
			  return new ResponseEntity<>("Room id:"+id +" not in OPEN state", HttpStatus.CONFLICT);
		  }
			  return new ResponseEntity<>("Room id:"+id +" not found", HttpStatus.NOT_FOUND);
	    

	  }

}
