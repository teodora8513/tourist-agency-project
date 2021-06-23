/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.naprednajava.touristagency.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.ac.bg.fon.naprednajava.touristagency.enumeration.RoomType;

/**
 *
 * @author Djina
 */
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name="room")
@Data
public class RoomEntity implements MyEntity{
    
	@EmbeddedId
	private RoomIdentity id;
	
	/* Hotel 
	@Id 
	@ManyToOne
	@PrimaryKeyJoinColumn(name="hotel_id", referencedColumnName="id") 
	@Getter
    private HotelEntity hotel;  */         
	
	/* Room Id */
	
	/*
	@Id
    @Column(name="hotel_id")
    private Long hotel_id;
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
    private Long id;*/
	
	/* Number 
	
	@Id
	@Getter @Setter
	private String room_number;*/
	
	
	@MapsId("hotel_id")
	@ManyToOne
	private HotelEntity hotel;

	
	/* Description */
    private String description;

    /* Price per night */
    @Column(name = "price_per_night")
    private BigDecimal pricePerNight;
    
    /* Room type */
    @Column(name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    
    /* Is it available? */
    private boolean available;
    
    /* Reservation */
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="reservation_id")
    private ReservationEntity reservation;


}

