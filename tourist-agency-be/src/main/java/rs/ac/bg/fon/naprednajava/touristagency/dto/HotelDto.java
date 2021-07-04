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
	private int rating;
	private DestinationDto destination;
	private String imageName;
	private String imageFile;
	private byte[] image;
	//private String extension;
	
	public HotelDto() {
		
		
	}
	
	
	public HotelDto(Long id, String name, String address, int rating, DestinationDto destination, String imageName,
			String imageFile, byte[] image/*, String extension*/) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.destination = destination;
		this.imageName = imageName;
		this.imageFile = imageFile;
		this.image = image;
		//this.extension = extension;
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


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getImageFile() {
		return imageFile;
	}


	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	/*
	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
	}
*/

}
