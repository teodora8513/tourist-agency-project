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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import rs.ac.bg.fon.naprednajava.touristagency.dto.DestinationDto;
import rs.ac.bg.fon.naprednajava.touristagency.dto.StateDto;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyexists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.DestinationService;

@RestController
@RequestMapping(path = "/destination")
@CrossOrigin("*")
public class DestinationController implements rs.ac.bg.fon.naprednajava.touristagency.controller.RestController<DestinationDto, Long>{

	private DestinationService destinationService;
	
	
	@Autowired
	public DestinationController(DestinationService destinationService) {
		this.destinationService = destinationService;
	}

	@GetMapping
	@Override
	public ResponseEntity<List<DestinationDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(destinationService.getAll());
	}

	@GetMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> findById(@PathVariable Long ID) {
		Optional<DestinationDto> dto = destinationService.findById(ID);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto.get());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Destination with id: " + ID + " was not found!");
	}

	@PostMapping
	@Override
	public ResponseEntity<Object> save(DestinationDto dto) {
		try {
			destinationService.save(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body("Destination " + dto.getName() + " is created!");
		} catch (MyEntityAlreadyexists | MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable Long ID) {
		try {
			destinationService.delete(ID);
			return ResponseEntity.status(HttpStatus.OK).body("Destination with id " +  ID + " is deleted!");
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Page<DestinationDto>> getByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> update(@RequestBody DestinationDto dto) {
		try {
			destinationService.update(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body("Destination : "  + dto.getName()+ " is updated!");
		} catch (MyEntityAlreadyexists | MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	
}
