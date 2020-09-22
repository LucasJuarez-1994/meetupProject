package com.santander.meetup.room.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santander.meetup.room.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
	
	
	@Modifying
	  @Query("update Room r set r.modifiedBy = :modifier  where r.id = :id")
	  void  updateState(@Param("id") Long id, @Param("modifier") String modifier );
	
	@Transactional
	@Modifying
	@Query("delete from Room r where r.id= :id")
	void deleteRoomById(@Param("id") Long id);


}