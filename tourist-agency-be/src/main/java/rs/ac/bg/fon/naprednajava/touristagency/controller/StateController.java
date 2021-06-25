package rs.ac.bg.fon.naprednajava.touristagency.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import rs.ac.bg.fon.naprednajava.touristagency.dto.DestinationDto;
import rs.ac.bg.fon.naprednajava.touristagency.dto.StateDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.StateEntity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.StateService;

@RestController
@RequestMapping(path = "/state")
@CrossOrigin("*")
public class StateController implements rs.ac.bg.fon.naprednajava.touristagency.controller.RestController<StateDto, Long> {

	private StateService stateService;

	@Autowired
	public StateController(StateService stateService) {
		this.stateService = stateService;
	}

	@GetMapping
	@Override
	public ResponseEntity<List<StateDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(stateService.getAll());
	}
	
	@GetMapping(path = "/{id}")
	@Override
	public ResponseEntity<Object> findById(Long ID) {
		Optional<StateDto> dto = stateService.findById(ID);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto.get());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("State with id: " + ID + " was not found!");
	}

	@PostMapping
	@Override
	public ResponseEntity<Object> save(StateDto dto) {
		try {
			stateService.save(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body("State " + dto.getName() + " is created!");
		} catch (MyEntityAlreadyExists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@DeleteMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable Long ID) {
		try {
			stateService.delete(ID);
			return ResponseEntity.status(HttpStatus.OK).body("State with id " +  ID + " is deleted!");
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Page<StateDto>> getByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> update(@RequestBody StateDto dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(stateService.update(dto));
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}

	

}
