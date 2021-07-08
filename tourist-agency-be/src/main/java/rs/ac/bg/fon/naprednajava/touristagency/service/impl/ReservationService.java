package rs.ac.bg.fon.naprednajava.touristagency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.*;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.DestinationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.ReservationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.*;
import rs.ac.bg.fon.naprednajava.touristagency.service.MyService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService implements MyService<ReservationDto, Long> {

    private final ReservationMapper reservationMapper;
    private final DestinationMapper destinationMapper;

    private final ReservationRepository reservationRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final DestinationRepository destinationRepository;
    private final TransportationRepository transportationRepository;


    @Autowired
    public ReservationService(ReservationMapper reservationMapper, DestinationMapper destinationMapper, ReservationRepository reservationRepository,
                              HotelRepository hotelRepository, RoomRepository roomRepository, DestinationRepository destinationRepository,
                              TransportationRepository transportationRepository) {
        super();
        this.reservationMapper = reservationMapper;
        this.destinationMapper = destinationMapper;
        this.reservationRepository = reservationRepository;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.destinationRepository = destinationRepository;
        this.transportationRepository = transportationRepository;
    }

    @Override
    public Optional<ReservationDto> findById(Long id) {
        Optional<ReservationEntity> entity = reservationRepository.findById(id);
        return entity.map(reservationMapper::toDto);
    }

    @Override
    public List<ReservationDto> getAll() {
        List<ReservationEntity> entities = reservationRepository.findAll();
        entities = entities.stream().filter(el -> el.getPeople()>0).collect(Collectors.toList());
        return entities.stream().map(reservationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ReservationDto save(ReservationDto dto) throws MyEntityAlreadyExists, MyEntityDoesntExist {
        Objects.requireNonNull(dto);
        Objects.requireNonNull(dto.getHotel());
        Objects.requireNonNull(dto.getHotel().getId());

        TransportationEntity transportationEntity = this.transportationRepository.findById(dto.getTransportation().getId())
                .orElseThrow(() -> new MyEntityDoesntExist("Transportation with id: " +
                        dto.getTransportation().getId() + " doesn't exist"));

        DestinationEntity destinationEntity = this.destinationRepository.findById(dto.getDestination().getId())
                .orElseThrow(() -> new MyEntityDoesntExist("Destination with id: " +
                        dto.getDestination().getId() + " doesn't exist"));

        HotelEntity hotelEntity = this.hotelRepository.findById(dto.getHotel().getId())
                .orElseThrow(() -> new MyEntityDoesntExist("Hotel with id: " +
                        dto.getHotel().getId() + " doesn't exist!"));

        List<RoomEntity> rooms = this.roomRepository.findRoomsByHotelId(dto.getHotel().getId());
        ReservationEntity reservationEntity = this.reservationMapper.toEntity(dto);
        reservationEntity.setDestination(destinationEntity);
        reservationEntity.setHotel(hotelEntity);
        reservationEntity.setTransportation(transportationEntity);
        this.reservationRepository.save(reservationEntity);
        return dto;
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

   
  
    
   
}
