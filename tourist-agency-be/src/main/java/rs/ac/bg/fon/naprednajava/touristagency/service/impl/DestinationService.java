package rs.ac.bg.fon.naprednajava.touristagency.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.naprednajava.touristagency.dto.DestinationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.DestinationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.StateEntity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyexists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.DestinationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.DestinationRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.StateRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.MyService;

@Service
@Transactional
public class DestinationService implements MyService<DestinationDto, Long> {

	private DestinationMapper mapper;
	private DestinationRepository destinationRepository;
	private StateRepository stateRespository;
	
	@Autowired
	public DestinationService(DestinationMapper mapper, DestinationRepository destinationRepository,
			StateRepository stateRespository) {
		super();
		this.mapper = mapper;
		this.destinationRepository = destinationRepository;
		this.stateRespository = stateRespository;
	}

	@Override
	public Optional<DestinationDto> findById(Long id) {
		Optional<DestinationEntity> entity = destinationRepository.findById(id);
		if(entity.isPresent()) {
			return Optional.of(mapper.toDto(entity.get()));
		}
		else {
			return Optional.empty();
		}
	}

	@Override
	public List<DestinationDto> getAll() {
		List<DestinationEntity> entities = destinationRepository.findAll();
		return entities.stream().map(el -> mapper.toDto(el)).collect(Collectors.toList());
	}

	@Override
	public DestinationDto save(DestinationDto dto) throws MyEntityAlreadyexists, MyEntityDoesntExist {
		Optional<DestinationEntity> destinationEntity = destinationRepository.findById(dto.getId());
		if(destinationEntity.isPresent()) {
			throw new MyEntityAlreadyexists("Destination " + dto.getName() + " already exist!");
		}
		else {
			Optional<StateEntity> stateEntity = stateRespository.findById(dto.getState().getId());
			if(!stateEntity.isPresent()) {
				throw new MyEntityDoesntExist("State " + stateEntity.get().getName() + " doesn't exist!");
			}
			else {
				destinationRepository.save(mapper.toEntity(dto));
				return dto;
			}
		}
	}

	@Override
	public void delete(Long id) throws MyEntityDoesntExist {
		Optional<DestinationEntity> entitie = destinationRepository.findById(id);
		if(entitie.isPresent()) {
			destinationRepository.deleteById(id);
		}
		else {
			throw new MyEntityDoesntExist("Destination with id: " + id + " does not exist!");
		}
		
	}

	@Override
	public Optional<DestinationDto> update(DestinationDto dto) throws MyEntityDoesntExist, MyEntityAlreadyexists {
		Optional<DestinationEntity> destinationEntity = destinationRepository.findById(dto.getId());
		if(destinationEntity.isPresent()) {
			Optional<StateEntity> state = stateRespository.findById(dto.getId());
			if(!state.isPresent()) {
				throw new MyEntityDoesntExist("State " + dto.getState().getName()+ " doesn't exist!");
			}
			else {
			destinationRepository.save(mapper.toEntity(dto));
			return Optional.of(dto);
				}
			}
		else {
			throw new MyEntityAlreadyexists("State " + dto.getName() + " doesn't exist!");
		}
	}

	@Override
	public Page<DestinationDto> findByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
