package com.santander.meetup.guest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="guest_detail")

public class Guest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5925435201938503803L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(
	    strategy= GenerationType.AUTO,
	    generator="native"
	)
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "ID", insertable=false, updatable=false)
	@JsonIgnore
	private GuestDetail meeting;
	
}
