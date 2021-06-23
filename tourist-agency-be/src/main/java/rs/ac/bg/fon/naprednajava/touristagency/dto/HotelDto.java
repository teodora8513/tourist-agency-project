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

@AllArgsConstructor @NoArgsConstructor
@Data
public class HotelDto implements MyDto{

	private Long id;
	private String name;
	private String address;
	//private List<RoomEntity> rooms;
	private int rating;
	private DestinationDto destination;
	
	
}
