package rs.ac.bg.fon.naprednajava.touristagency.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.naprednajava.touristagency.dto.RoomDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomIdentity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.security.authorization.IsAdminUser;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.HotelService;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.RoomService;

@RestController
@RequestMapping(path = "/room")
@CrossOrigin("*")
public class RoomController implements rs.ac.bg.fon.naprednajava.touristagency.controller.RestRoomController<RoomDto, RoomIdentity>{

	private RoomService service;
	
	@Autowired
	public RoomController(RoomService service, HotelService hotelService) {
		this.service = service;
	}
	
	@GetMapping
	@Override
	public ResponseEntity<List<RoomDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@IsAdminUser
	@GetMapping(path = "/{id}")
	@Override
	public ResponseEntity<Object> findById(RoomIdentity id) {
		Optional<RoomDto> dto = service.findById(id);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto.get());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Room with id: " + id + " was not found!");
		
	}

	@IsAdminUser
	@PostMapping
	@Override
	public ResponseEntity<Object> save(RoomDto dto) {
		RoomIdentity id = dto.getId();
		Optional<RoomDto> dtoExists = service.findById(id);
		if(dtoExists.isEmpty()) {
			try {
				return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
			} catch (MyEntityAlreadyExists e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			} catch (MyEntityDoesntExist e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Room with id:" + id + " already exists!");
		}
		
	}

	@IsAdminUser
	//@DeleteMapping(path="/{id}")
	@DeleteMapping
	@Override
	public ResponseEntity<Object> deleteById(RoomIdentity id) {
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Room with id " +  id.getRoom_number() + " is deleted!");
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}

	@IsAdminUser
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

	@IsAdminUser
	@GetMapping(path = "/hotel/{id}")
	@Override
	public ResponseEntity<List<RoomDto>> findRoomsByHotelId(Long id) {
		List<RoomDto> dto = service.findRoomsByHotelId(id);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

}

