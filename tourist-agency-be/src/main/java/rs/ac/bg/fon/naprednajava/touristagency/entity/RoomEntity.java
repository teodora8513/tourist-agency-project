/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.naprednajava.touristagency.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    
	@ManyToOne
	@PrimaryKeyJoinColumn(name="hotel_id", referencedColumnName="id")
	//@JoinColumn(name="hotel_id") 
    private HotelEntity hotel;            
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private String room_number;
        
    private String description;

    @Column(name = "price_per_night")
    private BigDecimal pricePerNight;
    
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    
    private boolean available;

    
}
