package rs.ac.bg.fon.naprednajava.touristagency.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.naprednajava.touristagency.enumeration.RoomType;
import java.math.BigDecimal;
import java.util.List;
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
@AllArgsConstructor @NoArgsConstructor
@Table(name="hotel")
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "rooms"})
public class HotelEntity implements MyEntity {

	/* Hotel Id */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
	/* Name */
    private String name;
      
    /* Address */
    @NotNull
    @Column(unique = true)
    private String address;

    /*
    @OneToMany(mappedBy = "hotel", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
    private List<RoomEntity> rooms;*/
    
    
    /* Rating */
    private int rating;
    
    /* Destination */
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private DestinationEntity destination;
    
        
}

