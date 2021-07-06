package rs.ac.bg.fon.naprednajava.touristagency.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.TransportationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.enumeration.Meals;

public class ReservationDto implements MyDto {

	private Long id;

	private UserEntity user;

	private Date dateFrom;

	private Date dateTo;

	private int numberOfNights;

	private List<RoomEntity> rooms;

	private Meals meals;

	private HotelEntity hotel;

	private TransportationEntity transportation;

	private double totalPrice;

	private int people;
	
	private DestinationDto destination;

	public ReservationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationDto(Long id, UserEntity user, Date dateFrom, Date dateTo, int numberOfNights,
			List<RoomEntity> rooms, Meals meals, HotelEntity hotel, TransportationEntity transportation,
			double totalPrice, int people, DestinationDto destination) {
		super();
		this.id = id;
		this.user = user;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.numberOfNights = numberOfNights;
		this.rooms = rooms;
		this.meals = meals;
		this.hotel = hotel;
		this.transportation = transportation;
		this.totalPrice = totalPrice;
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

	public Meals getMeals() {
		return meals;
	}

	public void setMeals(Meals meals) {
		this.meals = meals;
	}

	public HotelEntity getHotel() {
		return hotel;
	}

	public void setHotel(HotelEntity hotel) {
		this.hotel = hotel;
	}

	public TransportationEntity getTransportation() {
		return transportation;
	}

	public void setTransportation(TransportationEntity transportation) {
		this.transportation = transportation;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public DestinationDto getDestination() {
		return destination;
	}

	public void setDestination(DestinationDto destination) {
		this.destination = destination;
	}
}
