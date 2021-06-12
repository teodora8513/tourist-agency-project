package rs.ac.bg.fon.naprednajava.touristagency.dto;

import java.math.BigDecimal;

import rs.ac.bg.fon.naprednajava.touristagency.enumeration.RoomType;

public class RoomDto implements MyDto{

	private HotelDto hotel;
	private Long id;
	private String room_number;
	private String description;
	private BigDecimal pricePerNight;
	private RoomType roomType;
	private boolean available;
	
	public RoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RoomDto(HotelDto hotel, Long id, String room_number, String description, BigDecimal pricePerHight,
			RoomType roomType, boolean available) {
		this.hotel = hotel;
		this.id = id;
		this.room_number = room_number;
		this.description = description;
		this.pricePerNight = pricePerHight;
		this.roomType = roomType;
		this.available = available;
		
	}

	public HotelDto getHotel() {
		return hotel;
	}

	public void setHotel(HotelDto hotel) {
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(BigDecimal pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	
	
	
	
}
