package rs.ac.bg.fon.naprednajava.touristagency.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.ac.bg.fon.naprednajava.touristagency.enumeration.Season;
import rs.ac.bg.fon.naprednajava.touristagency.enumeration.TransportationType;

@Entity
@Table(name= "transportation")
public class TransportationEntity implements MyEntity {

	/*Cenovnik: BUS: 50, CAR: 0, PLANE: 150, MINI_BUS: 100*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TransportationType type;
	
	private double price;
	
	@Enumerated(EnumType.STRING)
	private Season season;
	
	@ManyToOne
	@JoinColumn(name = "start")
	private DestinationEntity startDestination;
	
	@ManyToOne
	@JoinColumn(name = "end")
	private DestinationEntity endDestination;

	public TransportationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransportationEntity(Long id, TransportationType type, double price, Season season,
			DestinationEntity startDestination, DestinationEntity endDestination) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.season = season;
		this.startDestination = startDestination;
		this.endDestination = endDestination;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransportationType getType() {
		return type;
	}

	public void setType(TransportationType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	
	public DestinationEntity getStartDestination() {
		return startDestination;
	}

	public void setStartDestination(DestinationEntity startDestination) {
		this.startDestination = startDestination;
	}

	public DestinationEntity getEndDestination() {
		return endDestination;
	}

	public void setEndDestination(DestinationEntity endDestination) {
		this.endDestination = endDestination;
	}

	@Override
	public String toString() {
		return "TransportationEntity [id=" + id + ", type=" + type + ", price=" + price + ", season=" + season
				+ ", startDestination=" + startDestination + ", endDestination=" + endDestination + "]";
	}

	

	
}
