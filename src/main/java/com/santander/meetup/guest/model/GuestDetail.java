package com.santander.meetup.guest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="guest_header")

public class GuestDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8088999018740173424L;

	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO,
	    generator="native"
	)
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column
	private String roomId;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ID", referencedColumnName="ID", nullable=false, insertable=false, updatable=false)
    private List<Guest> guest;
	
   	
}
