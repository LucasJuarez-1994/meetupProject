package com.santander.meetup.room.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santander.meetup.room.model.Room;
import com.santander.meetup.room.model.RoomState;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
	
	@Query("select r.state from Room r where r.id = :id")
	  RoomState getState(@Param("id") Long id);
	
	@Modifying
	  @Query("update Room r set r.state = :state, r.modifiedBy = :modifier  where r.id = :id")
	  void  updateState(@Param("id") Long id, @Param("state") RoomState state, @Param("modifier") String modifier );
	
	@Transactional
	@Modifying
	@Query("delete from Room r where r.id= :id")
	void deleteRoomById(@Param("id") Long id);


}