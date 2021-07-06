package rs.ac.bg.fon.naprednajava.touristagency.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import rs.ac.bg.fon.naprednajava.touristagency.dto.HotelDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.DestinationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.DestinationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.DestinationRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.HotelService;

@RestController
@RequestMapping(path = "/hotel")
@CrossOrigin("*")
public class HotelController implements rs.ac.bg.fon.naprednajava.touristagency.controller.RestHotelController<HotelDto, Long>{

	private HotelService service;
	//private DestinationService destinationService;
	private DestinationRepository destinationRepo;
	private DestinationMapper destinationMapper;
	
	@Autowired
	public HotelController(HotelService service, DestinationRepository destinationRepo, 
			DestinationMapper destinationMapper) {
		this.service = service;
		//this.destinationService = destinationService;
		this.destinationRepo = destinationRepo;
		this.destinationMapper = destinationMapper;
	}
	
	@GetMapping
	@Override
	public ResponseEntity<List<HotelDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@GetMapping(path = "/{id}")
	@Override
	public ResponseEntity<Object> findById(Long id) {
		Optional<HotelDto> dto = service.findById(id);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto.get());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hotel with id: " + id + " was not found!");
	}
	
	/*
	
	@PostMapping
	@Override
	public ResponseEntity<Object> save(HotelDto dto)  {	
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
		} catch (MyEntityAlreadyExists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	*/

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

	@PostMapping
	@Override
	public ResponseEntity<Object> save(String name, String address, Integer rating, 
			String destination_name, /*String extension,*/ MultipartFile imageFile) throws IOException {
		
		HotelDto dto = new HotelDto();
		dto.setName(name);
		dto.setAddress(address);
		dto.setRating(rating);
		
		DestinationEntity destination = destinationRepo.findDestinationByName(destination_name);
		
		dto.setDestination(destinationMapper.toDto(destination));
		dto.setImageName(imageFile.getOriginalFilename());
		dto.setImageType(imageFile.getContentType());
		dto.setImage(compressBytes(imageFile.getBytes()));
		//dto.setExtension(extension);
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
		} catch (MyEntityAlreadyExists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
       System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
	
	
	@GetMapping("destination")
	public ResponseEntity<List<HotelDto>> getAllByDestination(@RequestParam Long destinationId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.findHotelEntityByDestinationId(destinationId));
	}

}


