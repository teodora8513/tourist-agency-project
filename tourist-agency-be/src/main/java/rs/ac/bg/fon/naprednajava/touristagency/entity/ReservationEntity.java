package rs.ac.bg.fon.naprednajava.touristagency.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.enumeration.Meals;

@Entity
@Table(name="reservation")
public class ReservationEntity implements MyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@Column(name="date_from")
	private Date dateFrom;
	
	@Column(name="dateTo")
	private Date dateTo;
	
	@Column(name="num_of_nights")
	private int numberOfNights;
	
	@OneToMany(mappedBy = "reservation")
	private List<RoomEntity> rooms;
	
	@Enumerated(EnumType.STRING)
	private Meals meals;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private HotelEntity hotel;
	
	@ManyToOne
	@JoinColumn(name="transportation_id")
	private TransportationEntity transportation;
	
	@Column(name="total_price")
	private double totalPrice;
	
	private int people;

	@ManyToOne
	@JoinColumn(name = "destination_id")
	private DestinationEntity destination;
	
	public ReservationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationEntity(Long id, UserEntity user, Date dateFrom, Date dateTo, int numberOfNights,
			List<RoomEntity> rooms, int people, Meals meals, TransportationEntity transportation, DestinationEntity destination) {
		super();
		this.id = id;
		this.user = user;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.numberOfNights = numberOfNights;
		this.rooms = rooms;
		this.meals = meals;
		this.transportation = transportation;
		this.totalPrice = getTotalPrice();
		this.people = people;
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public List<RoomEntity> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomEntity> rooms) {
		this.rooms = rooms;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	

	public HotelEntity getHotel() {
		return hotel;
	}

	public void setHotel(HotelEntity hotel) {
		this.hotel = hotel;
	}

	public Meals getMeals() {
		return meals;
	}

	public void setMeals(Meals meals) {
		this.meals = meals;
	}

	public TransportationEntity getTransportation() {
		return transportation;
	}

	public void setTransportation(TransportationEntity transportation) {
		this.transportation = transportation;
	}

	public double getTotalPrice() {
		int roomPrice = 0;
		
		for (RoomEntity roomEntity : rooms) {
			roomPrice += roomEntity.getPricePerNight().intValue();
		}
		
		int accommodation = numberOfNights * roomPrice;
		int meal = priceOfMeals(meals);
		int meals = numberOfNights * people * meal;
		double transport = transportation.getPrice() * people;
		return accommodation + meals + transport;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	private int priceOfMeals(Meals meal) {
		int mealPrice;
		switch (meal) {
		case BB :
			mealPrice = 10;
			break;

		case PP:
			mealPrice = 20;
			break;
		
		case FB:
			mealPrice = 35;
			break;
			
		case ALL:
			mealPrice = 50;
			break;
		default:
			mealPrice = 0;
			break;
		}
		return mealPrice;
	}

	public DestinationEntity getDestination() {
		return destination;
	}

	public void setDestination(DestinationEntity destination) {
		this.destination = destination;
	}
	
	
}
