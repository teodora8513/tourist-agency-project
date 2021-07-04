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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
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
    
    @Column(name = "image_name", nullable=false)
    private String imageName;
    
    @Column(name = "image_file", nullable=false)
    private String imageType;
    
    @Lob
    @Column(nullable=false, columnDefinition = "BLOB")
    private byte[] image;
    
    /*@Column(nullable=false)
    private String extension;*/

    public HotelEntity() {
    	
    	
    }

	public HotelEntity(Long id, String name, String address, int rating, DestinationEntity destination,
			String imageName, String imageType, byte[] image/*, String extension*/) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.destination = destination;
		this.imageName = imageName;
		this.imageType = imageType;
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

	public DestinationEntity getDestination() {
		return destination;
	}

	public void setDestination(DestinationEntity destination) {
		this.destination = destination;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
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

