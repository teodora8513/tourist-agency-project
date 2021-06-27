package rs.ac.bg.fon.naprednajava.touristagency.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.ReservationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomEntity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.ReservationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.HotelRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.ReservationRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.RoomRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.MyService;

@Service
public class ReservationService implements MyService<ReservationDto, Long> {

	private ReservationMapper reservationMapper;
	private ReservationRepository reservationRepository;
	private HotelRepository hotelRepository;
	private RoomRepository roomRepository;

	
	@Autowired
	public ReservationService(ReservationMapper reservationMapper, ReservationRepository reservationRepository,
			HotelRepository hotelRepository, RoomRepository roomRepository) {
		super();
		this.reservationMapper = reservationMapper;
		this.reservationRepository = reservationRepository;
		this.hotelRepository = hotelRepository;
		this.roomRepository = roomRepository;
	}

	@Override
	public Optional<ReservationDto> findById(Long id) {
		Optional<ReservationEntity> entity = reservationRepository.findById(id);
		if (entity.isPresent()) {
			return Optional.of(reservationMapper.toDto(entity.get()));
		} else {
			return Optional.empty();

		}
	}

	@Override
	public List<ReservationDto> getAll() {
		List<ReservationEntity> entities = reservationRepository.findAll();
		return entities.stream().map(el -> reservationMapper.toDto(el)).collect(Collectors.toList());
	}

	@Override
	public ReservationDto save(ReservationDto dto) throws MyEntityAlreadyExists, MyEntityDoesntExist {
		Optional<ReservationEntity> resEntity = reservationRepository.findById(dto.getId());
		if(resEntity.isEmpty()) {
			Optional<HotelEntity> hotelEntity = hotelRepository.findById(dto.getHotel().getId());
			if(hotelEntity.isPresent()) {
				for (RoomEntity room : dto.getRooms()) {
					Optional<RoomEntity> roomEntity = roomRepository.findById(room.getId());
					if(roomEntity.isPresent()) {
						continue;
					}
					else {
						throw new MyEntityDoesntExist("Room with id: " + room.getId() + " doesn't exist!");
					}
				}
				reservationRepository.save(reservationMapper.toEntity(dto));
				return dto;
			}
			else {
				throw new MyEntityDoesntExist("Hotel with id " + dto.getHotel().getId() + " doesn't exist!");
			}
		}
		else {
			throw new MyEntityAlreadyExists("Reservation with id " + dto.getId() + " already exist!");
		}
		
	}

	@Override
	public void delete(Long id) throws MyEntityDoesntExist {
		Optional<ReservationEntity> entity = reservationRepository.findById(id);
		if (entity.isPresent()) {
			reservationRepository.deleteById(id);
		} else {
			throw new MyEntityDoesntExist("Reservation with id " + id + " does not exist!");
		}

	}

	@Override
	public Optional<ReservationDto> update(ReservationDto dto) throws MyEntityDoesntExist, MyEntityAlreadyExists {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ReservationDto> findByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ReservationDto> getReservationsById(Long id){
		List <ReservationEntity> entities = reservationRepository.reservationsById(id);
		return entities.stream().map(el -> reservationMapper.toDto(el)).collect(Collectors.toList());

	}

}
