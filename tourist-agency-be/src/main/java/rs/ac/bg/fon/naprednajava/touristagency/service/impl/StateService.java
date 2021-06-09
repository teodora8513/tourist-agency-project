package rs.ac.bg.fon.naprednajava.touristagency.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.naprednajava.touristagency.dto.StateDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.StateEntity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyexists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.StateMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.StateRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.MyService;

@Service
@Transactional
public class StateService implements MyService<StateDto, Long> {

	private StateRepository repository;
	private StateMapper mapper;
	
	@Autowired
	public StateService(StateRepository repository, StateMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Optional<StateDto> findById(Long id) {
		Optional<StateEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
			return Optional.of(mapper.toDto(entity.get()));
		}
		return Optional.empty();
	}

	@Override
	public List<StateDto> getAll() {
		List<StateEntity> entities = repository.findAll();
		return entities.stream().map(en -> {
			return mapper.toDto(en);
		}).collect(Collectors.toList());
	}

	@Override
	public StateDto save(StateDto dto) throws MyEntityAlreadyexists {
		Optional<StateEntity> entity = repository.findById(dto.getId());
		if(entity.isPresent()) {
			throw new MyEntityAlreadyexists("State " + entity.get().getName() + " already exists in the system!");
		}
		else {
			repository.save(mapper.toEntity(dto));
			return dto;
		}
	}

	@Override
	public void delete(Long id) throws MyEntityDoesntExist {
		Optional<StateEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
			repository.deleteById(id);
		}
		else
			throw new MyEntityDoesntExist("State with id: " + id + " doesn't exist!");		
	}

	@Override
	public Optional<StateDto> update(StateDto dto) throws MyEntityDoesntExist  {
		Optional<StateEntity> entity = repository.findById(dto.getId());
		if(entity.isPresent()) {
			repository.save(mapper.toEntity(dto));
			return Optional.of(dto);
		}
		else {
			throw new MyEntityDoesntExist("State " + dto.getName() + " doesn't exist!");
		}
	}

	@Override
	public Page<StateDto> findByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


}
