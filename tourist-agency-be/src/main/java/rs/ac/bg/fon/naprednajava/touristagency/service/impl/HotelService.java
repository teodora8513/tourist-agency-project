package rs.ac.bg.fon.naprednajava.touristagency.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.naprednajava.touristagency.dto.HotelDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomEntity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyexists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.HotelMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.HotelRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.RoomRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.MyService;

@Service
@Transactional
public class HotelService implements MyService<HotelDto, Long>{

	private HotelMapper mapper;
	private HotelRepository repository;
	private RoomRepository roomRepository;
	
	@Autowired
	public HotelService(HotelMapper mapper, HotelRepository repository, RoomRepository roomRepository) {
		this.mapper = mapper;
		this.repository = repository;
		this.roomRepository = roomRepository;
	}
	
	@Override
	public Optional<HotelDto> findById(Long id) {
		Optional<HotelEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
			return Optional.of(mapper.toDto(entity.get()));
		}
		return Optional.empty();
	}

	@Override
	public List<HotelDto> getAll() {
		List<HotelEntity> entities = repository.findAll();
		return entities.stream().map(en -> {
			return mapper.toDto(en);
		}).collect(Collectors.toList());
	}

	@Override
	public HotelDto save(HotelDto dto) throws MyEntityAlreadyexists {
		Optional<HotelEntity> entity = repository.findById(dto.getId());
		if(entity.isPresent()) {
			throw new MyEntityAlreadyexists("Hotel " + entity.get().getName() + 
					" at address " + entity.get().getAddress() + 
					" already exists in the system!");
		}
		/*else {
			repository.save(mapper.toEntity(dto));
			for (RoomEntity room : dto.getRooms()) {
					Optional<RoomEntity> roomEntity = roomRepository.findById(room.getId());
				if(roomEntity.isPresent()) {
					throw new MyEntityAlreadyexists("Room with id: " + room.getId() + " already exists!");
				}
				else {
					room.setHotel(mapper.toEntity(dto));
				}
			}
			
		}*/
	
		return dto;
	}

	@Override
	public void delete(Long id) throws MyEntityDoesntExist {
		Optional<HotelEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
			repository.deleteById(id);
		}
		else
			throw new MyEntityDoesntExist("Hotel with id: " + id + " doesn't exist!");
		
	}

	@Override
	public Optional<HotelDto> update(HotelDto dto) throws MyEntityDoesntExist {
		Optional<HotelEntity> entity = repository.findById(dto.getId());
		if(entity.isPresent()) {
			repository.save(mapper.toEntity(dto));
			return Optional.of(dto);
		}
		else {
			throw new MyEntityDoesntExist("Hotel " + dto.getName() + " at address " + dto.getAddress() + " doesn't exist!");
		}
	}

	@Override
	public Page<HotelDto> findByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}

