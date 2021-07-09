package rs.ac.bg.fon.naprednajava.touristagency.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.security.authorization.IsAdminUser;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.ReservationService;

@RestController
@RequestMapping(path = "/reservation")
@CrossOrigin("*")
public class ReservationController implements rs.ac.bg.fon.naprednajava.touristagency.controller.RestController<ReservationDto, Long>{

	private final ReservationService reservationService;
	
	@Autowired
	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@GetMapping
	@Override
	public ResponseEntity<List<ReservationDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAll());
	}

	@GetMapping(path="/{id}")
	@Override
	public ResponseEntity<Object> findById(@PathVariable Long ID) {
		Optional<ReservationDto> dto = reservationService.findById(ID);
		if(dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(reservationService.findById(ID));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No reservation with id " + ID);
		
		
	}

	@IsAdminUser
	@PostMapping
	@Override
	public ResponseEntity<Object> save(ReservationDto dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(reservationService.save(dto));
		} catch (MyEntityAlreadyExists | MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping(path= "/{id}")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		try {
			reservationService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Reservation with id : " + id + " is deleted!");
		} catch (MyEntityDoesntExist e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}

	//TODO Da li bi rezervacija mogla da se update-uje
	@Override
	public ResponseEntity<Object> update(ReservationDto dto) {
		return null;
	}
/*
	@GetMapping(path="/myReservations/{id}")
	public ResponseEntity<List<ReservationDto>> getReservationById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(reservationService.getReservationsById(id));
	}
	*/
	@Override
	public ResponseEntity<Page<ReservationDto>> getByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
