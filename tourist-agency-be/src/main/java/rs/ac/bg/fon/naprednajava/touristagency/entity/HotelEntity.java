package rs.ac.bg.fon.naprednajava.touristagency.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
@Data
public class HotelEntity implements MyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
        
    private String name;
        
    @NotNull
    @Column(unique = true)
    private String address;
        
    /*
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="hotel")
    @MapKey(name="hotel_id")
    @Column(name="room_id")
    private ArrayList<RoomEntity> rooms;
    */
    private int rating;
    
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private DestinationEntity destination;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

      
        
}
