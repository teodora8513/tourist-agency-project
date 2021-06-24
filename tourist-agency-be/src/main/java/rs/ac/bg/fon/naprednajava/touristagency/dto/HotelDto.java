package rs.ac.bg.fon.naprednajava.touristagency.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.ReservationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomEntity;
import rs.ac.bg.fon.naprednajava.touristagency.enumeration.RoomType;

public class HotelDto implements MyDto{

	private Long id;
	private String name;
	private String address;
	//private List<RoomEntity> rooms;
	private int rating;
	private DestinationDto destination;
	
	public HotelDto() {
		
		
	}
	
	public HotelDto(Long id, String name, String address, int rating, DestinationDto destination) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.destination = destination;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public DestinationDto getDestination() {
		return destination;
	}
	
	public void setDestination(DestinationDto destination) {
		this.destination = destination;
	}
	

}
