package rs.ac.bg.fon.naprednajava.touristagency.entity;



import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor @NoArgsConstructor
@Data
@Embeddable
public class RoomIdentity implements MyEntity{

	private Long hotel_id;
	private String room_number;
	
}