package rs.ac.bg.fon.naprednajava.touristagency.dto;

import java.util.ArrayList;

public class HotelDto implements MyDto{

	private Long id;
	private String name;
	private String address;
	private ArrayList<RoomDto> rooms;
	private int rating;
	private DestinationDto destination;
	
	public HotelDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HotelDto(Long id, String name, String address, ArrayList<RoomDto> rooms,
			int rating, DestinationDto destionation) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.rooms = rooms;
		this.rating = rating;
		this.destination = destionation;
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

	public ArrayList<RoomDto> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<RoomDto> rooms) {
		this.rooms = rooms;
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
