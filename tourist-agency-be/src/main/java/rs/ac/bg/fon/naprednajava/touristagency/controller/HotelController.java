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
import rs.ac.bg.fon.naprednajava.touristagency.dto.HotelDto;
import rs.ac.bg.fon.naprednajava.touristagency.dto.StateDto;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.HotelService;

@RestController
@RequestMapping(path = "/hotel")
@CrossOrigin("*")
public class HotelController implements rs.ac.bg.fon.naprednajava.touristagency.controller.RestController<HotelDto, Long>{

	private HotelService service;

	@Autowired
	public HotelController(HotelService service) {
		this.service = service;
	}
	
	@GetMapping
	@Override
	public ResponseEntity<List<HotelDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@GetMapping(path = "/{id}")
	@Override
	public ResponseEntity<Object> findById(Long ID) {
		Optional<HotelDto> dto = service.findById(ID);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto.get());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hotel with id: " + ID + " was not found!");
	}

	@PostMapping
	@Override
	public ResponseEntity<Object> save(HotelDto dto) {
		try {	
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
		} catch (MyEntityAlreadyExists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> deleteById(Long id) {
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Hotel with id " +  id + " is deleted!");
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> update(HotelDto dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(dto));
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Page<HotelDto>> getByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}


