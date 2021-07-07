package rs.ac.bg.fon.naprednajava.touristagency.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.naprednajava.touristagency.dto.HotelDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.DestinationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomEntity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.DestinationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.HotelMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.DestinationRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.HotelRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.RoomRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.MyService;

@Service
@Transactional
public class HotelService implements MyService<HotelDto, Long>{

	private HotelMapper mapper;
	private HotelRepository repository;
	private RoomRepository roomRepository;
	private DestinationMapper destinationMapper;

	private final DestinationRepository destinationRepository;
	
	@Autowired
	public HotelService(HotelMapper mapper, HotelRepository repository, RoomRepository roomRepository,
						DestinationRepository destinationRepository,
						DestinationMapper destinationMapper) {
		this.mapper = mapper;
		this.repository = repository;
		this.roomRepository = roomRepository;
		this.destinationRepository = destinationRepository;
		this.destinationMapper = destinationMapper;
	}
	
	@Override
	public Optional<HotelDto> findById(Long id) {
		Optional<HotelEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
			HotelDto dto = mapper.toDto(entity.get());
			byte[] image = dto.getImage();
			dto.setImage(decompressBytes(image));
			return Optional.of(dto);
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
	public HotelDto save(HotelDto dto) throws MyEntityAlreadyExists{
		/*Optional<HotelEntity> hotelEntity = repository.findHotelByAddress(dto.getAddress());
		if(hotelEntity.isPresent()) {
			throw new MyEntityAlreadyExists("Hotel " + 
					" at address " + hotelEntity.get().getAddress() + 
					" already exists!");
		}
		else {*/
		HotelEntity entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toDto(entity);
			
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
		
		HotelEntity entity = repository.findById(dto.getId()).orElseThrow(
				()-> new MyEntityDoesntExist("Hotel with id: " + dto.getId() + " doesn't exist!"));
		
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setRating(dto.getRating());
		entity.setDestination(destinationMapper.toEntity(dto.getDestination()));
		
		repository.save(entity);
		dto.setImage(entity.getImage());
		dto.setImageName(entity.getImageName());
		dto.setImageType(entity.getImageType());
		return Optional.of(dto);
		
		/*Optional<HotelEntity> entity = repository.findById(dto.getId());
		if(entity.isPresent()) {
			repository.save(mapper.toEntity(dto));
			return Optional.of(dto);
		}
		else {
			throw new MyEntityDoesntExist("Hotel with id: " + dto.getId() +  " doesn't exist!");
		}*/
	}

	@Override
	public Page<HotelDto> findByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HotelDto> findHotelEntityByDestinationId(Long id) {
		DestinationEntity destinationEntity = this.destinationRepository.findById(id).orElse(null);
		if(destinationEntity == null) {
			throw new EntityNotFoundException("Destination with that id can not be found");
		}
		List<HotelEntity> hotels = this.repository.findHotelEntityByDestination(destinationEntity);
		return hotels.stream().map((hotelEntity -> {
			return this.mapper.toDto(hotelEntity);
		})).collect(Collectors.toList());
	}
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			} outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		
		return outputStream.toByteArray();
	}

}

