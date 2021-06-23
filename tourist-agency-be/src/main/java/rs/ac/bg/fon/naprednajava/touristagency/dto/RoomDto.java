package rs.ac.bg.fon.naprednajava.touristagency.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomIdentity;
import rs.ac.bg.fon.naprednajava.touristagency.enumeration.RoomType;

@AllArgsConstructor @NoArgsConstructor
@Data
public class RoomDto implements MyDto{

	private RoomIdentity id;
	private String description;
	private BigDecimal pricePerNight;
	private RoomType roomType;
	private boolean available;
	private HotelEntity hotel;
}

