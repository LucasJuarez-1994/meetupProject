package com.santander.meetup.room.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="room")

public class Room implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 6750282561054715248L;
	
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO,
	    generator="native"
	)
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column
	private String roomId;
	
	@Enumerated(EnumType.STRING)
	@Column
	private RoomState state;
	
	@Column
	private String reason;
	
	@Column
	private LocalDateTime createdDate;
	
	@Column
	private String createdBy;
	
	@Column
	private LocalDateTime modifiedDate;
	
	@Column
	private String modifiedBy;
	

}
