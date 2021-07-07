package rs.ac.bg.fon.naprednajava.touristagency.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.naprednajava.touristagency.dto.TransportationDto;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.TransportationService;

import java.util.List;

/**
 * Transportation Controller
 *
 * @author mdjukanovic
 */
@RestController
@RequestMapping(path = "/transportation")
public class TransportationController implements rs.ac.bg.fon.naprednajava.touristagency.controller.RestController<TransportationDto, Long> {

    /** Transportation Service **/
    private final TransportationService transportationService;

    public TransportationController(TransportationService transportationService) {
        this.transportationService = transportationService;
    }

    @GetMapping("")
    @Override
    public ResponseEntity<List<TransportationDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transportationService.getAll());
    }

    @Override
    public ResponseEntity<Object> findById(Long ID) {
        return null;
    }

    @PostMapping("")
    @Override
    public ResponseEntity<Object> save(TransportationDto dto) {
        try {
            this.transportationService.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Trasnportation created!");
        } catch (MyEntityAlreadyExists | MyEntityDoesntExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Long ID) {
        return null;
    }

    @Override
    public ResponseEntity<Object> update(TransportationDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Page<TransportationDto>> getByPage(Pageable pageable) {
        return null;
    }
}
