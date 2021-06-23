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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.naprednajava.touristagency.dto.RoomDto;
import rs.ac.bg.fon.naprednajava.touristagency.dto.StateDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomIdentity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyexists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.RoomService;

@RestController
@RequestMapping(path = "/room")
@CrossOrigin("*")
public class RoomController implements rs.ac.bg.fon.naprednajava.touristagency.controller.RestRoomController<RoomDto, RoomIdentity>{

	private RoomService service;
	
	@Autowired
	public RoomController(RoomService service) {
		this.service = service;
	}
	
	@GetMapping
	@Override
	public ResponseEntity<List<RoomDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@GetMapping(path = "/{id}")
	@Override
	public ResponseEntity<Object> findById(RoomIdentity ID) {
		Optional<RoomDto> dto = service.findById(ID);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto.get());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Room with id: " + ID + " was not found!");
		
	}

	@PostMapping
	@Override
	public ResponseEntity<Object> save(RoomDto dto) {
		try {
			service.save(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body("Room " + dto.getId() + " is created!");
		} catch (MyEntityAlreadyexists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> deleteById(RoomIdentity ID) {
		try {
			service.delete(ID);
			return ResponseEntity.status(HttpStatus.OK).body("Room with id " +  ID + " is deleted!");
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}

	@PutMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> update(RoomDto dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(dto));
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Page<RoomDto>> getByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}

